import java.util.*;
public class switch_yesorno {
  public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);
    String input = sc.next();
    while(input.equals("0987")){

    System.out.println("Hi here I am Tony Mafia,I am your companian for this advanture");
    System.out.println("Here you were droped in a very dense jungle of dark oak forest. vilagers");
    System.out.println("of this forest claim that,there is big manssion in the center of jungle called manssion of deth");
    System.out.println("they also told me that a man accedently went there and that night very creapy noises are coming frpm manssion,  ");
    System.out.println("and they told me this is not one case there is may cases");
    System.out.println("do you wana to listion another story or we can carry on to the game");
    System.out.println("if you want to lision story then type `a` and if u want to carry on then type`b` ");
   
  


    switch (input) {
      case "hj":
         System.out.println("I Want to lestion this story also");
      System.out.println("are you sure(type 2)");

          break;
     
       case "h":
        System.out.println("then lision  ");
        System.out.println("A team went there and dicide to stay in that manssion ");
        System.out.println("now you will ask why they go there now listion me they were camping in forest ");
        System.out.println("now come to the story when they were sleeping a scriming voice comes from menssion ");
        System.out.println("when veligers go there in morning they found 7 dead body ");
        System.out.println("there was no mark on anyones body now you can understand");
       break;
    
       case "g" :
System.out.println("lets go to the game ");
      System.out.println("now you are");
    
      default:

        break;
    }
    break;
    }
  }
}
