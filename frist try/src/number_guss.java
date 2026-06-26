import java.util.*;
public class number_guss {
  public static void main(String[] args) {
    Random random = new Random();
   
     int numbers = random.nextInt(100);
    //  int attackDamage = numbers[randomIndex];
    // System.out.println(numbers);

int guss;
  Scanner sc = new Scanner(System.in);  
    
  while(true){
    System.out.println("number");
  guss= sc.nextInt();
    if(guss > numbers){
      System.out.println("too high");

    }                                      
    else if(guss < numbers){
      System.out.println("too low");
    } 
  
   else{
    System.out.println("right");
       break;
   }
   

   }
  
   sc.close(); 

 
    
  }
}
