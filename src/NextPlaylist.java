/*  Antony Adamovich, Cheuk Cheung, Louis Cumberland, Tim McGowan
*   NextPlaylist.java for Next-Playlist SE Project 
*   West Chester University - CSC 402 - Dr. Richard G. Epstein
*   Created: 16-APR-2020
*   Please see https://github.com/AAAdamovich/next-playlist for version tracking
*/

import java.io.PrintStream;
import java.sql.*;
import java.util.ArrayList;
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
import javafx.scene.paint.Color;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.StackPane;

public class NextPlaylist extends Application
{

    private static String prettyPrint(ArrayList<String> list){
        String textBlock = "";
        for(String song : list){
            textBlock += song + "\n";
        }
        return textBlock;
    }
    
    private static int addSongs(ArrayList<String> songList, String query){
        // TODO - Credentials needed to log onto remote server
            final String SERVER = "jdbc:mysql://db4free.net:3306/darqchocolate";
            final String USERNAME = "cookieman";
            final String PASSWORD = "cookiesandchocolate";
            String nextSong = "";
            int songsAdded = 0;

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

            // These two loops control generation of the query results
            // While loop iterates by row of results
            while (results.next()){
              // For loop iterates by column of results
              for(int i = 1; i <= metadata.getColumnCount(); i++){
                nextSong += (results.getString(i) + " ");
              }
              // Add single line song to array and wipe String for next line
              songList.add(nextSong);
              nextSong = "";
              songsAdded ++;
            }
            return songsAdded;
        }
        catch(SQLException e){
            // !! No error handling !!
            e.printStackTrace();
            return -1;
        }
    }
    
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
  
  
  private TextField searchbar1, searchbar3, FirstName, LastName, searchbar5, searchbar6;
  private Label label, resultLabel4, labeltitle, labeltitleS, songname2, resultTitle, resultHistory, resultArtist,resultGenre,resultGenre2, resultLength, resultYear,resultTitle2, resultHistory2, resultArtist2, resultLength2, resultYear2;
  private RadioButton ShortButton, MediumButton, LongButton;
  private CheckBox g1,g2,g3,g4,g5,g6,g7,g8,g9;
  private String search, Titletext, Albumtext;
  private String searchTitle, searchArtist, searchAlbum, searchGenre, searchLength, searchYear,searchTitle2, searchArtist2, searchAlbum2, searchGenre2, searchLength2, searchYear2;
  private Button toGenre, toTitle, toArtist, toLength, toAlbum, toYear, toHistory0, toHistory1, toHistory2, toHistory3, toHistory4,toHistory5, toHistory6;
  private Button backToMain1, backToMain2, backToMain3, backToMain4, backToMain5, backToMain6, backToMain7;
  private Button search1, search2, search3, search4, search5, search6;
  private VBox S0Main, S4Genre, S1Title, S2Artist, S5Length, S3Album, S6Year, S7History;
  private HBox buttonOp1,buttonOp2,buttonOp3,buttonOp4,buttonOp5,buttonOp6;
  Stage window;
  Scene sceneX, scene0,scene1,scene2, scene3, scene4, scene5, scene6, scene7;
  String checkUser, checkPw;
  ArrayList<String> songList = new ArrayList<String>();
 
  @Override
  public void start(Stage primaryStage) throws Exception
  {
      
    window = primaryStage;
    
    //sceneLogin
    Label lblUserName = new Label("Username ");
    final TextField txtUserName = new TextField();
    txtUserName.setPrefColumnCount(15);
    Label lblPassword = new Label("Password ");
    final PasswordField pf = new PasswordField();
    pf.setPrefColumnCount(15);
    Button login = new Button("Login");
    Button store = new Button("Store");
    
    Label lblMessage1 = new Label();
    lblMessage1.setTextFill(Color.web("#ff0000", 0.8));
    final Label lblMessage2 = new Label();
    GridPane gridPane = new GridPane();
    gridPane.add(lblUserName, 0, 0);
    gridPane.add(txtUserName, 1, 0);
    gridPane.add(lblMessage2, 1, 3);
    gridPane.add(lblPassword, 0, 1);
    gridPane.add(pf, 1, 1);
    gridPane.add(login, 0, 2);
    gridPane.add(store, 1, 2);
    
    login.setOnAction(event -> {

        checkUser = txtUserName.getText();
        checkPw = pf.getText();
            
        if(PasswordUtils.verifyUser(checkUser) && PasswordUtils.verifyPassword(checkPw)){
            primaryStage.setScene(scene0);
        }
        else{
            lblMessage1.setText("Incorrect user or password.");
        }

        // Wipe fields for incorrect passwords / future access
        txtUserName.setText("");
        pf.setText("");
    });
    
     store.setOnAction(event -> {

        checkUser = txtUserName.getText();
        checkPw = pf.getText();
        
        PasswordUtils.saveLogin(checkUser, checkPw);
        System.out.println("Credentials saved");

    });
    sceneX = new Scene(gridPane, 300, 200);
    gridPane.setAlignment(Pos.CENTER);

//sceneLogin end
//scene0
    Label label0 = new Label("Click on the what do want to search by");

    toTitle = new Button("Title");
    toTitle.setMaxSize(100, 200);
    toArtist = new Button("Artist");
    toArtist.setMaxSize(100, 200);
    toAlbum = new Button("Album");
    toAlbum.setMaxSize(100, 200);
    toGenre = new Button("Genre");
    toGenre.setMaxSize(100, 200);
    toLength = new Button("Length");
    toLength.setMaxSize(100, 200);
    toYear = new Button("Year");
    toYear.setMaxSize(100, 200);
    toHistory0 = new Button("History");
    toHistory0.setMaxWidth(148);
    toHistory0.setStyle("-fx-text-fill: #0000ff");
    GridPane gridpane = new GridPane();
    gridpane.add(toTitle,0,1);
    gridpane.add(toArtist,1,1);
    gridpane.add(toAlbum,2,1);
    gridpane.add(toGenre,0,2);
    gridpane.add(toLength,1,2);
    gridpane.add(toYear,2,2);
    toTitle.setOnAction(e -> window.setScene(scene1));
    toArtist.setOnAction(e -> window.setScene(scene2));
    toAlbum.setOnAction(e -> window.setScene(scene3));
    toGenre.setOnAction(e -> window.setScene(scene4));
    toLength.setOnAction(e -> window.setScene(scene5));
    toYear.setOnAction(e -> window.setScene(scene6));
    toHistory0.setOnAction(event -> {
        resultHistory.setText(prettyPrint(songList));
        window.setScene(scene7);
    });
    S0Main = new VBox(10, label0, gridpane, toHistory0);
    scene0 = new Scene(S0Main, 300, 200);
    S0Main.setAlignment(Pos.CENTER);
    gridpane.setAlignment(Pos.CENTER);
    //end scene 0
    //scene 1
     StackPane layoutTitle = new StackPane();
     Label message1 = new Label("Search By Title");
     Label sp1 = new Label();
     searchbar1 = new TextField();
     searchbar1.setPrefColumnCount(15);
     resultTitle = new Label();
     resultTitle2 = new Label();
     search1 = new Button("Search");
     backToMain1 = new Button("Back");
     backToMain1.setOnAction(w -> window.setScene(scene0));
     toHistory1 = new Button("History");
     toHistory1.setOnAction(w -> window.setScene(scene7));
     toHistory1.setMaxWidth(148);
     toHistory1.setStyle("-fx-text-fill: #0000ff");
     search1.setOnAction(event->
     {
       Titletext = searchbar1.getText();
       searchTitle2 = "Songs Found: " + addSongs(songList, "SELECT * FROM Song WHERE Song.title = \"" + Titletext + "\"");
       searchTitle = getSongs("SELECT * FROM Song WHERE Song.title = \"" + Titletext + "\"");
       System.out.println(searchbar1.getText());
       
       if (searchTitle.length() == 0)
       resultTitle.setText("No Result Found");
       else
       {
       resultTitle.setText(searchTitle);
       resultTitle2.setText(searchTitle2);
       }
       //add to resultHistory.setText(searchTitle);
     });//End handle
     buttonOp1 = new HBox(10, search1, backToMain1);
     GridPane gridT1 = new GridPane();
     gridT1.add(message1, 0, 0);
     gridT1.add(searchbar1, 0, 1);
     gridT1.add(sp1, 0, 3);
     gridT1.add(buttonOp1, 0, 4);
     S1Title = new VBox(10, message1, gridT1,resultTitle2, resultTitle);
     layoutTitle.getChildren().add(S1Title);
     scene1 = new Scene(layoutTitle, 500, 200);
     buttonOp1.setAlignment(Pos.CENTER);
     S1Title.setAlignment(Pos.CENTER);
     gridT1.setAlignment(Pos.CENTER);
    //end scene1
        
    //scene 2
     StackPane layoutArtist = new StackPane();
     Label message2 = new Label("Search By: ");
     Label labelF = new Label("First Name");
     Label labelL = new Label("Last Name");
     Label resultArtist = new Label();
     Label resultArtist2 = new Label();
     FirstName = new TextField();
     LastName = new TextField();
     search2 = new Button("Search");
     search2.setOnAction(event->
     {
       String searchF = FirstName.getText();
       String searchL = LastName.getText();
       if (searchL.length()==0)
       {
       searchArtist = getSongs("SELECT * FROM Song WHERE Song.artist = \"" + searchF + "\"");
       searchArtist2 = "Songs Found: " + addSongs(songList, "SELECT * FROM Song WHERE Song.artist = \"" + searchF + "\"");
       }
       else if (searchF.length()==0)
       {
       searchArtist = getSongs("SELECT * FROM Song WHERE Song.artist = \"" + searchL + "\"");
       searchArtist2 = "Songs Found: " + addSongs(songList, "SELECT * FROM Song WHERE Song.artist = \"" + searchL + "\"");
       }
       else
       {
       searchArtist = getSongs("SELECT * FROM Song WHERE Song.artist = \"" + (searchF + " " + searchL)+ "\"");
       searchArtist2 = "Songs Found: " + addSongs(songList, "SELECT * FROM Song WHERE Song.artist = \"" + (searchF + " " + searchL)+ "\"");
       }
       if (searchArtist.length() == 0)
       resultArtist.setText("No Result Found");
       else
       {
       resultArtist.setText(searchArtist);
       resultArtist2.setText(searchArtist2);
       }
       //add to resultHistory.setText(searchArtist);
     });
     backToMain2 = new Button("Back");
     backToMain2.setOnAction(y -> window.setScene(scene0));
     toHistory2 = new Button("History");
     toHistory2.setOnAction(w -> window.setScene(scene7));
     toHistory2.setMaxWidth(148);
     toHistory2.setStyle("-fx-text-fill: #0000ff");
     GridPane ArtistGrid = new GridPane();
     ArtistGrid.add(message2, 0, 0);
     ArtistGrid.add(labelF, 0, 1);
     ArtistGrid.add(labelL, 1, 1);
     ArtistGrid.add(FirstName, 0, 2);
     ArtistGrid.add(LastName, 1, 2);
     buttonOp2 = new HBox(10, search2, backToMain2);
     S2Artist = new VBox(10, ArtistGrid, buttonOp2, resultArtist2, resultArtist);
     layoutArtist.getChildren().add(S2Artist);
     scene2 = new Scene(layoutArtist, 500, 200);
     S2Artist.setAlignment(Pos.CENTER);
     buttonOp2.setAlignment(Pos.CENTER);
     ArtistGrid.setAlignment(Pos.CENTER);
    //end scene2 
   
    //scene 3
    StackPane layoutAlbum = new StackPane();
    Label message3 = new Label("Search By Album");
    Label resultAlbum = new Label();
    Label resultAlbum2 = new Label();
    Label sp3x1 = new Label();
    searchbar3 = new TextField();
    searchbar3.setPrefColumnCount(15);
    search3 = new Button("Search");
    search3.setOnAction(event->
     {
       Albumtext = searchbar3.getText();
       searchAlbum2 = "Songs Found: " + addSongs(songList, "SELECT * FROM Song WHERE Song.album = \"" + Albumtext + "\"");
       
       searchAlbum = getSongs("SELECT * FROM Song WHERE Song.album = \"" + Albumtext + "\"");
       System.out.println(searchbar3.getText());
       if (searchAlbum.length() == 0)
       resultAlbum.setText("No Result Found");
       else
       {
       resultAlbum.setText(searchAlbum);
       resultAlbum2.setText(searchAlbum2);
       }
       //add to resultHistory.setText(searchTitle);
     });//End handle
    backToMain3 = new Button("Back");
    backToMain3.setOnAction(y -> window.setScene(scene0));
    toHistory3 = new Button("History");
    toHistory3.setOnAction(w -> window.setScene(scene7));
    toHistory3.setMaxWidth(148);
    toHistory3.setStyle("-fx-text-fill: #0000ff");
    buttonOp3 = new HBox(10, search3, backToMain3);
    
    GridPane gridT3 = new GridPane();
    gridT3.add(message3, 0, 0);
    gridT3.add(searchbar3, 0, 1);
    gridT3.add(sp3x1, 0, 3);
    gridT3.add(buttonOp3, 0, 4);
    
    S3Album = new VBox(10, gridT3,resultAlbum2, resultAlbum);
    layoutAlbum.getChildren().add(S3Album);
    scene3 = new Scene(layoutAlbum, 500, 200);
    S3Album.setAlignment(Pos.CENTER);
    buttonOp3.setAlignment(Pos.CENTER);
    gridT3.setAlignment(Pos.CENTER);
    //end scene 3
    //scene4
    StackPane layoutGenre = new StackPane();
    Label labelG = new Label("Check the ones you would like to search by:");
    g1 = new CheckBox("Pop");
    g2 = new CheckBox("Trap");
    g3 = new CheckBox("Synthwave");
    g4 = new CheckBox("Rap");
    g5 = new CheckBox("Pop rock");
    g6 = new CheckBox("R&B");
    resultGenre = new Label();
    resultGenre2 = new Label();
    GridPane Genregrid = new GridPane();
    Genregrid.add(g1,0,0);
    Genregrid.add(g2,0,1);
    Genregrid.add(g3,0,2);
    Genregrid.add(g4,1,0);
    Genregrid.add(g5,1,1);
    Genregrid.add(g6,1,2);
    backToMain4 = new Button("Back");
    backToMain4.setOnAction(w -> window.setScene(scene0));
    search4 = new Button("Search");
    //search4.setOnAction(e -> handleOptions(g1,g2,g3,g4,g5,g6,g7,g8,g9));
    search4.setOnAction(event->
     {
      ArrayList<String> genres = new ArrayList<String>();
      String query = "";
      if (g1.isSelected()){
          genres.add("Pop");
      }
      if (g2.isSelected()){
          genres.add("Trap");
      }
      if (g3.isSelected()){
          genres.add("Synthwave");
      }
      if (g4.isSelected()){
          genres.add("Rap");
      }
      if (g5.isSelected()){
          genres.add("Pop rock");
      }
      if (g6.isSelected()){
          genres.add("R&B");
      }
      for(String genre : genres){
          // If this is the first genre to search for, initial query string is specified
          if(query.length() == 0){
              query += "SELECT * FROM Song WHERE Song.genre = \"" + genre + "\"";
          }
          // For multiple genre search, append an OR clause for each additional genre
          else{
              query += " OR Song.genre = \"" + genre + "\"";
          }
      }
      // Run the generated query
      addSongs(songList, query);
      //resultGenre.setText(genres);
     });//End handle
    
    toHistory4 = new Button("History");
    toHistory4.setOnAction(w -> window.setScene(scene7));
    toHistory4.setMaxWidth(148);
    toHistory4.setStyle("-fx-text-fill: #0000ff");
    buttonOp4 = new HBox(10, search4, backToMain4);
    S4Genre = new VBox(10, labelG, Genregrid, buttonOp4,resultGenre2,resultGenre);
    layoutGenre.getChildren().add(S4Genre);
    scene4 = new Scene(layoutGenre, 500, 200);
    S4Genre.setAlignment(Pos.CENTER);
    Genregrid.setAlignment(Pos.CENTER);
    buttonOp4.setAlignment(Pos.CENTER);
    //end scene4
    //scene5
    StackPane layoutlength = new StackPane();
    resultLength = new Label();
    resultLength2 = new Label();
    Label message5 = new Label("Search By Length");
    ShortButton = new RadioButton("Short(Less than 2 Minute)");
    MediumButton = new RadioButton("Medium(Between 2 to 4 Minutes)");
    LongButton = new RadioButton("Long(Greater than 4 Minutes)");
    ToggleGroup radioGroup = new ToggleGroup();
    ShortButton.setToggleGroup(radioGroup);
    MediumButton.setToggleGroup(radioGroup);
    LongButton.setToggleGroup(radioGroup);
    MediumButton.setSelected(true);
    search5 = new Button("Search");
    search5.setOnAction(event->
    {
      if (ShortButton.isSelected())
      {
          searchLength = getSongs("SELECT * FROM Song WHERE Song.length < '00:02:01'");
          searchLength2 = "Songs Found: " + addSongs(songList, "SELECT * FROM Song WHERE Song.length < '00:02:01'");
          System.out.println("Less than 2 Minute");
          if (searchLength.length() == 0)
          resultLength.setText("No Result Found");
          else
          {
          resultLength.setText(searchLength);
          resultLength2.setText(searchLength2);
          }
      }
      
      if (MediumButton.isSelected())
      {
          searchLength = getSongs("SELECT * FROM Song WHERE Song.length > '00:02:00' AND Song.length < '00:04:01'");
          searchLength2 = "Songs Found: " + addSongs(songList, "SELECT * FROM Song WHERE Song.length > '00:02:00' AND Song.length < '00:04:01'");
          System.out.println("Between 2 to 4 Minutes");
          if (searchLength.length() == 0)
          resultLength.setText("No Result Found");
          else
          {
          resultLength.setText(searchLength);
          resultLength2.setText(searchLength2);
          }
      }
      
      if (LongButton.isSelected())
      { 
          searchLength = getSongs("SELECT * FROM Song WHERE Song.length > '00:04:00'");
          searchLength2 = "Songs Found: " + addSongs(songList, "SELECT * FROM Song WHERE Song.length > '00:04:00'");
          System.out.println("Greater than 4 Minutes");
          if (searchLength.length() == 0)
          resultLength.setText("No Result Found");
          else{
          resultLength.setText(searchLength);
          resultLength2.setText(searchLength2);
          }
      }

    });//End handle
    backToMain5 = new Button("Back");
    backToMain5.setOnAction(y -> window.setScene(scene0));

    toHistory5 = new Button("History");
    toHistory5.setMaxWidth(148);
    toHistory5.setStyle("-fx-text-fill: #0000ff");
    toHistory5.setOnAction(w -> window.setScene(scene7));    
    VBox radioButton = new VBox(20, ShortButton, MediumButton, LongButton);
    buttonOp5 = new HBox(10, search5, backToMain5);
    S5Length = new VBox(10,message5, radioButton, buttonOp5,resultLength2, resultLength);
    layoutlength.getChildren().add(S5Length);
    scene5 = new Scene(layoutlength,550,400);
    //end scene5
    //scene6
    StackPane layoutYear = new StackPane();
    Label message6 = new Label("Search By Release Year");
    Label sp6 = new Label();
    searchbar6 = new TextField();
    searchbar6.setPrefColumnCount(15);
    resultYear = new Label();
    resultYear2 = new Label();
    search6 = new Button("Search");
    backToMain6 = new Button("Back");
    backToMain6.setOnAction(w -> window.setScene(scene0));
    toHistory6 = new Button("History");
    toHistory6.setOnAction(w -> window.setScene(scene7));
    toHistory6.setMaxWidth(148);
    toHistory6.setStyle("-fx-text-fill: #0000ff");
    search6.setOnAction(event->
     {
       int Yeartextnum = Integer.parseInt(searchbar6.getText());
       searchYear2 = "Songs Found: " + addSongs(songList, "SELECT * FROM Song WHERE Song.releaseyear = \"" + Yeartextnum + "\"");
       searchYear = getSongs("SELECT * FROM Song WHERE Song.releaseyear = \"" + Yeartextnum + "\"");
       System.out.println(searchbar6.getText());
       if (searchYear.length() == 0)
       resultYear.setText("No Result Found");
       else
       {
       resultYear.setText(searchYear);
       resultYear2.setText(searchYear2);
       }
       //add to resultHistory.setText(searchTitle);
     });//End handle
    buttonOp6 = new HBox(10, search6, backToMain6);
    GridPane gridT6 = new GridPane();
    gridT6.add(message6, 0, 0);
    gridT6.add(searchbar6, 0, 1);
    gridT6.add(sp6, 0, 3);
    gridT6.add(buttonOp6, 0, 4);
    S6Year = new VBox(10, message6, gridT6,resultYear2, resultYear);
    layoutYear.getChildren().add(S6Year);
    scene6 = new Scene(layoutYear, 550, 400);
    buttonOp6.setAlignment(Pos.CENTER);
    S6Year.setAlignment(Pos.CENTER);
    gridT6.setAlignment(Pos.CENTER);
    //end scene6
    
    //scene7 add the array here so it can keep all the search made
    StackPane layoutHistory = new StackPane();
    Label xs = new Label("History: ");
    resultHistory = new Label();
    resultHistory.setText(prettyPrint(songList));
    backToMain7 = new Button("Back");
    backToMain7.setOnAction(y -> window.setScene(scene0));
    S7History = new VBox(10, xs, resultHistory, backToMain7);
    layoutHistory.getChildren().add(S7History);
    scene7 = new Scene(layoutHistory, 500, 200);
    //end scene7
    //Start Scene
    primaryStage.setScene(sceneX);
    primaryStage.setTitle("Searching for Music App");
    primaryStage.show();
  }//End start

  public static void main(String[] args)
  {
    launch(args);
  }//End main  
}//End class
