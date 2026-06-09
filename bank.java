import java.util.*;
import java.io.*;

public class bank {

    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);

        while (true) {
            double balance = 0.0;
            int loggedInAccount = -1;

            System.out.println("================================");
            System.out.println("         Welcome Bank!");
            System.out.println("================================");
            System.out.println("1. Login");
            System.out.println("a. Create Account");

            String choice = sc.next();

            if (choice.equals("1")) {
                System.out.println("Write your ACCOUNT NUMBER:");
                int accountNumber11 = sc.nextInt();

                System.out.println("Write your PIN:");
                int accountPin1 = sc.nextInt();

                try {
                    File file = new File("accounts.txt");

                    if (!file.exists()) {
                        System.out.println("No accounts found!");
                        continue;
                    }

                    Scanner reader = new Scanner(file);
                    boolean found = false;
                    boolean pinCorrect = false;

                    while (reader.hasNextLine()) {
                        String line = reader.nextLine();
                        if (line.contains("Account Number: " + accountNumber11)) {
                            found = true;
                            if (line.contains("PIN: " + accountPin1)) {
                                pinCorrect = true;
                                loggedInAccount = accountNumber11;
                                String[] parts = line.split("Balance: ");
                                balance = Double.parseDouble(parts[1].trim());
                            }
                            break;
                        }
                    }
                    reader.close();

                    if (!found) { System.out.println("Account Not Found!"); continue; }
                    if (!pinCorrect) { System.out.println("Wrong PIN!"); continue; }

                } catch (Exception e) {
                    e.printStackTrace();
                    continue;
                }

                System.out.println("Login Successful! Welcome to your account!");

                // ✅ Inner menu loop — all options at same level
                while (true) {
                    System.out.println("\nYour Balance is: $" + balance);
                    System.out.println("1.> Deposit");
                    System.out.println("2.> Withdraw");
                    System.out.println("3.> Check Balance");
                    System.out.println("4.> Logout");

                    String choice1 = sc.next();

                    if (choice1.equals("1")) {
                        System.out.println("Enter amount to deposit:");
                        double depositAmount = sc.nextDouble();
                        double oldBalance = balance;
                        balance += depositAmount;

                        try {
                            File file2 = new File("accounts.txt");
                            String content = new Scanner(file2).useDelimiter("\\Z").next();
                            content = content.replace(
                                "Account Number: " + loggedInAccount + "     |     Balance: " + oldBalance,
                                "Account Number: " + loggedInAccount + "     |     Balance: " + balance
                            );
                            FileWriter fw = new FileWriter(file2);
                            fw.write(content);
                            fw.close();
                            System.out.println("Processing deposit...");
                            Thread.sleep(1500);
                            System.out.println("Deposited successfully! New Balance: $" + balance);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    } else if (choice1.equals("2")) {
                        System.out.println("Enter amount to withdraw:");
                        double withdrawAmount = sc.nextDouble();

                        if (withdrawAmount > balance) {
                            System.out.println("Insufficient balance!");
                        } else {
                            double oldBalance = balance;
                            balance -= withdrawAmount;

                            try {
                                File file2 = new File("accounts.txt");
                                String content = new Scanner(file2).useDelimiter("\\Z").next();
                                content = content.replace(
                                    "Account Number: " + loggedInAccount + "     |     Balance: " + oldBalance,
                                    "Account Number: " + loggedInAccount + "     |     Balance: " + balance
                                );
                                FileWriter fw = new FileWriter(file2);
                                fw.write(content);
                                fw.close();
                                System.out.println("Processing withdrawal...");
                                Thread.sleep(1500);
                                System.out.println("Withdrawn successfully! New Balance: $" + balance);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }

                    } else if (choice1.equals("3")) {
                        // ✅ Now actually reachable
                        System.out.println("Your current balance is: $" + balance);

                    } else if (choice1.equals("4")) {
                        System.out.println("Logged out!");
                        break;

                    } else {
                        System.out.println("Invalid choice!");
                    }
                }

            } else if (choice.equals("a")) {
                System.out.println("Write your NAME:");
                String name = sc.next();

                Random random = new Random();
                int pin = random.nextInt(1000, 9999); // ✅ Fixed range
                int accountNumber = random.nextInt(100000000, 999999999);

                System.out.println("Your PIN is: " + pin);
                System.out.println("Account Number: " + accountNumber);

                try (FileWriter writer = new FileWriter("accounts.txt", true)) {
                    writer.write("Name: " + name);
                    writer.write("     |     PIN: " + pin);
                    writer.write("     |     Account Number: " + accountNumber);
                    writer.write("     |     Balance: 0.0\n");
                    writer.write("  --------------------\n");
                    System.out.println("Account Created Successfully!");
                } catch (IOException e) {
                    e.printStackTrace();
                }

            } else {
                System.out.println("Invalid Choice!");
            }
        }
    }
}