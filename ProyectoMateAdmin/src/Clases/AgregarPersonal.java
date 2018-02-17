/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import BaseDatos.ConectorBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

/**
 *
 * @author HOLA
 */
public class AgregarPersonal {
    
     ConectorBD mysql = new ConectorBD();
     Connection cn= mysql.Conectar();
     private String sSQL ="";
     private String sSQL2 ="";
     
           
    public boolean registrar(Personal persona){
        sSQL = "insert into bdproyectomate.persona(nombre,apellido,dni,ruc,cargo)"+ "values(?,?,?,?,?)";
        sSQL2 = "insert into bdproyectomate.area(idPersona,nombre)";
        try{
            PreparedStatement pst = cn.prepareStatement(sSQL);
            PreparedStatement pst2 = cn.prepareStatement(sSQL2);
            
            pst.setString(1, persona.getNombre());
            pst.setString(2, persona.getApellidos());
            pst.setInt(3, persona.getDNI());
            pst.setString(4, persona.getRuc());
            pst.setString(5, persona.getCargo());
            
              int n = pst.executeUpdate();
            
            if (n != 0) {
                int n2 = pst2.executeUpdate();
                if (n2 != 0) {
                 return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
          
        }catch(Exception e){
            JOptionPane.showConfirmDialog(null, e);
          return false;
        }
    }
}
