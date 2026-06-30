

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class snakey extends JPanel {

  int foodX;
  int foodY;

  int snakeLength = 0;
  int score = 0;

  // Images
  Image background = new ImageIcon(
      "C:\\Users\\GAURAV TIWARY\\application\\vs data\\projects\\scr\\mountain-peaks-beautiful-scenery.jpg").getImage();

  Image tile = new ImageIcon(
      "C:\\Users\\GAURAV TIWARY\\application\\vs data\\projects\\scr\\Background.png").getImage();

  Image bodyImage = new ImageIcon(
      "C:\\Users\\GAURAV TIWARY\\application\\vs data\\projects\\scr\\body2.png").getImage();

  Image head = new ImageIcon(
      "C:\\Users\\GAURAV TIWARY\\application\\vs data\\projects\\scr\\head.png").getImage();

  Image food = new ImageIcon(
      "C:\\Users\\GAURAV TIWARY\\application\\vs data\\projects\\scr\\food.png").getImage();

  // Game settings
  int tileSize = 32;
  int[][] board = new int[19][28];

  // Snake position
  int snakeX = 5;
  int snakeY = 5;

  // Direction
  int dirX = 0;
  int dirY = 0;





  ArrayList<Point> body = new ArrayList<>();

  Timer timer;

  public snakey() {

    setPreferredSize(new Dimension(896, 608));
    setFocusable(true);

    spawnFood();

    // GAME LOOP (movement)

    timer = new Timer(150, e -> {

      // 1. Add CURRENT head position to body (BEFORE moving)

      body.add(0, new Point(snakeX, snakeY));

      if (body.size() > snakeLength) {
        body.remove(body.size() - 1);
      }
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

      // if (snakeX == foodX && snakeY == foodY) {

      //   snakeLength++; // Grow the snake

      //   spawnFood(); // Generate new food

      // }

      // Self collision
      for (Point p : body) {

        if (snakeX == p.x && snakeY == p.y) {
          timer.stop();
          System.out.println("Game Over");

        }

      }


      if (snakeX == foodX && snakeY == foodY) {

        snakeLength++;
        score += 1;
        spawnFood();

      }

      repaint();
    });
    timer.start();

    // INPUT SYSTEM
    addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyPressed(java.awt.event.KeyEvent e) {

        switch (e.getKeyCode()) {

          case KeyEvent.VK_A:
            if (dirX != 1) { // not coming from RIGHT
              dirX = -1;
              dirY = 0;
            }
            break;

          case KeyEvent.VK_D:
            if (dirX != -1) { // not coming from LEFT
              dirX = 1;
              dirY = 0;
            }
            break;

          case KeyEvent.VK_W:
            if (dirY != 1) { // not coming from DOWN
              dirX = 0;
              dirY = -1;
            }
            break;

          case KeyEvent.VK_S:
            if (dirY != -1) { // not coming from UP
              dirX = 0;
              dirY = 1;
            }
            break;
        }
      }
    });
  }

  void spawnFood() {

    boolean valid;

    do {

      valid = true;

      foodX = (int) (Math.random() * board[0].length);
      foodY = (int) (Math.random() * board.length);

      // Don't spawn on head
      if (foodX == snakeX && foodY == snakeY) {
        valid = false;
      }

      // Don't spawn on body
      for (Point p : body) {

        if (p.x == foodX && p.y == foodY) {
          valid = false;
          break;
        }

      }

    } while (!valid);
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);

    // 1. BACKGROUND
    g.drawImage(background, 0, 0, getWidth(), getHeight(), this);

    g.setColor(new Color(0, 0, 0, 180));
    g.fillRoundRect(10, 10, 170, 40, 15, 15);

    g.setColor(Color.WHITE);
    g.setFont(new Font("Arial", Font.BOLD, 22));
    g.drawString("Score : " + score, 20, 38);

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


  
    g.drawImage(
        food,
        foodX * tileSize,
        foodY * tileSize,
        tileSize,
        tileSize,
        this);

    for (Point p : body) {

      g.drawImage(
          bodyImage,
          p.x * tileSize,
          p.y * tileSize,
          tileSize,
          tileSize,
          this);

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
    SwingUtilities.invokeLater(() -> panel.requestFocusInWindow());

  }
}
