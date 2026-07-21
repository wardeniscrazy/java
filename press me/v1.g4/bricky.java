...

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

public class bricky extends JPanel implements KeyListener {

  // ==========================
  // Window Settings
  // ==========================
  private static final int WIDTH = 960;
  private static final int HEIGHT = 800;

  // ==========================
  // Images
  // ==========================
  private final Image background = new ImageIcon("press me\\v1.g4\\background.jpg").getImage();
  private final Image paddle = new ImageIcon("press me\\v1.g4\\paddle.png").getImage();
  private final Image ball = new ImageIcon("press me\\v1.g4\\ball.png").getImage();

  // ==========================
  // Paddle
  // ==========================
  private final int paddleWidth = 90;
  private final int paddleHeight = 80;
  private final int paddleSpeed = 12;

  private int paddleX = (WIDTH - paddleWidth) / 2;
  private final int paddleY = 700;

  // ==========================
  // Ball
  // ==========================
  private int ballX = WIDTH / 2 - 15;
  private int ballY = HEIGHT / 2 - 15;

  public bricky() {

    setPreferredSize(new Dimension(WIDTH, HEIGHT));
    setFocusable(true);
    addKeyListener(this);

    // Current working directory
    System.out.println("Working Directory:");
    System.out.println(new File(".").getAbsolutePath());

    // Check image loading
    System.out.println("Background : " + background.getWidth(null));
    System.out.println("Paddle     : " + paddle.getWidth(null));
    System.out.println("Ball       : " + ball.getWidth(null));
  }

  @Override
  protected void paintComponent(Graphics g) {

    super.paintComponent(g);

    // Background
    if (background.getWidth(null) > 0) {
      g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
    } else {
      g.setColor(Color.BLACK);
      g.fillRect(0, 0, getWidth(), getHeight());
    }

    // Paddle
    if (paddle.getWidth(null) > 0) {
      g.drawImage(paddle, paddleX, paddleY, paddleWidth, paddleHeight, this);
    } else {
      g.setColor(Color.WHITE);
      g.fillRect(paddleX, paddleY, paddleWidth, paddleHeight);
    }

    // Ball
    if (ball.getWidth(null) > 0) {
      g.drawImage(ball, ballX, ballY, 30, 30, this);
    } else {
      g.setColor(Color.RED);
      g.fillOval(ballX, ballY, 30, 30);
    }
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

    // Keep paddle inside panel
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

      frame.setResizable(false); // Change to true later if needed
      frame.setLocationRelativeTo(null);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);

      game.requestFocus();
    });
  }
}
