
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class snakey extends JPanel {

  // Images
  Image background = new ImageIcon(
      "C:\\Users\\GAURAV TIWARY\\application\\vs data\\projects\\scr\\mountain-peaks-beautiful-scenery.jpg").getImage();

  Image tile = new ImageIcon(
      "C:\\Users\\GAURAV TIWARY\\application\\vs data\\projects\\scr\\Background.png").getImage();

  Image head = new ImageIcon(
      "C:\\Users\\GAURAV TIWARY\\application\\vs data\\projects\\scr\\head.png").getImage();

  // Game settings
  int tileSize = 32;
  int[][] board = new int[19][28];

  // Snake position
  int snakeX = 5;
  int snakeY = 5;

  // Direction
  int dirX = 0;
  int dirY = 0;

  public snakey() {

    setPreferredSize(new Dimension(896, 608));
    setFocusable(true);

    // 1. Add CURRENT head position to body (BEFORE moving)
    //body.add(0, new Point(snakeX, snakeY));

    // GAME LOOP (movement)
    Timer timer = new Timer(150, e -> {

      // 1. MOVE FIRST
      snakeX += dirX;
      snakeY += dirY;

      // 2. WRAP AROUND WORLD
      if (snakeX < 0)
        snakeX = board[0].length - 1;
      if (snakeX >= board[0].length)
        snakeX = 0;

      if (snakeY < 0)
        snakeY = board.length - 1;
      if (snakeY >= board.length)
        snakeY = 0;

      // 3. REDRAW
      repaint();
    });
    timer.start();

    // INPUT SYSTEM
    addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyPressed(java.awt.event.KeyEvent e) {

        switch (e.getKeyCode()) {

          case KeyEvent.VK_LEFT:
            if (dirX != 1) { // not coming from RIGHT
              dirX = -1;
              dirY = 0;
            }
            break;

          case KeyEvent.VK_RIGHT:
            if (dirX != -1) { // not coming from LEFT
              dirX = 1;
              dirY = 0;
            }
            break;

          case KeyEvent.VK_UP:
            if (dirY != 1) { // not coming from DOWN
              dirX = 0;
              dirY = -1;
            }
            break;

          case KeyEvent.VK_DOWN:
            if (dirY != -1) { // not coming from UP
              dirX = 0;
              dirY = 1;
            }
            break;
        }
      }
    });
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);

    // 1. BACKGROUND
    g.drawImage(background, 0, 0, getWidth(), getHeight(), this);

    // 2. GRID
    for (int row = 0; row < board.length; row++) {
      for (int col = 0; col < board[row].length; col++) {

        g.drawImage(
            tile,
            col * tileSize,
            row * tileSize,
            tileSize,
            tileSize,
            this);
      }
    }

    // 3. SNAKE HEAD (TOP LAYER)
    g.drawImage(
        head,
        snakeX * tileSize,
        snakeY * tileSize,
        tileSize,
        tileSize,
        this);
  }

  public static void main(String[] args) {

    JFrame frame = new JFrame("Snake Game");

    snakey panel = new snakey();

    frame.add(panel);

    frame.pack();
    frame.setResizable(true);
    frame.setLocationRelativeTo(null);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);

    // IMPORTANT: give keyboard focus
    panel.requestFocusInWindow();
  }
}
