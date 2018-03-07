/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseDatos;

import Clases.Area;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author HOLA
 */
public class Estados {
    private int id;
    private String nombre;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String toString(){
        return this.nombre;
    }
    //metodo para llenar el combo boc jalando los datos  registrados en la tabla area
    public Vector<Estados> mostrarEstados(){
         Area area =new Area();
       String nombre= null;
       int i=0;
       ConectorBD mysql = new ConectorBD();
         Connection cn= mysql.Conectar(); 
           Vector<Estados> datos = new Vector <Estados>();
          Estados dat = null;
        try {
            String sql="SELECT * FROM bdproyectomate.area where idArea ";
            PreparedStatement ver = cn.prepareStatement(sql);
            ResultSet seleccionar= ver.executeQuery();
            dat = new Estados();
            //se coloca la primera oopcion
            dat.setId(0);
            dat.setNombre("Seleccione una opcion");
            datos.add(dat);
            while(seleccionar.next()){
                dat = new Estados();
                //se coloca la primera oopcion
                dat.setId(seleccionar.getInt("idArea"));
                dat.setNombre(seleccionar.getString("nombre"));
                datos.add(dat);
              
             
            }
           
           seleccionar.close();
            
        } catch (SQLException e) {
            System.err.println(e.toString());
        }
        return datos;
    }
}
