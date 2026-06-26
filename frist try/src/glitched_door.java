import java.util.*;
public class glitched_door {
  public static void main(String[] args) {
    
  
  Random random = new Random();
  int num = random.nextInt(0,9);
  Scanner sc = new Scanner(System.in);
  int guss;
  int attampt = 3;
  while (attampt > 0) {
    
  
    while (true) {
      System.out.println("guss the code to open the door (0-9)");
      guss = sc.nextInt();
      if (guss > num) {
        System.out.println("your guss is low");
        
      }
     else if(guss < num){
      System.out.println("ur guss is high");
      
     }
   
     else{
      System.out.println("your guss is right after many tryes");
      break;
    }
    attampt-- ;
    System.out.println("attampts left" + attampt
    );


  }
  if(attampt == 0){
    System.out.println("systemi is locked");
   break;
  }
 }
}
}