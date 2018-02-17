/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Connection.Conexion;
import ModeloBD.Empleados;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

/**
 *
 * @author baci
 */
public class EmpleadosDatos extends Conexion {

    private final String SLQ_SELECT = "SELECT legajo, num_documento, apellido, nombre FROM empleados ORDER BY apellido";

    private QueryRunner QR = new QueryRunner();
    private List<Empleados> empleados;
    private String SQL = "";

    public List<Empleados> empleados() {

        try {

            empleados = (List<Empleados>) QR.query(getConn(), SLQ_SELECT, new BeanListHandler(Empleados.class));

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Error:" + ex);
        }

        return empleados;
    }

    public List<Empleados> empleados(String SQL) {

        try {

            empleados = (List<Empleados>) QR.query(getConn(), SQL, new BeanListHandler(Empleados.class));

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Error:" + ex);
        }

        return empleados;

    }

}
