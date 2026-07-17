import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class bricky extends JPanel implements KeyListener {

  // ==========================
  // Window Settings
  // ==========================
  private static final int WIDTH = 960;
  private static final int HEIGHT = 800;

  // ==========================
  // Images
  // ==========================
  private final Image background = new ImageIcon("java/press me/background.jpg").getImage();
  private final Image paddle = new ImageIcon("java/press me/paddle.png").getImage();
  private final Image ball = new ImageIcon("java/press me/ball.png").getImage();

  // ==========================
  // Paddle
  // ==========================
  private final int paddleWidth = 90;
  private final int paddleHeight = 80;
  private final int paddleSpeed = 12;

  private int paddleX = (WIDTH - paddleWidth) / 2;
  private final int paddleY = 700;

  public bricky() {
    setPreferredSize(new Dimension(WIDTH, HEIGHT));
    setFocusable(true);
    addKeyListener(this);
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);

    // Draw Background
    g.drawImage(background, 0, 0, getWidth(), getHeight(), this);

    // Draw Paddle
    g.drawImage(paddle, paddleX, paddleY, paddleWidth, paddleHeight, this);

    // Draw Ball (currently centered)
    g.drawImage(ball, WIDTH / 2 - 15, HEIGHT / 2 - 15, 30, 30, this);
  }

  @Override
  public void keyPressed(KeyEvent e) {

    switch (e.getKeyCode()) {

      case KeyEvent.VK_LEFT:
        paddleX -= paddleSpeed;
        break;

      case KeyEvent.VK_RIGHT:
        paddleX += paddleSpeed;
        break;
    }

    // Keep paddle inside the window
    paddleX = Math.max(0, Math.min(paddleX, getWidth() - paddleWidth));

    repaint();
  }

  @Override
  public void keyReleased(KeyEvent e) {
  }

  @Override
  public void keyTyped(KeyEvent e) {
  }

  public static void main(String[] args) {

    SwingUtilities.invokeLater(() -> {

      JFrame frame = new JFrame("Breakout");

      bricky game = new bricky();

      frame.add(game);
      frame.pack();
      frame.setResizable(true);
      frame.setLocationRelativeTo(null);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);

      game.requestFocusInWindow();
    });
  }
}