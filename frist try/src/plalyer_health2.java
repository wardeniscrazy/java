import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class plalyer_health2 {
  static int player_health = 100;
  static Random random = new Random();

  public static void main(String[] args) {
    int[] damage = {1,1,1,1,1,1,1,2,2,2,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34};

    JFrame frame = new JFrame("NPC Battle");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(460, 520);
    frame.setLocationRelativeTo(null);

    JPanel mainPanel = new JPanel(new BorderLayout(12, 12));
    mainPanel.setBackground(new Color(20, 24, 33));
    mainPanel.setBorder(BorderFactory.createEmptyBorder(18, 18, 18, 18));

    JLabel title = new JLabel("NPC Battle Arena", SwingConstants.CENTER);
    title.setForeground(new Color(247, 210, 96));
    title.setFont(new Font("Arial", Font.BOLD, 28));

    JLabel healthText = new JLabel("NPC Health: " + player_health, SwingConstants.CENTER);
    healthText.setForeground(Color.WHITE);
    healthText.setFont(new Font("Arial", Font.BOLD, 22));

    JProgressBar healthBar = new JProgressBar(0, 100);
    healthBar.setValue(player_health);
    healthBar.setStringPainted(true);
    healthBar.setForeground(new Color(61, 220, 151));
    healthBar.setBackground(new Color(52, 58, 70));
    healthBar.setFont(new Font("Arial", Font.BOLD, 14));

    JTextArea battleLog = new JTextArea();
    battleLog.setEditable(false);
    battleLog.setBackground(new Color(31, 36, 48));
    battleLog.setForeground(new Color(230, 235, 245));
    battleLog.setFont(new Font("Consolas", Font.PLAIN, 15));
    battleLog.setText("Click ATTACK to give random damage to NPC.\n");

    JButton attackButton = new JButton("ATTACK");
    attackButton.setBackground(new Color(255, 86, 86));
    attackButton.setForeground(Color.WHITE);
    attackButton.setFont(new Font("Arial", Font.BOLD, 20));
    attackButton.setFocusPainted(false);

    JButton skipButton = new JButton("NO");
    skipButton.setBackground(new Color(80, 88, 105));
    skipButton.setForeground(Color.WHITE);
    skipButton.setFont(new Font("Arial", Font.BOLD, 18));
    skipButton.setFocusPainted(false);

    JButton restartButton = new JButton("RESTART");
    restartButton.setBackground(new Color(247, 210, 96));
    restartButton.setForeground(new Color(20, 24, 33));
    restartButton.setFont(new Font("Arial", Font.BOLD, 18));
    restartButton.setFocusPainted(false);

    JPanel healthPanel = new JPanel(new GridLayout(2, 1, 8, 8));
    healthPanel.setOpaque(false);
    healthPanel.add(healthText);
    healthPanel.add(healthBar);

    JPanel buttonPanel = new JPanel(new GridLayout(1, 3, 12, 12));
    buttonPanel.setOpaque(false);
    buttonPanel.add(attackButton);
    buttonPanel.add(skipButton);
    buttonPanel.add(restartButton);

    JPanel bottomPanel = new JPanel(new BorderLayout(12, 12));
    bottomPanel.setOpaque(false);
    bottomPanel.add(new JScrollPane(battleLog), BorderLayout.CENTER);
    bottomPanel.add(buttonPanel, BorderLayout.SOUTH);

    mainPanel.add(title, BorderLayout.NORTH);
    mainPanel.add(healthPanel, BorderLayout.CENTER);
    mainPanel.add(bottomPanel, BorderLayout.SOUTH);

    attackButton.addActionListener(event -> {
      if (player_health > 0) {
        int randomIndex = random.nextInt(damage.length);
        int attackDamage = damage[randomIndex];
        player_health -= attackDamage;

        healthText.setText("NPC Health: " + player_health);
        healthBar.setValue(Math.max(player_health, 0));
        battleLog.append("You gave " + attackDamage + " damage\n");
        battleLog.append("NPC health: " + player_health + "\n");

        if (player_health <= 0) {
          battleLog.append("NPC is dead\n");
          attackButton.setEnabled(false);
          skipButton.setEnabled(false);
          healthText.setText("NPC is dead");
        }
      }
    });

    skipButton.addActionListener(event -> battleLog.append("You did not attack NPC\n"));

    restartButton.addActionListener(event -> {
      player_health = 100;
      healthText.setText("NPC Health: " + player_health);
      healthBar.setValue(player_health);
      battleLog.setText("Game restarted. Click ATTACK to give random damage to NPC.\n");
      attackButton.setEnabled(true);
      skipButton.setEnabled(true);
    });

    frame.add(mainPanel);
    frame.setVisible(true);
  }
}
