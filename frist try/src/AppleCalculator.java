import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;

public class AppleCalculator extends JFrame implements ActionListener {
    private JLabel display;
    private String currentOperator = "";
    private double firstNumber = 0;
    private boolean startNewNumber = true;
    
    public AppleCalculator() {
        setTitle("Calculator");
        setSize(350, 520);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        
        // Use transparent content pane
        setBackground(new Color(30, 30, 30));
        
        // Main panel
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(new Color(30, 30, 30));
        mainPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        
        // Display
        display = new JLabel("0", SwingConstants.RIGHT);
        display.setFont(new Font("SF Pro Display", Font.PLAIN, 60));
        display.setForeground(Color.WHITE);
        display.setOpaque(true);
        display.setBackground(new Color(30, 30, 30));
        display.setBorder(new EmptyBorder(10, 20, 10, 20));
        mainPanel.add(display, BorderLayout.NORTH);
        
        // Button panel
        JPanel buttonPanel = new JPanel(new GridLayout(5, 4, 10, 10));
        buttonPanel.setBackground(new Color(30, 30, 30));
        
        // Button labels
        String[] buttons = {
            "AC", "+/-", "%", "÷",
            "7", "8", "9", "×",
            "4", "5", "6", "-",
            "1", "2", "3", "+",
            "0", ".", "⌫", "="
        };
        
        for (String text : buttons) {
            JButton button = createButton(text);
            buttonPanel.add(button);
        }
        
        mainPanel.add(buttonPanel, BorderLayout.CENTER);
        add(mainPanel);
    }
    
    private JButton createButton(String text) {
        JButton button = new JButton(text) {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(getBackground());
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 35, 35);
                g2.dispose();
                super.paintComponent(g);
            }
        };
        
        button.setFont(new Font("SF Pro Display", Font.BOLD, 24));
        button.setFocusPainted(false);
        button.setContentAreaFilled(false);
        button.setOpaque(false);
        
        // Color based on button type
        switch (text) {
            case "AC":
            case "+/-":
            case "%":
                button.setBackground(new Color(172, 172, 172));
                button.setForeground(Color.BLACK);
                break;
            case "÷":
            case "×":
            case "-":
            case "+":
                button.setBackground(new Color(255, 149, 0)); // Apple Orange
                button.setForeground(Color.WHITE);
                break;
            case "=":
                button.setBackground(new Color(255, 149, 0));
                button.setForeground(Color.WHITE);
                break;
            case "⌫":
                button.setBackground(new Color(172, 172, 172));
                button.setForeground(Color.BLACK);
                break;
            default:
                button.setBackground(new Color(68, 68, 68));
                button.setForeground(Color.WHITE);
        }
        
        button.addActionListener(this);
        return button;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        
        switch (command) {
            case "AC":
                display.setText("0");
                currentOperator = "";
                firstNumber = 0;
                break;
            case "⌫":
                String text = display.getText();
                if (text.length() > 1) {
                    display.setText(text.substring(0, text.length() - 1));
                } else {
                    display.setText("0");
                }
                break;
            case "+/-":
                try {
                    double val = Double.parseDouble(display.getText());
                    display.setText(String.valueOf(-val));
                } catch (Exception ex) {}
                break;
            case "%":
                try {
                    double percent = Double.parseDouble(display.getText()) / 100;
                    display.setText(formatNumber(percent));
                } catch (Exception ex) {}
                break;
            case "÷":
            case "×":
            case "-":
            case "+":
                try {
                    firstNumber = Double.parseDouble(display.getText());
                    currentOperator = command;
                    startNewNumber = true;
                } catch (Exception ex) {}
                break;
            case "=":
                if (!currentOperator.isEmpty()) {
                    try {
                        double secondNumber = Double.parseDouble(display.getText());
                        double result = 0;
                        switch (currentOperator) {
                            case "+": result = firstNumber + secondNumber; break;
                            case "-": result = firstNumber - secondNumber; break;
                            case "×": result = firstNumber * secondNumber; break;
                            case "÷": result = secondNumber != 0 ? firstNumber / secondNumber : 0; break;
                        }
                        display.setText(formatNumber(result));
                        currentOperator = "";
                    } catch (Exception ex) {}
                }
                break;
            case ".":
                if (!display.getText().contains(".")) {
                    display.setText(display.getText() + ".");
                }
                break;
            default:
                if (startNewNumber) {
                    display.setText(command);
                    startNewNumber = false;
                } else {
                    String current = display.getText();
                    display.setText(current.equals("0") ? command : current + command);
                }
        }
    }
    
    private String formatNumber(double num) {
        if (num == (long) num) {
            return String.valueOf((long) num);
        }
        return String.valueOf(num);
    }
    
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        SwingUtilities.invokeLater(() -> {
            AppleCalculator calc = new AppleCalculator();
            calc.setVisible(true);
        });
    }
}
