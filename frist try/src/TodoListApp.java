import java.io.*;
import java.util.*;

public class TodoListApp {

    private static class Task {
        int id;
        String description;
        boolean done;

        Task(int id, String description, boolean done) {
            this.id = id;
            this.description = description;
            this.done = done;
        }
    }

    // Simple persistence format (one task per line):
    // id|done(1/0)|description
    private static final String DB_FILE = "todolist_tasks.txt";

    public static void main(String[] args) {
        List<Task> tasks = loadTasks();
        int nextId = tasks.stream().mapToInt(t -> t.id).max().orElse(0) + 1;

        try (Scanner sc = new Scanner(System.in)) {
            while (true) {
                System.out.println("\n=== TODO LIST ===");
                System.out.println("1. Add task");
                System.out.println("2. List tasks");
                System.out.println("3. Toggle done (by id)");
                System.out.println("4. Delete task (by id)");
                System.out.println("5. Exit");
                System.out.print("Choose an option: ");

                String line = sc.nextLine().trim();
                int choice;
                try {
                    choice = Integer.parseInt(line);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid choice. Enter a number from 1-5.");
                    continue;
                }

                if (choice == 1) {
                    System.out.print("Enter task description: ");
                    String desc = sc.nextLine().trim();
                    if (desc.isEmpty()) {
                        System.out.println("Description cannot be empty.");
                        continue;
                    }
                    tasks.add(new Task(nextId++, desc, false));
                    saveTasks(tasks);
                    System.out.println("Task added.");
                } else if (choice == 2) {
                    if (tasks.isEmpty()) {
                        System.out.println("No tasks yet.");
                    } else {
                        // Sort by id for stable display
                        tasks.sort(Comparator.comparingInt(t -> t.id));
                        for (Task t : tasks) {
                            System.out.printf("[%s] %d: %s%n", t.done ? "X" : " ", t.id, t.description);
                        }
                    }
                } else if (choice == 3) {
                    System.out.print("Enter task id to toggle: ");
                    int id = readInt(sc);
                    Task task = findById(tasks, id);
                    if (task == null) {
                        System.out.println("Task not found for id: " + id);
                    } else {
                        task.done = !task.done;
                        saveTasks(tasks);
                        System.out.println("Task updated.");
                    }
                } else if (choice == 4) {
                    System.out.print("Enter task id to delete: ");
                    int id = readInt(sc);
                    Task task = findById(tasks, id);
                    if (task == null) {
                        System.out.println("Task not found for id: " + id);
                    } else {
                        tasks.remove(task);
                        saveTasks(tasks);
                        System.out.println("Task deleted.");
                    }
                } else if (choice == 5) {
                    System.out.println("Goodbye!");
                    break;
                } else {
                    System.out.println("Invalid option. Enter a number from 1-5.");
                }
            }
        }
    }

    private static int readInt(Scanner sc) {
        while (true) {
            String s = sc.nextLine().trim();
            try {
                return Integer.parseInt(s);
            } catch (NumberFormatException e) {
                System.out.print("Please enter a valid integer id: ");
            }
        }
    }

    private static Task findById(List<Task> tasks, int id) {
        for (Task t : tasks) {
            if (t.id == id) return t;
        }
        return null;
    }

    private static List<Task> loadTasks() {
        List<Task> tasks = new ArrayList<>();
        File f = new File(DB_FILE);
        if (!f.exists()) return tasks;

        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String line;
            while ((line = br.readLine()) != null) {
                // allow empty lines
                line = line.trim();
                if (line.isEmpty()) continue;

                // id|done|description
                String[] parts = line.split("\\|", 3);
                if (parts.length < 3) continue;

                int id;
                boolean done;
                try {
                    id = Integer.parseInt(parts[0]);
                    done = parts[1].equals("1");
                } catch (Exception e) {
                    continue;
                }

                String description = parts[2];
                tasks.add(new Task(id, description, done));
            }
        } catch (IOException ignored) {
            // If reading fails, just start with empty list.
        }
        return tasks;
    }

    private static void saveTasks(List<Task> tasks) {
        // Keep stable order in file
        tasks.sort(Comparator.comparingInt(t -> t.id));
        try (PrintWriter pw = new PrintWriter(new FileWriter(DB_FILE, false))) {
            for (Task t : tasks) {
                pw.println(t.id + "|" + (t.done ? "1" : "0") + "|" + t.description.replace("\n", " "));
            }
        } catch (IOException e) {
            System.out.println("Warning: could not save tasks to disk: " + e.getMessage());
        }
    }
}

