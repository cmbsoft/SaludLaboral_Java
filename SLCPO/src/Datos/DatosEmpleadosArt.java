/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Connection.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import Logica.FuncionesPropias;

/**
 *
 * @author baci
 */
public class DatosEmpleadosArt {

    private DefaultTableModel modelo;
    FuncionesPropias funcionesp = new FuncionesPropias();

    public void cargaTabla(String SQL, JTable table) {

        String[] registros = new String[10];
        String[] titulos = {"Artículo", "Desde", "Hasta", "Días", "Id"};
        modelo = new DefaultTableModel(null, titulos);

        Conexion conex = new Conexion();

        funcionesp.limpiarTabla(table, modelo);

        try {
            Statement empleados = conex.getConn().createStatement();
            ResultSet RS = empleados.executeQuery(SQL);

            while (RS.next()) {
                registros[0] = RS.getString("IdArticulo");
                registros[1] = RS.getString("Desde");
                registros[2] = RS.getString("Hasta");
                registros[3] = RS.getString("Cantidad");
                registros[4] = RS.getString("Id");
                modelo.addRow(registros);
            }

        } catch (SQLException e) {
            System.out.println("Metodo cargaTabla - " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al consultar", "Error", JOptionPane.ERROR_MESSAGE);
        }

        table.setModel(modelo);
        table.getColumnModel().getColumn(0).setPreferredWidth(200);
        table.getColumnModel().getColumn(1).setPreferredWidth(300);
        table.getColumnModel().getColumn(2).setPreferredWidth(300);
        table.getColumnModel().getColumn(3).setPreferredWidth(300);
        table.getColumnModel().getColumn(4).setPreferredWidth(0);
    }

}
