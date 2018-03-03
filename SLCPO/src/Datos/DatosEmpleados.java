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
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import Vistas.Sistema;
import Datos.TraeDatosBD;

/**
 *
 * @author baci
 */
public class DatosEmpleados extends Conexion {

    private DefaultTableModel modelo;

    public void cargaTabla(String SQL, JTable table) {

        String[] registros = new String[10];
        String[] titulos = {"Legajo", "Apellido y Nombre", "Sexo"};
        modelo = new DefaultTableModel(null, titulos);

        Conexion conex = new Conexion();

        try {
            Statement empleados = conex.getConn().createStatement();
            ResultSet RS = empleados.executeQuery(SQL);

            while (RS.next()) {
                registros[0] = RS.getString("legajo");
                registros[1] = RS.getString("Apellido") + ", " + RS.getString("Nombre");
                registros[2] = RS.getString("Sexo");
                modelo.addRow(registros);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al consultar", "Error", JOptionPane.ERROR_MESSAGE);
        }

        table.setModel(modelo);
        table.getColumnModel().getColumn(0).setPreferredWidth(200);
        table.getColumnModel().getColumn(1).setPreferredWidth(500);
        table.getColumnModel().getColumn(2).setPreferredWidth(200);
    }

    public void cargaDatosEmpleados(String legajo) throws SQLException {

        String SQL = "SELECT * FROM empleados where legajo='" + legajo + "'";

        // empleados = empleados(SQL);
        TraeDatosBD traedatos = new TraeDatosBD();

        FuncionesPropias fechaformato = new FuncionesPropias();

        Conexion conex = new Conexion();

        try {
            Statement empleados = conex.getConn().createStatement();
            ResultSet RS = empleados.executeQuery(SQL);

            while (RS.next()) {

                Sistema.lblApellido.setText(RS.getString("Apellido"));
                Sistema.lblNombre.setText(RS.getString("Nombre"));

                Sistema.lblApellido1.setText(RS.getString("Apellido"));
                Sistema.lblNombre1.setText(RS.getString("Nombre"));

                Sistema.lblDNI.setText(RS.getString("Num_documento"));
                Sistema.LblLocalidad.setText(traedatos.TraeLocalidadEmpleado(legajo));
                Sistema.lblCP.setText(RS.getString("Codigopostal"));
                Sistema.lblDireccion.setText(RS.getString("Domicilio"));
                Sistema.lblTelefono.setText(RS.getString("Telefono"));
                Sistema.lblMovil.setText(RS.getString("Telmovil"));
                Sistema.lblFecNac.setText(fechaformato.dFechaddmmyyyy(RS.getDate("Fecha_nacimiento")));
                Sistema.lblEdad.setText(FuncionesPropias.getEdad(RS.getDate("Fecha_nacimiento")));
                Sistema.lblCarpMed.setText(RS.getString("Carp_medica"));
                Sistema.lblAptitud.setText(RS.getString("Aptitud"));
                Sistema.lblEstCivil.setText(RS.getString("Estado_civil"));
                Sistema.lblCUIL.setText(RS.getString("Cuil"));
                Sistema.lblMail.setText(RS.getString("Mail"));

                Sistema.lblDecNomb.setText(RS.getString("Decreto_nom"));

                Sistema.lblRevista.setText(traedatos.TraeRevistaNombre(legajo));
                Sistema.lblServicio.setText(traedatos.TraeServicio(legajo));
                Sistema.lblEscalafon.setText(traedatos.TraeEscalafon(legajo));
                Sistema.lblAgrupamiento.setText(traedatos.TraeAgrupamiento(legajo));
                Sistema.lblFunReal.setText(traedatos.TraeFuncionReal(legajo));

            }

        } catch (SQLException e) {
            System.out.println("Metodo cargaDatosEmpleados - " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al consultar: " + e, "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

}
