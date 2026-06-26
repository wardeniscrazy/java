import java.util.*;
import java.util.concurrent.*;

/**
 * Terminal Shop Simulator
 * - The SHOP'S OWN CLOCK (9:00 AM -> 6:00 PM) ticks automatically in real time,
 * pinned to the top-right corner of the terminal.
 * - NPCs arrive automatically in the background at random intervals while the
 * shop is open, and queue up for you to approve/reject at the counter.
 * - 1 real second = 1 in-game minute (change TICK_MS / MINUTES_PER_TICK to
 * adjust speed).
 */
public class ShopSimulator {

  // ---------- Item ----------
  static class Item {
    String name;
    int price;
    int stock;

    Item(String name, int price, int stock) {
      this.name = name;
      this.price = price;
      this.stock = stock;
    }
  }

  // ---------- NPC ----------
  static class NPC {
    String name;
    Item wants;
    int quantity;

    NPC(String name, Item wants, int quantity) {
      this.name = name;
      this.wants = wants;
      this.quantity = quantity;
    }
  }

  // ---------- Shop State ----------
  static Map<String, Item> inventory = new LinkedHashMap<>();
  static int money = 500;

  static final int OPEN_HOUR = 9;
  static final int CLOSE_HOUR = 18;

  // Game clock state (in total minutes since midnight)
  static volatile int gameMinutes = OPEN_HOUR * 60;
  static volatile boolean shopOpen = true;

  // Speed of the game clock
  static final long TICK_MS = 1000; // real-time ms per tick
  static final int MINUTES_PER_TICK = 1; // game-minutes added per tick

  static final int TERMINAL_WIDTH = 90; // adjust to your terminal width

  static Random rng = new Random();
  static Scanner sc = new Scanner(System.in);
  static BlockingQueue<NPC> npcQueue = new LinkedBlockingQueue<>();

  static String[] npcNames = {
      "Raju", "Simran", "Vikram", "Anjali", "Karan",
      "Pooja", "Aman", "Neha", "Rohit", "Divya"
  };

  public static void main(String[] args) throws InterruptedException {
    setupInventory();

    System.out.print("\u001B[2J\u001B[H"); // clear screen
    printWelcome();

    // --- Start background threads ---
    Thread clockThread = new Thread(ShopSimulator::runGameClock);
    clockThread.setDaemon(true);
    clockThread.start();

    Thread npcSpawner = new Thread(ShopSimulator::runNpcSpawner);
    npcSpawner.setDaemon(true);
    npcSpawner.start();

    // --- Main loop: handle NPCs as they arrive ---
    while (shopOpen || !npcQueue.isEmpty()) {
      NPC npc = npcQueue.poll(500, TimeUnit.MILLISECONDS);
      if (npc != null) {
        handleCounter(npc);
      }
    }

    closeShop();
  }

  // ---------- Game Clock Thread ----------
  static void runGameClock() {
    while (shopOpen) {
      try {
        Thread.sleep(TICK_MS);
      } catch (InterruptedException e) {
        break;
      }
      gameMinutes += MINUTES_PER_TICK;
      if (gameMinutes >= CLOSE_HOUR * 60) {
        gameMinutes = CLOSE_HOUR * 60;
        shopOpen = false;
      }
      drawClock();
    }
    drawClock();
  }

  static void drawClock() {
    String timeStr = "SHOP CLOCK: " + formatGameTime() + (shopOpen ? "  [OPEN]" : "  [CLOSED]");
    synchronized (System.out) {
      System.out.print("\u001B[s"); // save cursor position
      System.out.print("\u001B[1;1H"); // move to row 1
      System.out.print("\u001B[2K"); // clear that line
      int padding = TERMINAL_WIDTH - timeStr.length();
      if (padding < 0)
        padding = 0;
      System.out.print(" ".repeat(padding) + timeStr);
      System.out.print("\u001B[u"); // restore cursor position
      System.out.flush();
    }
  }

