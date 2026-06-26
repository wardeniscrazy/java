import java.util.Scanner;

public class Inventroy {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    String[][] inventory = {
        { "Wooden Pickaxe", "Stone Pickaxe", "Iron Pickaxe", "Diamond Pickaxe" },
        { "Wooden Sword", "Stone Sword", "Iron Sword", "Diamond Sword" },
        { "Wood", "Stone", "Coal", "Iron Ore" },
        { "Apple", "Bread", "Carrot", "Potato" }
    };

    boolean inventoryOpen = false;

    while (true) {

      System.out.println("\n========== MENU ==========");
      System.out.println("1. Open Inventory");
      System.out.println("2. Close Inventory");
      System.out.println("3. Exit");
      System.out.print("Choose: ");

      int choice = sc.nextInt();

      switch (choice) {

        case 1:

          inventoryOpen = true;

          System.out.println("\n========== INVENTORY ==========\n");

          for (int i = 0; i < inventory.length; i++) {

            System.out.println(
                "+----------------+----------------+----------------+----------------+");

            for (int j = 0; j < inventory[i].length; j++) {

              System.out.printf("| %-14s ", inventory[i][j]);

            }

            System.out.println("|");
          }

          System.out.println(
              "+----------------+----------------+----------------+----------------+");

          break;

        case 2:

          if (inventoryOpen) {

            inventoryOpen = false;
            System.out.println("Inventory Closed.");

          } else {

            System.out.println("Inventory is already closed.");
          }

          break;

        case 3:

          System.out.println("Saving Game...");
          System.out.println("Exiting...");
          sc.close();
          return;

        default:

          System.out.println("Invalid Input!");
      }
    }
  }
}