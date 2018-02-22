/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Connection.Conexion;
import ModeloBD.Empleados;
import ModeloBD.Articulos;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

/**
 *
 * @author bacinet
 */
public class ArticulosDatos extends Conexion {

    private final String SLQ_SELECT = "SELECT legajo, num_documento, apellido, nombre FROM empleados ORDER BY apellido";

    private QueryRunner QR = new QueryRunner();
    private List<Articulos> articulos;
    private String SQL = "";

    public List<Articulos> articulos() {

        try {

            articulos = (List<Articulos>) QR.query(getConn(), SLQ_SELECT, new BeanListHandler(Articulos.class));

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Error:" + ex);
        }

        return articulos;
    }

    public List<Articulos> articulos(String SQL) {

        try {

            articulos = (List<Articulos>) QR.query(getConn(), SQL, new BeanListHandler(Articulos.class));

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Error:" + ex);
        }

        return articulos;

    }

}
