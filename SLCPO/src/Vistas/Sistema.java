/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

//import Datos.DatosEmpleados;
//import Datos.DatosArticulos;
//import Datos.TraeDatosBD;
//import Datos.DatosEmpleadosArt;
//import Datos.DatosFichadas;
//import Datos.DatosFrancos;
//import Datos.DatosFeriados;
import Datos.*;
import Logica.FuncionesPropias;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.Color;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Year;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author baci
 */
public class Sistema extends javax.swing.JFrame {

    DatosEmpleados cargaDatosEmp = new DatosEmpleados();
    DatosArticulos cargaDatosArt = new DatosArticulos();
    FuncionesPropias funcionesp = new FuncionesPropias();
    TraeDatosBD traedatos = new TraeDatosBD();
    DatosEmpleadosArt empleadosArt = new DatosEmpleadosArt();
    DatosFichadas cargaFichadas = new DatosFichadas();
    DatosFrancos cargaFrancos = new DatosFrancos();
    DatosFeriados cargaFeriados = new DatosFeriados();
    DatosDNL cargaDLN = new DatosDNL();

    String SQL = null;
    String cLegajo = null;

    public Sistema() {
        initComponents();

        this.setIconImage(new ImageIcon(getClass().getResource("/Archivos/group.png")).getImage());
        jTabbedPane2.setIconAt(0, new ImageIcon(getClass().getResource("/Archivos/group.png")));
        jTabbedPane2.setIconAt(1, new ImageIcon(getClass().getResource("/Archivos/articulo_add.png")));
        jTabbedPane2.setIconAt(2, new ImageIcon(getClass().getResource("/Archivos/certificado_add.png")));
        jTabbedPane2.setIconAt(3, new ImageIcon(getClass().getResource("/Archivos/certifica.png")));
        //jTabbedPane2

        cboAnio.setSelectedIndex(0);

        opActivo.setSelected(true);
        this.setLocationRelativeTo(null);

        cargaDatosEmp.cargaTabla(buscaEmpleado(), tablaEmpleados);

        Date date = new Date();

        dtDesde.setDate(date);
        dtHasta.setDate(date);

        cargaDatosArt.cargaArtCombo(cboArticulos);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        String Anio = sdf.format(date);
        funcionesp.cargaComboAnios(Integer.parseInt(Anio), cboAnio);
        funcionesp.cargaMesActual(cboMes);

        //   cargaFichadas.cargaTablaFichadas(buscaFichadas(), tablaControlAsis);
    }

    public String buscaEmpleado() {
        //String SQL = null;

        if (txtBuscar.getText().equals("")) {
            if (opActivo.isSelected()) {
                SQL = "SELECT legajo, num_documento, apellido, nombre, sexo FROM empleados WHERE baja=0 ORDER BY apellido";
            } else {
                SQL = "SELECT legajo, num_documento, apellido, nombre, sexo FROM empleados WHERE baja=1 ORDER BY apellido";
            }

        } else {
            if (opActivo.isSelected()) {

                SQL = "SELECT legajo, num_documento, apellido, nombre, sexo FROM empleados WHERE baja=0 "
                        + "AND (legajo LIKE '%" + txtBuscar.getText() + "%' OR Nombre LIKE '%" + txtBuscar.getText() + "%' "
                        + "OR Apellido LIKE '%" + txtBuscar.getText() + "%') ORDER BY apellido";

            } else {

                SQL = "SELECT legajo, num_documento, apellido, nombre, sexo FROM empleados WHERE baja=1 "
                        + "AND (legajo like'%" + txtBuscar.getText() + "%' OR Nombre like'%" + txtBuscar.getText() + "%' "
                        + "OR Apellido like '%" + txtBuscar.getText() + "%') ORDER BY apellido";

            }
        }
        return SQL;
    }

    private String buscaFichadas() {

        int anioSeleccionado = 0;
        //String mesSeleccionado = cboMes.getSelectedItem().toString();
        int mesnumero = FuncionesPropias.mesNumero(cboMes.getSelectedItem().toString());

        if (cboAnio.getItemCount() != 0) {

            anioSeleccionado = Integer.parseInt(cboAnio.getSelectedItem().toString());
        }

        String ultimoDia = FuncionesPropias.ultimoDiaMes(mesnumero, anioSeleccionado);
        String primerDia = FuncionesPropias.primerDiaMes(mesnumero, anioSeleccionado);

        SQL = "SELECT fecha, hora, TipoHora, tipo FROM `temporalbajadatos` WHERE `temporalbajadatos`.`fecha` "
                + "BETWEEN '" + primerDia + "' AND '" + ultimoDia + "' AND tarjeta=(SELECT nro_tarjeta FROM tarjetas_empleados "
                + "WHERE legajo='" + cLegajo + "' AND ISNULL(fecha_baja_tarjeta)) ORDER BY fecha, tipo";

        return SQL;
    }

