/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capadatos;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Admin
 */
public class Conexion {
    
    Connection conexion;
    
    public Conexion(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/todos","root","");
            System.out.println("SE CONECTO A LA BASE DE DATOS");
        } catch (Exception e) {
            System.out.println("NO SE CONECTO A LA BASE DE DATOS: " + e.getMessage());
        }
    }
    
    public Connection getConexion(){
        return conexion;
    }
    
}
