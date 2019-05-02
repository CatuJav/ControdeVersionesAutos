/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplo1ds.interfaces;

import java.sql.*;  
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Nitro5
 */
public class conexion {
    Connection conect=null;//Al momento de importar las librerias se debe importar de jaca.sql no de com.mysql
    //Para iniciar se debe agregar las librerias mysql JDBC
    public Connection conectar(){//Con com.mysql.dbc
        try { 
            Class.forName("com.mysql.jdbc.Driver"); //Seleccionamos los packetes de la libreria que se cargo
            conect= DriverManager.getConnection("jdbc:mysql://localhost/viaje","root",""); //Si en la vida real va la ip de servidor
            //JOptionPane.showMessageDialog(null, "Se conectó correctamente");
        } catch (Exception ex) {// Recoge todas las exepcipnes
            JOptionPane.showMessageDialog(null, "Sin conexión");
        }
        return conect;
    }
  
}
