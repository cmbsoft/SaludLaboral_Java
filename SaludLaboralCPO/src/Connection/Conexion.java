/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connection;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author baci
 */
public class Conexion {

    private String db = "personaldb";
    private String user = "root";
    private String password = "baci2508";
    private String url = "jdbc:mysql://192.168.10.63/" + db;
    private Connection conn = null;

    public Conexion() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(this.url, this.user, this.password);

            if (conn != null) {
                System.out.println("La conexión a la base de datos " + this.db + "... Exitosa");

            }

        } catch (Exception ex) {
            System.out.println(" Error conexión a la base de datos: " + ex + ".... :( ");
        }

    }

    public Connection getConn() {
        return conn;
    }

    public static void closeRS(ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    }

    public static void closePS(PreparedStatement stmt) {
        try {
            if (stmt != null) {
                stmt.close();
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    }
//Cierre de la conexion

    public static void close(Connection conn) {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    }

}
