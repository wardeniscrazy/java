import java.util.*;

public class coolshoots {
  public static void main(String[] args) {

    Random rand = new Random();

    int randomPoint = rand.nextInt(1, 100);

    int[] yesno = { 0, 0, 1 };

    int randomIndex1 = rand.nextInt(yesno.length);
    int randomYesNo = yesno[randomIndex1];
    int randomIndex2 = rand.nextInt(1, 10);
    int randomWind = randomIndex2;
    if (randomYesNo == 1) {
      System.out.println("Wind is strong");
      System.out.println("Wind strength: " + randomWind);
      System.out.println("Your shot is affected by the wind");
      System.out.println("your acuracy is reduced by " + randomWind + "%");
      System.out.println("Your shot is reduced by " + (randomWind * 0.01) * 100 + "%");
      System.out.println("your point " + (randomPoint - randomWind));
    } else {
      System.out.println("Wind is weak");
      System.out.println(randomPoint);
    }

  }

}
