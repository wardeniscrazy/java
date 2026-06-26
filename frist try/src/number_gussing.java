import java.util.*;
public class number_gussing {
  public static void main(String[] args) {
    Random random = new Random();
    int number = random.nextInt(100);
    Scanner sc = new Scanner(System.in);

    // user's gussed number
    int guss;
    while (true) {
      System.out.println("guss ur numberr!");
      guss = sc.nextInt();
      if (guss > number) {
        System.out.println("your guss is low");
        
      }
     else if(guss < number){
      System.out.println("ur guss is high");
     }
     else{
      System.out.println("your guss is right after many tryes");
      break;
    }
   

    }
    sc.close();
  }
}
