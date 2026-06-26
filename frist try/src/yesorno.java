import java.util.Scanner;
public class yesorno {
  public static void main(String[] args) {
  
    
    
    System.out.println("Hi here I am Tony Mafia,I am your companian for this advanture");
    System.out.println("Here you were droped in a very dense jungle of dark oak forest. vilagers");
    System.out.println("of this forest claim that,there is big manssion in the center of jungle called manssion of deth");
    System.out.println("they also told me that a man accedently went there and that night very creapy noises are coming frpm manssion,  ");
    System.out.println("and they told me this is not one case there is may cases");
    System.out.println("do you wana to listion another story or we can carry on to the game");
    System.out.println("if you want to lision story then type `a` and if u want to carry on then type`b` ");
   
   Scanner sc = new Scanner(System.in);
    String input = sc.next();

    // while (input.equals("exit")) {


    if (input.equals("a")) {
      System.out.println("I Want to lestion this story also");
      System.out.println("are you sure(type y)");

      
   Scanner scc = new Scanner(System.in);
    String gg = sc.next();
      if (gg.equals("y")) {
        System.out.println("then lision  ");
        System.out.println("A team went there and dicide to stay in that manssion ");
        System.out.println("now you will ask why they go there now listion me they were camping in forest ");
        System.out.println("now come to the story when they were sleeping a scriming voice comes from menssion ");
        System.out.println("when veligers go there in morning they found 7 dead body ");
        System.out.println("there was no mark on anyones body now you can understand");

      }
   
    
    }
     else if (input.equals("b")) {
      System.out.println("lets go to the game ");
      System.out.println("now you are frount of mansion  you have two ways to go but you ccan not go away from mension because");
      System.out.println("it is midnight and you need to go in mension to stay  whole night  ");
      System.out.println("`click i to go inside through main door`");
     System.out.println("click h to go through back door");
     
     Scanner maindoor = new Scanner(System.in);
     String input3 = maindoor.next();

      if (input3.equals("1"));{
      System.out.println("now you are in hall a big halll it is massiv big with in centera big jhumar which is making creapy noise");
      System.out.println("like chrrrr chrrr chrrr and seems like it can flaw any time"); 
      System.out.println("now u need to go safe  ");
      System.out.println("how click t for go inside in a room or click y to go in side corner ");

      }
     
             if(input3.equals("h")){
System.out.println("you entered in a black room you need to turn on lights");
System.out.println("click l to turn lights ");
Scanner scccc = new Scanner(System.in);
String input4 = scccc.next();
                                if (input4.equals("l")) {
                                   System.out.println(" now u saw this room is filled with  furnature which is covered with a with cloths kz");
                                }
      } 
      
     
    }
    }
    }
      
  


  









