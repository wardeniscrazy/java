import java.util.*;

public class lootpool {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Random rand = new Random();

    String[] lootPool = { "Wooden Pickaxe", "Stone Pickaxe", "Iron Pickaxe", "Diamond Pickaxe",
        "Wooden Sword", "Stone Sword", "Iron Sword", "Diamond Sword",
        "Wood", "Stone", "Coal", "Iron Ore",
        "Apple", "Bread", "Carrot", "Potato" };

    String[] sentences = { "You found a chest", "You got a chest ", "You received a  chest ",
        "You obtained a  chest " };
        int randomSentenceIndex = rand.nextInt(sentences.length);
    System.out.println(sentences[randomSentenceIndex]);

        System.out.print("press enter to open a chest");
        sc.nextLine();
 
    String[] sentences2nd = { "You found a ", "You got a ", "You received a  ", "You obtained a  " };
    int randomSentenceIndex2 = rand.nextInt(sentences2nd.length);
    System.out.println(sentences2nd[randomSentenceIndex2]);

        int randomIndex = rand.nextInt(lootPool.length);

        System.out.println(lootPool[randomIndex]);
    
        int randomIndex2 = rand.nextInt(lootPool.length);

        System.out.println(lootPool[randomIndex2]);


  }
  
}
