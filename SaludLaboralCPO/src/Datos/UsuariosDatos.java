/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Connection.Conexion;
import ModeloBD.Articulos;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import ModeloBD.Usuarios;
import org.apache.commons.dbutils.QueryRunner;

/**
 *
 * @author baci
 */
public class UsuariosDatos extends Conexion {

    private QueryRunner QR = new QueryRunner();
    private List<Usuarios> usuarios;
    private String SQL = "";

    public List<Usuarios> usuarios() {
        try {
            usuarios = (List<Usuarios>) QR.query(getConn(), "SELECT * FROM usuarios",
                    new BeanListHandler(Usuarios.class));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error : " + ex);
        }
        return usuarios;
    }

}
