
import javax.swing.*;
import java.awt.*;

public class snakey extends JPanel {

  Image background = new ImageIcon(
      "C:\\Users\\#############\\application\\vs data\\projects\\scr\\mountain-peaks-beautiful-scenery.jpg").getImage();
  Image tile = new ImageIcon("C:\\Users\\#############\\application\\vs data\\projects\\scr\\Background.png")
      .getImage();

  int tileSize = 32;
  int[][] board = new int[19][28];
  int hi = 40;

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);

    // Background
    g.drawImage(background, 0, 0, getWidth(), getHeight(), this);

    // Tiles
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
  }

  public static void main(String[] args) {

    JFrame frame = new JFrame("Snake");

    snakey panel = new snakey();

    panel.setPreferredSize(new Dimension(896, 608));

    frame.add(panel);

    frame.pack();
    frame.setResizable(false);
    frame.setLocationRelativeTo(null);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }
}
