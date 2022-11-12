/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capalogica;
import java.util.Date;
/**
 *
 * @author alexd
 */
public class todoDAO {
    private int id;

    
    private String Nombres ;
    private String Apellidos;
    private int empleado;
    private int departamento;
    private String tarea;
    private String fecha_inicio;
    private String fecha_fin;
    private int prioridad;
    private String nombre_departamento;
    private String prioridades;
        public void setId(int id) {
            this.id = id;
        }

        public int getId() {
            return id;
        }
        public String getNombres() {
            return Nombres;
        }

        public void setNombres(String Nombres) {
            this.Nombres = Nombres;
        }

        public String getApellidos() {
            return Apellidos;
        }

        public void setApellidos(String Apellidos) {
            this.Apellidos = Apellidos;
        }

        public int getEmpleado() {
            return empleado;
        }

        public void setEmpleado(int empleado) {
            this.empleado = empleado;
        }

        public int getDepartamento() {
            return departamento;
        }

        public void setDepartamento(int departamento) {
            this.departamento = departamento;
        }

        public String getTarea() {
            return tarea;
        }

        public void setTarea(String tarea) {
            this.tarea = tarea;
        }

        public String getFecha_inicio() {
            return fecha_inicio;
        }

        public void setFecha_inicio(String fecha_inicio) {
            this.fecha_inicio = fecha_inicio;
        }

        public String getFecha_fin() {
            return fecha_fin;
        }

        public void setFecha_fin(String fecha_fin) {
            this.fecha_fin = fecha_fin;
        }

        public int getPrioridad() {
            return prioridad;
        }

        public void setPrioridad(int prioridad) {
            this.prioridad = prioridad;
        }

        public String getNombre_departamento() {
            return nombre_departamento;
        }

        public void setNombre_departamento(String nombre_departamento) {
            this.nombre_departamento = nombre_departamento;
        }

        public String getPrioridades() {
            return prioridades;
        }

        public void setPrioridades(String prioridades) {
            this.prioridades = prioridades;
        }
}
