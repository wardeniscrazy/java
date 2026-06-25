
import java.util.*;

public class shopi2 {
  public static void main(String[] args) throws InterruptedException {
    int balance = 0;

    System.out.println("***************************************************");
    System.out.println("                     my shop");
    System.out.println("***************************************************");
    System.out.println("");
    System.out.println("");
    System.out.println("YOUR SHOP IS CLOSED");
    System.out.println("press 'O' TO OPEN ");

    Scanner newsc = new Scanner(System.in);
    String hi = newsc.next();

    if (hi.equals("o")) {
      System.out.println("YOUR SHOPE IS OPEN NOW LETSSS GOOOO");

    }

    int totalSeconds = 8 * 60;

    // customers string

    int hour = 8;
    int minute = 0;

    while (true) {

      String[] playerNames = {
          // Basic Classes
          "Warrior", "Mage", "Knight", "Hunter", "Adventurer", "Paladin", "Rogue", "Merchant",
          "Dragon Slayer", "Wizard", "Cleric", "Ranger", "Bard", "Necromancer", "Druid",
          "Barbarian", "Sorcerer", "Thief", "Assassin", "Monk", "Berserker", "Enchanter",
          "Alchemist", "Summoner", "Crusader", "Shadow Knight", "Holy Priest", "Bounty Hunter", "Pirate",
          // Mythical Characters
          "Vampire", "Werewolf", "Ghost", "Demon", "Angel", "Phoenix Knight", "Ice Wizard",
          "Fire Mage", "Storm Caller", "Earth Shaman", "Time Traveler", "Dimension Walker",
          "Robot", "Cyborg", "Zombie", "Skeleton", "Golem", "Dragon", "Giant", "Elf", "Dwarf", "Orc", "Goblin",
          "Fairy",
          // Fantasy Names
          "Aragorn", "Legolas", "Gimli", "Gandalf", "Frodo", "Samwise", "Boromir", "Gollum",
          "Sauron", "Morgoth", "Elrond", "Galadriel", "Arwen", "Haldir", "Thoden", "Eomer",
          // Heroes & Legends
          "Heracles", "Achilles", "Hector", "Odysseus", "Perseus", "Jason", "Theseus", "Bellerophon",
          "Atalanta", "Medusa", "Minotaur", "Cyclops", "Hydra", "Phoenix", "Griffin", "Pegasus",
          // Modern Names
          "Alex", "Jordan", "Casey", "Morgan", "Taylor", "Riley", "Avery", "Quinn",
          "Sage", "River", "Storm", "Hunter", "Scout", "Ranger", "Raven", "Shadow",
          // Indian Names
          "Arjun", "Krishna", "Rama", "Ashok", "Vikram", "Anand", "Rohan", "Naveen",
          "Priya", "Anjali", "Neha", "Isha", "Diya", "Rani", "Priya", "Madhuri",
          // Strength Types
          "Titan", "Colossus", "Leviathan", "Kraken", "Hydra Slayer", "Chimera Hunter", "Basilisk Killer",
          "Wyvern Rider", "Troll Crusher", "Ogre Breaker", "Giant Slayer",
          // Speed/Agility
          "Swift Arrow", "Quick Strike", "Shadow Runner", "Night Stalker", "Ghost Blade",
          "Silent Killer", "Wind Dancer", "Flash Step", "Lightning Bolt",
          // Wisdom/Magic
          "Spell Weaver", "Rune Master", "Oracle", "Sage", "Mystic", "Shaman", "Seer",
          "Lich King", "Archmage", "Warlock", "Witch Doctor", "Voodoo Master",
          // Unique
          "Nobody", "Traveler", "Wanderer", "Nomad", "Stranger", "Visitor", "Tourist",
          "Seeker", "Explorer", "Adventurer", "Daredevil", "Lucky Gambler"
      };

      // items

      String[][] items = {
          // Grocery
          { "Grocery", "Rice", "50" },
          { "Grocery", "Wheat Flour", "45" },
          { "Grocery", "Sugar", "40" },
          { "Grocery", "Salt", "20" },
          { "Grocery", "Milk", "30" },
          { "Grocery", "Bread", "25" },
          { "Grocery", "Eggs", "60" },
          { "Grocery", "Apple", "15" },
          { "Grocery", "Banana", "10" },
          { "Grocery", "Potato", "25" },

          // Electronics
          { "Electronics", "Keyboard", "1500" },
          { "Electronics", "Mouse", "700" },
          { "Electronics", "Monitor", "12000" },
          { "Electronics", "Laptop", "50000" },
          { "Electronics", "Smartphone", "20000" },
          { "Electronics", "USB Hub", "600" },
          { "Electronics", "Headphones", "2500" },
          { "Electronics", "Webcam", "1800" },
          { "Electronics", "Microphone", "3000" },
          { "Electronics", "Power Bank", "1200" },

          // Clothing
          { "Clothing", "T-Shirt", "500" },
          { "Clothing", "Jeans", "1200" },
          { "Clothing", "Jacket", "2500" },
          { "Clothing", "Shoes", "3000" },
          { "Clothing", "Cap", "400" },
          { "Clothing", "Socks", "100" },
          { "Clothing", "Gloves", "350" },
          { "Clothing", "Hoodie", "1800" },

          // Furniture
          { "Furniture", "Chair", "2000" },
          { "Furniture", "Table", "5000" },
          { "Furniture", "Bed", "12000" },
          { "Furniture", "Wardrobe", "15000" },
          { "Furniture", "Bookshelf", "4000" },
          { "Furniture", "Sofa", "25000" },

          // Tools
          { "Tools", "Hammer", "300" },
          { "Tools", "Screwdriver", "150" },
          { "Tools", "Wrench", "250" },
          { "Tools", "Drill Machine", "3500" },
          { "Tools", "Saw", "450" },
          { "Tools", "Measuring Tape", "100" },

          // Medical
          { "Medical", "Bandage", "50" },
          { "Medical", "First Aid Kit", "300" },
          { "Medical", "Thermometer", "250" },
          { "Medical", "Pain Relief Gel", "120" },
          { "Medical", "Antiseptic Liquid", "180" },

          // Sports
          { "Sports", "Football", "800" },
          { "Sports", "Cricket Bat", "1500" },
          { "Sports", "Cricket Ball", "200" },
          { "Sports", "Badminton Racket", "1000" },
          { "Sports", "Basketball", "900" },
          { "Sports", "Skipping Rope", "150" },

          // Books
          { "Books", "Java Programming", "600" },
          { "Books", "Game Design", "750" },
          { "Books", "Algorithms", "900" },
          { "Books", "Mathematics", "500" },
          { "Books", "Physics", "550" },

          // Toys
          { "Toys", "Toy Car", "400" },
          { "Toys", "Puzzle", "250" },
          { "Toys", "Building Blocks", "800" },
          { "Toys", "Remote Control Car", "2500" },
          { "Toys", "Action Figure", "1200" },

          // Vehicles
          { "Vehicles", "Bicycle", "8000" },
          { "Vehicles", "Electric Scooter", "70000" },
          { "Vehicles", "Motorcycle", "120000" },
          { "Vehicles", "Car", "600000" },

          // Stationery
          { "Stationery", "Notebook", "50" },
          { "Stationery", "Pen", "10" },
          { "Stationery", "Pencil", "5" },
          { "Stationery", "Eraser", "5" },
          { "Stationery", "School Bag", "1200" },

          // Gaming
          { "Gaming", "Gaming Mouse", "2000" },
          { "Gaming", "Mechanical Keyboard", "3500" },
          { "Gaming", "Game Controller", "2500" },
          { "Gaming", "Gaming Headset", "4000" },
          { "Gaming", "Gaming Chair", "15000" }
      };

      Random rn = new Random();

      int mobIndex = rn.nextInt(items.length);

      Random rand = new Random();

      int damage = 0;

      String monster = items[mobIndex][0];

      Random rand1 = new Random();
      String customer = playerNames[rand.nextInt(playerNames.length)];

      System.out.println(customer + "has arived go and check ");

      // System.out.println(customer);
      int rn1 = damage;

      Thread.sleep(1000);

      minute++;

      if (minute == 60) {
        minute = 0;
        hour++;
      }

      if (hour == 24) {
        hour = 0;
      }

      System.out.print("Press O gto go on counter: ");

      String input = newsc.next();

      if (!input.equalsIgnoreCase("o")) {
        continue;
      }

      int mobGold = Integer.parseInt(items[mobIndex][2].trim());
      balance += mobGold;

      System.out.println("\r" + rn1);

      // System.out.println("You have " + items[mobIndex][3]+ " golds");

      {
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
      }

      System.out.print("\r" + customer + " come to buy " + items[mobIndex][1]);

      System.out.printf("                                        Time: %02d:%02d%n", hour, minute);

      System.out.println("\rPrice: " + items[mobIndex][2] + "$");
      System.out.println("\r(catogry: " + (items[mobIndex][0]) + ")");
      System.out.println("");
      System.out.println("\r" + balance);
      System.out.println("");
      System.out.println("");

      int randomTime = rand.nextInt(5000) + 1000;

      Thread.sleep(randomTime);

    }
  }
}
