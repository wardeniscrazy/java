


import java.util.*;

public class shopi2 {
  public static void main(String[] args) {

Scanner sc

    // customers string

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

    System.out.println("***************************************************");
    System.out.println("                     my shop");
    System.out.println("***************************************************");
    System.out.println("");
    System.out.println("");
    System.out.println("YOUR SHOP IS CLOSED");
    System.out.println("press 'O' TO OPEN ");
    
  

    Random rand = new Random();
    String customer = playerNames[rand.nextInt(playerNames.length)];
    System.out.println(customer);

  }
}
