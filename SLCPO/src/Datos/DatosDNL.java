/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Connection.Conexion;
import Logica.FuncionesPropias;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author baci
 */
public class DatosDNL {

    private DefaultTableModel modelo;
    FuncionesPropias funcionesp = new FuncionesPropias();

    public void cargaTablaDNL(String SQL, JTable table) {

        String[] registros = new String[10];
        String[] titulos = {"Desde", "Hasta", "Cantidad"};
        modelo = new DefaultTableModel(null, titulos);

        Conexion conex = new Conexion();

        funcionesp.limpiarTabla(table, modelo);

        try {
            Statement empleados = conex.getConn().createStatement();
            ResultSet RS = empleados.executeQuery(SQL);

            while (RS.next()) {
                registros[0] = RS.getString("Desde");
                registros[1] = RS.getString("Hasta");
                registros[2] = RS.getString("Cantidad");

                modelo.addRow(registros);
            }

        } catch (SQLException e) {
            System.out.println("Metodo cargaTablaDNL - " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al consultar", "Error", JOptionPane.ERROR_MESSAGE);
        }

        table.setModel(modelo);
        table.getColumnModel().getColumn(0).setPreferredWidth(200);
        table.getColumnModel().getColumn(1).setPreferredWidth(200);
        table.getColumnModel().getColumn(2).setPreferredWidth(100);

    }

}
