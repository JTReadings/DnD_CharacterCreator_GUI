import javax.imageio.ImageIO;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
import java.awt.image.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;


public class characterOptions {

    static String url="jdbc:mysql://localhost/"+"dnd";
    static String userid="root", password = "boop";
    static Connection con = getJDBCConnection();
    ResultSet rs;

    JComboBox selectRace = new JComboBox();
    JComboBox selectClass = new JComboBox();
    JComboBox selectBackground = new JComboBox();

    BufferedImage img;

    JLabel racePic;
    
    public characterOptions(){     
    }

    public static Connection getJDBCConnection() {     
       try {
         con = DriverManager.getConnection(url,userid, password);
         System.out.println("Connection established");
       } catch(SQLException ex) {
         System.err.println("SQLException: " + ex.getMessage());
       }  
       return con; 
    }
    
    public JComboBox raceSelection(){
        try {
            System.out.println(selectRace.getSelectedItem());
            rs = con.createStatement().executeQuery("SELECT raceNames from races");
            while (rs.next()) {
                selectRace.addItem(rs.getString("raceNames"));
                }
            rs.close();         
            }
        catch(SQLException ex) {
            System.err.println("SQLException: " +ex.getMessage());
        }        
        return selectRace;
    }

  /*  public JLabel racePics(){
        System.out.println("\"images/"+ selectRace.getSelectedItem() +".png\"");
        selectRace.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == selectRace) {
                    try {
                        img = ImageIO.read(new File("images/"+ raceSelection().getSelectedItem() +".png"));
                        racePic = new JLabel(new ImageIcon(img));
                    }       
                catch(IOException ex) {
                    ex.printStackTrace();
                } 
                }  
            }
        });
        if(racePic == null){
            racePic = new JLabel();
            return racePic;
        }
        else {
            return racePic;
        }
    }*/
    

    public JComboBox classSelection(){
        try {
            ResultSet rs = con.createStatement().executeQuery("SELECT classNames from classes");
            while (rs.next()) {
                selectClass.addItem(rs.getString("classNames")); 
                }
            rs.close();         
            }
        catch(SQLException ex) {
            System.err.println("SQLException: " +ex.getMessage());
        }
        selectClass.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == selectClass) {
                    System.out.println("Yay!"+ selectClass.getSelectedItem());
                }
            }
        });
        return selectClass;
    }

    public JComboBox backgroundSelection(){
        try {
            ResultSet rs = con.createStatement().executeQuery("SELECT backgroundNames from backgrounds");
            while (rs.next()) {
                selectBackground.addItem(rs.getString("backgroundNames")); 
                }
            rs.close();         
            }
        catch(SQLException ex) {
            System.err.println("SQLException: " +ex.getMessage());
        }
        selectBackground.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == selectBackground) {
                    System.out.println("Yay!"+ selectBackground.getSelectedItem());
                }
            }
        });
        return selectBackground;
    }
}
