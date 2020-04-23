
//package test;

import java.io.PrintStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class Test {
    
  /** Queries the database for songs based on an input query and prints 
  * the results immediately to the output stream. 
  * !! Exception handling is not considered !! 
  * 
  * @param output The stream to which the query results will be sent to
  * @param query A SQL query that describes what sort of information is
  *   to be requested from the server
  * 
  * @throws SQLException
  */
  private static void printSongs(PrintStream output, String query) throws Exception
  {
    // TODO - Credentials needed to log onto remote server
    final String SERVER = "jdbc:mysql://127.0.0.1:3306/test";
    final String DATABASE = "test";
    final String USERNAME = "root";//CnC
    final String PASSWORD = "cookies";//vQB3po5qdvEuRANA
    //Class.forName("com.mysql.jdbc.Driver");
    // Credentials are used to establish a connection
    System.out.println("Done1");
    Connection conn = DriverManager.getConnection(SERVER, USERNAME, PASSWORD);
    // The statement object will drive any queries to the database
    
    System.out.println("Done2");
    Statement st = conn.createStatement();
    
    System.out.println("Done3");
    ResultSet results = st.executeQuery(query);
    
    System.out.println("Done4");
    // metadata describes how the results are organized
    // Used to fetch the column count of the results table,
    //  necessary for printing the results later
    ResultSetMetaData metadata = results.getMetaData();

    // These two loops control printing of the query results
    // While loop iterates by row of results
    while (results.next()){
      // For loop iterates by column of results
      for(int i = 1; i <= metadata.getColumnCount(); i++){
        output.print(results.getString(i) + " ");
      }
      // Insert newline for every row iteration
      output.println();
    }
    // Extra padding for any text that comes after this method call
    output.println();
    conn.close();
  }//end of printSongs
    
  
  public static void main(String[] args) throws Exception{
        printSongs(System.out, "SELECT * FROM Song");
    }
}
