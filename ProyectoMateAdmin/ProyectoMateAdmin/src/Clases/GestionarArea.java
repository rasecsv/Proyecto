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

/**
 *
 * @author HOLA
 */
public class GestionarArea {
       ConectorBD mysql = new ConectorBD();
        Connection cn= mysql.Conectar();
        private  String sSQL ="";
         PreparedStatement pst=null;
          ResultSet rs =null;
    public boolean registar(Area area){
     
        
        sSQL ="INSERT into bdproyectomate.area(Nombre,HoraEntrada,HoraSalida) VALUES (?,?,?)";
        try{
            //prepara la  conexion con la BD
             pst = cn.prepareStatement(sSQL);
            
            DateFormat dt = new SimpleDateFormat("hh:mm:ss");
            java.util.Date fecha =null;
            java.util.Date fecha2 =null;
            java.sql.Time ins1=null;
            java.sql.Time ins2 =null;
            pst.setString(1,area.getNombre());
            //Parseamos la cadena para convertirlo en formato time hora:minuto:segundo
            try {
                fecha = dt.parse(area.getHoraIn());
               // ins1 = new java.sql.Date(fecha.getTime());
                ins1=new java.sql.Time(fecha.getTime());
                pst.setTime(2,ins1);               
            } catch (ParseException | SQLException e) {
                JOptionPane.showMessageDialog(null,"Ingrese una hora correcta");
            }
            try {
                fecha2 =dt.parse(area.getHoraOut());
                ins2 = new java.sql.Time(fecha2.getTime());
                pst.setTime(3,ins2);

            } catch (ParseException | SQLException e) {
                 JOptionPane.showMessageDialog(null,"Ingrese una hora correcta");
            }
            
            //falta validar la entrada de hora incorrecta
          //  pst.setDate(2, (Date) area.getHoraIn());
          //  pst.setDate(3, (Date) area.getHoraOut());
            
             int n = pst.executeUpdate();
            
            return n != 0;
            
        }catch(SQLException | HeadlessException e){
              JOptionPane.showConfirmDialog(null, e);
            return false;
        }
       
    }
     public  boolean buscar(String nombre){
         boolean dat=false;
         String data = null;
        String hout=null,hin=null;
        String sSQL="SELECT * FROM bdproyectomate.area where Nombre= ?" ;
        try {
            pst =cn.prepareStatement(sSQL);
            pst.setString(1, nombre);
            rs =pst.executeQuery();
            while(rs.next()){
                if(rs != null){
                    dat=true;
//              data = rs.getString("Nombre");
//                hin= rs.getString("HoraEntrada");
//                hout=rs.getString("HoraSalida");
////               
                      }
                if(rs == null){
//                    JOptionPane.showMessageDialog(null,"EL area buscada no existe ");
                     dat=false;
               
                    }
                pst.close();
            }    
  
         } catch (SQLException | HeadlessException e) {
             System.out.println(e);
         }
           return dat;
        }
   public void asignar(String nombre){
       
       String nomb;
       String hin;
       String hout;
       boolean a =buscar(nombre);
       try {
           if(a == true){
               nomb= rs.getString("Nombre");
               hin=rs.getString("HoraEntrada");
               hout=rs.getString("HoraSalida");
           }else{
               System.out.println("no se pudo");
           }
       } catch (Exception e) {
       }
       
   }
   public int ID(String nombre){
       
   int id=0;
    sSQL="SELECT * FROM bdproyectomate.area where Nombre= ?" ;
        try {
            pst =cn.prepareStatement(sSQL);
            pst.setString(1, nombre);
            rs =pst.executeQuery();
            while(rs.next()){
                if(rs != null){
                   id =rs.getInt("idArea");
                    System.out.println(id);
                     }
                if(rs == null){
                    JOptionPane.showMessageDialog(null,"El area ingresada no existe");
                    }
                
//                pst.close();
            }    
  
         } catch (SQLException | HeadlessException e) {
             System.out.println(e);
         }
      //  System.out.println(id);
       return id;     
   }
    public boolean eliminar(String nombre){
        boolean rpta=false;
        //String nombre;
        int cont =ID(nombre);
       sSQL="Delete FROM bdproyectomate.area where idArea= "+cont;
        
       // Area dependencia = new Area ();
    try {
        Statement pst =cn.createStatement();
       // pst = cn.createStatement(sSQL);
        
            //pst.setInt(1,cont);
            int confirmar= pst.executeUpdate(sSQL);
            if(confirmar ==1){
               // System.out.println("se elimino con exito");
                rpta=true;
            }else{
                System.out.println("no se pudo eliminar");
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


    public boolean actualizar(String nombre,Area area){
       
        int val= ID(nombre);
         System.out.println(nombre);
       // System.out.println(val);
          System.out.println("entre o no entre");
        
         sSQL = "update  bdproyectomate.area set  Nombre= ?, HoraEntrada= ?, HoraSalida= ?"+" where idArea = "+val+"";
         System.out.println("pase");
         try {
             System.out.println("aqui tbmn");
             pst = cn.prepareStatement(sSQL);
             System.out.println("conecto");
             System.out.println("hola aqui toy");
            DateFormat dt = new SimpleDateFormat("hh:mm:ss");
            java.util.Date fecha =null;
            java.util.Date fecha2 =null;
            java.sql.Time ins1=null;
            java.sql.Time ins2 =null;
        
               try {
         //          System.out.println(nombre);
                   
                 pst.setString(1,area.getNombre());   
                fecha = dt.parse(area.getHoraIn());
               // ins1 = new java.sql.Date(fecha.getTime());
                ins1=new java.sql.Time(fecha.getTime());
                pst.setTime(2,ins1);  
                
            } catch (ParseException | SQLException e) {
                JOptionPane.showMessageDialog(null,"Ingrese una hora correcta");
            }
            try {
                fecha2 =dt.parse(area.getHoraOut());
                ins2 = new java.sql.Time(fecha2.getTime());
                pst.setTime(3,ins2);

            } catch (ParseException | SQLException e) {
                 JOptionPane.showMessageDialog(null,"Ingrese una hora correcta");
            }
           
              pst.executeUpdate();
             return true;
        } catch (SQLException | HeadlessException e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }       
    
    
    } 
}