  // ---------- NPC Spawner Thread ----------
  static void runNpcSpawner() {
    while (shopOpen) {
      try {
        // random gap of 3-8 real seconds before next NPC shows up
        Thread.sleep(3000 + rng.nextInt(5000));
      } catch (InterruptedException e) {
        break;
      }
      if (!shopOpen)
        break;
      NPC npc = generateNPC();
      if (npc != null) {
        npcQueue.offer(npc);
      }
    }
  }

  static void setupInventory() {
    inventory.put("Bread", new Item("Bread", 30, 10));
    inventory.put("Milk", new Item("Milk", 25, 10));
    inventory.put("Rice (kg)", new Item("Rice (kg)", 50, 15));
    inventory.put("Eggs (dozen)", new Item("Eggs (dozen)", 60, 8));
    inventory.put("Soap", new Item("Soap", 20, 12));
    inventory.put("Chocolate", new Item("Chocolate", 15, 20));
  }

  static void printWelcome() {
    moveCursor(3, 1);
    printLine("============================================");
    printLine("   WELCOME TO WARDEN'S GENERAL STORE");
    printLine("============================================");
    printLine("Shop opens at " + formatHour(OPEN_HOUR) + " and closes at " + formatHour(CLOSE_HOUR));
    printLine("You start with Rs." + money + " in cash.");
    printInventory();
    printLine("\nPress ENTER to open the shop (clock will start ticking)...");
    sc.nextLine();
    printLine("\nShop is now OPEN. Customers will start arriving...\n");
  }

  static void printInventory() {
    printLine("\n--- Current Stock ---");
    for (Item item : inventory.values()) {
      printLine(String.format("%-15s Rs.%-5d Stock: %d", item.name, item.price, item.stock));
    }
  }

  static void moveCursor(int row, int col) {
    System.out.print("\u001B[" + row + ";" + col + "H");
  }

  static void printLine(String s) {
    synchronized (System.out) {
      System.out.println(s);
    }
  }

  static NPC generateNPC() {
    List<Item> available = new ArrayList<>();
    for (Item item : inventory.values()) {
      if (item.stock > 0)
        available.add(item);
    }
    if (available.isEmpty())
      return null;

    Item chosen = available.get(rng.nextInt(available.size()));
    int qty = 1 + rng.nextInt(Math.min(3, chosen.stock));
    String name = npcNames[rng.nextInt(npcNames.length)];
    return new NPC(name, chosen, qty);
  }

  static void handleCounter(NPC npc) {
    int total = npc.wants.price * npc.quantity;
    printLine("\n--- Customer at counter (" + formatGameTime() + ") ---");
    printLine(npc.name + " wants to buy " + npc.quantity + "x " + npc.wants.name +
        " (Rs." + npc.wants.price + " each) = Rs." + total);
    printLine("Available stock: " + npc.wants.stock);

    if (npc.wants.stock < npc.quantity) {
      printLine("Not enough stock to fulfill this order! " + npc.name + " leaves disappointed.");
      return;
    }

    System.out.print("Approve sale? (y/n): ");
    String input = sc.nextLine().trim().toLowerCase();

    if (input.equals("y") || input.equals("yes")) {
      npc.wants.stock -= npc.quantity;
      money += total;
      printLine("Sale approved! +Rs." + total + " | " + npc.name + " happily leaves with " +
          npc.quantity + "x " + npc.wants.name + ". (Cash: Rs." + money + ")");
    } else {
      printLine("Sale rejected. " + npc.name + " shrugs and walks out.");
    }
  }

  static String formatGameTime() {
    int h = gameMinutes / 60;
    int m = gameMinutes % 60;
    String period = h >= 12 ? "PM" : "AM";
    int display = h % 12;
    if (display == 0)
      display = 12;
    return String.format("%d:%02d %s", display, m, period);
  }

  static String formatHour(int h) {
    String period = h >= 12 ? "PM" : "AM";
    int display = h % 12;
    if (display == 0)
      display = 12;
    return display + ":00 " + period;
  }

  static void closeShop() {
    printLine("\n============================================");
    printLine("It's " + formatGameTime() + " - closing time!");
    printLine("Shop is now CLOSED.");
    printLine("============================================");
    printInventory();
    printLine("\nFinal cash: Rs." + money);
    printLine("Thanks for managing Warden's General Store today!");
  }
}
