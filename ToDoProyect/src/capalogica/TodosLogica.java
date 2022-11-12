/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capalogica;

import capadatos.Datos;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class TodosLogica {
    
    //retornara un listado de 
    public ArrayList<EmpleadosDAO> getEmpleados(){
        
        ArrayList<EmpleadosDAO> lstEmpleados = new ArrayList<EmpleadosDAO>();
        
        try {
            String consultaSQL = "SELECT * FROM empleados";
            Datos datos = new Datos();
            ResultSet resultado = datos.ejecutarSelect(consultaSQL);
            
            //Resulset -1 0
            while(resultado.next()){
                //se crea un objeto por cada ejecucion del bucle
                EmpleadosDAO objUsuariosDao = new EmpleadosDAO();
                
                objUsuariosDao.setId(resultado.getInt("id"));
                objUsuariosDao.setNombres(resultado.getString("Nombres"));
                objUsuariosDao.setApellidos(resultado.getString("Apellidos"));
                
                //Se almacenan todos los objetos creados gracias al lazo while
                lstEmpleados.add(objUsuariosDao);
            }
            
        } catch (Exception e) {
            System.out.println("NO SE LLENO EL LISTADO DE EMPLEADOS");
        }   
        
        return lstEmpleados;
    } 
    
    public ArrayList<DepartamentosDAO> getDepartamentos(){
        
        ArrayList<DepartamentosDAO> lstDep = new ArrayList<DepartamentosDAO>();
        
        try {
            String consultaSQL = "SELECT * FROM departamentos";
            Datos datos = new Datos();
            ResultSet resultado = datos.ejecutarSelect(consultaSQL);
            
            while(resultado.next()){
                //se crea un objeto por cada ejecucion del bucle
                DepartamentosDAO objDep = new DepartamentosDAO();
                
                objDep.setId(resultado.getInt("id"));
                objDep.setNombre(resultado.getString("Nombre"));
                
                //Se almacenan todos los objetos creados gracias al lazo while
                lstDep.add(objDep);
            }
            
        } catch (Exception e) {
            System.out.println("NO SE LLENO EL LISTADO DE Departamentos");
        }   
        
        return lstDep;
    } 
    
    
    public void LLenarData(todoDAO tdo){
        Datos dto = new Datos();
        dto.ejecutaInsert(tdo);
                
    }
    
    public void PrepararDataEdit(todoDAO tdo){
        Datos dto = new Datos();
        dto.ejecutaEditar(tdo);
                
    }
    
    public ArrayList<todoDAO> getTodoList(){
        
        ArrayList<todoDAO> lstTodo = new ArrayList<todoDAO>();
        
        try {
            String consultaSQL = "SELECT * FROM vistatodo ORDER BY TODOINDEX DESC";
            Datos datos = new Datos();
            ResultSet resultado = datos.ejecutarSelect(consultaSQL);
            
            while(resultado.next()){
                //se crea un objeto por cada ejecucion del bucle
                todoDAO obj = new todoDAO();
                
                obj.setId(resultado.getInt("TODOINDEX"));
                obj.setNombres(resultado.getString("Nombres"));
                obj.setApellidos(resultado.getString("Apellidos"));
                obj.setNombre_departamento(resultado.getString("Nombre"));
                obj.setTarea(resultado.getString("tarea"));

                obj.setFecha_inicio(resultado.getString("fecha_inicio"));
                obj.setFecha_fin(resultado.getString("fecha_fin"));
                obj.setPrioridad(resultado.getInt("prioridad"));
                obj.setDepartamento(resultado.getInt("depIndex"));
                //Se almacenan todos los objetos creados gracias al lazo while
                lstTodo.add(obj);
            }
            
        } catch (Exception e) {
            System.out.println("NO SE LLENO EL LISTADO DE USUARIOS");
        }   
        
        return lstTodo;
    }
    
    public String EliminarToDo(int id){
        String mensaje="";
        try{
            String consultaSQL = "DELETE  FROM todos WHERE id='"+id+"'";
            Datos dt = new Datos();
            dt.ejecutaDML(consultaSQL);
            
                mensaje= "Registro eliminado";
        }catch(Exception e){System.out.println("Fallo");}
        
        return  mensaje;
    }
    
    
    public String PrioridadesBajas (){
        String Cant="0";
        try{
            String consultaSQL = "SELECT COUNT(empleado) AS BAJA FROM todos WHERE prioridad=1";
            Datos dto = new Datos();
            
            ResultSet rs = dto.ejecutarSelect(consultaSQL);
            //-1
            if (rs.next()) {
                Cant = rs.getString("BAJA");
            }
        }catch (Exception e){System.out.println("Fallo");}
        
        return Cant;
    }
    
    public String PrioridadIntermedia(){
        String Cant="0";
        try{
            String consultaSQL = "SELECT COUNT(empleado) AS INTER FROM todos WHERE prioridad=2";
            Datos dto = new Datos();
            
            ResultSet rs = dto.ejecutarSelect(consultaSQL);
            if (rs.next()) {
                Cant = rs.getString("INTER");
            }
        }catch (Exception e){System.out.println("Fallo");}
        
        return Cant;
    }
    
    public String PrioridadAlta(){
        String Cant="0";
        try{
            String consultaSQL = "SELECT COUNT(empleado) AS ALTA FROM todos WHERE prioridad=3";
            Datos dto = new Datos();
            
            ResultSet rs = dto.ejecutarSelect(consultaSQL);
            if (rs.next()) {
                Cant = rs.getString("ALTA");
            }
        }catch (Exception e){System.out.println("Fallo");}
        
        return Cant;
    }
}
