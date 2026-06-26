import java.util.*;

public class rock_paper_seaser {
    public static void main(String[]args){

Scanner scanner = new Scanner(System.in);
String choice = scanner.next();

        // // Array of words to randomize
        // String[] words = {"rock", "paper", "scissors"};
        
        // // Create Random instance
        // Random random = new Random();
        
        // // Get a random index based on array length
        // int randomIndex = random.nextInt(words.length);
        
        // // Print the randomized word
        // System.out.println("Random word: " + words[randomIndex]);
             if (choice.equals("rock")) {
                System.out.println("paper");
                
             }
             else if (choice.equals("seaser")) {
                    System.out.println("stone");
             
    }
    else if(choice.equals ( "paper")){
                    System.out.println("seaser");
                }
        scanner.close();
    }
    
}
