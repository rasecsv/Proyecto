package GUI;

import BaseDatos.ConectorBD;
import BaseDatos.Estados;
import Clases.AgregarPersonal;
import Clases.Area;
import Clases.LimitadorCaracteres;
import Clases.Personal;
import java.awt.event.ItemEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

public class Agregar extends javax.swing.JFrame {
    private final String accion = "guardar";
    private DefaultComboBoxModel modelocombo;
    Area area = new Area();
    ConectorBD mysql = new ConectorBD();
    Connection cn= mysql.Conectar(); 
 
    Personal persona = new Personal();
    AgregarPersonal agregar = new AgregarPersonal();  
    public Agregar() {
        modelocombo = new DefaultComboBoxModel(new String[]{});
        initComponents();
         txtDNI.setDocument(new LimitadorCaracteres(txtDNI,8));
         txtRUC.setDocument(new LimitadorCaracteres(txtRUC,11));
      //  seleccionar();
        //llenarCombo();
        Estados cc = new Estados();
        DefaultComboBoxModel modeloEstad = new DefaultComboBoxModel( cc.mostrarEstados());
        CombArea.setModel(modeloEstad);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        txtDNI = new javax.swing.JTextField();
        txtRUC = new javax.swing.JTextField();
        txtCargo = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        CombArea = new javax.swing.JComboBox();
        btnEliminar = new javax.swing.JButton();
        txtBuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        txtArea = new javax.swing.JTextField();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Nombre");

        jLabel2.setText("Apellido");

        jLabel3.setText("DNI");

        jLabel4.setText("RUC");

        jLabel5.setText("Cargo");

        jLabel6.setText("Area");

        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });

        txtApellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellidoActionPerformed(evt);
            }
        });

        txtDNI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDNIActionPerformed(evt);
            }
        });

        txtRUC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRUCActionPerformed(evt);
            }
        });

        txtCargo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCargoActionPerformed(evt);
            }
        });

        btnAgregar.setText("Guardar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        CombArea.setModel(modelocombo);
        CombArea.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CombAreaItemStateChanged(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        txtBuscar.setText("jTextField1");

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        txtArea.setText("jTextField2");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(btnEliminar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAgregar)
                .addGap(87, 87, 87))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                        .addComponent(btnBuscar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtRUC, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                                .addComponent(txtCargo)
                                .addComponent(txtApellido)
                                .addComponent(txtNombre)
                                .addComponent(txtDNI)
                                .addComponent(CombArea, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2))
                    .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtRUC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(CombArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnAgregar)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnEliminar)
                        .addGap(22, 22, 22))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
        txtNombre.requestFocus();
    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidoActionPerformed
        // TODO add your handling code here:
        txtApellido.requestFocus();
    }//GEN-LAST:event_txtApellidoActionPerformed

    private void txtDNIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDNIActionPerformed
        // TODO add your handling code here:
        
               txtDNI.requestFocus();
    }//GEN-LAST:event_txtDNIActionPerformed

    private void txtRUCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRUCActionPerformed
        // TODO add your handling code here:
        txtRUC.requestFocus();
    }//GEN-LAST:event_txtRUCActionPerformed

    private void txtCargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCargoActionPerformed
        // TODO add your handling code here:
        txtCargo.requestFocus();
    }//GEN-LAST:event_txtCargoActionPerformed
    
    
    
    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        // TODO add your handling code here:
               String sql="SELECT * FROM bdproyectomate.area";
         
        try {
            PreparedStatement verArea = cn.prepareStatement(sql);
            ResultSet ver = verArea.executeQuery();
           
        } catch (SQLException ex) {
            Logger.getLogger(Agregar.class.getName()).log(Level.SEVERE, null, ex);
        }
           
        
       
 
        persona.setNombre(txtNombre.getText());
        persona.setApellidos(txtApellido.getText());
        persona.setDni(Integer.parseInt(txtDNI.getText()));
        persona.setRuc(txtRUC.getText());
     //   persona.setCargo(txtCargo.getText());
       // int i = CombArea.getSelectedIndex();
      Estados est = (Estados)CombArea.getSelectedItem();
      int es= est.getId(); 
     
      if(CombArea.getSelectedIndex() ==0 || CombArea.getSelectedIndex() ==1 ){
          JOptionPane.showMessageDialog(rootPane,"Seleccione una opcion");
      } else{
          persona.setIdArea(es);
      }    
     
           
      persona.setPermisosAdmin(1);
        
        if((txtCargo.getText()).equals("empleado") ||(txtCargo.getText()).equals("Empleado") ){
           persona.setCargo(false);
        }else{
            persona.setCargo(true);
        }
        
        if (accion.equals("guardar")) {
            
             if(CombArea.getSelectedIndex()==0 || CombArea.getSelectedIndex()==1){
                   JOptionPane.showMessageDialog(rootPane, "Seleccione una opcion");
             }else{
                  if (agregar.registrar(persona)){
                    JOptionPane.showMessageDialog(rootPane, "El cliente fue registrado correctamente"); 
                  }else{
                    JOptionPane.showMessageDialog(rootPane,"No se puede registrar el cliente");
                }
             }      
         }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void CombAreaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CombAreaItemStateChanged
        // TODO add your handling code here:
        
        if(evt.getStateChange() == ItemEvent.SELECTED){
           
        }
    }//GEN-LAST:event_CombAreaItemStateChanged

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
        String busq=txtBuscar.getText();
        String nomb="",apellido="";
        int area=0,dni = 0,cargo,ruc=0;
       String c = "";
        try {
            if(persona != null){
               String sql = "select Nombre,DNI,RUC,Area_idArea,Cargo,apellidos from bdproyectomate.personal+where Nombre= "+busq+"";
                 
               PreparedStatement pers = cn.prepareStatement(sql);
                 ResultSet ver = pers.executeQuery();
                 if(busq.equals(persona.getNombre())){
                    while(ver.next()){
                  nomb=ver.getString("Nombre");
                  apellido=ver.getString("apellidos");
                  dni=ver.getInt("DNI");
                  ruc=ver.getInt("RUC");
                  cargo=ver.getInt("Cargo");
                  if(cargo == 0){
                      c="Empleado";
                  }else{
                      c="Administrador";
                  }
                  area=ver.getInt("Area_idArea");
                 } 
                 }
                 
                 txtNombre.setText(nomb);
                 txtApellido.setText(apellido);
                 txtDNI.setText(Integer.toString(dni));
                txtRUC.setText(Integer.toString(ruc));
                txtCargo.setText(c);
                txtArea.setText(Integer.toString(area));
                 
           
            }
        } catch (Exception e) {
        }
        
            
        
    }//GEN-LAST:event_btnBuscarActionPerformed
    
    
    
    public static void main(String args[]) {
        
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Agregar().setVisible(true);
            }
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox CombArea;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtArea;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtCargo;
    private javax.swing.JTextField txtDNI;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtRUC;
    // End of variables declaration//GEN-END:variables
}
