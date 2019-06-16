/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplo1ds.interfaces;


import clases.Cifrar;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Nitro5
 */
public class registrar extends javax.swing.JInternalFrame {

    /**
     * Creates new form registrar
     */
    public registrar() {
        initComponents();
        cargarTabla("");
        jtblRegistrar.getTableHeader().setReorderingAllowed(false) ;
      
        jtblRegistrar.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (jtblRegistrar.getSelectedRow() != -1) {
                    int fila = jtblRegistrar.getSelectedRow();
                    txtRCedula.setText(jtblRegistrar.getValueAt(fila, 0).toString());
                    txtRNombre.setText(jtblRegistrar.getValueAt(fila, 1).toString());
                    txtRApellido.setText(jtblRegistrar.getValueAt(fila, 2).toString());
                  
                    cbxCargo.setSelectedItem(jtblRegistrar.getValueAt(fila, 4).toString());
                }
            }
    
    });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtRNombre = new javax.swing.JTextField();
        txtRContra = new javax.swing.JPasswordField();
        txtRComprobarContra = new javax.swing.JPasswordField();
        cbxCargo = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtRApellido = new javax.swing.JTextField();
        txtRCedula = new javax.swing.JFormattedTextField();
        btnRegistrar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtblRegistrar = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Cedula");

        jLabel2.setText("Nombre");

        jLabel3.setText("Contraseña");

        jLabel4.setText("Repita la contaseña");

        txtRContra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRContraKeyTyped(evt);
            }
        });

        txtRComprobarContra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRComprobarContraKeyTyped(evt);
            }
        });

        cbxCargo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione...", "administrador", "secretario" }));

        jLabel5.setText("Perfil");

        jLabel6.setText("Apellido");

        try {
            txtRCedula.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jtblRegistrar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jtblRegistrar);

        jButton1.setText("Modificar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Eliminar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel3))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbxCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtRNombre)
                    .addComponent(txtRContra)
                    .addComponent(txtRComprobarContra)
                    .addComponent(txtRApellido)
                    .addComponent(txtRCedula, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRegistrar)
                    .addComponent(btnCancelar)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 543, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtRCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(btnRegistrar)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtRNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtRApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(btnCancelar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtRContra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtRComprobarContra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton2))
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbxCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 421, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
        DefaultTableModel modelo;
    public void cargarTabla(String dato){
        String[] titulos = {"CEDULA", "NOMBRE",
            "APELLIDO", "CLAVE", "PERFIL"
           };
        modelo = new DefaultTableModel(null, titulos);
        String[] registros = new String[5];
        try {

            conexion cc = new conexion();
            Connection cn = cc.conectar();
            String sql = "";
            sql = "SELECT  USU_CEDULA,USU_NOMBRE, USU_APELLIDO,USU_CLAVE, USU_PERFIL FROM ususarios";
            Statement psd = cn.createStatement();
            ResultSet rs = psd.executeQuery(sql);
            while (rs.next()) {
                registros[0] = rs.getString(1);
                registros[1] = rs.getString(2);
                registros[2] = rs.getString(3);
                registros[3] = c.desencrip(rs.getString(4));
                registros[4] = rs.getString(5);
              
                modelo.addRow(registros);
            }
            jtblRegistrar.setModel(modelo);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
       public void modificarUsuario() {
        
         boolean bced = false, bnom = false, bape = false, bcont = false, brepcont = false, bcarg = false, vali = false;
        String CED = "", NOM = "", APE = "", CONR = "", RECON = "", CARG = "";
        if (txtRCedula.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingresar cedula");
        } else {
            CED = txtRCedula.getText();
            bced = true;
        }
        if (txtRNombre.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingresar nombre");
        } else {
            NOM = txtRNombre.getText();
            bnom = true;
        }
        if (txtRApellido.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingresar apellido");
        } else {
            APE = txtRApellido.getText();
            bape = true;
        }
        if (txtRContra.getPassword().toString().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingresar password");
        } else {
            char[] p = txtRContra.getPassword();
            for (int i = 0; i < p.length; i++) {
                CONR += p[i];
            }
        try {
            CONR =c.encriptart(CONR);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(registrar.class.getName()).log(Level.SEVERE, null, ex);
        }
            bcont = true;
        }
        if (txtRComprobarContra.getPassword().toString().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingresar password");
        } else {
            RECON = txtRComprobarContra.getPassword().toString();
            brepcont = true;
        }
        if (Arrays.equals(txtRContra.getPassword(), txtRComprobarContra.getPassword())) {
            vali = true;
        } else {
            JOptionPane.showMessageDialog(null, "Las contaseñas no coinciden");
        }
        if (cbxCargo.getSelectedItem().toString().equals("Seleccione...")) {
            JOptionPane.showMessageDialog(null, "Seleccione un cargo");
        } else {
            CARG = cbxCargo.getSelectedItem().toString();
            bcarg = true;
        }
        if (bced == true && bnom == true && bape == true && bcont == true && brepcont == true && bcarg == true && vali == true) {
            try {
                conexion cc = new conexion();
                Connection cn = cc.conectar();
                String sql = "";
                sql = "UPDATE ususarios SET USU_NOMBRE='" + NOM + "',USU_APELLIDO='" + APE + 
                    "', USU_CLAVE='" + CONR + "', "
                    + "USU_PERFIL='" + CARG+ "' "
                    +  " where USU_CEDULA='" + CED + "'";
            PreparedStatement psd = cn.prepareStatement(sql);
            int n= psd.executeUpdate();
            if (n > 0) {
                JOptionPane.showMessageDialog(null, "Se modificó");
                cargarTabla("");
              
            
                limpiar();
            }
            } catch (Exception ex) {
               JOptionPane.showMessageDialog(null, ex);
            }
        } else {
            System.out.println("No valido");
            System.out.println("1: " + CONR);
            System.out.println("2: " + RECON);
        }
    }
       public void eliminar(){
          if(txtRCedula.getText().isEmpty()){}else{
           if (JOptionPane.showConfirmDialog(new JInternalFrame(),
                "Estas seguro de borrar el registro?", "Borrar resgistro", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
        
        try {
            
            conexion cc = new conexion();
            Connection cn = cc.conectar();
            String sql = "";
            sql = "DELETE FROM ususarios  WHERE USU_CEDULA='" + txtRCedula.getText() + "'";
            PreparedStatement psd = cn.prepareStatement(sql);
            int n = psd.executeUpdate();
            if (n > 0) {
                JOptionPane.showMessageDialog(null, "Se elimino");
                cargarTabla("");
                
                limpiar();
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }}else{}}
       }
    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        // TODO add your handling code here:
        registrar();
       
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        this.dispose();
        
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtRContraKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRContraKeyTyped
        // TODO add your handling code here:
        if (txtRContra.getPassword().length==4) {
            evt.consume();
        }
    }//GEN-LAST:event_txtRContraKeyTyped

    private void txtRComprobarContraKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRComprobarContraKeyTyped
        // TODO add your handling code here:
        if (txtRComprobarContra.getPassword().length==4) {
            evt.consume();
        }
    }//GEN-LAST:event_txtRComprobarContraKeyTyped

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        modificarUsuario();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        eliminar();
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(registrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(registrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(registrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(registrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new registrar().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JComboBox<String> cbxCargo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtblRegistrar;
    private javax.swing.JTextField txtRApellido;
    private javax.swing.JFormattedTextField txtRCedula;
    private javax.swing.JPasswordField txtRComprobarContra;
    private javax.swing.JPasswordField txtRContra;
    private javax.swing.JTextField txtRNombre;
    // End of variables declaration//GEN-END:variables
Cifrar c= new Cifrar();
    public void registrar() {
    
        boolean bced = false, bnom = false, bape = false, bcont = false, brepcont = false, bcarg = false, vali = false;
        String CED = "", NOM = "", APE = "", CONR = "", RECON = "", CARG = "";
        if (txtRCedula.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingresar cedula");
        } else {
            CED = txtRCedula.getText();
            bced = true;
        }
        if (txtRNombre.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingresar nombre");
        } else {
            NOM = txtRNombre.getText();
            bnom = true;
        }
        if (txtRApellido.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingresar apellido");
        } else {
            APE = txtRApellido.getText();
            bape = true;
        }
        if (txtRContra.getPassword().toString().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingresar password");
        } else {
            char[] p = txtRContra.getPassword();
            for (int i = 0; i < p.length; i++) {
                CONR += p[i];
            }
        try {
            CONR =c.encriptart(CONR);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(registrar.class.getName()).log(Level.SEVERE, null, ex);
        }
            bcont = true;
        }
        if (txtRComprobarContra.getPassword().toString().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingresar password");
        } else {
            RECON = txtRComprobarContra.getPassword().toString();
            brepcont = true;
        }
        if (Arrays.equals(txtRContra.getPassword(), txtRComprobarContra.getPassword())) {
            vali = true;
        } else {
            JOptionPane.showMessageDialog(null, "Las contaseñas no coinciden");
        }
        if (cbxCargo.getSelectedItem().toString().equals("Seleccione...")) {
            JOptionPane.showMessageDialog(null, "Seleccione un cargo");
        } else {
            CARG = cbxCargo.getSelectedItem().toString();
            bcarg = true;
        }
        if (bced == true && bnom == true && bape == true && bcont == true && brepcont == true && bcarg == true && vali == true) {
            try {
                conexion cc = new conexion();
                Connection cn = cc.conectar();
                String sql = "";
                sql = "INSERT INTO ususarios(USU_CEDULA, USU_NOMBRE, USU_APELLIDO, USU_CLAVE, USU_PERFIL) "
                        + "VALUES(?,?,?,?,?)";
                PreparedStatement psd = cn.prepareStatement(sql);
                psd.setString(1, CED);
                psd.setString(2, NOM);
                psd.setString(3, APE);
                psd.setString(4, CONR);
                psd.setString(5, CARG);
                int n = psd.executeUpdate();
                limpiar();
                if (n > 0) {
                    JOptionPane.showMessageDialog(null, "Registro correcta");
                    cargarTabla("");
                }
                
                System.out.println("valido");
            } catch (Exception ex) {
               JOptionPane.showMessageDialog(null, ex);
            }
        } else {
            System.out.println("No valido");
            System.out.println("1: " + CONR);
            System.out.println("2: " + RECON);
        }
    }

    public void limpiar() {
        txtRCedula.setText("");
        txtRNombre.setText("");
        txtRApellido.setText("");
        txtRContra.setText("");
        txtRComprobarContra.setText("");
        cbxCargo.setSelectedIndex(0);
    }
}
