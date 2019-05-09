/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package componentes;

import ejemplo1ds.interfaces.conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author Nitro5
 */
public class cbxCargarDastos extends JComboBox {
    public cbxCargarDastos(){

   
  
    }
    

    
    
  Connection conect=null;//Al momento de importar las librerias se debe importar de jaca.sql no de com.mysql
    //Para iniciar se debe agregar las librerias mysql JDBC
    public Connection conectar(String base){//Con com.mysql.dbc
        try { 
            Class.forName("com.mysql.jdbc.Driver"); //Seleccionamos los packetes de la libreria que se cargo
            conect= DriverManager.getConnection("jdbc:mysql://localhost/"+base,"root",""); //Si en la vida real va la ip de servidor
            //JOptionPane.showMessageDialog(null, "Se conectó correctamente");
        } catch (Exception ex) {// Recoge todas las exepcipnes
            JOptionPane.showMessageDialog(null, "Sin conexión");
        }
        return conect;
    }

    
    public void cargarDatos(String base, String tabla, String campo) {  
        
        
        
            try {
        
                String sql = "";
                sql = "select "+campo+ " from "+tabla;
                Statement psd = conectar(base).createStatement();
                ResultSet rs = psd.executeQuery(sql);//ResulteSet es parte del Middleware
                this.addItem("Seleccione...");
                while (rs.next()) {
                    String cod = rs.getString(campo);
                    this.addItem(cod);
                   
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);

            }
        }
    }
        

