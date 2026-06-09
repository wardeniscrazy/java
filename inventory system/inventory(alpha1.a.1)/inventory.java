import java.util.Arrays;
public class inventroy {
  public static void main(String[] args) { 
  

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
}
