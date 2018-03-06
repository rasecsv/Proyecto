/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import BaseDatos.ConectorBD;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HOLA
 */
public class AgregarPersonal {
    
     ConectorBD mysql = new ConectorBD();
     Connection cn= mysql.Conectar();
     private String sSQL ="";
     private String sSQL2 ="";
       PreparedStatement pst=null;
       ResultSet rs =null;
    Personal persona = new Personal();
    
    public boolean registrar(Personal persona){
        sSQL = "INSERT into bdproyectomate.personal(Nombre,DNI,RUC,Area_idArea,Cargo,ADMIN_idAdmin,apellidos) VALUES (?,?,?,?,?,?,?)";
        try{
            pst = cn.prepareStatement(sSQL);
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
            }else{
                return true;
            }
          
        }catch(Exception e){
            JOptionPane.showConfirmDialog(null, e);
          return false;
        }
         
    }
     public int ID(Integer dni){
       
   int id=0;
         System.out.println(dni);
    sSQL="SELECT * FROM bdproyectomate.personal where DNI= "+dni ;
        try {
            pst =cn.prepareStatement(sSQL);
           // pst.setInt(2,dni);
            System.out.println("de nuevo :b"+dni);
            rs =pst.executeQuery();
            while(rs.next()){
                if(rs != null){
                   id =rs.getInt("idPersonal");
                    System.out.println(id);
                     }
                if(rs == null){
                    JOptionPane.showMessageDialog(null,"El nombre  ingresada no existe");
                    }
                
//                pst.close();
            }    
  
         } catch (SQLException | HeadlessException e) {
             System.out.println(e);
         }
      //  System.out.println(id);
       return id;     
   }

    public boolean eliminar(Personal persona) throws Exception {
        boolean rpta = false;
        
        try {
            if(persona!=null){
                  sSQL="delete from bdproyectomate.personal where idPersonal= ?";
                  pst = cn.prepareStatement(sSQL);
//                 pst.setInt(1, persona.getIdPersona());
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
    
     public boolean actualizar(Integer dni,Personal persona){
        
          System.out.println("entre o no entre");
        
         sSQL = "update  bdproyectomate.personal set RUC =?, Cargo= ?, Area_idArea= ?"+" where DNI= ?"+dni;
         System.out.println("pase");
         try {
             System.out.println("aqui tbmn");
             pst = cn.prepareStatement(sSQL);
             System.out.println("conecto");
             try {
                 pst.setString(4,persona.getRuc());
                 
                 
             } catch (Exception e) {
             }
             
            // pst.setInt(1 ,val);
             //pst.executeUpdate();
               
    
         }catch(Exception e){
             
         }
         return true;
     }
  public void updateSalida(Integer dni,Personal persona) {
        int id=ID(dni);
        String UPDATE = "UPDATE personal SET Nombre= ?,apellidos=?,RUC=?,DNI=?,Area_idArea=?, Cargo=? WHERE idPersonal=?";
        
        try {
           pst = cn.prepareStatement(UPDATE);
            pst.setString(1, persona.getNombre());
            pst.setString(2, persona.getApellidos());
            pst.setString(3, persona.getRuc());
            pst.setInt(4, persona.getDni());
            pst.setInt(5, persona.getIdArea());
            pst.setBoolean(6, persona.isCargo());
            pst.setInt(7, id);
            pst.executeUpdate();
            pst.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