    private String buscaFrancos() {

        int anioSeleccionado = 0;
        //String mesSeleccionado = cboMes.getSelectedItem().toString();
        int mesnumero = FuncionesPropias.mesNumero(cboMes.getSelectedItem().toString());

        if (cboAnio.getItemCount() != 0) {

            anioSeleccionado = Integer.parseInt(cboAnio.getSelectedItem().toString());
        }

        String ultimoDia = FuncionesPropias.ultimoDiaMes(mesnumero, anioSeleccionado);
        String primerDia = FuncionesPropias.primerDiaMes(mesnumero, anioSeleccionado);

        SQL = "Select Desde from empleados_francos where legajo='" + cLegajo + "' "
                + "AND Desde BETWEEN '" + primerDia + "' AND '" + ultimoDia + "' ";

        return SQL;
    }

    private String buscaDNL() {

        int anioSeleccionado = 0;
        //String mesSeleccionado = cboMes.getSelectedItem().toString();
        int mesnumero = FuncionesPropias.mesNumero(cboMes.getSelectedItem().toString());

        if (cboAnio.getItemCount() != 0) {

            anioSeleccionado = Integer.parseInt(cboAnio.getSelectedItem().toString());
        }

        String ultimoDia = FuncionesPropias.ultimoDiaMes(mesnumero, anioSeleccionado);
        String primerDia = FuncionesPropias.primerDiaMes(mesnumero, anioSeleccionado);

        SQL = "Select * from empleados_dnt where legajo='" + cLegajo + "' "
                + "AND Desde BETWEEN '" + primerDia + "' AND '" + ultimoDia + "' "
                + "AND Hasta BETWEEN '" + primerDia + "' AND '" + ultimoDia + "' ";

        //SQL = "SELECT * frOM `feriados` WHERE fecha BETWEEN '" + primerDia + "' AND '" + ultimoDia + "'";
        return SQL;
    }

