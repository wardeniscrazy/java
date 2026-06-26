import java.util.*;
public class player_health {
  public static void main(String[]args){
    int player_health = 100;

         int[] damage = {1,1,1,1,1,1,1,2,2,2,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60,61,62,63,64,65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80,81,82,83,84,85,86,87,88,89,90};
        
         Random random = new Random();
        
          System.out.println("Remaing NPC Health: " + player_health);
          System.out.println("You have chance to give damage the NPC ");
        // // Get a random index based on array length
         int randomIndex = random.nextInt(damage.length);
        int attackDamage = damage[randomIndex];
        // // Print the randomized word
       // System.out.println(damage);
                    System.out.println("Damage given by AI: " + damage[randomIndex]);

  
    Scanner scc = new Scanner(System.in);
   int users_damage = scc.nextInt();                      
  
  player_health -= attackDamage;
                              
   if(player_health <= 0){
    System.out.println("NPC is dead");
   }
   scc.close();
 
   
  }
  
}
