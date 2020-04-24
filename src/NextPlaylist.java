/*  Antony Adamovich, Cheuk Cheung, Louis Cumberland, Tim McGowan
*   NextPlaylist.java for Next-Playlist SE Project 
*   West Chester University - CSC 402 - Dr. Richard G. Epstein
*   Created: 16-APR-2020
*   Please see https://github.com/AAAdamovich/next-playlist for version tracking
*/

import java.io.PrintStream;
import java.sql.*;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.CheckBox;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.layout.StackPane;

public class NextPlaylist extends Application
{
    /** Queries the database for songs based on an input query and returns 
    * the results of the query as a single String. Each row from the query
    * result is given its own line in the String
    * !! Exception handling is not considered !! 
    * 
    * @param query A SQL query that describes what sort of information is
    *   to be requested from the server
    * @return A String representation of the query result, one database row
    *   per line
    */
    private static String getSongs(String query){
        // Credentials needed to log onto remote server
        final String SERVER = "jdbc:mysql://db4free.net:3306/darqchocolate";
        final String USERNAME = "cookieman";
        final String PASSWORD = "cookiesandchocolate";

        // The String representation of the query result
        String queryResult = "";
        
        try{
            // Credentials are used to establish a connection
            Connection conn = DriverManager.getConnection(SERVER, USERNAME, PASSWORD);
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
                    queryResult += (results.getString(i) + " ");
                }
                // Insert newline for every row iteration
                queryResult += "\n";
            }
            return queryResult;
        }
        catch(SQLException e){
            // !! No error handling !!
            e.printStackTrace();
            return null;
        }
    }
  
  /** Queries the database for songs based on an input query and prints 
  * the results immediately to the output stream. 
  * !! Exception handling is not considered !! 
  * 
  * @param output The stream to which the query results will be sent to
  * @param query A SQL query that describes what sort of information is
  *   to be requested from the server
  */
  private static void printSongs(PrintStream output, String query)
  {
    // Credentials needed to log onto remote server
    final String SERVER = "jdbc:mysql://db4free.net:3306/darqchocolate";
    final String USERNAME = "cookieman";
    final String PASSWORD = "cookiesandchocolate";

    try{
        // Credentials are used to establish a connection
        Connection conn = DriverManager.getConnection(SERVER, USERNAME, PASSWORD);
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
    }
    catch(SQLException e){
        // !! No error handling !!
        e.printStackTrace();
    }
    
    // Extra padding for any text that comes after this method call
    output.println();
  }//end of printSongs
  
  
  private TextField searchbar1, searchbar2, FirstName, LastName, searchbar5, searchbar6;
  private Label label, resultLabel4, labeltitle, labeltitleS, songname2;
  private RadioButton ShortButton, MediumButton, LongButton;
  private CheckBox g1,g2,g3,g4,g5,g6,g7,g8,g9;
  Stage window;
  Scene scene0,scene1,scene2, scene2x1, scene3, scene4, scene5, scene6;
  
  @Override
  public void start(Stage primaryStage) throws Exception
  {
    // !! Query Testing - To be removed !!
    //printSongs(System.out, "SELECT * FROM Songs");
      
    window = primaryStage;
    //scene0
    Label label0 = new Label("Click on the what do want to search by");
    Button label1 = new Button(" Genre ");
    Button label2 = new Button(" Title ");
    Button label3 = new Button(" Artist ");
    Button label4 = new Button(" Length ");
    Button label5 = new Button(" Album ");
    Button label6 = new Button(" Year ");
    label = new Label();
    GridPane gridpane = new GridPane();
    gridpane.add(label1,0,1);
    gridpane.add(label2,1,1);
    gridpane.add(label3,2,1);
    gridpane.add(label4,0,2);
    gridpane.add(label5,1,2);
    gridpane.add(label6,2,2);
    label1.setOnAction(e -> window.setScene(scene1));
    label2.setOnAction(e -> window.setScene(scene2));
    label3.setOnAction(e -> window.setScene(scene3));
    label4.setOnAction(e -> window.setScene(scene4));
    label5.setOnAction(e -> window.setScene(scene5));
    label6.setOnAction(e -> window.setScene(scene6));
    VBox vbox = new VBox(10, label0, gridpane, label);
    scene0 = new Scene(vbox, 400, 200);
    //end scene 0
    
    //scene1
    StackPane layoutGenre = new StackPane();
    Label labelG = new Label("Check the ones you would like to search by:");
    g1 = new CheckBox("POP");
    g2 = new CheckBox("Hip Hop");
    g3 = new CheckBox("Rock");
    g4 = new CheckBox("Metal");
    g5 = new CheckBox("Jazz");
    g6 = new CheckBox("Country");
    g7 = new CheckBox("Classical");
    g8 = new CheckBox("Blues");
    g9 = new CheckBox("Instrumental");
    GridPane Genregrid = new GridPane();
    Genregrid.add(g1,0,0);
    Genregrid.add(g2,0,1);
    Genregrid.add(g3,0,2);
    Genregrid.add(g4,1,0);
    Genregrid.add(g5,1,1);
    Genregrid.add(g6,1,2);
    Genregrid.add(g7,2,0);
    Genregrid.add(g8,2,1);
    Genregrid.add(g9,2,2);
    
    Button search1 = new Button("Search");
    search1.setOnAction(e -> handleOptions(g1,g2,g3,g4,g5,g6,g7,g8,g9));
    Button back1 = new Button("Back");
    back1.setOnAction(w -> window.setScene(scene0));
    HBox buttonOp1 = new HBox(10, search1, back1);
    VBox layout1 = new VBox(10, labelG, Genregrid, buttonOp1);
    layoutGenre.getChildren().add(layout1);
    scene1 = new Scene(layoutGenre, 400, 200);
    //end scene1
    
    //scene 2
     StackPane layoutTitle = new StackPane();
     searchbar2 = new TextField();
     Button search2 = new Button("Search");
     search2.setOnAction(y -> window.setScene(scene2x1));
     Button back2 = new Button("Back");
     back2.setOnAction(y -> window.setScene(scene0));
     HBox buttonOp2 = new HBox(10, search2, back2);
     VBox layout2 = new VBox(10, searchbar2, buttonOp2);
     layoutTitle.getChildren().add(layout2);
     scene2 = new Scene(layoutTitle, 400, 200);
    //end scene2
    
    //scene2.1
    StackPane layoutTitleS = new StackPane();
    labeltitleS = new Label("Found: ");
    String s = "xxx";
    //printSongs(System.out, "SELECT * FROM Song WHERE Song.title = \"" + searchbar2.getText() + "\"");
    songname2 = new Label(s);
    Button back2x1 = new Button("Back");
    back2x1.setOnAction(y -> window.setScene(scene2));
    HBox tt = new HBox(labeltitleS);
    VBox layout2x1 = new VBox(10, tt, songname2, back2x1);
    layoutTitleS.getChildren().add(layout2x1);
    scene2x1 = new Scene(layoutTitleS, 400, 200);
    //end scene2.1

    
    //scene 3
     StackPane layoutArtist = new StackPane();
     Label message3 = new Label("Search By: ");
     Label labelF = new Label("First Name");
     Label labelL = new Label("Last Name");
     FirstName = new TextField();
     LastName = new TextField();
     Button search3 = new Button("Search");
     search3.setOnAction(new ButtonClickHandler3());
     Button back3 = new Button("Back");
     back3.setOnAction(y -> window.setScene(scene0));
     GridPane ArtistGrid = new GridPane();
     ArtistGrid.add(labelF, 0, 0);
     ArtistGrid.add(labelL, 1, 0);
     ArtistGrid.add(FirstName, 0, 1);
     ArtistGrid.add(LastName, 1, 1);
     HBox buttonOp3 = new HBox(10, search3, back3);
     VBox layout3 = new VBox(10,message3, ArtistGrid, buttonOp3);
     layoutArtist.getChildren().add(layout3);
     scene3 = new Scene(layoutArtist, 400, 200);
    //end scene3 
    
    //scene4
    StackPane layoutlength = new StackPane();
    ShortButton = new RadioButton("Short");
    MediumButton = new RadioButton("Medium");
    LongButton = new RadioButton("Long");
    ToggleGroup radioGroup = new ToggleGroup();
    ShortButton.setToggleGroup(radioGroup);
    MediumButton.setToggleGroup(radioGroup);
    LongButton.setToggleGroup(radioGroup);
    MediumButton.setSelected(true);
    Button search4 = new Button("Search");
    search4.setOnAction(new ButtonClickHandler4());
    Button back4 = new Button("Back");
    back4.setOnAction(w -> window.setScene(scene0));
    
    HBox radioButton = new HBox(20, ShortButton, MediumButton, LongButton);
    HBox buttonOp4 = new HBox(10, search4, back4);
    VBox layout4 = new VBox(10, radioButton, buttonOp4);
    layoutlength.getChildren().add(layout4);
    scene4 = new Scene(layoutlength,400,200);
    //end scene4
    
    //scene 5
    StackPane layoutAlbum = new StackPane();
    searchbar5 = new TextField();
    Button search5 = new Button("Search");
    search5.setOnAction(new ButtonClickHandler5());
    Button back5 = new Button("Back");
    back5.setOnAction(y -> window.setScene(scene0));
    HBox buttonOp5 = new HBox(10, search5, back5);
    VBox layout5 = new VBox(10, searchbar5, buttonOp5);
    layoutAlbum.getChildren().add(layout5);
    scene5 = new Scene(layoutAlbum, 400, 200);
    //end scene 5
    
    //scene6
    StackPane layoutYear = new StackPane();
    searchbar6 = new TextField();
    Button search6 = new Button("Search");
    search6.setOnAction(new ButtonClickHandler6());
    Button back6 = new Button("Back");
    back6.setOnAction(y -> window.setScene(scene0));
    HBox buttonOp6 = new HBox(10, search6, back6);
    VBox layout6 = new VBox(10, searchbar6, buttonOp6);
    layoutYear.getChildren().add(layout6);
    scene6 = new Scene(layoutYear, 400, 200);
    //end scene6
    
    //Start Scene
    primaryStage.setScene(scene0);
    primaryStage.setTitle("Searching for Music App");
    primaryStage.show();
  }//End start

