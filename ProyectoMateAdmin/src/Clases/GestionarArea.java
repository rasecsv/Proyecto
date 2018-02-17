/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import BaseDatos.ConectorBD;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
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
     
        
        sSQL ="insert into bdproyectomate.area(id,nombre,HoraEntrada,HoraSalida) values (?,?,?,?)";
        try{
            PreparedStatement pst = cn.prepareStatement(sSQL);
            
            pst.setString(1,area.getNombre());
            pst.setDate(2, (Date) area.getHoraIn());
            pst.setDate(3, (Date) area.getHoraOut());
            
             int n = pst.executeUpdate();
            
            if (n != 0) {              
                    return true;            
            } else {
                return false;
            }
            
        }catch(Exception e){
              JOptionPane.showConfirmDialog(null, e);
            return false;
        }
       
    }
    
}
