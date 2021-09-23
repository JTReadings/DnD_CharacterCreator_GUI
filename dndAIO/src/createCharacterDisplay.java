import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class createCharacterDisplay extends characterOptions {

    static String url="jdbc:mysql://localhost/"+"dnd";
    static String userid="root", password = "boop";
    static Connection con;

    ImageIcon applogo = new ImageIcon("images/test.png");
    JFrame mainDisplay;
    JPanel options = new JPanel();
    JLabel firstMessage, secondMessage, selectRace, selectClass, selectBackground; 
    JButton welcomeNext = new JButton("Let's Get Started!");

    {
        mainDisplay = new JFrame("Character Creator");
        mainDisplay.setSize(450,236);
        mainDisplay.setLocationRelativeTo(null);
        mainDisplay.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainDisplay.setIconImage(applogo.getImage());
        mainDisplay.setLayout(new BorderLayout());
        
        selectRace = new JLabel("Race:");
        selectClass = new JLabel("Class:");
        selectBackground = new JLabel("Background:");
        firstMessage = new JLabel("<html>Welcome to the D&D Character Creator!<br/> Since you have no characters saved, <br/>lets start with the basics of a 5th Edition D&D Character</html>");
        secondMessage = new JLabel("<html>The Main Components of any D&D Player Character are their Race, Class, and Background.<br/> Please select an option from each of the following:</html>");
        firstMessage.setFont(new Font("MV Boli",Font.PLAIN,20));
        secondMessage.setFont(new Font("MV Boli",Font.PLAIN,20));
      
        mainDisplay.add(firstMessage, BorderLayout.CENTER);
        mainDisplay.add(welcomeNext, BorderLayout.SOUTH);

        options.add(selectRace);
        options.add(raceSelection());
      //  options.add(racePics());
        options.add(selectClass);
        options.add(classSelection());
        options.add(selectBackground);
        options.add(backgroundSelection());

        welcomeNext.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == welcomeNext) {
                    mainDisplay.remove(welcomeNext);
                    mainDisplay.remove(firstMessage);
                    mainDisplay.setVisible(false);

                    mainDisplay.add(secondMessage, BorderLayout.NORTH);
                    mainDisplay.add(options, BorderLayout.CENTER);
                    mainDisplay.setVisible(true);
                }
            }
        });
        mainDisplay.pack();
        mainDisplay.setVisible(true);
    }
}
