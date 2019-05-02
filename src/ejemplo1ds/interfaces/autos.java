/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates 
 * and open the template in the editor.
 */
package ejemplo1ds.interfaces;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Nitro5
 */
public class autos extends javax.swing.JFrame {

    /**
     * Creates new form autos
     */
    DefaultTableModel modelo;

    public autos() {
        initComponents();
        bloquear();
        bloquearBoton();
        cargarMarca();
        cargarTablaAutos("");
        spnAutAnio.setValue(1960);
        tblAuto.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (tblAuto.getSelectedRow() != -1) {
                    bloquearBotonModificar();
                    desbloquear();
                    int fila = tblAuto.getSelectedRow();
                    txtAutPlaca.setText(tblAuto.getValueAt(fila, 0).toString().trim());
                    String dat = "";
                    for (int i = 0; i < lm.size(); i++) {
                        String dat1[] = lm.get(i).toString().split(" ");
                        if (tblAuto.getValueAt(fila, 2).toString().equals(dat1[1])) {
                            dat = lm.get(i).toString();
                        }
                    }

                    String dat2 = "";
                    for (int i = 0; i < lmo.size(); i++) {
                        String dat1[] = lmo.get(i).toString().split(" ");
                        if (tblAuto.getValueAt(fila, 1).toString().equals(dat1[1])) {
                            dat2 = lmo.get(i).toString();
                        }
                    }

                    cbxAutMarca.setSelectedItem(dat);
                    cbxAutModelo.setSelectedItem(dat2);
                    spnAutAnio.setValue(Integer.valueOf(tblAuto.getValueAt(fila, 3).toString()));
                    cbxAutColor.setSelectedItem(tblAuto.getValueAt(fila, 4).toString());
                    spnAutCapacidad.setValue(Integer.valueOf(tblAuto.getValueAt(fila, 5).toString()));
                    txtAutObservacion.setText(tblAuto.getValueAt(fila, 6).toString().trim());
                    btnModificar.setEnabled(true);

                } else {
                    limpiar();
                }
            }
        });
    }
