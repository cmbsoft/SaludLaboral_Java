/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saludlaboralcpo;

import Presentacion.Acceso;
import Presentacion.Sistema;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import javax.swing.ImageIcon;

/**
 *
 * @author baci
 */
public class SaludLaboralCPO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Sistema sistema = new Sistema();

        Acceso acceso = new Acceso();

        sistema.setVisible(true);

        acceso.setVisible(true);

    }

}
