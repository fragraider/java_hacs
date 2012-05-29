/** @file */

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Database.QueryExchange;
import java.sql.SQLException;


/**
 * @Brief Class for prepairing the frames from the serial interface. 
 * 
 * This class was made as a proof of concept for the group to show how an interface from the serial to the database package was probably going to look. I made one method which I didnt really get a chance to test because no frame ever made it from the hardware. 
 * 
 */
public class SerialParser {
    
    public String committRFID(String serialData) throws SQLException{
        QueryExchange affirmEx = new QueryExchange();
        String affirmRFID = affirmEx.affirmRFID(serialData).toString();
        return affirmRFID;
    }
    
    
}


