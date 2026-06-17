
import java.util.*;

public class Dungeon_Loot_Explorer {
  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
   

    String[][] mon = {

        { "Swamp Rat", "Common", "Rat Tail, Torn Fur, 2 Gold" },
        { "Mountain Goat", "Common", "Goat Horn, Thick Hide, 4 Gold" },
        { "Wild Chicken", "Common", "Feather, Raw Meat, 1 Gold" },
        { "Cave Frog", "Common", "Sticky Core, Frog Leg, 2 Gold" },
        { "Forest Fox", "Common", "Fox Tail, Soft Fur, 3 Gold" },
        { "Young Spider", "Common", "Spider Silk, Venom Sac, 3 Gold" },
        { "Lost Scout", "Common", "Broken Dagger, Cloth Scrap, 5 Gold" },
        { "Goblin Peasant", "Common", "Rusty Knife, Goblin Ear, 4 Gold" },
        { "Zombie Villager", "Common", "Rotten Flesh, Bone Fragment, 2 Gold" },
        { "Skeleton Archer", "Common", "Broken Bow, Bone Fragment, 3 Gold" },

        { "Mud Crab", "Common", "Crab Claw, Hard Shell, 2 Gold" },
        { "Wild Boar", "Common", "Boar Tusk, Raw Meat, 5 Gold" },
        { "Cave Bat", "Common", "Bat Wing, Dark Fur, 2 Gold" },
        { "Bandit Rookie", "Common", "Leather Strap, Dull Dagger, 6 Gold" },
        { "Wolf Pup", "Common", "Wolf Fang, Soft Fur, 3 Gold" },
        { "Desert Lizard", "Common", "Lizard Scale, Dry Hide, 3 Gold" },
        { "River Turtle", "Common", "Turtle Shell, River Pearl, 4 Gold" },
        { "Dark Crow", "Common", "Black Feather, Sharp Beak, 2 Gold" },
        { "Stone Beetle", "Common", "Beetle Shell, Stone Core, 4 Gold" },
        { "Tiny Slime", "Common", "Slime Gel, Sticky Residue, 2 Gold" },

        { "Broken Golem", "Common", "Stone Fragment, Magic Dust, 8 Gold" },
        { "Feral Cat", "Common", "Cat Claw, Soft Fur, 2 Gold" },
        { "Snow Rabbit", "Common", "Rabbit Foot, White Fur, 1 Gold" },
        { "Goblin Miner", "Common", "Copper Ore, Pickaxe Head, 6 Gold" },
        { "Goblin Cook", "Common", "Burnt Meat, Iron Spoon, 4 Gold" },
        { "Rotten Zombie", "Common", "Rotten Flesh, Decayed Bone, 2 Gold" },
        { "Dust Imp", "Common", "Dust Essence, Tiny Horn, 4 Gold" },
        { "Marsh Snake", "Common", "Snake Fang, Snake Skin, 3 Gold" },
        { "Wild Dog", "Common", "Dog Fang, Rough Fur, 3 Gold" },
        { "Jungle Monkey", "Common", "Monkey Paw, Jungle Fruit, 4 Gold" },

        { "Woodland Deer", "Common", "Deer Antler, Deer Hide, 5 Gold" },
        { "Scavenger Bird", "Common", "Wing Feather, Sharp Talon, 2 Gold" },
        { "Young Kobold", "Common", "Kobold Tooth, Leather Pouch, 5 Gold" },
        { "Cursed Farmer", "Common", "Old Hat, Rusty Sickle, 6 Gold" },
        { "Cave Worm", "Common", "Worm Segment, Acid Gland, 3 Gold" },
        { "Lost Merchant", "Common", "Trade Ledger, Cloth Bundle, 7 Gold" },
        { "Weak Skeleton", "Common", "Bone Fragment, Skull Piece, 3 Gold" },
        { "Small Ooze", "Common", "Ooze Gel, Sticky Core, 2 Gold" },
        { "Goblin Thief", "Common", "Lockpick, Goblin Ear, 6 Gold" },
        { "Forest Sprite", "Common", "Sprite Dust, Nature Leaf, 10 Gold" },

        //uncommon=========================

        { "Goblin Warrior", "Uncommon", "Iron Axe, Goblin Badge, 6 Gold" },
        { "Goblin Shaman", "Uncommon", "Magic Totem, Shaman Robe, 7 Gold" },
        { "Dire Wolf", "Uncommon", "Dire Fang, Thick Fur, 8 Gold" },
        { "Stone Troll", "Uncommon", "Troll Hide, Stone Chunk, 10 Gold" },
        { "Orc Scout", "Uncommon", "Orc Tooth, Scout Knife, 7 Gold" },
        { "Fire Imp", "Uncommon", "Fire Essence, Burnt Horn, 8 Gold" },
        { "Ice Sprite", "Uncommon", "Ice Crystal, Frozen Dust, 7 Gold" },
        { "Venom Spider", "Uncommon", "Venom Gland, Spider Silk, 8 Gold" },
        { "Cave Stalker", "Uncommon", "Sharp Claw, Dark Fur, 9 Gold" },
        { "Dark Mage", "Uncommon", "Magic Dust, Torn Spellbook, 10 Gold" },

        { "Shadow Bandit", "Uncommon", "Shadow Cloth, Dagger Blade, 8 Gold" },
        { "Frost Zombie", "Uncommon", "Frozen Bone, Rotten Flesh, 7 Gold" },
        { "Bone Knight", "Uncommon", "Knight Bone, Rusty Shield, 10 Gold" },
        { "Sand Raider", "Uncommon", "Desert Cloth, Curved Blade, 8 Gold" },
        { "Lava Beetle", "Uncommon", "Lava Shell, Heat Core, 9 Gold" },
        { "Ancient Bat", "Uncommon", "Ancient Wing, Bat Fang, 7 Gold" },
        { "Crystal Slime", "Uncommon", "Crystal Shard, Slime Core, 9 Gold" },
        { "Cursed Knight", "Uncommon", "Cursed Armor Piece, Dark Metal, 11 Gold" },
        { "Forest Guardian", "Uncommon", "Living Bark, Nature Essence, 10 Gold" },
        { "River Serpent", "Uncommon", "Serpent Scale, Water Pearl, 9 Gold" },

        { "Swamp Witch", "Uncommon", "Witch Herb, Magic Brew, 10 Gold" },
        { "Thunder Hawk", "Uncommon", "Thunder Feather, Sharp Talon, 9 Gold" },
        { "Poison Drake", "Uncommon", "Drake Scale, Poison Sac, 11 Gold" },
        { "Savage Orc", "Uncommon", "Orc Tooth, Iron Club, 9 Gold" },
        { "Goblin Captain", "Uncommon", "Captain Badge, Steel Dagger, 10 Gold" },
        { "Mushroom Beast", "Uncommon", "Glow Mushroom, Beast Core, 8 Gold" },
        { "Undead Archer", "Uncommon", "Bone Arrow, Undead Bone, 8 Gold" },
        { "Frost Wolf", "Uncommon", "Frost Fang, Thick Fur, 10 Gold" },
        { "Ash Golem", "Uncommon", "Ash Core, Stone Fragment, 11 Gold" },
        { "Jungle Hunter", "Uncommon", "Hunter Spear, Jungle Fang, 9 Gold" },

        { "Dark Assassin", "Uncommon", "Poison Blade, Shadow Cloth, 12 Gold" },
        { "Moon Stalker", "Uncommon", "Moon Fragment, Sharp Claw, 11 Gold" },
        { "Scarred Minotaur", "Uncommon", "Minotaur Horn, Heavy Hide, 13 Gold" },
        { "Crypt Keeper", "Uncommon", "Crypt Key, Bone Dust, 12 Gold" },
        { "Steel Boar", "Uncommon", "Steel Tusk, Reinforced Hide, 15 Gold" },

        //rare==============================

        { "Orc Champion", "Rare", "Champion Axe, Orc Medal, 16 Gold" },
        { "Dark Priest", "Rare", "Dark Tome, Holy Relic, 17 Gold" },
        { "Flame Drake", "Rare", "Drake Scale, Fire Core, 18 Gold" },
        { "Ice Golem", "Rare", "Ice Crystal, Frozen Core, 18 Gold" },
        { "Shadow Beast", "Rare", "Shadow Fang, Dark Essence, 19 Gold" },
        { "Vampire Hunter", "Rare", "Silver Dagger, Hunter Cloak, 20 Gold" },
        { "Ancient Treant", "Rare", "Ancient Bark, Nature Core, 21 Gold" },
        { "Thunder Lizard", "Rare", "Thunder Scale, Storm Core, 18 Gold" },
        { "Necromancer", "Rare", "Soul Crystal, Necro Tome, 22 Gold" },
        { "Crystal Guardian", "Rare", "Crystal Heart, Shattered Gem, 20 Gold" },

        { "Blood Werewolf", "Rare", "Blood Fang, Thick Pelt, 22 Gold" },
        { "Spirit Knight", "Rare", "Spirit Blade, Ghost Armor, 23 Gold" },
        { "Infernal Demon", "Rare", "Demon Horn, Infernal Ash, 24 Gold" },
        { "Cursed Paladin", "Rare", "Broken Holy Sword, Cursed Plate, 23 Gold" },
        { "Abyss Stalker", "Rare", "Void Claw, Abyss Essence, 24 Gold" },
        { "Death Reaper", "Rare", "Reaper Hood, Soul Dust, 25 Gold" },
        { "Runic Golem", "Rare", "Rune Stone, Magic Core, 22 Gold" },
        { "Bone Dragon", "Rare", "Dragon Bone, Ancient Skull, 27 Gold" },
        { "Storm Elemental", "Rare", "Storm Fragment, Charged Essence, 24 Gold" },
        { "Void Mage", "Rare", "Void Orb, Torn Grimoire, 25 Gold" },

        { "Golden Minotaur", "Rare", "Minotaur Horn, Gold Nugget, 26 Gold" },
        { "Dark Warlord", "Rare", "War Banner, Dark Armor, 28 Gold" },
        { "Soul Collector", "Rare", "Soul Gem, Spirit Chain, 26 Gold" },
        { "Chaos Beast", "Rare", "Chaos Claw, Beast Core, 27 Gold" },
        { "Ancient Serpent", "Rare", "Ancient Scale, Venom Core, 25 Gold" },
        { "Phantom Rider", "Rare", "Ghost Saddle, Phantom Dust, 26 Gold" },
        { "Hell Hound", "Rare", "Hell Fang, Burning Fur, 24 Gold" },
        { "Corrupted Treant", "Rare", "Corrupt Bark, Twisted Seed, 23 Gold" },
        { "Shadow Reaper", "Rare", "Shadow Scythe Fragment, Dark Crystal, 29 Gold" },
        { "Titan Beetle", "Rare", "Titan Shell, Heavy Core, 30 Gold" },

        //epic+++++++++++++++++++++++++++++

        { "Ancient Dragon", "Epic", "Dragon Heart, Ancient Scale, 40 Gold" },
        { "Frost Dragon", "Epic", "Frozen Heart, Frost Scale, 38 Gold" },
        { "Inferno Dragon", "Epic", "Inferno Core, Dragon Fang, 42 Gold" },
        { "Lich King", "Epic", "Lich Crown, Soul Crystal, 45 Gold" },
        { "Demon General", "Epic", "Demon Blade, Infernal Horn, 40 Gold" },
        { "Void Reaper", "Epic", "Void Essence, Reaper Fragment, 43 Gold" },
        { "Titan Golem", "Epic", "Titan Core, Giant Stone, 39 Gold" },
        { "Ancient Hydra", "Epic", "Hydra Fang, Hydra Scale, 41 Gold" },
        { "Chaos Knight", "Epic", "Chaos Armor, Chaos Shard, 37 Gold" },
        { "Storm Dragon", "Epic", "Storm Core, Dragon Wing, 44 Gold" },

        { "Soul Tyrant", "Epic", "Soul Relic, Spirit Chain, 46 Gold" },
        { "Blood King", "Epic", "Blood Crown, Crimson Gem, 42 Gold" },
        { "Plague Lord", "Epic", "Plague Essence, Toxic Core, 39 Gold" },
        { "Shadow Emperor", "Epic", "Shadow Crystal, Dark Cloak, 47 Gold" },
        { "Abyss Watcher", "Epic", "Abyss Eye, Void Fragment, 43 Gold" },

        //legendry======================

        { "Dragon King", "Legendary", "Dragon Crown, King Scale, 60 Gold" },
        { "Phoenix King", "Legendary", "Phoenix Flame, Eternal Feather, 65 Gold" },
        { "Titan Lord", "Legendary", "Titan Core, Giant Relic, 70 Gold" },
        { "Ancient God", "Legendary", "Divine Fragment, Sacred Crystal, 75 Gold" },
        { "Void Monarch", "Legendary", "Void Crown, Abyss Core, 72 Gold" },

        { "Abyss King", "Legendary", "Abyss Relic, Dark Heart, 78 Gold" },
        { "Celestial Guardian", "Legendary", "Celestial Crystal, Star Fragment, 80 Gold" },
        { "Demon Overlord", "Legendary", "Overlord Horn, Infernal Core, 85 Gold" },
        { "World Devourer", "Legendary", "World Fragment, Ancient Fang, 90 Gold" },
        { "Storm Emperor", "Legendary", "Storm Crown, Thunder Core, 95 Gold" },

        //methic===============

        { "The Forgotten One", "Mythic", "Forgotten Relic, Eternal Core, 150 Gold" },
        { "World Ender", "Mythic", "World Fragment, Apocalypse Heart, 175 Gold" },
        { "Void God", "Mythic", "Void Essence, Divine Core, 200 Gold" },
        { "Titan of Worlds", "Mythic", "Titan Soul, World Stone, 225 Gold" },
        { "The Final Boss", "Mythic", "Creator Crystal, Final Crown, 250 Gold" }

    };

    int player_health = 100;

    Random rn = new Random();

    System.out.println("=========================================");
    System.out.println("  Welcome to the Dungeon Loot Explorer!");
    System.out.println("=========================================");
    int level;
    int hp;
    int gold;
    int xp;
    System.out.println("level: ");
    System.out.println("HP: ");
    System.out.println("Gold: ");
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