public void prueba01(){
    //elaborado por sebastian gonzalez
    System.out.println("Aporte01");
}
    public void limpiar() {
        txtAutPlaca.setText("");
        cbxAutMarca.setSelectedItem("Seleccione...");
        cbxAutModelo.setSelectedItem("Seleccione...");
        spnAutAnio.setValue(1960);
        cbxAutColor.setSelectedItem("Seleccione...");
        spnAutCapacidad.setValue(0);
        txtAutObservacion.setText("");
    }

    public void bloquearBoton() {
        System.out.println("mensaje hecho por michelle vean si asoma");
        btnNuevo.setEnabled(true);
        btnModificar.setEnabled(false);
        btnCancelar.setEnabled(false);
        btnEliminar.setEnabled(false);
        btnGuardar.setEnabled(false);
        btnSalir.setEnabled(false);
    }

    public void bloquearBotonModificar() {
        btnNuevo.setEnabled(false);
        btnModificar.setEnabled(false);
        btnCancelar.setEnabled(true);
        btnEliminar.setEnabled(true);
        btnGuardar.setEnabled(true);
        btnSalir.setEnabled(true);
    }

    public void desbloquearBotonNuevo() {
        btnNuevo.setEnabled(false);
        btnModificar.setEnabled(false);
        btnCancelar.setEnabled(true);
        btnEliminar.setEnabled(false);
        btnGuardar.setEnabled(true);
        btnSalir.setEnabled(true);
    }

    public void bloquear() {
        txtAutPlaca.setEnabled(false);
        cbxAutMarca.setEnabled(false);
        cbxAutModelo.setEnabled(false);
        spnAutAnio.setEnabled(false);
        cbxAutColor.setEnabled(false);
        spnAutCapacidad.setEnabled(false);
        txtAutObservacion.setEnabled(false);
    }

    public void desbloquear() {
        txtAutPlaca.setEnabled(true);
        cbxAutMarca.setEnabled(true);
        cbxAutModelo.setEnabled(true);
        spnAutAnio.setEnabled(true);
        cbxAutColor.setEnabled(true);
        spnAutCapacidad.setEnabled(true);
        txtAutObservacion.setEnabled(true);
    }

    public void guardarAuto() {
        try {
            String AUT_PLACA = "", MOD_CODIGO = "", AUT_COLOR = "", AUT_OBSERVACION;
            Integer AUT_ANIO = 1960, AUT_CAPACIDAD = 0;
            conexion cc = new conexion();
            Connection cn = cc.conectar(); //Connection java.sql
            
            if (txtAutPlaca.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Ingrese la placa");
                txtAutPlaca.requestFocus();
            } else {

                AUT_PLACA = txtAutPlaca.getText();
            }
            if (cbxAutModelo.getSelectedItem().toString().equals("Seleccione...")) {
                JOptionPane.showMessageDialog(null, "Seleccione un modelo");
                cbxAutModelo.requestFocus();
            } else {
                MOD_CODIGO = cbxAutModelo.getSelectedItem().toString().split(" ")[0];
            }
            if (Integer.valueOf(spnAutAnio.getValue().toString()) < 1960 || Integer.valueOf(spnAutAnio.getValue().toString()) > 2019) {
                JOptionPane.showMessageDialog(null, "Ingrese el año correcto");
                spnAutAnio.requestFocus();
            } else {
                AUT_ANIO = Integer.valueOf(spnAutAnio.getValue().toString());
            }
            if (cbxAutColor.getSelectedItem().toString().equals("Seleccione...")) {
                JOptionPane.showMessageDialog(null, "Seleccione un color");
                cbxAutColor.requestFocus();
            } else {
                AUT_COLOR = cbxAutColor.getSelectedItem().toString();
            }
            if (Integer.valueOf(spnAutCapacidad.getValue().toString()) > 25) {
                JOptionPane.showMessageDialog(null, "Menor de 25");
                spnAutCapacidad.requestFocus();
            } else {
                AUT_CAPACIDAD = Integer.valueOf(spnAutCapacidad.getValue().toString());
            }
            AUT_OBSERVACION = txtAutObservacion.getText();

            String sql = "";
            sql = "insert into autos(AUT_PLACA, MOD_CODIGO, "
                    + "AUT_ANIO, AUT_COLOR, "
                    + "AUT_CAPACIDAD, AUT_OBSERVACION) "
                    + "values(?,?,?,?,?,?)"; //Cuando no se que valores voy a ingresar pongo ?

            PreparedStatement psd = cn.prepareStatement(sql);
            psd.setString(1, AUT_PLACA);
            psd.setString(2, MOD_CODIGO);
            psd.setInt(3, AUT_ANIO);
            psd.setString(4, AUT_COLOR);
            psd.setInt(5, AUT_CAPACIDAD);
            if (txtAutObservacion.getText().isEmpty()) {
                String obsVacio = "Sin observacion";
                psd.setString(6, obsVacio);
            } else {
                psd.setString(6, AUT_OBSERVACION);
            }
            int n = psd.executeUpdate();
            if (n > 0) {
                JOptionPane.showMessageDialog(null, "Insersión correcta");
                cargarTablaAutos("");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    ArrayList lm = new ArrayList();

    public void cargarMarca() {

        try {
            conexion cc = new conexion();
            Connection cn = cc.conectar();
            String sql = "";
            sql = "select * from marca";
            Statement psd = cn.createStatement();
            ResultSet rs = psd.executeQuery(sql);//ResulteSet es parte del Middleware
            cbxAutMarca.addItem("Seleccione...");
            while (rs.next()) {
                String id = rs.getString("MAR_CODIGO");
                String marca = rs.getString("MAR_NOM");
                cbxAutMarca.addItem(id + " " + marca);
                lm.add(id + " " + marca);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);

        }

    }
    ArrayList lmo = new ArrayList();

    public void cargarModelo() {
        if (cbxAutMarca.getSelectedItem().equals("Seleccione...")) {
            cbxAutModelo.addItem("Seleccione...");
        } else {
            String mars2[] = String.valueOf(cbxAutMarca.getSelectedItem().toString()).split(" ");
            int codi = Integer.valueOf(mars2[0]);

            try {
                conexion cc = new conexion();
                Connection cn = cc.conectar();
                String sql = "";
                sql = "select * from modelo " + "where MAR_CODIGO= '" + codi + "'";
                Statement psd = cn.createStatement();
                ResultSet rs = psd.executeQuery(sql);//ResulteSet es parte del Middleware
                cbxAutModelo.addItem("Seleccione...");
                while (rs.next()) {
                    String cod = rs.getString("MOD_CODIGO");
                    String modelo = rs.getString("COD_NOM");
                    cbxAutModelo.addItem(cod + " " + modelo);
                    lmo.add(cod + " " + modelo);
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);

            }
        }
    }
    ArrayList modeloaut = new ArrayList();
    ArrayList marca = new ArrayList();

    public void borrarTextos() {
        txtAutPlaca.setText("");
        cbxAutMarca.setSelectedIndex(0);
        cbxAutModelo.setSelectedItem(0);
        spnAutAnio.setValue(0);
        cbxAutColor.setSelectedIndex(0);
        spnAutCapacidad.setValue(0);
        txtAutObservacion.setText("");
    }

    public void cargarTablaAutos(String dato) {
        String[] titulos = {"PLACA", "MODELO",
            "MARCA", "AÑO", "COLOR",
            "CAPACIDAD", "OBSERVACION"};
        modelo = new DefaultTableModel(null, titulos);
        String[] registros = new String[7];
        try {

            conexion cc = new conexion();
            Connection cn = cc.conectar();
            String sql = "";
            sql = "SELECT A.AUT_PLACA, A.MOD_CODIGO, "
                    + "A.AUT_ANIO, A.AUT_COLOR, "
                    + "A.AUT_CAPACIDAD, A.AUT_OBSERVACION, M.COD_NOM, R.MAR_NOM FROM AUTOS AS A, MODELO AS M, MARCA AS R "
                    + "WHERE  A.MOD_CODIGO=M.MOD_CODIGO AND "
                    + "M.MAR_CODIGO=R.MAR_CODIGO AND "
                    + "A.AUT_PLACA LIKE " + "'%" + dato + "%' AND "
                    + "ACTIVO=1";
            Statement psd = cn.createStatement();
            ResultSet rs = psd.executeQuery(sql);
            while (rs.next()) {
                registros[0] = rs.getString("AUT_PLACA");
                registros[1] = rs.getString("COD_NOM");
                registros[2] = rs.getString("MAR_NOM");
                registros[3] = rs.getString("AUT_ANIO");
                registros[4] = rs.getString("AUT_COLOR");
                registros[5] = rs.getString("AUT_CAPACIDAD");
                registros[6] = rs.getString("AUT_OBSERVACION");
                modelo.addRow(registros);
            }
            tblAuto.setModel(modelo);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

    }

    public void modificarAuto() {
        try {
            conexion cc = new conexion();
            Connection cn = cc.conectar();
            String sql = "";
            String dat = "";
            for (int i = 0; i < lmo.size(); i++) {
                String dat1[] = lmo.get(i).toString().split(" ");
                if (cbxAutModelo.getSelectedItem().toString().equals(dat1[0] + " " + dat1[1])) {
                    dat = dat1[0];
                    System.out.println(dat);
                }
            }

            sql = "UPDATE AUTOS SET MOD_CODIGO='" + dat + "',AUT_ANIO='" + spnAutAnio.getValue() + "', AUT_COLOR='" + cbxAutColor.getSelectedItem().toString() + "', "
                    + "AUT_CAPACIDAD='" + spnAutCapacidad.getValue() + "', "
                    + " AUT_OBSERVACION='" + txtAutObservacion.getText() + "' where AUT_PLACA='" + txtAutPlaca.getText() + "'";
            PreparedStatement psd = cn.prepareStatement(sql);
            int n= psd.executeUpdate();
            if (n > 0) {
                JOptionPane.showMessageDialog(null, "Se modificó");
                cargarTablaAutos("");
                bloquear();
                bloquearBoton();
                limpiar();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    public void eliminarAuto() {
        if (JOptionPane.showConfirmDialog(new JInternalFrame(),
                "Estas seguro de borrar el registro?", "Borrar resgistro", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
        
        try {
            conexion cc = new conexion();
            Connection cn = cc.conectar();
            String sql = "";
            sql = "DELETE FROM AUTOS WHERE AUT_PLACA='" + txtAutPlaca.getText() + "'";
            PreparedStatement psd = cn.prepareStatement(sql);
            int n = psd.executeUpdate();
            if (n > 0) {
                JOptionPane.showMessageDialog(null, "Se elimino");
                cargarTablaAutos("");
                bloquear();
                bloquearBoton();
                limpiar();
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }}else{}
    }
    public void eliminarAuto2(){
     if (JOptionPane.showConfirmDialog(new JInternalFrame(),
                "Estas seguro de borrar el registro?", "Borrar resgistro", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
        
        try {
            conexion cc = new conexion();
            Connection cn = cc.conectar();
            String sql = "";
            sql = "UPDATE AUTOS SET ACTIVO=0 WHERE AUT_PLACA='" + txtAutPlaca.getText() + "'";
            PreparedStatement psd = cn.prepareStatement(sql);
            int n = psd.executeUpdate();
            if (n > 0) {
                JOptionPane.showMessageDialog(null, "Se elimino");
                cargarTablaAutos("");
                bloquear();
                bloquearBoton();
                limpiar();
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }}else{}
    
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtAutPlaca = new javax.swing.JTextField();
        cbxAutMarca = new javax.swing.JComboBox<>();
        cbxAutModelo = new javax.swing.JComboBox<>();
        spnAutAnio = new javax.swing.JSpinner();
        cbxAutColor = new javax.swing.JComboBox<>();
        spnAutCapacidad = new javax.swing.JSpinner();
        txtAutObservacion = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        btnNuevo = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAuto = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        txtBuscarPlaca = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setText("PLACA");

        jLabel2.setText("MARCA");

        jLabel3.setText("MODELO");

        jLabel4.setText("AÑO");

        jLabel5.setText("COLOR");

        jLabel6.setText("CAPACIDAD");

        jLabel7.setText("OBSERVACION");

        txtAutPlaca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtAutPlacaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtAutPlacaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAutPlacaKeyTyped(evt);
            }
        });

        cbxAutMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxAutMarcaActionPerformed(evt);
            }
        });
        cbxAutMarca.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                cbxAutMarcaPropertyChange(evt);
            }
        });

        spnAutAnio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                spnAutAnioKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                spnAutAnioKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                spnAutAnioKeyTyped(evt);
            }
        });

        cbxAutColor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione...", "ROJO", "AZUL", "VERDE" }));

        spnAutCapacidad.setName(""); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtAutPlaca)
                    .addComponent(txtAutObservacion)
                    .addComponent(spnAutCapacidad)
                    .addComponent(spnAutAnio)
                    .addComponent(cbxAutModelo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbxAutColor, 0, 452, Short.MAX_VALUE)
                    .addComponent(cbxAutMarca, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtAutPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbxAutMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbxAutModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(spnAutAnio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cbxAutColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(spnAutCapacidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAutObservacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(42, 42, 42))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnModificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnNuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnNuevo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGuardar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnModificar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEliminar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancelar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSalir)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tblAuto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ));
        jScrollPane1.setViewportView(tblAuto);

        jLabel8.setText("BUSCAR");

        txtBuscarPlaca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarPlacaKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 708, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtBuscarPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtBuscarPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        // TODO add your handling code here:
        desbloquear();
        desbloquearBotonNuevo();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void cbxAutMarcaPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_cbxAutMarcaPropertyChange
        // TODO add your handling code here:

    }//GEN-LAST:event_cbxAutMarcaPropertyChange

    private void cbxAutMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxAutMarcaActionPerformed
        // TODO add your handling code here:
        cbxAutModelo.removeAllItems();
        cargarModelo();

    }//GEN-LAST:event_cbxAutMarcaActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        guardarAuto();

        borrarTextos();
        bloquear();
        bloquearBoton();


    }//GEN-LAST:event_btnGuardarActionPerformed

    private void txtAutPlacaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAutPlacaKeyReleased
        // TODO add your handling code here:

        String l = txtAutPlaca.getText().toUpperCase();
        txtAutPlaca.setText(l);


    }//GEN-LAST:event_txtAutPlacaKeyReleased

    private void txtAutPlacaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAutPlacaKeyPressed
        // TODO add your handling code here:

    }//GEN-LAST:event_txtAutPlacaKeyPressed

    private void txtAutPlacaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAutPlacaKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (txtAutPlaca.getText().length() < 3) {
            if ((c < 'A' || c > 'Z') && (c < 'a' || c > 'z')) {
                evt.consume();
            }
        } else {
            if (txtAutPlaca.getText().length() < 7) {
                if ((c < '0' || c > '9')) {
                    evt.consume();
                } else {

                }
            } else {
                evt.consume();
            }

        }


    }//GEN-LAST:event_txtAutPlacaKeyTyped

    private void spnAutAnioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_spnAutAnioKeyTyped
        // TODO add your handling code here:

        char c = evt.getKeyChar();
        if (c < '0' || c > '9') {
            evt.consume();
        } else {

        }
    }//GEN-LAST:event_spnAutAnioKeyTyped

    private void spnAutAnioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_spnAutAnioKeyPressed
        // TODO add your handling code here:

        char c = evt.getKeyChar();
        if (c < '0' || c > '9') {
            evt.consume();
        } else {

        }

    }//GEN-LAST:event_spnAutAnioKeyPressed

    private void spnAutAnioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_spnAutAnioKeyReleased
        // TODO add your handling code here:

        char c = evt.getKeyChar();
        if (c < '0' || c > '9') {
            evt.consume();
        } else {

        }

    }//GEN-LAST:event_spnAutAnioKeyReleased

    private void txtBuscarPlacaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarPlacaKeyReleased
        // TODO add your handling code here:
        cargarTablaAutos(txtBuscarPlaca.getText());
    }//GEN-LAST:event_txtBuscarPlacaKeyReleased

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        limpiar();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        // TODO add your handling code here:
        modificarAuto();

    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        //eliminarAuto();
        
        eliminarAuto2();
    }//GEN-LAST:event_btnEliminarActionPerformed

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
                    javax.swing.UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(autos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(autos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(autos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(autos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new autos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<String> cbxAutColor;
    private javax.swing.JComboBox<String> cbxAutMarca;
    private javax.swing.JComboBox<String> cbxAutModelo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner spnAutAnio;
    private javax.swing.JSpinner spnAutCapacidad;
    private javax.swing.JTable tblAuto;
    private javax.swing.JTextField txtAutObservacion;
    private javax.swing.JTextField txtAutPlaca;
    private javax.swing.JTextField txtBuscarPlaca;
    // End of variables declaration//GEN-END:variables

}