    private String buscaFeriados() {

        int anioSeleccionado = 0;
        //String mesSeleccionado = cboMes.getSelectedItem().toString();
        int mesnumero = FuncionesPropias.mesNumero(cboMes.getSelectedItem().toString());

        if (cboAnio.getItemCount() != 0) {

            anioSeleccionado = Integer.parseInt(cboAnio.getSelectedItem().toString());
        }

        String ultimoDia = FuncionesPropias.ultimoDiaMes(mesnumero, anioSeleccionado);
        String primerDia = FuncionesPropias.primerDiaMes(mesnumero, anioSeleccionado);

        SQL = "SELECT * frOM `feriados` WHERE fecha BETWEEN '" + primerDia + "' AND '" + ultimoDia + "'";

        return SQL;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        txtBuscar = new javax.swing.JTextField();
        opPasivo = new javax.swing.JRadioButton();
        opActivo = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaEmpleados = new javax.swing.JTable();
        btSeleccionar = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lblLegajo = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblApellido = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        lblDNI = new javax.swing.JLabel();
        lblFecNac = new javax.swing.JLabel();
        lblDireccion = new javax.swing.JLabel();
        LblLocalidad = new javax.swing.JLabel();
        lblCP = new javax.swing.JLabel();
        lblTelefono = new javax.swing.JLabel();
        lblMovil = new javax.swing.JLabel();
        lblCarpMed = new javax.swing.JLabel();
        lblAptitud = new javax.swing.JLabel();
        lblEstCivil = new javax.swing.JLabel();
        lblCUIL = new javax.swing.JLabel();
        lblMail = new javax.swing.JLabel();
        lblDecNomb = new javax.swing.JLabel();
        lblRevista = new javax.swing.JLabel();
        lblServicio = new javax.swing.JLabel();
        lblEscalafon = new javax.swing.JLabel();
        lblAgrupamiento = new javax.swing.JLabel();
        lblFunReal = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        lblEdad = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        cboArticulos = new javax.swing.JComboBox<>();
        jLabel25 = new javax.swing.JLabel();
        dtDesde = new com.toedter.calendar.JDateChooser();
        jLabel26 = new javax.swing.JLabel();
        dtHasta = new com.toedter.calendar.JDateChooser();
        jLabel27 = new javax.swing.JLabel();
        txtDias = new javax.swing.JTextField();
        btGuardar = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaHistArtTodos = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        tablaHistArt = new javax.swing.JTable();
        lblArticuloSelec = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel12 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaControlAsis = new javax.swing.JTable();
        cboMes = new javax.swing.JComboBox<>();
        cboAnio = new javax.swing.JComboBox<>();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tablaFrancos = new javax.swing.JTable();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tablaFeriados = new javax.swing.JTable();
        jLabel32 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tablaDNL = new javax.swing.JTable();
        jLabel37 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        lblLegajo1 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        lblNombre1 = new javax.swing.JLabel();
        lblApellido1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema");
        getContentPane().setLayout(new javax.swing.OverlayLayout(getContentPane()));

        jTabbedPane2.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jTabbedPane2StateChanged(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(78, 165, 23), 2, true), "Buscar empleado"));

        txtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarActionPerformed(evt);
            }
        });
        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBuscarKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });

        buttonGroup1.add(opPasivo);
        opPasivo.setText("Pasivos");
        opPasivo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                opPasivoMouseClicked(evt);
            }
        });

        buttonGroup1.add(opActivo);
        opActivo.setText("Activos");
        opActivo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        opActivo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                opActivoMouseClicked(evt);
            }
        });

        jLabel1.setText("Buscar:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(opActivo)
                        .addGap(27, 27, 27)
                        .addComponent(opPasivo)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(opActivo)
                    .addComponent(opPasivo))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(78, 165, 23), 2, true));

        tablaEmpleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Legajo", "Apellido y Nombre"
            }
        ));
        tablaEmpleados.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tablaEmpleadosKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tablaEmpleados);

        btSeleccionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Archivos/accept.png"))); // NOI18N
        btSeleccionar.setText("Seleccionar");
        btSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSeleccionarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btSeleccionar, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addGap(18, 18, 18)
                .addComponent(btSeleccionar)
                .addContainerGap())
        );

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(78, 165, 23), 2, true), "Empleado seleccionado"));

        jLabel2.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(9, 146, 231));
        jLabel2.setText("Legajo:");

        lblLegajo.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        lblLegajo.setForeground(new java.awt.Color(81, 186, 109));
        lblLegajo.setText("..");

        jLabel3.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(9, 146, 231));
        jLabel3.setText("Apellido:");

        jLabel23.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(9, 146, 231));
        jLabel23.setText("Nombre:");

        lblNombre.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        lblNombre.setForeground(new java.awt.Color(81, 186, 109));
        lblNombre.setText("..");

        lblApellido.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        lblApellido.setForeground(new java.awt.Color(81, 186, 109));
        lblApellido.setText("..");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel23)
                        .addGap(18, 18, 18)
                        .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblLegajo, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(242, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lblLegajo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lblApellido))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(78, 165, 23), 2, true));
        jPanel7.setForeground(new java.awt.Color(255, 255, 255));
        jPanel7.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(247, 165, 41));
        jLabel4.setText("DNI:");

        jLabel5.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(247, 165, 41));
        jLabel5.setText("Fecha de Nac:");

        jLabel6.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(247, 165, 41));
        jLabel6.setText("Dirección:");

        jLabel7.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(247, 165, 41));
        jLabel7.setText("Localidad:");

        jLabel8.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(247, 165, 41));
        jLabel8.setText("CP:");

        jLabel9.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(247, 165, 41));
        jLabel9.setText("Teléfono:");

        jLabel10.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(247, 165, 41));
        jLabel10.setText("Móvil:");

        jLabel11.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(247, 165, 41));
        jLabel11.setText("Carpeta Médica:");

        jLabel12.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(247, 165, 41));
        jLabel12.setText("Aptitud:");

        jLabel13.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(247, 165, 41));
        jLabel13.setText("Estado Civil:");

        jLabel14.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(247, 165, 41));
        jLabel14.setText("CUIL:");

        jLabel15.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(247, 165, 41));
        jLabel15.setText("Mail:");

        jLabel16.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(247, 165, 41));
        jLabel16.setText("Dto Nombramiento:");

        jLabel17.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(247, 165, 41));
        jLabel17.setText("Revista:");

        jLabel18.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(247, 165, 41));
        jLabel18.setText("Servicio:");

        jLabel19.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(247, 165, 41));
        jLabel19.setText("Escalafon:");

        jLabel20.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(247, 165, 41));
        jLabel20.setText("Agrupamiento:");

        jLabel21.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(247, 165, 41));
        jLabel21.setText("Función Real:");

        lblDNI.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        lblDNI.setForeground(new java.awt.Color(53, 114, 25));
        lblDNI.setText("..");

        lblFecNac.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        lblFecNac.setForeground(new java.awt.Color(53, 114, 25));
        lblFecNac.setText("..");

        lblDireccion.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        lblDireccion.setForeground(new java.awt.Color(53, 114, 25));
        lblDireccion.setText("..");

        LblLocalidad.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        LblLocalidad.setForeground(new java.awt.Color(53, 114, 25));
        LblLocalidad.setText("..");

        lblCP.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        lblCP.setForeground(new java.awt.Color(53, 114, 25));
        lblCP.setText("..");

        lblTelefono.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        lblTelefono.setForeground(new java.awt.Color(53, 114, 25));
        lblTelefono.setText("..");

        lblMovil.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        lblMovil.setForeground(new java.awt.Color(53, 114, 25));
        lblMovil.setText("..");

        lblCarpMed.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        lblCarpMed.setForeground(new java.awt.Color(53, 114, 25));
        lblCarpMed.setText("..");

        lblAptitud.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        lblAptitud.setForeground(new java.awt.Color(53, 114, 25));
        lblAptitud.setText("..");

        lblEstCivil.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        lblEstCivil.setForeground(new java.awt.Color(53, 114, 25));
        lblEstCivil.setText("..");

        lblCUIL.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        lblCUIL.setForeground(new java.awt.Color(53, 114, 25));
        lblCUIL.setText("..");

        lblMail.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        lblMail.setForeground(new java.awt.Color(53, 114, 25));
        lblMail.setText("..");

        lblDecNomb.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        lblDecNomb.setForeground(new java.awt.Color(53, 114, 25));
        lblDecNomb.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblDecNomb.setText("..");

        lblRevista.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        lblRevista.setForeground(new java.awt.Color(53, 114, 25));
        lblRevista.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblRevista.setText("..");

        lblServicio.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        lblServicio.setForeground(new java.awt.Color(53, 114, 25));
        lblServicio.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblServicio.setText("..");

        lblEscalafon.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        lblEscalafon.setForeground(new java.awt.Color(53, 114, 25));
        lblEscalafon.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblEscalafon.setText("..");

        lblAgrupamiento.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        lblAgrupamiento.setForeground(new java.awt.Color(53, 114, 25));
        lblAgrupamiento.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblAgrupamiento.setText("..");

        lblFunReal.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        lblFunReal.setForeground(new java.awt.Color(53, 114, 25));
        lblFunReal.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblFunReal.setText("..");

        jLabel22.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(247, 165, 41));
        jLabel22.setText("Edad:");

        lblEdad.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        lblEdad.setForeground(new java.awt.Color(53, 114, 25));
        lblEdad.setText("..");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel15))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblAptitud)
                                    .addComponent(lblEstCivil)
                                    .addComponent(lblCUIL)
                                    .addComponent(lblMail)
                                    .addComponent(lblCarpMed, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel22)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblEdad, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(112, 112, 112)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel9)
                                .addGroup(jPanel7Layout.createSequentialGroup()
                                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel6)
                                        .addComponent(jLabel7)
                                        .addComponent(jLabel8))
                                    .addGap(40, 40, 40)
                                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblDireccion)
                                        .addComponent(LblLocalidad)
                                        .addComponent(lblCP)
                                        .addComponent(lblTelefono)))
                                .addGroup(jPanel7Layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addGap(18, 18, 18)
                                    .addComponent(lblFecNac, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(jPanel7Layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addGap(72, 72, 72)
                                    .addComponent(lblDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(98, 98, 98)
                                .addComponent(lblMovil))
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addComponent(jLabel21)
                                        .addGap(9, 9, 9))
                                    .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                                        .addComponent(jLabel19)
                                        .addGap(26, 26, 26))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                                        .addComponent(jLabel18)
                                        .addGap(37, 37, 37))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                                        .addComponent(jLabel17)
                                        .addGap(39, 39, 39)))
                                .addGap(43, 43, 43)))
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblRevista, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblFunReal, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(lblAgrupamiento, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(lblEscalafon, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(lblServicio, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addComponent(lblDecNomb, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(253, 253, 253))))
        );

        jPanel7Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {lblAgrupamiento, lblDecNomb, lblEscalafon, lblFunReal, lblRevista, lblServicio});

        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblDNI)
                                .addComponent(jLabel4))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblFecNac, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(lblDireccion))
                                .addGap(14, 14, 14)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(LblLocalidad))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(lblCP))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(lblTelefono))))
                        .addGap(7, 7, 7)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(lblMovil)))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(lblDecNomb))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel18)
                                .addGap(14, 14, 14)
                                .addComponent(jLabel19)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel20)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel21))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(111, 111, 111)
                                .addComponent(lblFunReal))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(lblRevista)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblServicio)
                                .addGap(14, 14, 14)
                                .addComponent(lblEscalafon)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblAgrupamiento)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel22)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(lblCarpMed))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(lblAptitud))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addGap(14, 14, 14)
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel15))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(lblEstCivil)
                                .addGap(15, 15, 15)
                                .addComponent(lblCUIL)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblMail))))
                    .addComponent(lblEdad))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 118, Short.MAX_VALUE))
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 658, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 16, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jPanel2, jPanel8});

        jTabbedPane2.addTab("Empleado", jPanel1);

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(78, 165, 23), 2, true), "Ingreso de Artículos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 12), new java.awt.Color(78, 165, 23))); // NOI18N

        jLabel24.setForeground(new java.awt.Color(247, 165, 41));
        jLabel24.setText("Artículo:");

        cboArticulos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cboArticulosMouseClicked(evt);
            }
        });
        cboArticulos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboArticulosActionPerformed(evt);
            }
        });
        cboArticulos.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                cboArticulosPropertyChange(evt);
            }
        });

        jLabel25.setForeground(new java.awt.Color(247, 165, 41));
        jLabel25.setText("Desde:");

        dtDesde.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                dtDesdePropertyChange(evt);
            }
        });

        jLabel26.setForeground(new java.awt.Color(247, 165, 41));
        jLabel26.setText("Hasta:");

        dtHasta.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                dtHastaFocusLost(evt);
            }
        });
        dtHasta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                dtHastaMousePressed(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dtHastaMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                dtHastaMouseExited(evt);
            }
        });
        dtHasta.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                dtHastaPropertyChange(evt);
            }
        });

        jLabel27.setForeground(new java.awt.Color(247, 165, 41));
        jLabel27.setText("Cantidad de días:");

        txtDias.setEditable(false);
        txtDias.setText("1");

        btGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Archivos/disk.png"))); // NOI18N
        btGuardar.setText("Guardar");
        btGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel24)
                        .addGap(18, 18, 18)
                        .addComponent(cboArticulos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel25)
                        .addGap(27, 27, 27)
                        .addComponent(dtDesde, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel26)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dtHasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 6, Short.MAX_VALUE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel27)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDias, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)))
                .addContainerGap())
        );

        jPanel9Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {dtDesde, dtHasta});

        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(cboArticulos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel25)
                    .addComponent(jLabel26)
                    .addComponent(dtDesde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dtHasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel27)
                            .addComponent(txtDias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(btGuardar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(78, 165, 23), 2, true), "Historial del Artículos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 12), new java.awt.Color(78, 165, 23))); // NOI18N

        tablaHistArtTodos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(tablaHistArtTodos);

        tablaHistArt.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane4.setViewportView(tablaHistArt);

        lblArticuloSelec.setForeground(new java.awt.Color(247, 165, 41));
        lblArticuloSelec.setText("Historial Artículo seleccionado:");

        jLabel34.setForeground(new java.awt.Color(247, 165, 41));
        jLabel34.setText("Historial de todos los Artículos");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Archivos/delete.png"))); // NOI18N
        jButton1.setText("Eliminar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblArticuloSelec)
                    .addComponent(jLabel34)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 393, Short.MAX_VALUE)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addComponent(lblArticuloSelec)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jButton1)))
                .addGap(8, 8, 8)
                .addComponent(jLabel34)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(78, 165, 23), 2, true), "Control de Asistencia", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 12), new java.awt.Color(78, 165, 23))); // NOI18N

        tablaControlAsis.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tablaControlAsis);

        cboMes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Agosto", "Septiembre", "Noviembre", "Diciembre" }));
        cboMes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboMesActionPerformed(evt);
            }
        });

        cboAnio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1900", "1901" }));
        cboAnio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboAnioActionPerformed(evt);
            }
        });

        jLabel30.setForeground(new java.awt.Color(247, 165, 41));
        jLabel30.setText("Mes:");

        jLabel31.setForeground(new java.awt.Color(247, 165, 41));
        jLabel31.setText("Año:");

        tablaFrancos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane5.setViewportView(tablaFrancos);

        jLabel28.setForeground(new java.awt.Color(247, 165, 41));
        jLabel28.setText("Fichadas:");

        jLabel29.setForeground(new java.awt.Color(247, 165, 41));
        jLabel29.setText("Francos:");

        tablaFeriados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane6.setViewportView(tablaFeriados);

        jLabel32.setForeground(new java.awt.Color(247, 165, 41));
        jLabel32.setText("Feriados:");

        tablaDNL.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane7.setViewportView(tablaDNL);

        jLabel37.setForeground(new java.awt.Color(247, 165, 41));
        jLabel37.setText("DNL:");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel29)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jLabel30)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboMes, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel31)
                        .addGap(18, 18, 18)
                        .addComponent(cboAnio, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel28)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(jLabel37)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel30)
                    .addComponent(jLabel31)
                    .addComponent(cboAnio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(jLabel37))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel29)
                            .addComponent(jLabel32))
                        .addGap(3, 3, 3)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));
        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(78, 165, 23), 2, true), "Empleado seleccionado"));
        jPanel13.setPreferredSize(new java.awt.Dimension(540, 122));

        jLabel33.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(9, 146, 231));
        jLabel33.setText("Legajo:");

        lblLegajo1.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        lblLegajo1.setForeground(new java.awt.Color(81, 186, 109));
        lblLegajo1.setText("..");

        jLabel35.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(9, 146, 231));
        jLabel35.setText("Apellido:");

        jLabel36.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(9, 146, 231));
        jLabel36.setText("Nombre:");

        lblNombre1.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        lblNombre1.setForeground(new java.awt.Color(81, 186, 109));
        lblNombre1.setText("..");

        lblApellido1.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        lblApellido1.setForeground(new java.awt.Color(81, 186, 109));
        lblApellido1.setText("..");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jLabel36)
                        .addGap(18, 18, 18)
                        .addComponent(lblNombre1, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel35)
                            .addComponent(jLabel33))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblLegajo1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblApellido1, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(242, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33)
                    .addComponent(lblLegajo1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel35)
                    .addComponent(lblApellido1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNombre1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Artículos", jPanel3);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1157, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 658, Short.MAX_VALUE)
        );

        jTabbedPane2.addTab("Certificado", jPanel5);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1157, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 658, Short.MAX_VALUE)
        );

        jTabbedPane2.addTab("Justifica/Injustifica", jPanel6);

        getContentPane().add(jTabbedPane2);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarActionPerformed

    private void txtBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyPressed
        int key = evt.getKeyCode();
        if (key == KeyEvent.VK_ENTER) {
            tablaEmpleados.requestFocus();
        }
    }//GEN-LAST:event_txtBuscarKeyPressed

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased

        cargaDatosEmp.cargaTabla(buscaEmpleado(), tablaEmpleados);

    }//GEN-LAST:event_txtBuscarKeyReleased

    private void opPasivoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_opPasivoMouseClicked
        cargaDatosEmp.cargaTabla(buscaEmpleado(), tablaEmpleados);
    }//GEN-LAST:event_opPasivoMouseClicked

    private void opActivoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_opActivoMouseClicked

        cargaDatosEmp.cargaTabla(buscaEmpleado(), tablaEmpleados);

    }//GEN-LAST:event_opActivoMouseClicked

    private void tablaEmpleadosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tablaEmpleadosKeyPressed
