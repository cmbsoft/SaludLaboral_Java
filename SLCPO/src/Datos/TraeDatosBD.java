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
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author baci
 */
public class TraeDatosBD {

    Conexion conexion = new Conexion();
    // private List<Usuarios> usuarios;
    //private QueryRunner QR = new QueryRunner();

    public String TraeRevistaActivaId(String legajo) throws SQLException {

        String SQL = "SELECT * FROM revista_empleados WHERE legajo='" + legajo + "' AND (fin_fecha='__/__/____' OR fin_fecha='____/__/__') LIMIT 1";

        Connection conecta = conexion.getConn();
        String id_revista_empleados;

        Statement comando = (Statement) conecta.createStatement();
        ResultSet registro = comando.executeQuery(SQL);

        if (registro.next() == true) {
            id_revista_empleados = registro.getString(1);
        } else {
            id_revista_empleados = "0";
        }

        return id_revista_empleados;

    }

    public String TraeEscalafon(String legajo) throws SQLException {

        String IDR = "";

        IDR = TraeRevistaActivaId(legajo);
        System.out.println("Hola");

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

    public String TraeIdArticulo(String descripcion) throws SQLException {

        String SQL = "SELECT IdArticulo FROM articulos  WHERE Des='" + descripcion + "'";

        Conexion conexion = new Conexion();

        Connection conecta = conexion.getConn();
        String idarticulo;

        Statement comando = (Statement) conecta.createStatement();
        ResultSet registro = comando.executeQuery(SQL);

        if (registro.next() == true) {
            idarticulo = registro.getString(1);
        } else {
            idarticulo = "No se encuenta el IdArticulo";
        }

        return idarticulo;
    }

    public String HabilesCorridos(String IdArticulo) throws SQLException {
        String tipo = null;

        String SQL = "SELECT dias FROM articulos  WHERE IdArticulo='" + IdArticulo + "'";

        Conexion conexion = new Conexion();

        Connection conecta = conexion.getConn();

        Statement comando = (Statement) conecta.createStatement();
        ResultSet registro = comando.executeQuery(SQL);

        if (registro.next() == true) {
            tipo = registro.getString(1);
        } else {
            tipo = "No se encuenta el tipo de dias";
        }

        return tipo;
    }

    public int cantidadFeriados(String Desde, String Hasta) throws SQLException {
        int cantferiados = 0;
        String SQL;

        SQL = "SELECT COUNT(fecha) frOM `feriados` WHERE fecha BETWEEN '" + Desde + "' AND '" + Hasta + "'";

        Conexion conexion = new Conexion();

        Connection conecta = conexion.getConn();

        Statement comando = (Statement) conecta.createStatement();
        ResultSet registro = comando.executeQuery(SQL);

        if (registro.next() == true) {
            cantferiados = registro.getInt(1);
        } else {
            cantferiados = 0;
        }

        return cantferiados;
    }

    public int cantidadFrancos(String desde, String hasta, String legajo) throws SQLException {
        int cantfrancos = 0;
        String SQL;

        SQL = "Select COUNT(IdArticulo) from empleados_francos where legajo='" + legajo + "' "
                + "AND Desde BETWEEN '" + desde + "' AND '" + hasta + "' ";

        Conexion conexion = new Conexion();

        Connection conecta = conexion.getConn();

        Statement comando = (Statement) conecta.createStatement();
        ResultSet registro = comando.executeQuery(SQL);

        if (registro.next() == true) {
            cantfrancos = registro.getInt(1);
        } else {
            cantfrancos = 0;
        }

        return cantfrancos;
    }

    public boolean existenArt(String desde, String hasta, String legajo) throws SQLException {
        boolean existen = false;
        String SQL;

        SQL = "Select * FROM empleados_articulos Where legajo='" + legajo + "' AND Desde BETWEEN '" + desde + "' AND '" + hasta + "' AND baja=0";

        Conexion conexion = new Conexion();

        Connection conecta = conexion.getConn();

        Statement comando = (Statement) conecta.createStatement();
        ResultSet registro = comando.executeQuery(SQL);

        if (registro.next() == true) {
            existen = true;
        } else {
            existen = false;
        }

        return existen;
    }

    public int diasAnual(String IdArticulo) throws SQLException {
        int cantAnual = 0;

        String SQL = "SELECT cant_anio FROM articulos  WHERE IdArticulo='" + IdArticulo + "'";

        Conexion conexion = new Conexion();

        Connection conecta = conexion.getConn();

        Statement comando = (Statement) conecta.createStatement();
        ResultSet registro = comando.executeQuery(SQL);

        if (registro.next() == true) {
            cantAnual = registro.getInt(1);
        } else {
            cantAnual = 0;
        }

        return cantAnual;
    }

    public int diasMes(String IdArticulo) throws SQLException {
        int cantMes = 0;

        String SQL = "SELECT cant_mes FROM articulos  WHERE IdArticulo='" + IdArticulo + "'";

        Conexion conexion = new Conexion();

        Connection conecta = conexion.getConn();

        Statement comando = (Statement) conecta.createStatement();
        ResultSet registro = comando.executeQuery(SQL);

        if (registro.next() == true) {
            cantMes = registro.getInt(1);
        } else {
            cantMes = 0;
        }

        return cantMes;
    }

    public int diasCarrera(String IdArticulo) throws SQLException {
        int cantCarrera = 0;

        String SQL = "SELECT cant_carrera FROM articulos  WHERE IdArticulo='" + IdArticulo + "'";

        Conexion conexion = new Conexion();

        Connection conecta = conexion.getConn();

        Statement comando = (Statement) conecta.createStatement();
        ResultSet registro = comando.executeQuery(SQL);

        if (registro.next() == true) {
            cantCarrera = registro.getInt(1);
        } else {
            cantCarrera = 0;
        }

        return cantCarrera;
    }

    public int empleadoDiasCarreraArt(String IdArticulo, String legajo) throws SQLException {
        int cantCarrera = 0;

        String SQL = "SELECT SUM(Cantidad) FROM `empleados_articulos` WHERE IdArticulo='" + IdArticulo + "' AND legajo='" + legajo + "'";

        Conexion conexion = new Conexion();

        Connection conecta = conexion.getConn();

        Statement comando = (Statement) conecta.createStatement();
        ResultSet registro = comando.executeQuery(SQL);

        if (registro.next() == true) {
            cantCarrera = registro.getInt(1);
        } else {
            cantCarrera = 0;
        }

        return cantCarrera;

    }

    public int empleadoDiasAnioArt(String IdArticulo, String legajo) throws SQLException {
        int cant = 0;

        String SQL = "SELECT SUM(Cantidad) FROM `empleados_articulos` WHERE IdArticulo='" + IdArticulo + "' AND legajo='" + legajo + "'";

        Conexion conexion = new Conexion();

        Connection conecta = conexion.getConn();

        Statement comando = (Statement) conecta.createStatement();
        ResultSet registro = comando.executeQuery(SQL);

        if (registro.next() == true) {
            cant = registro.getInt(1);
        } else {
            cant = 0;
        }

        return cant;

    }

    public int empleadoDiasMesArt(String IdArticulo, String legajo) throws SQLException {
        int cant = 0;

        String SQL = "SELECT SUM(Cantidad) FROM `empleados_articulos` WHERE IdArticulo='" + IdArticulo + "' AND legajo='" + legajo + "'";

        Conexion conexion = new Conexion();

        Connection conecta = conexion.getConn();

        Statement comando = (Statement) conecta.createStatement();
        ResultSet registro = comando.executeQuery(SQL);

        if (registro.next() == true) {
            cant = registro.getInt(1);
        } else {
            cant = 0;
        }

        return cant;

    }

}

/// FIN !!!!!!!!!!!!
