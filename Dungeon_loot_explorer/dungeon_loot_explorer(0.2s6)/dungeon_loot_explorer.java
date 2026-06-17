
import java.util.*;

public class Dungeon_Loot_Explorer {
  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    String[][] mon = {

        { "Swamp Rat", "Common", "Rat Tail, Torn Fur ", " 2  " },
        { "Mountain Goat", "Common", "Goat Horn, Thick Hide", "4  " },
        { "Wild Chicken", "Common", "Feather, Raw Meat ", "1  " },
        { "Cave Frog", "Common", "Sticky Core, Frog Leg ", "2  " },
        { "Forest Fox", "Common", "Fox Tail, Soft Fur ", "3  " },
        { "Young Spider", "Common", "Spider Silk, Venom Sac ", " 3  " },

        { "Lost Scout", "Common", "Broken Dagger, Cloth Scrap", " 5  " },
        { "Goblin Peasant", "Common", "Rusty Knife, Goblin Ear", " 4  " },
        { "Skeleton Archer", "Common", "Broken Bow, Bone Fragment", " 3  " },
        { "Zombie Villager", "Common", "Rotten Flesh, Bone Fragment", "2  " },

        { "Mud Crab", "Common", "Crab Claw, Hard Shell", "2  " },
        { "Wild Boar", "Common", "Boar Tusk, Raw Meat", "5  " },
        { "Cave Bat", "Common", "Bat Wing, Dark Fur", "2  " },
        { "Bandit Rookie", "Common", "Leather Strap, Dull Dagger", "6  " },
        { "Wolf Pup", "Common", "Wolf Fang, Soft Fur", "3  " },
        { "Desert Lizard", "Common", "Lizard Scale, Dry Hide", "3  " },
        { "River Turtle", "Common", "Turtle Shell, River Pearl", " 4  " },
        { "Dark Crow", "Common", "Black Feather, Sharp Beak", "2  " },
        { "Stone Beetle", "Common", "Beetle Shell, Stone Core", " 4  " },
        { "Tiny Slime", "Common", "Slime Gel, Sticky Residue", " 2  " },

        { "Broken Golem", "Common", "Stone Fragment, Magic Dust", " 8  " },
        { "Feral Cat", "Common", "Cat Claw, Soft Fur", " 2  " },
        { "Snow Rabbit", "Common", "Rabbit Foot, White Fur", " 1  " },
        { "Goblin Miner", "Common", "Copper Ore, Pickaxe Head", " 6  " },
        { "Goblin Cook", "Common", "Burnt Meat, Iron Spoon", " 4  " },
        { "Rotten Zombie", "Common", "Rotten Flesh, Decayed Bone", " 2  " },
        { "Dust Imp", "Common", "Dust Essence, Tiny Horn", " 4  " },
        { "Marsh Snake", "Common", "Snake Fang, Snake Skin", " 3  " },
        { "Wild Dog", "Common", "Dog Fang, Rough Fur", " 3  " },
        { "Jungle Monkey", "Common", "Monkey Paw, Jungle Fruit", " 4  " },

        { "Woodland Deer", "Common", "Deer Antler, Deer Hide", " 5  " },
        { "Scavenger Bird", "Common", "Wing Feather, Sharp Talon", " 2  " },
        { "Young Kobold", "Common", "Kobold Tooth, Leather Pouch", " 5  " },
        { "Cursed Farmer", "Common", "Old Hat, Rusty Sickle", " 6  " },
        { "Cave Worm", "Common", "Worm Segment, Acid Gland", " 3  " },
        { "Lost Merchant", "Common", "Trade Ledger, Cloth Bundle", " 7  " },
        { "Weak Skeleton", "Common", "Bone Fragment, Skull Piece", " 3  " },
        { "Small Ooze", "Common", "Ooze Gel, Sticky Core", " 2  " },
        { "Goblin Thief", "Common", "Lockpick, Goblin Ear", " 6  " },
        { "Forest Sprite", "Common", "Sprite Dust, Nature Leaf", " 10  " }, {
            "Goblin Warrior", "Uncommon", "Iron Axe, Goblin Badge", " 6  " },
        { "Goblin Shaman", "Uncommon", "Magic Totem, Shaman Robe", " 7  " },
        { "Dire Wolf", "Uncommon", "Dire Fang, Thick Fur", " 8  " },
        { "Stone Troll", "Uncommon", "Troll Hide, Stone Chunk", " 10  " },
        { "Orc Scout", "Uncommon", "Orc Tooth, Scout Knife", " 7  " },

        // uncommon=========================

        { "Fire Imp", "Uncommon", "Fire Essence, Burnt Horn", " 8  " },
        { "Ice Sprite", "Uncommon", "Ice Crystal, Frozen Dust", " 7  " },
        { "Venom Spider", "Uncommon", "Venom Gland, Spider Silk", " 8  " },
        { "Cave Stalker", "Uncommon", "Sharp Claw, Dark Fur", " 9  " },
        { "Dark Mage", "Uncommon", "Magic Dust, Torn Spellbook", " 10  " },

        { "Shadow Bandit", "Uncommon", "Shadow Cloth, Dagger Blade", " 8  " },
        { "Frost Zombie", "Uncommon", "Frozen Bone, Rotten Flesh", " 7  " },
        { "Bone Knight", "Uncommon", "Knight Bone, Rusty Shield", " 10  " },
        { "Sand Raider", "Uncommon", "Desert Cloth, Curved Blade", " 8  " },
        { "Lava Beetle", "Uncommon", "Lava Shell, Heat Core", " 9  " },
        { "Ancient Bat", "Uncommon", "Ancient Wing, Bat Fang", " 7  " },
        { "Crystal Slime", "Uncommon", "Crystal Shard, Slime Core", " 9  " },
        { "Cursed Knight", "Uncommon", "Cursed Armor Piece, Dark Metal", " 11  " },
        { "Forest Guardian", "Uncommon", "Living Bark, Nature Essence", " 10  " },
        { "River Serpent", "Uncommon", "Serpent Scale, Water Pearl", " 9  " },

        { "Swamp Witch", "Uncommon", "Witch Herb, Magic Brew", " 10  " },
        { "Thunder Hawk", "Uncommon", "Thunder Feather, Sharp Talon", " 9  " },
        { "Poison Drake", "Uncommon", "Drake Scale, Poison Sac", " 11  " },
        { "Savage Orc", "Uncommon", "Orc Tooth, Iron Club", " 9  " },
        { "Goblin Captain", "Uncommon", "Captain Badge, Steel Dagger", " 10  " },
        { "Mushroom Beast", "Uncommon", "Glow Mushroom, Beast Core", " 8  " },
        { "Undead Archer", "Uncommon", "Bone Arrow, Undead Bone", " 8  " },
        { "Frost Wolf", "Uncommon", "Frost Fang, Thick Fur", " 10  " },
        { "Ash Golem", "Uncommon", "Ash Core, Stone Fragment", " 11  " },
        { "Jungle Hunter", "Uncommon", "Hunter Spear, Jungle Fang", " 9  " },

        { "Dark Assassin", "Uncommon", "Poison Blade, Shadow Cloth", " 12  " },
        { "Moon Stalker", "Uncommon", "Moon Fragment, Sharp Claw", " 11  " },
        { "Scarred Minotaur", "Uncommon", "Minotaur Horn, Heavy Hide", " 13  " },
        { "Crypt Keeper", "Uncommon", "Crypt Key, Bone Dust", " 12  " },
        { "Steel Boar", "Uncommon", "Steel Tusk, Reinforced Hide", " 15  " },
        { "Orc Champion", "Rare", "Champion Axe, Orc Medal", " 16  " },
        { "Dark Priest", "Rare", "Dark Tome, Holy Relic", " 17  " },
        { "Flame Drake", "Rare", "Drake Scale, Fire Core", " 18  " },
        { "Ice Golem", "Rare", "Ice Crystal, Frozen Core", " 18  " },

        // rare==============================

        { "Shadow Beast", "Rare", "Shadow Fang, Dark Essence", " 19  " },
        { "Vampire Hunter", "Rare", "Silver Dagger, Hunter Cloak", " 20  " },
        { "Ancient Treant", "Rare", "Ancient Bark, Nature Core", " 21  " },
        { "Thunder Lizard", "Rare", "Thunder Scale, Storm Core", " 18  " },
        { "Necromancer", "Rare", "Soul Crystal, Necro Tome", " 22  " },
        { "Crystal Guardian", "Rare", "Crystal Heart, Shattered Gem", " 20  " },

        { "Blood Werewolf", "Rare", "Blood Fang, Thick Pelt", " 22  " },
        { "Spirit Knight", "Rare", "Spirit Blade, Ghost Armor", " 23  " },
        { "Infernal Demon", "Rare", "Demon Horn, Infernal Ash", " 24  " },
        { "Cursed Paladin", "Rare", "Broken Holy Sword, Cursed Plate", " 23  " },
        { "Abyss Stalker", "Rare", "Void Claw, Abyss Essence", " 24  " },
        { "Death Reaper", "Rare", "Reaper Hood, Soul Dust", " 25  " },
        { "Runic Golem", "Rare", "Rune Stone, Magic Core", " 22  " },
        { "Bone Dragon", "Rare", "Dragon Bone, Ancient Skull", " 27  " },
        { "Storm Elemental", "Rare", "Storm Fragment, Charged Essence", " 24  " },
        { "Void Mage", "Rare", "Void Orb, Torn Grimoire", " 25  " },

        { " en Minotaur", "Rare", "Minotaur Horn,   Nugget", " 26  " },
        { "Dark Warlord", "Rare", "War Banner, Dark Armor", " 28  " },
        { "Soul Collector", "Rare", "Soul Gem, Spirit Chain", " 26  " },
        { "Chaos Beast", "Rare", "Chaos Claw, Beast Core", " 27  " },
        { "Ancient Serpent", "Rare", "Ancient Scale, Venom Core", " 25  " },
        { "Phantom Rider", "Rare", "Ghost Saddle, Phantom Dust", " 26  " },
        { "Hell Hound", "Rare", "Hell Fang, Burning Fur", " 24  " },
        { "Corrupted Treant", "Rare", "Corrupt Bark, Twisted Seed", " 23  " },
        { "Shadow Reaper", "Rare", "Shadow Scythe Fragment", " Dark Crystal, 29  " },
        { "Titan Beetle", "Rare", "Titan Shell, Heavy Core", " 30  " },
        { "Ancient Dragon", "Epic", "Dragon Heart, Ancient Scale", " 40  " },
        { "Frost Dragon", "Epic", "Frozen Heart, Frost Scale", " 38  " },
        { "Inferno Dragon", "Epic", "Inferno Core, Dragon Fang", " 42  " },

        // epic+++++++++++++++++++++++++++++

        { "Lich King", "Epic", "Lich Crown, Soul Crystal", " 45  " },
        { "Demon General", "Epic", "Demon Blade, Infernal Horn", " 40  " },
        { "Void Reaper", "Epic", "Void Essence, Reaper Fragment", " 43  " },
        { "Titan Golem", "Epic", "Titan Core, Giant Stone", " 39  " },
        { "Ancient Hydra", "Epic", "Hydra Fang, Hydra Scale", " 41  " },
        { "Chaos Knight", "Epic", "Chaos Armor, Chaos Shard", " 37  " },
        { "Storm Dragon", "Epic", "Storm Core, Dragon Wing", " 44  " },

        { "Soul Tyrant", "Epic", "Soul Relic, Spirit Chain", " 46  " },
        { "Blood King", "Epic", "Blood Crown, Crimson Gem", " 42  " },
        { "Plague Lord", "Epic", "Plague Essence, Toxic Core", " 39  " },
        { "Shadow Emperor", "Epic", "Shadow Crystal, Dark Cloak", " 47  " },
        { "Abyss Watcher", "Epic", "Abyss Eye, Void Fragment", " 43  " }, {
            "Dragon King", "Legendary", "Dragon Crown, King Scale", " 60  " },
        { "Phoenix King", "Legendary", "Phoenix Flame, Eternal Feather", " 65  " },

        // legendry======================

        { "Titan Lord", "Legendary", "Titan Core, Giant Relic", " 70  " },
        { "Ancient God", "Legendary", "Divine Fragment, Sacred Crystal", " 75  " },
        { "Void Monarch", "Legendary", "Void Crown, Abyss Core", " 72  " },

        { "Abyss King", "Legendary", "Abyss Relic, Dark Heart", " 78  " },
        { "Celestial Guardian", "Legendary", "Celestial Crystal, Star Fragment", " 80  "
        },
        { "Demon Overlord", "Legendary", "Overlord Horn, Infernal Core", " 85  " },
        { "World Devourer", "Legendary", "World Fragment, Ancient Fang", " 90  " },
        { "Storm Emperor", "Legendary", "Storm Crown, Thunder Core", " 95  " },
        { "The Forgotten One", "Mythic", "Forgotten Relic, Eternal Core", "150  " },

        // methic===============

        { "World Ender", "Mythic", "World Fragment, Apocalypse Heart", " 175  " },
        { "Void God", "Mythic", "Void Essence, Divine Core", " 200  " },
        { "Titan of Worlds", "Mythic", "Titan Soul, World Stone", " 225  " },
        { "The Final Boss", "Mythic", "Creator Crystal, Final Crown", "250  " }

    };

