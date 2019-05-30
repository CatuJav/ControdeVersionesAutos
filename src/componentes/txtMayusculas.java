/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package componentes;

import java.awt.event.KeyEvent;
import javax.swing.JTextField;

/**
 *
 * @author Nitro5
 */
public class txtMayusculas extends JTextField {

    public txtMayusculas() {
        this.addKeyListener(new java.awt.event.KeyAdapter() {

            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtAutPlacaKeyReleased(evt);
            }

        });
    }

    private void txtAutPlacaKeyReleased(KeyEvent evt) {
        String l = this.getText().toUpperCase();
        this.setText(l);

    }

}
