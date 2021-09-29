import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class createCharacterDisplay extends characterOptions {

    static String url="jdbc:mysql://localhost/"+"dnd";
    static String userid="root", password = "boop";
    static Connection con;

    ImageIcon applogo = new ImageIcon("images/test.png");

    createCharacterDisplay() {
        JFrame mainDisplay = new JFrame("Character Creator");;
        JLabel firstMessage = new JLabel("<html>Welcome to the D&D Character Creator!<br/> Since you have no characters saved, <br/>lets start with the basics of a 5th Edition D&D Character</html>");
        JButton welcomeNext = new JButton("Let's Get Started!");
        
        mainDisplay.setSize(450,236);
        mainDisplay.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainDisplay.setIconImage(applogo.getImage());
        mainDisplay.setLayout(new BorderLayout());
        firstMessage.setFont(new Font("MV Boli",Font.PLAIN,20));
        mainDisplay.add(firstMessage, BorderLayout.CENTER);
        mainDisplay.add(welcomeNext, BorderLayout.SOUTH);
    
        welcomeNext.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == welcomeNext) {
                    mainDisplay.setVisible(false);
                    selectionScreen();
                }}});
        mainDisplay.setVisible(true);
    }

    public void selectionScreen(){
        JFrame mainDisplay = new JFrame("Character Creator");
        JPanel selections = new JPanel();
//        JPanel options = new JPanel();
        JLabel selectRace = new JLabel("Race:");
        JLabel selectClass = new JLabel("Class:");
        JLabel selectBackground = new JLabel("Background:");
        JLabel secondMessage = new JLabel("<html>The Main Components of any D&D Player Character are their Race, Class, and Background.<br/> Please select an option from each of the following:</html>");
//        JPanel optionDetails = new JPanel(new CardLayout());
        JButton confirmSelection = new JButton("Confirm Selection");

        secondMessage.setFont(new Font("MV Boli",Font.PLAIN,20));
        mainDisplay.setSize(900,500);
        mainDisplay.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainDisplay.setIconImage(applogo.getImage());
        mainDisplay.setLayout(new BorderLayout());

        selections.add(selectRace);
        selections.add(raceSelection());
        selections.add(selectClass);
        selections.add(classSelection());
        selections.add(selectBackground);
        selections.add(backgroundSelection());
        confirmSelection.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == confirmSelection) {
                    mainDisplay.setVisible(false);
                    statScreen();
                }}});
        mainDisplay.add(secondMessage, BorderLayout.NORTH);
//        mainDisplay.add(optionDetails);
        mainDisplay.add(selections, BorderLayout.SOUTH);
        mainDisplay.add(confirmSelection, BorderLayout.CENTER);
        mainDisplay.setVisible(true);    
    }
    public void statScreen(){
        JFrame mainDisplay = new JFrame("Stats Selection");
        JPanel topStats = new JPanel();
        JPanel botStats = new JPanel();
        JPanel statOptions = new JPanel();
        JLabel strScore = new JLabel("Strength");
        JLabel dexScore = new JLabel("Dexterity");
        JLabel conScore = new JLabel("Constitution");
        JLabel intScore = new JLabel("Intelligence");
        JLabel wisScore = new JLabel("Wisdom");
        JLabel chaScore = new JLabel("Charisma");
        JButton standardArray = new JButton("Standard Array"); 
        JButton pointBuy = new JButton("Point Buy");
        JButton confirmSelection = new JButton("Confirm Selection");

        mainDisplay.setSize(900,500);
        mainDisplay.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainDisplay.setIconImage(applogo.getImage());
        mainDisplay.setLayout(new BorderLayout());

        topStats.add(strScore);
        topStats.add(super.statSelect()[0]);
        topStats.add(dexScore);
        topStats.add(super.statSelect()[1]);
        topStats.add(conScore);
        topStats.add(super.statSelect()[2]);
        botStats.add(intScore);
        botStats.add(super.statSelect()[3]);
        botStats.add(wisScore);
        botStats.add(super.statSelect()[4]);
        botStats.add(chaScore);
        botStats.add(super.statSelect()[5]);
        statOptions.add(standardArray);
        statOptions.add(pointBuy);

        mainDisplay.add(topStats, BorderLayout.WEST);
        mainDisplay.add(botStats, BorderLayout.EAST);
        mainDisplay.add(statOptions, BorderLayout.SOUTH);
        

        mainDisplay.setVisible(true);
    }
    public static void main(String[] args) {
        new createCharacterDisplay();
    }
}
