
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class bricky extends JPanel implements KeyListener {

  // Images
  Image background = new ImageIcon("java\\press me\\background.jpg").getImage();
  Image paddle = new ImageIcon("java\\press me\\paddle.png").getImage();
  Image ball = new ImageIcon("ball.png").getImage();

  // Window size
  final int WIDTH = 960;
  final int HEIGHT = 800;

  // Paddle
  int paddleWidth = 90;
  int paddleHeight = 80;

  int paddleX = (WIDTH - paddleWidth) / 2;
  int paddleY = 700;

  public bricky() {
    setFocusable(true);
    addKeyListener(this);
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);

    // Background
    g.drawImage(background, 0, 0, WIDTH, HEIGHT, this);

    // Paddle
    g.drawImage(paddle, paddleX, paddleY, paddleWidth, paddleHeight, this);
  }

  @Override
  public void keyPressed(KeyEvent e) {

    // Move Left
    if (e.getKeyCode() == KeyEvent.VK_LEFT) {
      if (paddleX > 0) {
        paddleX -= 10;
      }
    }

    // Move Right
    if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
      if (paddleX < WIDTH - paddleWidth) {
        paddleX += 10;
      }
    }

    // Keep paddle inside the window
    if (paddleX < 0) {
      paddleX = 0;
    }

    if (paddleX > getWidth() - paddleWidth) {
      paddleX = getWidth() - paddleWidth;
    }

    repaint();
  }

  @Override
  public void keyReleased(KeyEvent e) {
  }

  @Override
  public void keyTyped(KeyEvent e) {
  }

  public static void main(String[] args) {

    JFrame frame = new JFrame("Breakout");

    bricky game = new bricky();

    frame.add(game);
    frame.setSize(game.WIDTH, game.HEIGHT);
    frame.setResizable(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
    System.out.println("hi");
System.out.println("hi");
    // Give keyboard focus
    game.requestFocus();
  }
}
