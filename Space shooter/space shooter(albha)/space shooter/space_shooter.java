import javax.swing.JFrame;

public class space_shooter {
  
  public static void main(String[] args) {
    JFrame frame = new JFrame("My Simple Window");

    shooter_panel panel = new shooter_panel(); // Connect

    frame.add(panel);


    frame.setSize(474, 266);
     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null); // center on screen
    frame.setResizable(false);
    frame.setVisible(true);
  }
}