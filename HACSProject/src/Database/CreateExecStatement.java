/** @file */

/*
 * To change this template, choose Tools  Templates
 * and open the template in the editor.
 */


package Database;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Eirikur Emilsson. Adapted from examples. 
 */
public class CreateExecStatement{
 
     
    private Connection connection = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    private ResultSetMetaData metaData = null;
    
    public CreateExecStatement(){
        
    }
    /**
     * @Brief Sends a String to the database. 
     * 
     * This method begins by instantiating a connection and opening up a connection from the DerbyConnectionFactory. 
     * Then it takes an SQL String and sends it on to the database after. It returns a ResultSet. 
     * 
     * @param cmdString
     * @return
     * @throws SQLException 
     */
    public ResultSet queryExecution(String cmdString) throws SQLException    //getConfig //getConfigAll()
        {
        connection = DerbyConnectionFactory.createConnection();
        
        preparedStatement = connection.prepareStatement(cmdString);   //Formerly "SELECT * FROM  \"HACSDB\"" instead of cmdString
        //int 1stint = 5;     //For debugging only. 
        resultSet = preparedStatement.executeQuery();
        //int 2ndint = 6;    //For debugging only. 
        metaData = resultSet.getMetaData(); 

          /*   //For debugging only
            int numberOfColumns = metaData.getColumnCount();
            for (int i = 1; i <= numberOfColumns; i++) {
                System.out.printf("%-40s\t", metaData.getColumnName(i));
            }
            System.out.println();

            while (resultSet.next()) {
                for (int i = 1; i <= numberOfColumns; i++) {
                    System.out.printf("%-40s\t", resultSet.getObject(i));
                }
                System.out.println();   //Linebreak. 
            }
*/
        return resultSet;
        } 
   
    /*
     *@Brief Sends an non query SQL command to Database. 
     * 
     * This method was necessary because the queryExecution didn't want to run SQL strings that weren't a query. This was our way of getting around that. 
     */
    public void updateExecution(String cmdString) throws SQLException   //newUser //newConfig 
        {
        connection = DerbyConnectionFactory.createConnection();
        preparedStatement = connection.prepareStatement(cmdString); 
        preparedStatement.executeUpdate();
        
        
        } 
        
}