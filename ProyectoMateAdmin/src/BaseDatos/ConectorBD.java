package BaseDatos;
import java.sql.*;
import javax.swing.JOptionPane;

public class ConectorBD {
 public String bd="bdproyectomate";
 public String url="jdbc:mysql://localhost:3306/"+bd;
 public String user="root";
 public String pass="";
 public ConectorBD(){
     
 }
 public Connection Conectar(){
     Connection link=null;
     try {
       Class.forName("com.mysql.jdbc.Driver");
       link =DriverManager.getConnection(this.url, this.user,this. pass);
     } catch (Exception e) {
         JOptionPane.showMessageDialog(null,e);
     }
     return link;
 }
 
 
}