

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;

public class snakey extends JPanel {

  int tileSize = 32;

  // 2D Array
  int[][] map = {
      { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
      { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
      { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
      { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
      { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
      { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
      { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
      { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
      { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
      { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
      { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
      { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
      { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },

  };

  BufferedImage[] tile = new BufferedImage[2];

  public snakey() {

    try {
      tile[0] = ImageIO.read(new File("scr\\grass.png"));

    } catch (Exception e) {
      e.printStackTrace();
    }

    setPreferredSize(new Dimension(480, 416));
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);

    for (int row = 0; row < map.length; row++) {
      for (int col = 0; col < map[row].length; col++) {
        int tileNumber = map[row][col];

        g.drawImage(
            tile[tileNumber],
            col * tileSize,
            row * tileSize,
            tileSize,
            tileSize,
            null);
      }
    }
  }

  public static void main(String[] args) {

    JFrame frame = new JFrame();

    frame.add(new snakey());

    frame.pack();
    frame.setResizable(false);
    frame.setLocationRelativeTo(null);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }
}
