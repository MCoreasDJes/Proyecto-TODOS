/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capadatos;
import capalogica.todoDAO;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
/**
 *
 * @author alexd
 */
public class Datos {
    Connection conexion;
    Statement ejecutaConsultas;
    ResultSet resultado;
    Conexion objConexion; 
    
    public ResultSet ejecutarSelect(String consultaSQL){
        resultado = null;

        try{
            objConexion = new Conexion();
            conexion = objConexion.getConexion();
            
            //se encarga de encapsular la conexion y la sentencia
            ejecutaConsultas = conexion.createStatement();
            
            resultado = ejecutaConsultas.executeQuery(consultaSQL);
            
            System.out.println("SE EJECUTO LA SENTENCIA SELECT");
        }
        catch(Exception e) {
            System.out.println("SE EJECUTO LA SENTENCIA SELECT: " + e.getMessage());   
        }
        
        //Retornamos el resulset
        return resultado;
    }
    
    
    public void ejecutaInsert(todoDAO todoDao) {
        
        try {
            objConexion = new Conexion();
            conexion = objConexion.getConexion();
            
            CallableStatement ejecutarProcInsertar=conexion.prepareCall("{call sp_Insertar(?,?,?,?,?,?)}");
            ejecutarProcInsertar.setInt(1, todoDao.getEmpleado());
            ejecutarProcInsertar.setInt(2, todoDao.getDepartamento());
            ejecutarProcInsertar.setString(3, todoDao.getTarea());
            ejecutarProcInsertar.setString(4, todoDao.getFecha_inicio());
            ejecutarProcInsertar.setString(5, todoDao.getFecha_fin());
            ejecutarProcInsertar.setInt(6, todoDao.getPrioridad());
            ejecutarProcInsertar.execute();
            System.out.println("SE EJECUTO LA SENTENCIA DE ACCION");
        } catch (Exception e) {
            System.out.println("NO SE EJECUTO LA SENTENCIA DE ACCION: " + e.getMessage());
        }
    }
    
    public void ejecutaDML(String consultaSql) {
        try {
            objConexion = new Conexion();
            conexion = objConexion.getConexion();
            
            ejecutaConsultas = conexion.createStatement();
            
            ejecutaConsultas.execute(consultaSql);
            System.out.println("SE EJECUTO LA SENTENCIA DE ACCION");
        } catch (Exception e) {
            System.out.println("NO SE EJECUTO LA SENTENCIA DE ACCION: " + e.getMessage());
        }
    }
    public void ejecutaEditar(todoDAO obj) {
        
        try {
            objConexion = new Conexion();
            conexion = objConexion.getConexion();
            
            CallableStatement ejecutarProcEditar=conexion.prepareCall("{call sp_Editar(?,?,?,?,?,?,?)}");
            
            ejecutarProcEditar.setInt(1, obj.getId());
            ejecutarProcEditar.setInt(2, obj.getEmpleado());
            ejecutarProcEditar.setInt(3, obj.getDepartamento());
            ejecutarProcEditar.setString(4, obj.getTarea());
            ejecutarProcEditar.setString(5, obj.getFecha_inicio());
            ejecutarProcEditar.setString(6, obj.getFecha_fin());
            ejecutarProcEditar.setInt(7, obj.getPrioridad());
            ejecutarProcEditar.execute();
            System.out.println("SE EJECUTO LA SENTENCIA DE ACCION EDITAR");
        } catch (Exception e) {
            System.out.println("NO SE EJECUTO LA SENTENCIA DE ACCION EDITAR: " + e.getMessage());
        }
    }
}
