/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplo1ds.interfaces;

import com.github.lgooddatepicker.components.DatePickerSettings;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;
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
public class viajes extends javax.swing.JInternalFrame {

    /**
     * Creates new form viajes
     */
    public viajes() {
        initComponents();
        cargarCodigo();
        calendario();
        tblViajes.getTableHeader().setReorderingAllowed(false) ;
        cbxPalcaVi.cargarDatos("viaje", "autos", "AUT_PLACA");
        cbxChoferVi.cargarDatos("viaje", "chofer", "CHO_CEDULA");
        cbxOrigen.cargarDatos("viaje", "ciudades", "CIU_CODIGO", "CIU_NOMBRE");
        cbxDestino.cargarDatos("viaje", "ciudades", "CIU_CODIGO", "CIU_NOMBRE");
        cargarTabla("");
         tblViajes.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (tblViajes.getSelectedRow() != -1) {
                    int fila = tblViajes.getSelectedRow();
                    txtCodigoVi.setText(tblViajes.getValueAt(fila, 0).toString());
                    cbxPalcaVi.setSelectedItem(tblViajes.getValueAt(fila, 1).toString());
                    cbxChoferVi.setSelectedItem(tblViajes.getValueAt(fila, 2).toString());
                    txtFechaSalida.setText(tblViajes.getValueAt(fila, 3).toString());
                    txtFechaLlegada.setText(tblViajes.getValueAt(fila, 4).toString());
                    txtCosto.setText(tblViajes.getValueAt(fila, 5).toString());
                    spnKilometraje.setValue(Integer.valueOf(tblViajes.getValueAt(fila, 6).toString()));
                    cbxOrigen.setSelectedItem(tblViajes.getValueAt(fila, 7).toString());
                    cbxDestino.setSelectedItem(tblViajes.getValueAt(fila, 8).toString());
                    txtObservaciones.setText(tblViajes.getValueAt(fila, 9).toString());
                    
                }
            }
    
    });
    }

    public void cargarTabla(String dato) {

        String titulo[] = {"Codigo", "Placa", "Chofer", "Fecha de salida", "Fecha de llegada", "Costo", "Kilometraje",
             "Origen", "Destino", "Observaciones"};
        DefaultTableModel modelo = new DefaultTableModel(null, titulo);
        String registro[] = new String[10];
        try {
            conexion cc = new conexion();
            Connection cn = cc.conectar();
            String sql = "";
            sql = "SELECT * FROM viajes V INNER JOIN ciudades S ON V.CIU_CODIGO=S.CIU_CODIGO INNER JOIN ciudades C ON C.CIU_CODIGO=V.CIU_CIU_CODIGO";
            Statement psd = cn.createStatement();
            ResultSet rs = psd.executeQuery(sql);
            while (rs.next()) {
                registro[0] = rs.getString(1);
                registro[1] = rs.getString(2);
                registro[2] = rs.getString(3);
                registro[3] = rs.getString(4);
                registro[4] = rs.getString(5);
                registro[5] = rs.getString(6);
                registro[6] = rs.getString(7);
                registro[7] = rs.getString(11) + " " + rs.getString(12);
                registro[8] = rs.getString(13) + " " + rs.getString(14);
                registro[9] = rs.getString(8);
                modelo.addRow(registro);
            }
            ulti=Integer.valueOf(registro[0]);
            System.out.println("util: "+ulti);
            tblViajes.setModel(modelo);
        } catch (SQLException ex) {
            Logger.getLogger(viajes.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void cargarCodigo() {
        try {
            conexion cc = new conexion();
            Connection cn = cc.conectar();
            String sql = "";
            sql = "SELECT * FROM VIAJES ORDER BY VIAJE_CODIGO ASC";
            Statement psd = cn.createStatement();
            ResultSet rs = psd.executeQuery(sql);
            String dato = "0";
            while (rs.next()) {
                dato = rs.getString("VIAJE_CODIGO");
                System.out.println(dato);
            }
            txtCodigoVi.setText(String.valueOf(Integer.valueOf(dato) + 1));

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtCodigoVi = new javax.swing.JTextField();
        cbxPalcaVi = new componentes.cbxCargarDastos();
        cbxChoferVi = new componentes.cbxCargarDastos();
        spnKilometraje = new javax.swing.JSpinner();
        cbxOrigen = new componentes.cbxCargarDastos();
        cbxDestino = new componentes.cbxCargarDastos();
        txtFechaSalida = new com.github.lgooddatepicker.components.DatePicker();
        txtFechaLlegada = new com.github.lgooddatepicker.components.DatePicker();
        txtCosto = new javax.swing.JTextField();
        txtObservaciones = new componentes.txtMayusculas();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblViajes = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("VIAJES");

        jLabel2.setText("Código: ");

        jLabel3.setText("Placa del auto:");

        jLabel4.setText("Cédula del chofer:");

        jLabel5.setText("Fecha de salida:");

        jLabel6.setText("Fecha de llegada:");

        jLabel7.setText("Costo:");

        jLabel8.setText("Kilometraje:");

        jLabel9.setText("Origen:");

        jLabel10.setText("Destino:");

        jLabel11.setText("Observaciones:");

        txtCodigoVi.setEditable(false);

        txtCosto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCostoKeyTyped(evt);
            }
        });

        tblViajes.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblViajes);

        jButton1.setText("Guardar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Salir");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Modificar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Cancelar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Eliminar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addComponent(jButton3)
                    .addComponent(jButton4)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jButton2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(13, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel8))
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtFechaLlegada, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtFechaSalida, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbxChoferVi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbxPalcaVi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtCodigoVi, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(spnKilometraje, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxDestino, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbxOrigen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtCosto, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtObservaciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(42, 42, 42)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(81, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtCodigoVi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(cbxPalcaVi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(cbxChoferVi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtFechaSalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtFechaLlegada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(txtCosto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(spnKilometraje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(cbxOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(cbxDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(txtObservaciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        guardaViajes();
        limpiar();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtCostoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCostoKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if ((c > '0' && c < '9') || c == '.') {

        } else {
            evt.consume();
        }
    }//GEN-LAST:event_txtCostoKeyTyped

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        limpiar();
        cargarCodigo();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        modificarViaje();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        eliminar();
    }//GEN-LAST:event_jButton5ActionPerformed

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
            java.util.logging.Logger.getLogger(viajes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(viajes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(viajes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(viajes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new viajes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private componentes.cbxCargarDastos cbxChoferVi;
    private componentes.cbxCargarDastos cbxDestino;
    private componentes.cbxCargarDastos cbxOrigen;
    private componentes.cbxCargarDastos cbxPalcaVi;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner spnKilometraje;
    private javax.swing.JTable tblViajes;
    private javax.swing.JTextField txtCodigoVi;
    private javax.swing.JTextField txtCosto;
    private com.github.lgooddatepicker.components.DatePicker txtFechaLlegada;
    private com.github.lgooddatepicker.components.DatePicker txtFechaSalida;
    private componentes.txtMayusculas txtObservaciones;
    // End of variables declaration//GEN-END:variables
    public void calendario() {
        Locale pk = Locale.getDefault();

        DatePickerSettings ajuste = new DatePickerSettings(pk);
        ajuste.setFormatForDatesCommonEra("yyyy-MM-dd");

        ajuste.setFormatForDatesBeforeCommonEra("uuuu-MM-dd");

        DatePickerSettings ajuste2 = new DatePickerSettings(pk);
        ajuste2.setFormatForDatesCommonEra("yyyy-MM-dd");

        ajuste2.setFormatForDatesBeforeCommonEra("uuuu-MM-dd");
        txtFechaSalida.setSettings(ajuste);
        txtFechaLlegada.setSettings(ajuste2);
    }

    private void guardaViajes() {
        String codigo, placa, cedula, fsalida, fllegada, costo, kilmetraje, observacion, origen, destino;
        boolean pla = false, ced = false, fsa = false, flle = false, cos = false, kilo = false, ori = false, des = false;
        if (cbxPalcaVi.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Seleccione una placa");
        } else {
            pla = true;
        }
        if (cbxChoferVi.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Seleccione un chofer");
        } else {

            ced = true;
        }
        if (txtFechaSalida.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Seleccione una fecha de salida");
        } else {
            fsa = true;
        }
        if (txtFechaLlegada.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Seleccione una fecha de llegada");
        } else {
            flle = true;
        }
        if (txtCosto.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ponga un costo");
        } else {
            cos = true;
        }
        if (spnKilometraje.getValue().equals("")) {
            JOptionPane.showMessageDialog(this, "Establezca el kilometraje");
        } else {
            kilo = true;
        }
        if (txtObservaciones.getText().isEmpty()) {
            observacion = "NINGUNA";
        } else {
            observacion = txtObservaciones.getText();
        }
        if (cbxOrigen.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Seleccione un lugar de origen");
        } else {
            ori = true;
        }
        if (cbxDestino.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Seleccione un lugar de destino");
        } else {
            des = true;
        }

        if (pla && ced && fsa && flle && cos && kilo && ori && des) {
            try {
                conexion cc = new conexion();
                Connection cn = cc.conectar();
                String sql = "";
                sql = "INSERT INTO viajes(VIAJE_CODIGO,AUT_PLACA,CHO_CEDULA,F_SALIDA,F_LLEGADA,VIAJE_COSTO,VIAJE_KILOMETRAJE,"
                        + "VIAJE_OBSERVACION,CIU_CODIGO,CIU_CIU_CODIGO)"
                        + " VALUES(?,?,?,?,?,?,?,?,?,?)";
                PreparedStatement psd = cn.prepareStatement(sql);
                codigo = txtCodigoVi.getText();
                placa = cbxPalcaVi.getSelectedItem().toString();
                cedula = cbxChoferVi.getSelectedItem().toString();
                fsalida = txtFechaSalida.getText();
                fllegada = txtFechaLlegada.getText();
                costo = txtCosto.getText();
                kilmetraje = spnKilometraje.getValue().toString();
                String origenco[] = cbxOrigen.getSelectedItem().toString().split(" ");
                origen = origenco[0];
                String destinoco[] = cbxDestino.getSelectedItem().toString().split(" ");
                destino = destinoco[0];

                psd.setString(1, codigo);
                psd.setString(2, placa);
                psd.setString(3, cedula);
                psd.setString(4, fsalida);
                psd.setString(5, fllegada);
                psd.setString(6, costo);
                psd.setString(7, kilmetraje);
                psd.setString(8, observacion);
                psd.setString(9, origen);
                psd.setString(10, destino);
                int n = psd.executeUpdate();
                if (n > 0) {
                    JOptionPane.showMessageDialog(this, "Inserción correcta");
                    cargarTabla("");
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
            cargarCodigo();
        }
    }

    public void limpiar() {
        txtCosto.setText("");
        txtFechaLlegada.setText("");
        txtFechaSalida.setText("");
        txtObservaciones.setText("");
        cbxChoferVi.setSelectedIndex(0);
        cbxDestino.setSelectedIndex(0);
        cbxOrigen.setSelectedIndex(0);
        cbxPalcaVi.setSelectedIndex(0);
        spnKilometraje.setValue(0);

    }

    private void modificarViaje() {
        String codigo = "", placa = "", cedula = "", fsalida = "", fllegada = "", costo = "", kilmetraje= "", observacion= "", origen= "", destino= "";
        boolean pla = false, ced = false, fsa = false, flle = false, cos = false, kilo = false, ori = false, des = false;
        if (cbxPalcaVi.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Seleccione una placa");
        } else {
            pla = true;
        }
        if (cbxChoferVi.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Seleccione un chofer");
        } else {

            ced = true;
        }
        if (txtFechaSalida.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Seleccione una fecha de salida");
        } else {
            fsa = true;
        }
        if (txtFechaLlegada.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Seleccione una fecha de llegada");
        } else {
            flle = true;
        }
        if (txtCosto.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ponga un costo");
        } else {
            cos = true;
        }
        if (spnKilometraje.getValue().equals("")) {
            JOptionPane.showMessageDialog(this, "Establezca el kilometraje");
        } else {
            kilo = true;
        }
        if (txtObservaciones.getText().isEmpty()) {
            observacion = "NINGUNA";
        } else {
            observacion = txtObservaciones.getText();
        }
        if (cbxOrigen.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Seleccione un lugar de origen");
        } else {
            ori = true;
        }
        if (cbxDestino.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Seleccione un lugar de destino");
        } else {
            des = true;
        }

        if (pla && ced && fsa && flle && cos && kilo && ori && des) {
            try {
                codigo = txtCodigoVi.getText();
                placa = cbxPalcaVi.getSelectedItem().toString();
                cedula = cbxChoferVi.getSelectedItem().toString();
                fsalida = txtFechaSalida.getText();
                fllegada = txtFechaLlegada.getText();
                costo = txtCosto.getText();
                kilmetraje = spnKilometraje.getValue().toString();
                String origenco[] = cbxOrigen.getSelectedItem().toString().split(" ");
                origen = origenco[0];
                String destinoco[] = cbxDestino.getSelectedItem().toString().split(" ");
                destino = destinoco[0];
                conexion cc = new conexion();
                Connection cn = cc.conectar();
                String sql = "";
                sql = "UPDATE viajes SET AUT_PLACA='" +placa+
                        "', CHO_CEDULA='"+cedula+
                        "', F_SALIDA='"+fsalida+
                        "', F_LLEGADA='"+fllegada+
                        "', VIAJE_COSTO='"+costo+
                        "', VIAJE_KILOMETRAJE='"+kilmetraje+
                        "', VIAJE_OBSERVACION='"+observacion+
                        "', CIU_CODIGO='"+origen+
                        "', CIU_CIU_CODIGO='"+destino
                    +  "' where VIAJE_CODIGO='" + codigo + "'";
            PreparedStatement psd = cn.prepareStatement(sql);
            int n= psd.executeUpdate();
            if (n > 0) {
                JOptionPane.showMessageDialog(null, "Se modificó");
                cargarTabla("");
              
            
                limpiar();
            }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
            cargarCodigo();
        }
    }
    int ulti;
    private void eliminar() {
         if(txtCodigoVi.getText().isEmpty()||Integer.valueOf(txtCodigoVi.getText())>ulti){}else{
           if (JOptionPane.showConfirmDialog(new JInternalFrame(),
                "Estas seguro de borrar el registro?", "Borrar resgistro", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
        
        try {
            
            conexion cc = new conexion();
            Connection cn = cc.conectar();
            String sql = "";
            sql = "DELETE FROM viajes  WHERE VIAJE_CODIGO='" + txtCodigoVi.getText() + "'";
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
}
