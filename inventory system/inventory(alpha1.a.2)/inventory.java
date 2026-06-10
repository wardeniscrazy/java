import java.util.*;
public class inventroy {
  
  public static void main(String[] args) { 


Scanner sc = new Scanner(System.in);

    while (true) {

    System.out.println("1.> open inventoryz");
    System.out.println("2.> close inventory");
    // System.out.println("Inventory:");
    // System.out.println("Inventory:");
    // System.out.println("Inventory:");
    // System.out.println("Inventory:");
int open = sc.nextInt();
if (open == 1) {
    System.out.println("Inventory Opened");
    
    String [][] a = {{"picaxe  |","sword  |","axe         |","shovel"}
    ,               {"diamond |","iron   |","gold        |","coal"}
    ,               {"apple   |","bread  |","carrot      |","potato"}
  ,                 {""}
,                   {"Bow     |","Arrow  |","Fishing rod |","Water bucket"}};   
    for (int i = 0; i < a.length; i++) {
      for (int j = 0; j < a[i].length; j++) {
          System.out.print(a[i][j] + " ");
      }
 System.out.println();
    
}
 
  }

     if (open == 2) {
    System.out.println("Inventory Closed");



}
   

}
  }
}

