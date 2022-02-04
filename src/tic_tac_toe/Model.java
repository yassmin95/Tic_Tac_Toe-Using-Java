/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tic_tac_toe;

import java.sql.*;


/**
 *
 * @author Abdallah
 */
public class Model {
    public static Connection connection_to_database;
    public static Statement the_statement;
    public static ResultSet the_entire_table;


    public static int connect() throws ClassNotFoundException{
    try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection_to_database = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/user_base","abdallah","root");   
        the_statement = connection_to_database.createStatement();
        return 1; 
    }catch(SQLException e){
        System.out.println(e);
        return 0;
    }
    }

    public static void exit() throws SQLException{
        connection_to_database.close();
    }

public static void print_all_names() throws ClassNotFoundException, SQLException{
        Model.connect();
        the_entire_table = the_statement.executeQuery("SELECT * FROM users");
        while(the_entire_table.next()){
            System.out.println(the_entire_table.getString(1));
        }
        Model.exit();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // TODO code application logic here
        print_all_names();
    }
    
}