//        int key = evt.getKeyCode();
//        if (key == KeyEvent.VK_ENTER) {
//            btSeleccionar.requestFocus();
//        }
    }//GEN-LAST:event_tablaEmpleadosKeyPressed

    private void btSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSeleccionarActionPerformed

        try {
            cLegajo = (String) tablaEmpleados.getValueAt(tablaEmpleados.getSelectedRow(), 0);

            System.out.println("Legajo seleccionado: --->" + cLegajo);

            lblLegajo.setText(cLegajo);
            lblLegajo1.setText(cLegajo);
            cargaDatosEmp.cargaDatosEmpleados(cLegajo);
            historialArt(cLegajo);
            cargaFichadas.cargaTablaFichadas(buscaFichadas(), tablaControlAsis);
            cargaFrancos.cargaTablaFrancos(buscaFrancos(), tablaFrancos);
            cargaFeriados.cargaTablaFeriados(buscaFeriados(), tablaFeriados);
            cargaDLN.cargaTablaDNL(buscaDNL(), tablaDNL);

        } catch (SQLException ex) {
            Logger.getLogger(Sistema.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btSeleccionarActionPerformed

    private void btGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGuardarActionPerformed

        cantidadDiasOK();

    }//GEN-LAST:event_btGuardarActionPerformed

    private void dtHastaPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_dtHastaPropertyChange

        txtDias.setText(String.valueOf(funcionesp.DifEntreFechas(dtDesde.getDate(), dtHasta.getDate())));
    }//GEN-LAST:event_dtHastaPropertyChange

    private void dtHastaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dtHastaMouseExited

    }//GEN-LAST:event_dtHastaMouseExited

    private void dtHastaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dtHastaMouseClicked

    }//GEN-LAST:event_dtHastaMouseClicked

    private void dtHastaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dtHastaMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_dtHastaMousePressed

    private void dtHastaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_dtHastaFocusLost

    }//GEN-LAST:event_dtHastaFocusLost

    private void dtDesdePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_dtDesdePropertyChange
        txtDias.setText(String.valueOf(funcionesp.DifEntreFechas(dtDesde.getDate(), dtHasta.getDate())));
    }//GEN-LAST:event_dtDesdePropertyChange

    private void cboArticulosPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_cboArticulosPropertyChange
        //        String itemSeleecionado = (String) cboArticulos.getSelectedItem();
        //        try {
        //            String IdArt = traedatos.TraeIdArticulo(itemSeleecionado);
        //        } catch (SQLException ex) {
        //            Logger.getLogger(Sistema.class.getName()).log(Level.SEVERE, null, ex);
        //        }
    }//GEN-LAST:event_cboArticulosPropertyChange

    private void cboArticulosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboArticulosActionPerformed
        historialArt(cLegajo);
        String itemSeleecionado = (String) cboArticulos.getSelectedItem();
        try {
            lblArticuloSelec.setText("Historial Artículo seleccionado: " + traedatos.TraeIdArticulo(itemSeleecionado));
        } catch (SQLException ex) {
            Logger.getLogger(Sistema.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cboArticulosActionPerformed

    private void cboArticulosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cboArticulosMouseClicked

        historialArt(cLegajo);
    }//GEN-LAST:event_cboArticulosMouseClicked

    private void cboMesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboMesActionPerformed

        cargaFichadas.cargaTablaFichadas(buscaFichadas(), tablaControlAsis);
        cargaFrancos.cargaTablaFrancos(buscaFrancos(), tablaFrancos);
        cargaFeriados.cargaTablaFeriados(buscaFeriados(), tablaFeriados);
        cargaDLN.cargaTablaDNL(buscaDNL(), tablaDNL);

    }//GEN-LAST:event_cboMesActionPerformed

    private void cboAnioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboAnioActionPerformed

        cargaFichadas.cargaTablaFichadas(buscaFichadas(), tablaControlAsis);
        cargaFrancos.cargaTablaFrancos(buscaFrancos(), tablaFrancos);
        cargaFeriados.cargaTablaFeriados(buscaFeriados(), tablaFeriados);
        cargaDLN.cargaTablaDNL(buscaDNL(), tablaDNL);

    }//GEN-LAST:event_cboAnioActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTabbedPane2StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jTabbedPane2StateChanged

        System.out.println(jTabbedPane2.getSelectedIndex());

        if (jTabbedPane2.getSelectedIndex() > 0) {
            if (cLegajo == null) {

                JOptionPane.showMessageDialog(null, "Debe seleccionar un empleado");
                jTabbedPane2.setSelectedIndex(0);
            }
        }

    }//GEN-LAST:event_jTabbedPane2StateChanged

    private void historialArt(String legajo) {
        String itemSeleecionado = (String) cboArticulos.getSelectedItem();
        String IdArt = null;

        try {
            IdArt = traedatos.TraeIdArticulo(itemSeleecionado);
        } catch (SQLException ex) {
            Logger.getLogger(Sistema.class.getName()).log(Level.SEVERE, null, ex);
        }

        SQL = "Select * from empleados_articulos where legajo='" + legajo + "' and IdArticulo='" + IdArt + "' ORDER BY Desde DESC";
        empleadosArt.cargaTabla(SQL, tablaHistArt);

        SQL = "Select * from empleados_articulos where legajo='" + legajo + "' ORDER BY Desde DESC";
        empleadosArt.cargaTabla(SQL, tablaHistArtTodos);

    }

    private boolean cantidadDiasOK() {
        boolean cantDiasOk = false;

        String tipoDia;
        int cantFeriados;
        int cantFrancos;
        boolean existenart;

        SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd");
        String desde = formato.format(dtDesde.getDate());
        String hasta = formato.format(dtHasta.getDate());
        String itemSeleecionado = (String) cboArticulos.getSelectedItem();

        try {
            tipoDia = traedatos.HabilesCorridos(traedatos.TraeIdArticulo(itemSeleecionado));
        } catch (SQLException ex) {
            Logger.getLogger(Sistema.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            cantFeriados = traedatos.cantidadFeriados(desde, hasta);
        } catch (SQLException ex) {
            Logger.getLogger(Sistema.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            cantFrancos = traedatos.cantidadFrancos(desde, hasta, cLegajo);
        } catch (SQLException ex) {
            Logger.getLogger(Sistema.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            existenart = traedatos.existenArt(desde, hasta, cLegajo);
        } catch (SQLException ex) {
            Logger.getLogger(Sistema.class.getName()).log(Level.SEVERE, null, ex);
        }

        return cantDiasOk;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Sistema.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Sistema.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Sistema.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Sistema.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Sistema().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JLabel LblLocalidad;
    private javax.swing.JButton btGuardar;
    private javax.swing.JButton btSeleccionar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cboAnio;
    private javax.swing.JComboBox<String> cboArticulos;
    private javax.swing.JComboBox<String> cboMes;
    private com.toedter.calendar.JDateChooser dtDesde;
    private com.toedter.calendar.JDateChooser dtHasta;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTabbedPane jTabbedPane2;
    public static javax.swing.JLabel lblAgrupamiento;
    public static javax.swing.JLabel lblApellido;
    public static javax.swing.JLabel lblApellido1;
    public static javax.swing.JLabel lblAptitud;
    private javax.swing.JLabel lblArticuloSelec;
    public static javax.swing.JLabel lblCP;
    public static javax.swing.JLabel lblCUIL;
    public static javax.swing.JLabel lblCarpMed;
    public static javax.swing.JLabel lblDNI;
    public static javax.swing.JLabel lblDecNomb;
    public static javax.swing.JLabel lblDireccion;
    public static javax.swing.JLabel lblEdad;
    public static javax.swing.JLabel lblEscalafon;
    public static javax.swing.JLabel lblEstCivil;
    public static javax.swing.JLabel lblFecNac;
    public static javax.swing.JLabel lblFunReal;
    public static javax.swing.JLabel lblLegajo;
    public static javax.swing.JLabel lblLegajo1;
    public static javax.swing.JLabel lblMail;
    public static javax.swing.JLabel lblMovil;
    public static javax.swing.JLabel lblNombre;
    public static javax.swing.JLabel lblNombre1;
    public static javax.swing.JLabel lblRevista;
    public static javax.swing.JLabel lblServicio;
    public static javax.swing.JLabel lblTelefono;
    private javax.swing.JRadioButton opActivo;
    private javax.swing.JRadioButton opPasivo;
    private javax.swing.JTable tablaControlAsis;
    private javax.swing.JTable tablaDNL;
    private javax.swing.JTable tablaEmpleados;
    private javax.swing.JTable tablaFeriados;
    private javax.swing.JTable tablaFrancos;
    private javax.swing.JTable tablaHistArt;
    private javax.swing.JTable tablaHistArtTodos;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtDias;
    // End of variables declaration//GEN-END:variables
}
