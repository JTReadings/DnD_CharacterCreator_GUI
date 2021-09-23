import java.sql.*;

public class mainDisplay{

    static String databaseName="dnd";
    static String url="jdbc:mysql://localhost/"+databaseName;
    static String userid="root", password = "boop";
    static Statement stmt;
    static PreparedStatement pstmt;
    static Connection con;

    public static void main(String[] args)
    {
        new mainDisplay();
    }

    mainDisplay()
    {   
        if(checkforCharacter() == true)
        {
            new characterDisplay();
        }
        else
        {
            new createCharacterDisplay();
        } 
    }
    public static void findJDBCDriver()
    {
      try {
           Class.forName("com.mysql.cj.jdbc.Driver"); 
           System.out.println("Class Found");
       } catch(java.lang.ClassNotFoundException e) {
         System.err.print("ClassNotFoundException: ");
         System.err.println(e.getMessage());
       }
    }
    public static Connection getJDBCConnection()
    {     
       try {
         con = DriverManager.getConnection(url,userid, password);
         System.out.println("Connection established(Saved Characters)");
       } catch(SQLException ex) {
         System.err.println("SQLException: " + ex.getMessage());
       }  
       return con; 
    }
    public static boolean checkforCharacter()
    {
        Connection con = getJDBCConnection();
        String result = null;
        try {
            ResultSet rs = con.createStatement().executeQuery("SELECT pcID from playercharacter");
            while (rs.next()) {
                int id = rs.getInt("pcID");
                result+=id;
            }
        } catch(SQLException ex) {
            System.err.println("SQLException: " +ex.getMessage());
            }
        if(result == null)
            {
                return false;
            }
        else
            {
                return true;
            }
    }
}
