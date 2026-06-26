import java.util.*;

public class a_pet {
  public static void main(String[] args) throws Exception {
    Scanner new_sc = new Scanner(System.in);
    // it prints pet name
    String pet_name = ("sittu");
    System.out.println(pet_name);

    int hunger = 0;
    int energy = 100;
    while (energy >= 1) {

      hunger++;
      Thread.sleep(400);
      energy--;
      System.out.println(hunger + "%");
      System.out.println(energy);
      if (hunger >= 70) {
        System.out.println("your pet is hungry");
        System.out.println(hunger);
        String feed = new_sc.next();
        if (feed.equals("feed")) {
          hunger -= 30;
          energy += 30;

        }

                hunger--;
        Thread.sleep(100);

      }

    }

  }
}
