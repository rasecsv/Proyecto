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
        sSQL = "INSERT into bdproyectomate.persona(nombre,apellido,dni,ruc,cargo) VALUES (?,?,?,?,?)";
      //  sSQL2 = "SELECT * FROM bdproyectomate.area";
        try{
            PreparedStatement pst = cn.prepareStatement(sSQL);
          // PreparedStatement pst2 = cn.prepareStatement(sSQL2);
            Area area = new Area();
            int cont=0;
            pst.setString(1, persona.getNombre());
            pst.setString(7, persona.getApellidos());
            pst.setInt(2, persona.getDNI());
            pst.setString(3, persona.getRuc());
            pst.setString(5, persona.getCargo());
            
            if((persona.getCargo()).equals("Administrador")){
                pst.setBoolean(6, true);
            }else{
                pst.setBoolean(6, false);
            }
            
          pst.setInt(4, persona.getIdArea());
            int n = pst.executeUpdate();
            
            if (n == 0) {
                return false;
            }
          
        }catch(Exception e){
            JOptionPane.showConfirmDialog(null, e);
          return false;
        }
         return false;
    }
}
