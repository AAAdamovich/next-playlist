/*  Antony Adamovich, Cheuk Cheung, Louis Cumberland, Tim McGowan
*   NextPlaylist.java for Next-Playlist SE Project 
*   West Chester University - CSC 402 - Dr. Richard G. Epstein
*   Created: 16-APR-2020
*   Please see https://github.com/AAAdamovich/next-playlist
*      for version tracking
*/

//package nextplaylist;

import java.io.PrintStream;
import java.sql.*;
import javax.swing.JOptionPane; 

public class NextPlaylist
{
    
  // TODO - Potential feature to add songs to big list and then shuffle
  //private static void addSongs(Object[] list){}

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
    final String SERVER = "taz.wcupa.edu";
    final String DATABASE = "DarqChocolate";
    final String USERNAME = "CnC";
    final String PASSWORD = "vQB3po5qdvEuRANA";
  
    // Credentials are used to establish a connection
    Connection conn = DriverManager.getConnection("jdbc:mysql:" + SERVER + "/" + DATABASE, USERNAME, PASSWORD);
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
  }
  
  public static void main(String[] args) throws SQLException
  {
    printSongs(System.out, "SELECT * FROM Song");
    String optionInput;
    int option;
    optionInput = JOptionPane.showInputDialog("Search by what?(Enter Number 1-6)\n1. Genre\n2. Title\n3. Artist\n4. Length\n5. Album\n6. Year");
    option = Integer.parseInt(optionInput);
    while (option < 0 || option > 7)
    {
      JOptionPane.showMessageDialog(null, "Error Try Again!");
      optionInput = JOptionPane.showInputDialog("Search by what?(Enter Number 1-6)\n1. Genre\n2. Title\n3. Artist\n4. Length\n5. Album\n6. Year");
      option = Integer.parseInt(optionInput);
    }
      if (option == 1)
      {
        String genreYN1;
        char genreYN2;
        //JOptionPane.showMessageDialog(null, "Searching by Genre")
        genreYN1 = JOptionPane.showInputDialog("Searching by Genre? (Y or N)");
        genreYN2 = genreYN1.charAt(0);
        if (genreYN2==('Y')||genreYN2==('y'))
        {
          JOptionPane.showMessageDialog(null, "Yes");
        }
        else if (genreYN2 == 'N'||genreYN2 == 'n')
        {
          JOptionPane.showMessageDialog(null, "No");
        }
        else
        {
          JOptionPane.showMessageDialog(null, "Error Try Again");
        }
      }//Option 1 End
      else if (option == 2)
      {
        String TitleYN1;
        char TitleYN2;
        //JOptionPane.showMessageDialog(null, "Searching by Title")
        TitleYN1 = JOptionPane.showInputDialog("Searching by Title? (Y or N)");
        TitleYN2 = TitleYN1.charAt(0);
        if (TitleYN2 == ('Y')||TitleYN2 == ('y'))
        {
          JOptionPane.showMessageDialog(null, "Yes");
        }
        else if (TitleYN2 == 'N'||TitleYN2 == 'n')
        {
          JOptionPane.showMessageDialog(null, "No");
        }
        else
        {
          JOptionPane.showMessageDialog(null, "Error");
        }
      }//Option 2 End
      else if (option == 3)
      {
        String ArtistYN1;
        char ArtistYN2;
        //JOptionPane.showMessageDialog(null, "Searching by Artist")
        ArtistYN1 = JOptionPane.showInputDialog("Searching by Artist? (Y or N)");
        ArtistYN2 = ArtistYN1.charAt(0);
        if (ArtistYN2 == ('Y') || ArtistYN2 == ('y'))
        {
          JOptionPane.showMessageDialog(null, "Yes");
        }
        else if (ArtistYN2 == 'N'||ArtistYN2 == 'n')
        {
          JOptionPane.showMessageDialog(null, "No");
        }
        else
        {
          JOptionPane.showMessageDialog(null, "Error Try Again");
        }
      }//Option 3 End
      else if (option == 4)
      {
        String LengthYN1;
        char LengthYN2;
        //JOptionPane.showMessageDialog(null, "Searching by Length")
        LengthYN1 = JOptionPane.showInputDialog("Searching by Length? (Y or N)");
        LengthYN2 = LengthYN1.charAt(0);
        if (LengthYN2==('Y')||LengthYN2==('y'))
        {
          JOptionPane.showMessageDialog(null, "Yes");
        }
        else if (LengthYN2 == 'N'||LengthYN2 == 'n')
        {
          JOptionPane.showMessageDialog(null, "No");
        }
        else
        {
          JOptionPane.showMessageDialog(null, "Error Try Again");
        }
      }//Option 4 End
      else if (option == 5)
      {
        String AlbumYN1;
        char AlbumYN2;
        //JOptionPane.showMessageDialog(null, "Searching by Album")
        AlbumYN1 = JOptionPane.showInputDialog("Searching by Album? (Y or N)");
        AlbumYN2 = AlbumYN1.charAt(0);
        if (AlbumYN2 == ('Y')||AlbumYN2 == ('y'))
        {
          JOptionPane.showMessageDialog(null, "Yes");
        }
        else if (AlbumYN2 == 'N'||AlbumYN2 == 'n')
        {
          JOptionPane.showMessageDialog(null, "No");
        }
        else
        {
          JOptionPane.showMessageDialog(null, "Error Try Again");
        }
      }//Option 5 End
      else if (option == 6)
      {
        String YearYN1;
        char YearYN2;
        //JOptionPane.showMessageDialog(null, "Searching by Year")
        YearYN1 = JOptionPane.showInputDialog("Searching by Year? (Y or N)");
        YearYN2 = YearYN1.charAt(0);
        if (YearYN2 == ('Y') || YearYN2 == ('y'))
        {
          JOptionPane.showMessageDialog(null, "Yes");
        }
        else if (YearYN2 == 'N'||YearYN2 == 'n')
        {
          JOptionPane.showMessageDialog(null, "No");
        }
        else
        {
          JOptionPane.showMessageDialog(null, "Error Try Again");
        }
      }//Option 6 End
    JOptionPane.showMessageDialog(null, "Exiting Program");
  }//Main End
}//Program End
