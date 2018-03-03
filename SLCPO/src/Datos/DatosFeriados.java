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
public class DatosFeriados {

    private DefaultTableModel modelo;
    FuncionesPropias funcionesp = new FuncionesPropias();

    public void cargaTablaFeriados(String SQL, JTable table) {

        String[] registros = new String[10];
        String[] titulos = {"Fecha", "Descripción"};
        modelo = new DefaultTableModel(null, titulos);

        Conexion conex = new Conexion();

        funcionesp.limpiarTabla(table, modelo);

        try {
            Statement empleados = conex.getConn().createStatement();
            ResultSet RS = empleados.executeQuery(SQL);

            while (RS.next()) {
                registros[0] = RS.getString("fecha");
                registros[1] = RS.getString("descrip");

                modelo.addRow(registros);
            }

        } catch (SQLException e) {
            System.out.println("Metodo cargaTablaFeriados - " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al consultar", "Error", JOptionPane.ERROR_MESSAGE);
        }

        table.setModel(modelo);
        table.getColumnModel().getColumn(0).setPreferredWidth(150);
        table.getColumnModel().getColumn(1).setPreferredWidth(300);

    }

}
