import javax.swing.*;
import java.awt.*;

public class shooter_panel extends JPanel {
  private Image background;

  public shooter_panel() {
    background = new ImageIcon(
        "C:\\Users\\GAURAV TIWARY\\application\\vs data\\projects\\press me\\images\\background.png")
        .getImage();
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    if (background != null) {
      g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
    }
  }
}
