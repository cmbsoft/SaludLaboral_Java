/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Connection.Conexion;
import ModeloBD.tablaArticulos;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author baci
 */
public class DatosArticulos {

    public void cargaArtCombo(JComboBox combo) {

        String SQL = "SELECT Idarticulo, des FROM articulos WHERE art_tipo=3 ORDER BY des";

        Conexion conex = new Conexion();

        try {
            Statement empleados = conex.getConn().createStatement();
            ResultSet RS = empleados.executeQuery(SQL);

            while (RS.next()) {
                combo.addItem(RS.getString("Des"));
            }

        } catch (SQLException e) {
            System.out.println("Metodo cargaArtCombo - " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al consultar", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

}
