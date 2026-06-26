import java.util.Scanner;
public class whagiht_measering {
   public static void main(String[] args) {
  

    int usersinv = 100;
    
    
    int Wooden_axe = 5;
    int Wooden_picaxe = 7;
    int Wooden_hoe = 3;
    int Wooden_shovel = 6;
    int Wooden_sword = 9;
    
    int stone_axe = 8;
    int stone_picaxe = 13;
    int stone_hoe = 7;
    int stone_shovel = 9;
    int stone_sword = 15;
     /* if (input.equals("Wooden_axe")) {
      System.out.println(usersinv - Wooden_axe);

     }

     else if(input.equals("h")){
      System.out.println(Wooden_picaxe);
     }

     else if(input.equals("j")){
      System.out.println(stone_sword);
     } */

    int iron_axe = 14;
    int iron_picaxe = 18;
    int iron_hoe = 11;
    int iron_shovel = 16;
    int iron_sword = 19;

    int gold_axe = 12;
    int gold_picaxe = 16;
    int gold_hoe = 8;
    int gold_shovel = 14;
    int gold_sword = 17;
                        
    int diamond_axe = 17;
    int diamond_picaxe = 22;
    int diamond_hoe = 16;
    int diamond_shovel = 19;
    int diamond_sword = 27;
                        
    int netherite_axe = 19;
    int netherite_picaxe = 26;
    int netherite_hoe = 18;
    int netherite_shovel = 20;
    int netherite_sword = 32;
                        

System.out.println("you have these items in ₣₿₻ƒ ");
System.out.println("              Wooden items         Stone items         Iron items         Golden items         Diamond items         Netherite items");
System.out.println("  ");
System.out.println("1.Axes->      Wooden_axe           Stone_axe           Iron_axe           Gold_axe             Diamond_axe           Netherite_axe");
System.out.println("2.Picaxe->    Wooden_picaxe        Stone_picaxe        Iron_picaxe        Gold_picaxe          Diamond_picaxe        Netherite_picaxe");
System.out.println("3.Hoe->       Wooden_hoe           Stone_hoe           Iron_hoe           Gold_hoe             Diamond_hoe           Netherite_hoe");
System.out.println("4.Shovel->    Wooden_shovel        Stone_shovel        Iron_shovel        Gold_shovel          Diamond_shovel        Netherite_shovel");
System.out.println("4.Sword->     Wooden_sword         Stone_sword         Iron_sword         Gold_stone           Diamond_sword         Netherite_sword");

   


/* 
Scanner sc = new Scanner(System.in);
    String input = sc.next();

    Scanner sc2 = new Scanner(System.in);
    String input2 = sc.next();

System.out.println(iron_picaxe + iron_axe ); */






//----------------------------------------------------------------------------------------------------------


Scanner sc = new Scanner(System.in);

System.out.println("Enter item names separated by space:");
String inputLine = sc.nextLine();

String[] selectedItems = inputLine.split(" ");
int total = 0;

for (String item : selectedItems) {
    if (item.equals("Wooden_axe")) {
        total += Wooden_axe;
    } else if (item.equals("Wooden_picaxe")) {
        total += Wooden_picaxe;
    } else if (item.equals("Wooden_hoe")) {
        total += Wooden_hoe;
    } else if (item.equals("Wooden_shovel")) {
        total += Wooden_shovel;
    } else if (item.equals("Wooden_sword")) {
        total += Wooden_sword;
    } else if (item.equals("Stone_axe")) {
        total += stone_axe;
    } else if (item.equals("Stone_picaxe")) {
        total += stone_picaxe;
    } else if (item.equals("Stone_hoe")) {
        total += stone_hoe;
    } else if (item.equals("Stone_shovel")) {
        total += stone_shovel;
    } else if (item.equals("Stone_sword")) {
        total += stone_sword;
    } else if (item.equals("Iron_axe")) {
        total += iron_axe;
    } else if (item.equals("Iron_picaxe")) {
        total += iron_picaxe;
    } else if (item.equals("Iron_hoe")) {
        total += iron_hoe;
    } else if (item.equals("Iron_shovel")) {
        total += iron_shovel;
    } else if (item.equals("Iron_sword")) {
        total += iron_sword;
    } else if (item.equals("Gold_axe")) {
        total += gold_axe;
    } else if (item.equals("Gold_picaxe")) {
        total += gold_picaxe;
    } else if (item.equals("Gold_hoe")) {
        total += gold_hoe;
    } else if (item.equals("Gold_shovel")) {
        total += gold_shovel;
    } else if (item.equals("Gold_sword")) {
        total += gold_sword;
    } else if (item.equals("Diamond_axe")) {
        total += diamond_axe;
    } else if (item.equals("Diamond_picaxe")) {
        total += diamond_picaxe;
    } else if (item.equals("Diamond_hoe")) {
        total += diamond_hoe;
    } else if (item.equals("Diamond_shovel")) {
        total += diamond_shovel;
    } else if (item.equals("Diamond_sword")) {
        total += diamond_sword;
    } else if (item.equals("Netherite_axe")) {
        total += netherite_axe;
    } else if (item.equals("Netherite_picaxe")) {
        total += netherite_picaxe;
    } else if (item.equals("Netherite_hoe")) {
        total += netherite_hoe;
    } else if (item.equals("Netherite_shovel")) {
        total += netherite_shovel;
    } else if (item.equals("Netherite_sword")) {
        total += netherite_sword;
    } else {
        System.out.println("Invalid item: " + item);
    }
}

System.out.println("Total value: " + total);
System.out.println("Remaining inventory: " + (usersinv - total));





    

}

}
