import java.sql.*;
//import java.sql.DriverManager;
//import java.sql.SQLException;


//for admin inserting username and password

// This class can be used to initialize the database connection 
public class DatabaseConnection { 
    protected static Connection initializeDatabase() 
        throws SQLException, ClassNotFoundException 
    { 
        // Initialize all the information regarding 
        // Database Connection 
        String dbDriver = "com.mysql.jdbc.Driver"; 
        String dbURL = "jdbc:mysql://localhost/library"; 
        // Database name to access 
       // String dbName = "library"; 
        String dbUsername = "root"; 
        String dbPassword = "marlabs"; 
  
        Class.forName(dbDriver); 
        System.out.println("------->BEFORe DBConnection<=------------ ");
        Connection con = DriverManager.getConnection(dbURL , 
                                                     dbUsername,  
                                                     dbPassword); 
        System.out.println("------->after DBConnection<=------------ ");

        return con; 
    } 
}
