
import java.util.*;

public class Dungeon_Loot_Explorer {
  public static void main(String[] args) {

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
    int player_health = 100;

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

    while (true) {

      char input = sc.next().charAt(0);

      if (input == '1') {
        System.out.println("You need to fight with " + monster);
        System.out.println("Press 'a' to attack...");
        System.out.println("Press 'r' to run...");

        char action = sc.next().charAt(0);

        switch (action) {
          case 'a':
            System.out.println("Attack!");
            int[] damegs = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 12 };
            Random rnn = new Random();
            int rn1 = rnn.nextInt(100) + 1;
            System.out.println(rn1);
            System.out.println(player_health - rn1);

            break;

          case 'r':
            System.out.println("run fast");
            break;

        }
      }

    }
  }
}
