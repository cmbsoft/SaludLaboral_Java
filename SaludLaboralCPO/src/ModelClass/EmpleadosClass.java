/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelClass;

//import Datos.EmpleadosDatos;
import Datos.EmpleadosDatos;
import ModeloBD.Empleados;
import Presentacion.Sistema;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import Datos.TraeDatosBD;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import Logica.FuncionesPropias;
import Logica.FuncionesPropias;
/**
 *
 * @author baci
 */
public class EmpleadosClass extends EmpleadosDatos {

    private DefaultTableModel modelo;
    private List<Empleados> empleados, empleadosFilter;
    private String legajo;
    private String sql;
    private Object[] object;
    private String SQL = "";

    public List<Empleados> getEmpleadoses() {

        return empleados();
    }

    public void searchEmpleado(JTable table, String campo, int num_registro, int reg_por_pagina, int baja) {

        String[] registros = new String[10];
        String[] titulos = {"Legajo", "Apellido y Nombre", "Sexo"};
        modelo = new DefaultTableModel(null, titulos);

        if (baja == 1) {
            SQL = "SELECT legajo, num_documento, apellido, nombre, sexo FROM empleados WHERE baja=1 ORDER BY apellido";
        } else {
            SQL = "SELECT legajo, num_documento, apellido, nombre, sexo FROM empleados WHERE baja=0 ORDER BY apellido";
        }

        empleados = empleados(SQL);

        if (campo.equals("")) {

            empleadosFilter = empleados.stream()
                    .skip(num_registro).limit(reg_por_pagina)
                    .collect(Collectors.toList());
        } else {

            empleadosFilter = (List<Empleados>) empleados.stream()
                    .filter(C -> C.getLegajo().startsWith(campo) || C.getApellido().startsWith(campo) || C.getNombre().startsWith(campo))
                    .skip(num_registro).limit(reg_por_pagina)
                    .collect(Collectors.toList());

        }

        empleadosFilter.forEach(item -> {
            registros[0] = item.getLegajo();
            registros[1] = item.getApellido() + ", " + item.getNombre();
            registros[2] = item.getSexo();
            modelo.addRow(registros);

        });

        table.setModel(modelo);
        table.getColumnModel().getColumn(0).setPreferredWidth(200);
        table.getColumnModel().getColumn(1).setPreferredWidth(500);
        table.getColumnModel().getColumn(2).setPreferredWidth(200);
        //table.setRowHeight(30);

    }

    public void cargaDatosEmpleados(String legajo) throws SQLException {

        SQL = "SELECT * FROM empleados where legajo='" + legajo + "'";

        empleados = empleados(SQL);
        TraeDatosBD traedatos = new TraeDatosBD();

        FuncionesPropias fechaformato = new FuncionesPropias();

        Sistema.lblApellido.setText(empleados.get(0).getApellido());
        Sistema.lblNombre.setText(empleados.get(0).getNombre());
        Sistema.lblDNI.setText(empleados.get(0).getNum_documento());
        Sistema.LblLocalidad.setText(traedatos.TraeLocalidadEmpleado(legajo));
        Sistema.lblCP.setText(empleados.get(0).getCodigopostal());
        Sistema.lblDireccion.setText(empleados.get(0).getDomicilio());
        Sistema.lblTelefono.setText(empleados.get(0).getTelefono());
        Sistema.lblMovil.setText(empleados.get(0).getTelmovil());
        Sistema.lblFecNac.setText(fechaformato.dFechaddmmyyyy(empleados.get(0).getFecha_nacimiento()));
        Sistema.lblEdad.setText(FuncionesPropias.getEdad(empleados.get(0).getFecha_nacimiento()));
        Sistema.lblCarpMed.setText(empleados.get(0).getCarp_medica());
        Sistema.lblAptitud.setText(empleados.get(0).getAptitud());
        Sistema.lblEstCivil.setText(empleados.get(0).getEstado_civil());
        Sistema.lblCUIL.setText(empleados.get(0).getCuil());
        Sistema.lblMail.setText(empleados.get(0).getMail());

        Sistema.lblDecNomb.setText(empleados.get(0).getDecreto_nom());

        Sistema.lblRevista.setText(traedatos.TraeRevistaNombre(legajo));
        Sistema.lblServicio.setText(traedatos.TraeServicio(legajo));
        Sistema.lblEscalafon.setText(traedatos.TraeEscalafon(legajo));
        Sistema.lblAgrupamiento.setText(traedatos.TraeAgrupamiento(legajo));
        Sistema.lblFunReal.setText(traedatos.TraeFuncionReal(legajo));

    }

}
