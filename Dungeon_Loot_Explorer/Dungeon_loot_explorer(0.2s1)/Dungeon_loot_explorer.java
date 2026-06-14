import java.util.*;

public class Dungeon_Loot_Explorer {
  public static void main(String[] args) {
    while (true) {

      Scanner sc = new Scanner(System.in);
      String[] mon = {
          "Goblin",
          "Orc",
          "Skeleton",
          "Zombie",
          "Dragon",
          "Slime",
          "Vampire",
          "Werewolf",
          "Demon",
          "Giant Spider",
          "Ghost",
          "Troll",
          "Minotaur",
          "Lich",
          "Dark Knight"
      };
      Random rn = new Random();
      String monster = mon[rn.nextInt(mon.length)];
      
      System.out.println("=========================================");
      System.out.println("  Welcome to the Dungeon Loot Explorer!");
      System.out.println("=========================================");

      System.out.println("level: ");
      System.out.println("HP: ");
      System.out.println("Gold: ");
      System.out.println("XP:");

      System.out.println("1.> Enter Room");
      System.out.println("2.> Inventory");
      System.out.println("3.> Status:");
      System.out.println("4.> quit");

      int input = sc.nextInt();
      if (input == 1) {
        System.out.println("You need to fight wiht " + monster);
      }

    }
  }
}
