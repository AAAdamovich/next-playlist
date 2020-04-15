/* Anton Adamovich
*  Prof. Charles Herbert - CSCI-112 - Community College of Philadelphia (CCP)
*  Created: 3-23-2017 - Last Edited: 3-27-2017
*  Assignment 7
*  Description: Program queries a database using a JDBC (Java DataBase Connectivity)
*   driver and prints the entire database to a CSV (Comma Separated Values) file.
*   Another arbirary query will print its own results in the console. The database
*   used with the project is a list of courses from CCP's Fall 2014 semester.
*   JDBC driver was included in a locally-acccesible library. 
*   CAUTION: With this program, exception handling was not considered, 
*   unexpected errors will crash the program. 
*  Resources:
*   The Java Platform API Specification:
*   http://docs.oracle.com/javase/8/docs/api/overview-summary.html
*   Charles Herbert's "RemoteMySQLDemo" - cherbert@ccp.edu
*/
package connectorsql;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.sql.*;

public class ConnectorSQL {

    /** Queries a database and prints the results to a CSV (Comma Separated
     * Values) file. By default, the entire database is printed. Exception
     * handling is not considered, all Exceptions are thrown back to main. 
     * 
     * @param st The Statement object that drives the SQL queries to whatever
     * database st was assigned to
     * 
     * @return File object denoting the pathname of the CSV file where the 
     * results of the SQL query were printed
     * @throws Exception 
     */
    private static File pullAlltoCSV(Statement st) throws Exception{
        
        // Edit text field with custom SQL to change program behavior
        final String QUERY = "SELECT * FROM fall2014;";
        
        // File object where query results will be stored in CSV format
        File csvResults = new File("results.csv");
        // The buffered printer that will write the results to the file
        PrintWriter csvWriter = new PrintWriter(new BufferedWriter(new FileWriter(csvResults)));
        // results is a new table of whatever the SQL QUERY returned
        ResultSet results = st.executeQuery(QUERY);
        // metadata describes how the results are organized
        ResultSetMetaData metadata = results.getMetaData();
        // This metatdata is used to fetch the column count of the results table,
        //  neccessary for printing the results later
        int numColumns = metadata.getColumnCount();
        
        // These two loops control printing of the query results
        // While loop iterates by row of results
        while (results.next()){
            // For loop iterates by column of results
            for(int i = 1; i <= numColumns; i++){
                csvWriter.print(results.getString(i) + ",");
            } // End for
            // Insert newline for every row iteration
            csvWriter.println();
        } // End while

        // Tell the user where the results CSV file is located
        System.out.println("The query reults have been stored in a .csv file located here: ");
        System.out.println(csvResults.getAbsolutePath());
        // Extra padding for any text that comes after this method call
        System.out.println();
        // Close printer
        csvWriter.close();
        return csvResults;
    } // End method
    
    /** Queries a database and prints the results to the console. 
     * The query used is arbitrary and can be changed within the code to produce
     * different results. Exception handling is not considered, all Exceptions 
     * are thrown back to main. 
     * 
     * @param st The Statement object that drives the SQL queries to whatever
     * database st was assigned to
     * 
     * @throws Exception 
     */
    private static void customQuery(Statement st) throws Exception{
        
        // Edit text field with custom SQL to change program behavior
        final String QUERY = "SELECT subject, course, days, time FROM fall2014 WHERE subject = \"CSCI\" AND campus = \"MAI\";";
        // This text should reflect the results of the query
        final String DESCRIPTION = "Here are all the Computer Science (CSCI) courses that meet on Main campus: ";
        
        // results is a new table of whatever the SQL QUERY returned
        ResultSet results = st.executeQuery(QUERY);
        // metadata describes how the results are organized
        ResultSetMetaData metadata = results.getMetaData();
        // This metatdata is used to fetch the column count of the results table,
        //  neccessary for printing the results later
        int numColumns = metadata.getColumnCount();
        
        // Print description of query results before printing the results themselves
        System.out.println(DESCRIPTION);
        
        // These two loops control printing of the query results
        // While loop iterates by row of results
        while (results.next()){
            // For loop iterates by column of reults
            for(int i = 1; i <= numColumns; i++){
                System.out.print(results.getString(i) + " ");
            } // End for
            // Insert newline for every row iteration
            System.out.println();
        } // End while
        // Extra padding for any text that comes after this method call
        System.out.println();
    } // End method
    
    public static void main(String[] args) throws Exception{
        
        // Credentials needed to log onto remote server
        final String SERVER_IP = "68.178.217.12";
        final String DATABASE = "CWHDemo";
        final String USERNAME = "CWHDemo";
        final String PASSWORD = "Access2017!";
        
        // Crendetials are used to establish a connection
        Connection conn = DriverManager.getConnection("jdbc:mysql://" + SERVER_IP + "/" + DATABASE, USERNAME, PASSWORD);
        // The statement object will drive any queries to the database
        Statement st = conn.createStatement();
        
        // Program introduction
        System.out.println("Program will query a database and print its contents to a CSV (Comma Separated Values) file, ");
        System.out.println("then query the database a second time with a custom query and print those reults to the console. ");
        // Extra padding for any text that comes after this description
        System.out.println();
        // Database queries:
        pullAlltoCSV(st);
        customQuery(st);
        
        conn.close();
    } // End method
} // End class