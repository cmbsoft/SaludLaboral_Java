/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Connection.Conexion;
import com.mysql.jdbc.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author baci
 */
public class TraeDatosBD {

    Conexion conexion = new Conexion();

    public String TraeRevistaActivaId(String legajo) throws SQLException {

        String SQL = "SELECT * FROM revista_empleados WHERE legajo='" + legajo + "' AND (fin_fecha='__/__/____' OR fin_fecha='____/__/__') LIMIT 1";

        Connection conecta = conexion.getConn();
        String id_revista_empleados;

        Statement comando = (Statement) conecta.createStatement();
        ResultSet registro = comando.executeQuery(SQL);

        if (registro.next() == true) {
            id_revista_empleados = registro.getString(1);
        } else {
            id_revista_empleados = "Falta ID Revista";
        }

        return id_revista_empleados;

    }

    public String TraeEscalafon(String legajo) throws SQLException {

        String IDR = "";

        IDR = TraeRevistaActivaId(legajo);

        String SQL = "SELECT escalafon FROM empleados_cargos WHERE id_revista=" + IDR;

        Conexion conexion = new Conexion();

        Connection conecta = conexion.getConn();
        String escalafon;

        Statement comando = (Statement) conecta.createStatement();
        ResultSet registro = comando.executeQuery(SQL);

        if (registro.next() == true) {
            escalafon = registro.getString(1);
        } else {
            escalafon = "Falta Escalafon";
        }

        return escalafon;

    }

    public String TraeRevistaNombre(String legajo) throws SQLException {

        String SQL = "SELECT * FROM revista WHERE id=(SELECT Id_revista FROM revista_empleados WHERE legajo='" + legajo + "' AND (fin_fecha='__/__/____' OR fin_fecha='____/__/__') LIMIT 1)";

        String IDR = "";

        //IDR = TraeRevistaActivaId(legajo);
        //String SQL = "SELECT * FROM revista WHERE id=" + IDR;
        Conexion conexion = new Conexion();

        Connection conecta = conexion.getConn();
        String revistanombre = null;

        Statement comando = (Statement) conecta.createStatement();

        try {
            ResultSet registro = comando.executeQuery(SQL);

            if (registro.next() == true) {
                revistanombre = registro.getString("Nombre");
            } else {
                revistanombre = "Falta Revista";
            }

        } catch (SQLException e) {
            System.err.println("Error: " + e);
        }

        return revistanombre;
    }

    public String TraeServicio(String legajo) throws SQLException {

        String IDR = "";

        String SQL = "SELECT nombre_servicio FROM empleados_servicios LEFT JOIN servicios ON servicios.cod_servicio = empleados_servicios.cod_servicio WHERE legajo =" + legajo;

        Conexion conexion = new Conexion();

        Connection conecta = conexion.getConn();
        String servicio;

        Statement comando = (Statement) conecta.createStatement();
        ResultSet registro = comando.executeQuery(SQL);

        if (registro.next() == true) {
            servicio = registro.getString(1);
        } else {
            servicio = "Falta Servicio";
        }

        return servicio;

    }

    public String TraeAgrupamiento(String legajo) throws SQLException {

        String SQL = "SELECT DepartamentoNombre FROM departamentos "
                + "WHERE departamentos.id=( SELECT agrupamiento FROM empleados_cargos  "
                + "WHERE empleados_cargos.id_revista=(SELECT revista_empleados.id FROM revista_empleados  "
                + "WHERE legajo='" + legajo + "' AND (fin_fecha='__/__/____' OR fin_fecha='____/__/__') LIMIT 1) LIMIT 1)";

        Conexion conexion = new Conexion();

        Connection conecta = conexion.getConn();
        String agrupamiento;

        Statement comando = (Statement) conecta.createStatement();
        ResultSet registro = comando.executeQuery(SQL);

        if (registro.next() == true) {
            agrupamiento = registro.getString(1);
        } else {
            agrupamiento = "Falta Agrupamiento";
        }

        return agrupamiento;

    }

    public String TraeFuncionReal(String legajo) throws SQLException {

        String SQL = "SELECT f_real FROM empleados_servicios LEFT JOIN servicios "
                + "ON servicios.cod_servicio = empleados_servicios.cod_servicio WHERE legajo ='" + legajo + "'";

        Conexion conexion = new Conexion();

        Connection conecta = conexion.getConn();
        String funcionreal;

        Statement comando = (Statement) conecta.createStatement();
        ResultSet registro = comando.executeQuery(SQL);

        if (registro.next() == true) {
            funcionreal = registro.getString(1);
        } else {
            funcionreal = "Falta Función Real";
        }

        return funcionreal;

    }

    public String TraeLocalidadEmpleado(String legajo) throws SQLException {

        String SQL = "SELECT lnombre FROM localidades LEFT JOIN empleados ON empleados.codigo=localidades.codigo  WHERE legajo='" + legajo + "'";

        Conexion conexion = new Conexion();

        Connection conecta = conexion.getConn();
        String localidadEmpleado;

        Statement comando = (Statement) conecta.createStatement();
        ResultSet registro = comando.executeQuery(SQL);

        if (registro.next() == true) {
            localidadEmpleado = registro.getString(1);
        } else {
            localidadEmpleado = "Falta Localidad Empleado";
        }

        return localidadEmpleado;

    }

}
