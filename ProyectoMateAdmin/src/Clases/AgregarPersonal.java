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
import java.sql.Statement;
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
//metodo para registrar el personal     
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
    //funcion de busqueda del ID del personal mediante el ingreso del DNI
     public int ID(Integer dni){
       
   int id=0;
    //      System.out.println(dni);
   //query de busqueda por dni
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

     //metodo para eliminar  el personal se pasan el parametro de busqueda dni y el constructor en la clase personal
    public boolean eliminar(Integer dni,Personal persona) throws Exception {
       int id= ID(dni); 
       //se realiza asigna el valor  obtenido de la funcion ID 
        boolean rpta = false;
        
        try {
            if(persona!=null){
                  sSQL="delete from bdproyectomate.personal where idPersonal= "+id;
                  Statement st = cn.createStatement();
//                 pst.setInt(1, persona.getIdPersona());
                 int confirmar = st.executeUpdate(sSQL);
                 if(confirmar==1){
                          rpta=true;
                 }else{
                     JOptionPane.showMessageDialog(null,"No se pudo eliminar el personal correctamente");
                 }
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
    
   //funcion para actualizar el personal  
  public boolean updateSalida(Integer dni,Personal persona) {
        int id=ID(dni);
        //System.out.println("hola :" +dni);
        boolean val=false;
        //script para realizar el envio de los datos  aun no se por que no ejecutaba antes pero ahora si lo hace :v
        String UPDATE = "UPDATE bdproyectomate.personal SET Nombre= ?,DNI= ? , RUC=?  , Area_idArea=?, Cargo=? ,ADMIN_idAdmin=? ,apellidos=?" + " WHERE idPersonal= " +id+ "";
       // String UPDATE ="UPDATE bdproyectomate.personal  set Area_idArea=a.idArea from bdproyectomate.personal p JOIN bdproyectomate.area a where Area_idArea=? AND idPersonal= "+id+"";
      //    UPDATE producto SET id_categoria = cat.id_categoria  FROM  producto prod JOIN categrias cat ON   cat.clave_marca = prod.clave_marca
        try {
           // System.out.println("hola que hace");
           pst = cn.prepareStatement(UPDATE);
          
            pst.setString(1, persona.getNombre());
           // System.out.println(persona.getNombre());
            pst.setInt(2, persona.getDni());
          //  System.out.println(persona.getDni());
            pst.setString(3, persona.getRuc());
          //  System.out.println(persona.getRuc());            
            pst.setInt(4, persona.getIdArea());
         //   System.out.println(persona.getIdArea());
            pst.setInt(6, persona.getPermisosAdmin());
        //    System.out.println(persona.getPermisosAdmin());
            pst.setBoolean(5, persona.isCargo());
        //    System.out.println(persona.isCargo());
            pst.setString(7, persona.getApellidos());
        //    System.out.println(persona.getApellidos());
           // pst.setInt(0, id);
        //    System.out.println("llegue aqui :v");
            pst.executeUpdate();
        //    System.out.println("pase :(");
            return true;
           // pst.close();
            
        } catch (SQLException | HeadlessException e) {
            System.out.println(e);
               //JOptionPane.showConfirmDialog(null, e);
          //  System.out.println("pos no entre ");
            return false;
        }
 
    }

}
