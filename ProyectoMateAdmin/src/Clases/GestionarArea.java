/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import BaseDatos.ConectorBD;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
    public boolean registar(Area area){
     
        
        sSQL ="INSERT into bdproyectomate.area(Nombre,HoraEntrada,HoraSalida) VALUES (?,?,?)";
        try{
            //prepara la  conexion con la BD
            PreparedStatement pst = cn.prepareStatement(sSQL);
            
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
                System.err.println(e);
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
    
}
