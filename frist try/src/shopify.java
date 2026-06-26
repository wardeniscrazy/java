import java.util.Random;
import java.util.Scanner;

class Item {
  String name;
  int price;
  int stock;

  Item(String name, int price, int stock) {
    this.name = name;
    this.price = price;
    this.stock = stock;
  }

  public String toString() {
    return name + " - Price: " + price + " | Stock: " + stock;
  }
}

class Player {
  String name;
  int money;

  Player(String name, int money) {
    this.name = name;
    this.money = money;
  }
}

class Shop {
  Item[] items;
  int totalEarnings = 0;
  Random random = new Random();
  int playersServed = 0;

  Shop() {
    items = new Item[5];
    items[0] = new Item("Sword", 100, 5);
    items[1] = new Item("Potion", 20, 10);
    items[2] = new Item("Shield", 150, 3);
    items[3] = new Item("Bow", 120, 4);
    items[4] = new Item("Scroll", 50, 8);
  }

  void displayInventory() {
    System.out.println("\n=== SHOP INVENTORY ===");
    for (int i = 0; i < items.length; i++) {
      System.out.println("[" + i + "] " + items[i]);
    }
  }

  void playerArrives() {
    String[] playerNames = {
        // Basic Classes
        "Warrior", "Mage", "Knight", "Hunter", "Adventurer", "Paladin", "Rogue", "Merchant",
        "Dragon Slayer", "Wizard", "Cleric", "Ranger", "Bard", "Necromancer", "Druid",
        "Barbarian", "Sorcerer", "Thief", "Assassin", "Monk", "Berserker", "Enchanter",
        "Alchemist", "Summoner", "Crusader", "Shadow Knight", "Holy Priest", "Bounty Hunter", "Pirate",
        // Mythical Characters
        "Vampire", "Werewolf", "Ghost", "Demon", "Angel", "Phoenix Knight", "Ice Wizard",
        "Fire Mage", "Storm Caller", "Earth Shaman", "Time Traveler", "Dimension Walker",
        "Robot", "Cyborg", "Zombie", "Skeleton", "Golem", "Dragon", "Giant", "Elf", "Dwarf", "Orc", "Goblin", "Fairy",
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

    int randomIndex = random.nextInt(playerNames.length);
    int playerMoney = random.nextInt(400) + 50; // 50-450 paise

    Player player = new Player(playerNames[randomIndex], playerMoney);
    playersServed++;

    System.out.println("\n★ " + player.name + " aya! Uske paas " + playerMoney + " paise hain!");
    System.out.println("(" + player.name + " arrived! Has " + playerMoney + " money!)\n");

    // Player randomly buys items
    int numPurchases = random.nextInt(4) + 1; // 1-4 items khareedega

    for (int i = 0; i < numPurchases; i++) {
      int randomItemIndex = random.nextInt(items.length);
      Item selectedItem = items[randomItemIndex];

      if (selectedItem.stock > 0 && player.money >= selectedItem.price) {
        player.money -= selectedItem.price;
        selectedItem.stock--;
        totalEarnings += selectedItem.price;

        System.out.println("✓ " + player.name + " ne " + selectedItem.name + " kharida: " +
            selectedItem.price + " paise!");
        System.out.println("  (" + player.name + " bought " + selectedItem.name + ": " +
            selectedItem.price + " money!)");
      }
    }

    System.out.println("→ " + player.name + " gaya! Baaki paise: " + player.money);
    System.out.println("  (" + player.name + " left! Remaining money: " + player.money + ")");
  }

  void showEarnings() {
    System.out.println("\n╔════════════════════════════════╗");
    System.out.println("║  TOTAL EARNINGS (KUL KAMAI):   ║");
    System.out.println("║        " + totalEarnings + " paise         ║");
    System.out.println("╚════════════════════════════════╝");
  }
}

public class shopify {
  public static void main(String[] args) {
    Shop shop = new Shop();
    Scanner scanner = new Scanner(System.in);
    Random random = new Random();

    System.out.println("╔═══════════════════════════════════╗");
    System.out.println("║   🎮 WELCOME TO SHOP GAME! 🎮    ║");
    System.out.println("║   Dukaan Khol aur Paise Banao!   ║");
    System.out.println("╚═══════════════════════════════════╝\n");

    // Ask for game name
    System.out.print("🎪 Apne dukaan ka naam kya hoga? (Game Name): ");
    String gameName = scanner.nextLine();

    // Ask for number of players

    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    System.out.println("╔═══════════════════════════════════╗");
    System.out.println("║  🏪 \"" + gameName + "\" 🏪");
    System.out.println("║     GAME SHURU HO GAYA!           ║");
    System.out.println("╚═══════════════════════════════════╝\n");

    // Auto-spawn players
    while (true) {
      shop.displayInventory();
      System.out.println("\n🏪 Shop Open...");

      // Random delay 1-9 seconds
      // Random shop activity
      String[] waitingMessages = {
          "🧹 Cleaning the shop...",
          "📦 Arranging items on shelves...",
          "💰 Counting coins...",
          "🏪 Waiting for customers...",
          "📋 Checking inventory...",
          "🔨 Repairing equipment...",
          "✨ Polishing weapons...",
          "📖 Reading shop records..."
      };

      System.out.println(
          waitingMessages[random.nextInt(waitingMessages.length)]);

      // Random delay 1-9 seconds (hidden from player)
      int delaySeconds = random.nextInt(9) + 1;

      try {
        Thread.sleep(delaySeconds * 1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }

      shop.playerArrives();

      System.out.println("\n━━━━━━━━━━━━━━━━━━━━");
      System.out.println("1. Next Customer");
      System.out.println("2. Close Shop");
      System.out.print("Choice: ");

      int choice = scanner.nextInt();

      if (choice == 2) {
        break;
      }

      try {
        Thread.sleep(500);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }

    // Final summary

    System.out.println("/n╔═══════════════════════════════════╗");
    System.out.println("║     GAME KHATAM HO GAYA!          ║");
    System.out.println("╚═══════════════════════════════════╝");
    shop.showEarnings();
    System.out.println("\n📊 Aapke Dukaan ki Information:");
    System.out.println("🏪 Dukaan Ka Naam: " + gameName);

    System.out.println("👤 Players Served: " + shop.playersServed);
    System.out.println("💰 Total Kamai: " + shop.totalEarnings + " paise");

    System.out.println("\n🙏 Dhanyavaad! Aapka dukaan band ho raha hai!");
    System.out.println("Thank you! Your shop is closing!");

    scanner.close();
  }
}