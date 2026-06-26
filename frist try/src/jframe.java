import javax.swing.*;
import java.awt.*;

class GamePanel extends JPanel{
  Image player = new ImageIcon("C:\\Users\\GAURAV TIWARY\\application\\.vscode\\frist try\\white-lotus-ganesh-desktop-4gq9o9uxikc6rvfe.jpg").getImage();
@Override
protected void paintComponent(Graphics g){
  super.paintComponent(g);
  g.drawImage(player,100,100,null);
}
}


public class jframe{
  public static void main(String[] args) {
    JFrame frame = new JFrame("to print hello world");
    GamePanel panel =new GamePanel();
    frame.add(panel);

   
    frame.setSize(1000,1000);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     frame.setVisible(true);
  }
}