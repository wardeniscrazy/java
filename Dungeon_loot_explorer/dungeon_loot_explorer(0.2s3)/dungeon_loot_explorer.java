
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

    // 2D array: each item has [name, rarity]
    String[][] loot = {
        // COMMON
        { "Stick", "Common" },
        { "Pebble", "Common" },
        { "Torn Cloth", "Common" },
        { "Mushroom", "Common" },
        { "Bone Fragment", "Common" },
        { "Cracked Shield", "Common" },
        { "Empty Bottle", "Common" },
        { "Wooden Club", "Common" },
        { "Feather", "Common" },
        { "Spider Silk", "Common" },
        { "Bat Wing", "Common" },
        { "Clay Pot", "Common" },
        { "Herbs", "Common" },
        { "Dried Meat", "Common" },
        { "Small Gem", "Common" },
        { "Bronze Coin", "Common" },
        { "Broken Arrow", "Common" },
        { "Worn Gloves", "Common" },
        { "Old Boots", "Common" },
        { "Traveler's Hat", "Common" },
        { "Rabbit Fur", "Common" },
        { "Snake Skin", "Common" },
        { "Tree Sap", "Common" },
        { "Campfire Kit", "Common" },
        { "Stone Knife", "Common" },
        { "Tin Ring", "Common" },
        { "Wooden Spear", "Common" },
        { "Sling", "Common" },
        { "Small Torch", "Common" },
        { "Wheat Bundle", "Common" },

        // UNCOMMON
        { "Steel Sword", "Uncommon" },
        { "Crossbow", "Uncommon" },
        { "Iron Helmet", "Uncommon" },
        { "Golden Bracelet", "Uncommon" },
        { "Hunter's Knife", "Uncommon" },
        { "Wolf Fang", "Uncommon" },
        { "Moon Pendant", "Uncommon" },
        { "Battle Axe", "Uncommon" },
        { "Steel Boots", "Uncommon" },
        { "Gem Pouch", "Uncommon" },
        { "Magic Herb", "Uncommon" },
        { "Silver Dagger", "Uncommon" },
        { "Forest Charm", "Uncommon" },
        { "Knight Shield", "Uncommon" },
        { "Treasure Map", "Uncommon" },

        // RARE
        { "Flame Staff", "Rare" },
        { "Frost Wand", "Rare" },
        { "Golden Armor", "Rare" },
        { "Storm Bow", "Rare" },
        { "Runic Stone", "Rare" },
        { "Ancient Key", "Rare" },
        { "Royal Crown", "Rare" },
        { "Crystal Wand", "Rare" },
        { "Spirit Lantern", "Rare" },
        { "Mystic Blade", "Rare" },

        // EPIC
        { "Dragon Heart", "Epic" },
        { "Demon Horn", "Epic" },
        { "Celestial Bow", "Epic" },
        { "Ancient Relic", "Epic" },
        { "Titan Shield", "Epic" },
        { "Void Armor", "Epic" },
        { "Soul Gem", "Epic" },

        // LEGENDARY
        { "Blade of Eternity", "Legendary" },
        { "Crown of Kings", "Legendary" },
        { "Heart of the Dragon", "Legendary" },
        { "Orb of Creation", "Legendary" },
        { "Staff of the Ancients", "Legendary" }
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
            System.out.println("you killed "+monster);
            System.out.println("player health after fight " + (player_health - rn1));

            int row = rn.nextInt(loot.length);

            System.out.println(monster + " droped item: " + loot[row][0]);
            System.out.println("Rarity: " + loot[row][1]);

            break;
          case 'r':
            System.out.println("run fast");
            break; 
            

        }
      }

    }
  }
}

