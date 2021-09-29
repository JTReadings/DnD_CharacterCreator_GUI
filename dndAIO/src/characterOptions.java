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
    JComboBox selectScore = new JComboBox();
    
    public characterOptions() {     
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
            rs = con.createStatement().executeQuery("SELECT raceNames from races");
            while (rs.next()) {
                selectRace.addItem(rs.getString("raceNames"));
            }
                rs.close();         
        } catch(SQLException ex) {
            System.err.println("SQLException: " +ex.getMessage());
        }        
        selectRace.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == selectRace) {
                    System.out.println("Yay!"+ selectRace.getSelectedItem());
            
                }
            }
        });
        return selectRace;
    }

    public JComboBox classSelection(){
        try {
            rs = con.createStatement().executeQuery("SELECT classNames from classes");
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
            rs = con.createStatement().executeQuery("SELECT backgroundNames from backgrounds");
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

    public JComboBox[] statSelect(){
        JComboBox[] statsArray = new JComboBox[6];
        for(int j = 0; j <= 5; j++){
            statsArray[j] = new JComboBox();
            for(int i = 1; i <= 20; i++) {
                statsArray[j].addItem(i);
            }
        }
        return statsArray;
    }
}
