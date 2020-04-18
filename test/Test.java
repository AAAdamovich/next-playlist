
package test;

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
  private static void printSongs(PrintStream output, String query) throws SQLException
  {
    // TODO - Credentials needed to log onto remote server
    final String SERVER = "roadrunner.cs.wcupa.edu";
    final String DATABASE = "DarqChocolate";
    final String USERNAME = "CnC";
    final String PASSWORD = "vQB3po5qdvEuRANA";

    // Credentials are used to establish a connection
    Connection conn = DriverManager.getConnection("jdbc:mysql://" + SERVER + "/" + DATABASE, USERNAME, PASSWORD);
    // The statement object will drive any queries to the database
    Statement st = conn.createStatement();
    ResultSet results = st.executeQuery(query);
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
  }//end of printSongs
    
  
  public static void main(String[] args) throws SQLException{
        printSongs(System.out, "SELECT * FROM Songs");
    }
}