    int player_health = 100;

    Random rn = new Random();

    System.out.println("=========================================");
    System.out.println("  Welcome to the Dungeon Loot Explorer!");
    System.out.println("=========================================");
    int level;
    int hp;
    int gold = 0;

    int xp;
    System.out.println("level: ");
    System.out.println("HP: ");
    System.out.println(" Gold: ");
    System.out.println("XP:");

    System.out.println("1.> Enter Room");
    System.out.println("2.> Inventory");
    System.out.println("3.> Status:");
    System.out.println("4.> quit");

    while (true) {

      int input = sc.nextInt();

      if (input == 1) {

        int mobIndex = rn.nextInt(mon.length);
        String monster = mon[mobIndex][0];

        int mobGold = Integer.parseInt(mon[mobIndex][3].trim());
        gold += mobGold;

        System.out.println("You need to fight with " + monster);
        System.out.println("Press 'a' to attack...");

        char action = sc.next().charAt(0);

        while (true) {

          if (action == 'a') {

            System.out.println("Attack!");
            int[] damegs = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 12 };
            Random rnn = new Random();
            int rn1 = rnn.nextInt(100) + 1;
            System.out.println(rn1);
            System.out.println("you killed " + monster);
            System.out.println("(Rarity: " + (mon[mobIndex][1]) + ")");
            System.out.println("(Dropped Items: " + mon[mobIndex][2] + ")");
            System.out.println("Gold: " + mon[mobIndex][3]);
            System.out.println("You have " + gold + " golds");
            System.out.println("player health after fight " + (player_health - rn1));

          }
          break;
        }

      }

      if (input == 4) {
        break;
      }

    }

  }
}
