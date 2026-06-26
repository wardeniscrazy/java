

import java.util.*;

/**
 * Terminal Shop Simulator
 * - Shop has opening/closing time (clock).
 * - NPCs randomly arrive while shop is open and want to buy items.
 * - You (the shopkeeper) approve or reject each NPC's purchase at the counter.
 * - Tracks stock, money, and a simple event log.
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
    static int money = 500; // starting cash
    static int hour = 9;    // shop clock starts at 9 (24hr format)
    static final int OPEN_HOUR = 9;
    static final int CLOSE_HOUR = 18;
    static Random rng = new Random();
    static Scanner sc = new Scanner(System.in);

    static String[] npcNames = {
        "Raju", "Simran", "Vikram", "Anjali", "Karan",
        "Pooja", "Aman", "Neha", "Rohit", "Divya"
    };

    public static void main(String[] args) {
        setupInventory();
        printWelcome();

        while (hour < CLOSE_HOUR) {
            System.out.println("\n========================================");
            System.out.println("Shop clock: " + formatHour(hour) + "  |  Money: ₹" + money);
            System.out.println("========================================");

            // Randomly decide if an NPC comes this hour
            int npcCount = rng.nextInt(3); // 0,1,2 NPCs per hour
            if (npcCount == 0) {
                System.out.println("No customers this hour... shop is quiet.");
            }
            for (int i = 0; i < npcCount; i++) {
                NPC npc = generateNPC();
                if (npc == null) {
                    System.out.println("A customer walked in but left — nothing in stock they wanted.");
                    continue;
                }
                handleCounter(npc);
            }

            advanceHour();
        }

        closeShop();
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
        System.out.println("============================================");
        System.out.println("   WELCOME TO WARDEN'S GENERAL STORE");
        System.out.println("============================================");
        System.out.println("Shop opens at " + formatHour(OPEN_HOUR) + " and closes at " + formatHour(CLOSE_HOUR));
        System.out.println("You start with ₹" + money + " in cash.");
        printInventory();
        System.out.println("\nPress ENTER to open the shop...");
        sc.nextLine();
    }

    static void printInventory() {
        System.out.println("\n--- Current Stock ---");
        for (Item item : inventory.values()) {
            System.out.printf("%-15s ₹%-5d Stock: %d%n", item.name, item.price, item.stock);
        }
    }

    // Picks a random item that still has stock, builds an NPC wanting it
    static NPC generateNPC() {
        List<Item> available = new ArrayList<>();
        for (Item item : inventory.values()) {
            if (item.stock > 0) available.add(item);
        }
        if (available.isEmpty()) return null;

        Item chosen = available.get(rng.nextInt(available.size()));
        int qty = 1 + rng.nextInt(Math.min(3, chosen.stock));
        String name = npcNames[rng.nextInt(npcNames.length)];
        return new NPC(name, chosen, qty);
    }

    static void handleCounter(NPC npc) {
        int total = npc.wants.price * npc.quantity;
        System.out.println("\n--- Customer at counter ---");
        System.out.println(npc.name + " wants to buy " + npc.quantity + "x " + npc.wants.name +
                " (₹" + npc.wants.price + " each) = ₹" + total);
        System.out.println("Available stock: " + npc.wants.stock);

        if (npc.wants.stock < npc.quantity) {
            System.out.println("Not enough stock to fulfill this order! " + npc.name + " leaves disappointed.");
            return;
        }

        System.out.print("Approve sale? (y/n): ");
        String input = sc.nextLine().trim().toLowerCase();

        if (input.equals("y") || input.equals("yes")) {
            npc.wants.stock -= npc.quantity;
            money += total;
            System.out.println("Sale approved! +₹" + total + " | " + npc.name + " happily leaves with " +
                    npc.quantity + "x " + npc.wants.name + ".");
        } else {
            System.out.println("Sale rejected. " + npc.name + " shrugs and walks out.");
        }
    }

    static void advanceHour() {
        hour++;
        System.out.println("\n(Time passes... it is now " + formatHour(hour) + ")");
        System.out.println("Press ENTER to continue...");
        sc.nextLine();
    }

    static String formatHour(int h) {
        String period = h >= 12 ? "PM" : "AM";
        int display = h % 12;
        if (display == 0) display = 12;
        return display + ":00 " + period;
    }

    static void closeShop() {
        System.out.println("\n============================================");
        System.out.println("It's " + formatHour(hour) + " — closing time!");
        System.out.println("Shop is now CLOSED.");
        System.out.println("============================================");
        printInventory();
        System.out.println("\nFinal cash: ₹" + money);
        System.out.println("Thanks for managing Warden's General Store today!");
    }
}
