import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class characterDisplay {
    
    ImageIcon toplogo = new ImageIcon("test.png");
    JFrame mainDisplay;

    public characterDisplay()
    {
        mainDisplay = new JFrame("Character Viewer");
        mainDisplay.setSize(1200,650 );
        mainDisplay.setLocationRelativeTo(null);
        mainDisplay.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainDisplay.setIconImage(toplogo.getImage());
        mainDisplay.setLayout(new FlowLayout(FlowLayout.CENTER,10,0));
        mainDisplay.setVisible(true);
    }
    
}
