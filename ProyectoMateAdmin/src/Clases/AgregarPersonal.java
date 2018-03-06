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
     PreparedStatement pst=null;
     private String sSQL ="";
     private String sSQL2 ="";
     
           
    public boolean registrar(Personal persona){
        sSQL = "INSERT into bdproyectomate.personal(Nombre,DNI,RUC,Area_idArea,Cargo,ADMIN_idAdmin,apellidos) VALUES (?,?,?,?,?,?,?)";
   //    sSQL2 = "SELECT * FROM bdproyectomate.area";
        try{
            pst = cn.prepareStatement(sSQL);
            // PreparedStatement pst2 = cn.prepareStatement(sSQL2);
            Area area = new Area();
            int cont=0;
            pst.setString(1, persona.getNombre());
            pst.setString(7, persona.getApellidos());
            pst.setInt(2, persona.getDni());
            pst.setString(3, persona.getRuc());
            pst.setInt(6, persona.getPermisosAdmin());
          pst.setBoolean(5, persona.isCargo());
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
    public boolean eliminar(Personal persona) throws Exception {
        boolean rpta = false;
        
        try {
            if(persona!=null){
                  sSQL="delete from bdproyectomate.personal where idPersonal=?;";
                  pst = cn.prepareStatement(sSQL);
                 pst.setInt(1, persona.getIdPersona());
                 rpta =pst.executeUpdate()== 1;
            }
           
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try {
                pst.close();
                cn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
           
        return rpta;
        
    }
    
    
}
