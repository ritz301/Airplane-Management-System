/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ams;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author ritz619
 */
public class AMS {
    private static Connection con;
    static void createCon(){
        try{
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/AMS","root","");
        }catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        createCon();
        Login lg = new Login();
        lg.lg = lg;
        lg.con = con;
        lg.setVisible(true);
    }
    
}