private void handleOptions(CheckBox  g1, CheckBox  g2, CheckBox  g3, CheckBox  g4, CheckBox  g5, CheckBox  g6, CheckBox  g7, CheckBox  g8, CheckBox  g9)
   {
      String message = "You chose to search by\n";
      if (g1.isSelected()){
           message += "POP\n";
           printSongs(System.out, "SELECT * FROM Song WHERE Song.genre = \"" + message + "\"");
           // TODO - COntinue this pattern for all cases
      }
      if (g2.isSelected())
      message += "Hip Hop\n";
      if (g3.isSelected())
      message += "Rock\n";
      if (g4.isSelected())
      message += "Metal\n";
      if (g5.isSelected()) 
      message += "Jazz\n";
      if (g6.isSelected())
      message += "Country\n";
      if (g7.isSelected())
      message += "Classical\n";
      if (g8.isSelected())
      message += "Blues\n";
      if (g9.isSelected())
      message += "Instrumental\n";
      System.out.println(message);
  }//End handleOptions
class ButtonClickHandler2 implements EventHandler<ActionEvent> 
  {
    @Override
    public void handle(ActionEvent event)
    {
      String search = searchbar2.getText();
      printSongs(System.out, "SELECT * FROM Song WHERE Song.title = \"" + search + "\"");
      System.out.println(searchbar2.getText());
    }//End handle
  }//End ButtomClickHandler
