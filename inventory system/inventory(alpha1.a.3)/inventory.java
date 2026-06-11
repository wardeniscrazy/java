import java.util.*;

public class Inventroy {

  public static void main(String[] args) throws InterruptedException {

    Scanner sc = new Scanner(System.in);

    System.out.println("1.> open inventory");
    System.out.println("2.> close inventory");
    System.out.println("3.> exit");

    while (true) {

      int open = sc.nextInt();

      if (open == 1) {

        System.out.println("Inventory Opened");

        ArrayList<ArrayList<String>> inventory = new ArrayList<>();

        inventory.add(new ArrayList<>(Arrays.asList(
            "Pickaxe", "Sword", "Axe", "Shovel")));

        inventory.add(new ArrayList<>(Arrays.asList(
            "Diamond", "Iron", "Gold", "Coal")));

        inventory.add(new ArrayList<>(Arrays.asList(
            "Apple", "Bread", "Carrot", "Potato")));

        inventory.add(new ArrayList<>(Arrays.asList(
            "Bow", "Arrow", "Fishing Rod", "Water Bucket")));

        for (int i = 0; i < inventory.size(); i++) {

          for (int j = 0; j < inventory.get(i).size(); j++) {

            System.out.print(inventory.get(i).get(j) + " | ");
          }

          System.out.println();

          if (i != inventory.size() - 1) {
            System.out.println("------------------------------------------------");
          }
        }
      }

      System.out.println("\n2.> close inventory");
      System.out.println("3.> exit");

      if (open == 2) {
        System.out.println("Inventory Closed");
      }

      if (open < 1 || open > 3) {
        System.out.println("Invalid Input");
      }

      if (open == 3) {
        System.out.println("Exiting...");
        Thread.sleep(2580);
        break;
      }
    }

    sc.close();
  }
}
