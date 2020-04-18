import java.io.PrintStream;
import java.sql.*;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.geometry.Pos;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;

public class NextPlaylistJavaFX extends Application
{
  private static void addSongs(Object[] list)
  {
  
  }//end of addSongs
  private static void printSongs(PrintStream output, String query) throws SQLException
  {
    // TODO - Credentials needed to log onto remote server
    final String SERVER_IP = "";
    final String DATABASE = "";
    final String USERNAME = "";
    final String PASSWORD = "";

    // Credentials are used to establish a connection
    Connection conn = DriverManager.getConnection("jdbc:mysql://" + SERVER_IP + "/" + DATABASE, USERNAME, PASSWORD);
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
  private Label label;
  @Override
  public void start(Stage primaryStage)
  {
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
    
    label1.setOnAction(new ButtonClickHandler1());
    label2.setOnAction(new ButtonClickHandler2());
    label3.setOnAction(new ButtonClickHandler3());
    label4.setOnAction(new ButtonClickHandler4());
    label5.setOnAction(new ButtonClickHandler5());
    label6.setOnAction(new ButtonClickHandler6());

    
    VBox vbox = new VBox(10, label0, gridpane, label);
    Scene scene = new Scene(vbox, 400, 200);
    primaryStage.setScene(scene);
    primaryStage.setTitle("Searching For Music App");
    primaryStage.show();
  }//End start

class ButtonClickHandler1 implements EventHandler<ActionEvent>
  {
    @Override
    public void handle(ActionEvent event)
    {
      label.setText("You want to search by Genre.");
    }//End handle
  }//End ButtomClickHandler
class ButtonClickHandler2 implements EventHandler<ActionEvent>
  {
    @Override
    public void handle(ActionEvent event)
    {
      label.setText("You want to search by Title.");
    }//End handle
  }//End ButtomClickHandler
class ButtonClickHandler3 implements EventHandler<ActionEvent>
  {
    @Override
    public void handle(ActionEvent event)
    {
      label.setText("You want to search by Artist.");
    }//End handle
  }//End ButtomClickHandler
class ButtonClickHandler4 implements EventHandler<ActionEvent>
  {
    @Override
    public void handle(ActionEvent event)
    {
      label.setText("You want to search by Length.");
    }//End handle
  }//End ButtomClickHandler
class ButtonClickHandler5 implements EventHandler<ActionEvent>
  {
    @Override
    public void handle(ActionEvent event)
    {
      label.setText("You want to search by Album.");
    }//End handle
  }//End ButtomClickHandler
class ButtonClickHandler6 implements EventHandler<ActionEvent>
  {
    @Override
    public void handle(ActionEvent event)
    {
      label.setText("You want to search by Year.");
    }//End handle
  }//End ButtomClickHandler

  public static void main(String[] args) throws SQLException
  {
    launch(args);
  }//End main  
}//End class