class ButtonClickHandler3 implements EventHandler<ActionEvent>
  {
    @Override
    public void handle(ActionEvent event)
    {
      //String 
      String searchF = FirstName.getText();
      String searchL = LastName.getText();
      // NOTE Artist search should just be one variable
      printSongs(System.out, "SELECT * FROM Song WHERE Song.artist = \"" + searchF + "\"");
      System.out.println(searchF + " " + searchL);
    }//End handle
  }//End ButtomClickHandler

class ButtonClickHandler4 implements EventHandler<ActionEvent>
  {
    @Override
    public void handle(ActionEvent event)
    {
      if (ShortButton.isSelected()){
          System.out.println("Less than 2 Minute");
          printSongs(System.out, "SELECT * FROM Song WHERE Song.length < '00:02:01'");
      }
      
      if (MediumButton.isSelected()){
          System.out.println("Between 2 to 4 Minutes");
          printSongs(System.out, "SELECT * FROM Song WHERE Song.length > '00:02:00' AND Song.length < '00:04:01'");
      }
      
      if (LongButton.isSelected()){
          System.out.println("Greater than 4 Minutes"); 
          printSongs(System.out, "SELECT * FROM Song WHERE Song.length > '00:04:00'");
      }
      
    }//End handle
  }//End ButtomClickHandler
class ButtonClickHandler5 implements EventHandler<ActionEvent>
  {
    @Override
    public void handle(ActionEvent event)
    {
      String search = searchbar5.getText();
      printSongs(System.out, "SELECT * FROM Song WHERE Song.album = \"" + search + "\"");
      System.out.println(search);
    }//End handle
  }//End ButtomClickHandler
class ButtonClickHandler6 implements EventHandler<ActionEvent>
  {
    @Override
    public void handle(ActionEvent event)
    {
      int search = Integer.parseInt(searchbar6.getText());
      printSongs(System.out, "SELECT * FROM Song WHERE Song.releaseyear = \"" + search + "\"");
      System.out.println(search);
    }//End handle
  }//End ButtomClickHandler

  public static void main(String[] args)
  {
    launch(args);
  }//End main  
}//End class
