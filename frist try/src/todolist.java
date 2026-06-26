import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class todolist {

    private static class Task {
        String text;
        boolean done;
        Task(String text) {
            this.text = text;
            this.done = false;
        }
    }

    private final List<Task> tasks = new ArrayList<>();

    private DefaultListModel<String> model;
    private JList<String> list;
    private JTextField input;
    private JLabel stats;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new todolist().start());
    }

    private void start() {
        JFrame frame = new JFrame("Todo List");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(720, 480);
        frame.setLocationRelativeTo(null);

        // Colors
        Color bg = new Color(20, 20, 26);
        Color panel = new Color(32, 32, 40);
        Color border = new Color(70, 70, 90);
        Color text = new Color(235, 235, 245);
        Color sub = new Color(170, 170, 190);
        Color green = new Color(56, 189, 248); // blue-cyan accent
        Color ok = new Color(34, 197, 94);
        Color danger = new Color(244, 63, 94);

        frame.getContentPane().setBackground(bg);
        frame.setLayout(new BorderLayout(12, 12));

        // Header
        JPanel header = new JPanel(new BorderLayout());
        header.setBackground(panel);
        header.setBorder(BorderFactory.createEmptyBorder(14, 16, 14, 16));

        JLabel title = new JLabel("Todo List");
        title.setForeground(text);
        title.setFont(new Font("Segoe UI", Font.BOLD, 24));

        stats = new JLabel("0 done • 0 remaining");
        stats.setForeground(sub);
        stats.setFont(new Font("Segoe UI", Font.PLAIN, 13));

        header.add(title, BorderLayout.WEST);
        header.add(stats, BorderLayout.EAST);

        // Input
        JPanel inputPanel = new JPanel(new BorderLayout(10, 10));
        inputPanel.setBackground(bg);
        inputPanel.setBorder(BorderFactory.createEmptyBorder(0, 16, 0, 16));

        input = new JTextField();
        input.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        JButton addBtn = new JButton("Add");
        styleButton(addBtn, green);

        inputPanel.add(input, BorderLayout.CENTER);
        inputPanel.add(addBtn, BorderLayout.EAST);

        // List area
        model = new DefaultListModel<>();
        list = new JList<>(model);
        list.setFont(new Font("Consolas", Font.PLAIN, 13));
        list.setSelectionBackground(new Color(70, 70, 90));
        list.setSelectionForeground(text);
        list.setBackground(bg);

        JScrollPane scroll = new JScrollPane(list);
        scroll.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(border),
                "Tasks",
                javax.swing.border.TitledBorder.LEFT,
                javax.swing.border.TitledBorder.TOP,
                new Font("Segoe UI", Font.PLAIN, 12),
                sub
        ));

        // Actions
        JPanel actions = new JPanel(new FlowLayout(FlowLayout.CENTER, 14, 8));
        actions.setBackground(bg);

        JButton toggleBtn = new JButton("Done / Undone");
        styleButton(toggleBtn, ok);

        JButton deleteBtn = new JButton("Delete");
        styleButton(deleteBtn, danger);

        JButton clearBtn = new JButton("Clear All");
        styleButton(clearBtn, new Color(255, 152, 0));

        actions.add(toggleBtn);
        actions.add(deleteBtn);
        actions.add(clearBtn);

        // Layout compose
        JPanel center = new JPanel(new BorderLayout(12, 12));
        center.setBackground(bg);
        center.setBorder(BorderFactory.createEmptyBorder(6, 0, 0, 0));
        center.add(inputPanel, BorderLayout.NORTH);
        center.add(scroll, BorderLayout.CENTER);
        center.add(actions, BorderLayout.SOUTH);

        frame.add(header, BorderLayout.NORTH);
        frame.add(center, BorderLayout.CENTER);

        // Listeners
        addBtn.addActionListener(e -> addTask());
        input.addActionListener(e -> addTask());

        toggleBtn.addActionListener(e -> toggleSelected());
        deleteBtn.addActionListener(e -> deleteSelected());
        clearBtn.addActionListener(e -> clearAll());

        // Double click to toggle
        list.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                if (e.getClickCount() == 2) {
                    toggleSelected();
                }
            }
        });

        frame.setVisible(true);
        input.requestFocusInWindow();
        refresh();
    }

    private void styleButton(JButton b, Color c) {
        b.setBackground(c);
        b.setForeground(Color.WHITE);
        b.setFont(new Font("Segoe UI", Font.BOLD, 13));
        b.setFocusPainted(false);
        b.setBorder(BorderFactory.createEmptyBorder(10, 14, 10, 14));
        b.setOpaque(true);
        b.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }

    private void addTask() {
        String t = input.getText().trim();
        if (t.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Enter a task description.");
            return;
        }
        tasks.add(new Task(t));
        input.setText("");
        refresh();
        input.requestFocusInWindow();
    }

    private void toggleSelected() {
        int idx = list.getSelectedIndex();
        if (idx < 0) {
            JOptionPane.showMessageDialog(null, "Select a task first.");
            return;
        }
        tasks.get(idx).done = !tasks.get(idx).done;
        refresh();
        list.setSelectedIndex(idx);
    }

    private void deleteSelected() {
        int idx = list.getSelectedIndex();
        if (idx < 0) {
            JOptionPane.showMessageDialog(null, "Select a task first.");
            return;
        }
        tasks.remove(idx);
        refresh();
    }

    private void clearAll() {
        if (tasks.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No tasks to clear.");
            return;
        }
        int res = JOptionPane.showConfirmDialog(null, "Clear all tasks?", "Confirm", JOptionPane.YES_NO_OPTION);
        if (res == JOptionPane.YES_OPTION) {
            tasks.clear();
            refresh();
        }
    }

    private void refresh() {
        model.clear();
        for (Task t : tasks) {
            model.addElement((t.done ? "[X] " : "[ ] ") + t.text);
        }

        long done = tasks.stream().filter(x -> x.done).count();
        long remaining = tasks.size() - done;
        stats.setText(done + " done • " + remaining + " remaining");
    }
}

