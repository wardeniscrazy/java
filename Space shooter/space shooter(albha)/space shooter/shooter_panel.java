/* import javax.swing.*;
import java.awt.*;

public class shooter_panel extends JPanel {

  Image background;

  public shooter_panel() {

    background = new ImageIcon(
        "C:\\Users\\GAURAV TIWARY\\application\\vs data\\projects\\press me\\images\\background.png").getImage();
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);

    g.drawImage(background,  getWidth(), getHeight(), this);
  }
} */

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class shooter_panel extends JPanel {

  private BufferedImage background;

  public shooter_panel() {
    File file = new File(
        "C:\\Users\\GAURAV TIWARY\\application\\vs data\\projects\\press me\\images\\background.png");
    System.out.println("Image file exists: " + file.exists());
    System.out.println("Image file path: " + file.getAbsolutePath());
    try {
      background = ImageIO.read(file);
      System.out.println("BufferedImage loaded: " + (background != null));
      if (background != null) {
        System.out.println("Image dimensions: " + background.getWidth() + "x" + background.getHeight());
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);

    if (background != null) {
      g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
    } 
  }
}