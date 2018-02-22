/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author baci
 */
public class Sistema extends javax.swing.JFrame {

    /**
     * Creates new form Sistema
     */
    public Sistema() {
        initComponents();
        lblNotificacion.setText("Sistema");

        this.setLocationRelativeTo(null);
        this.setIconImage(new ImageIcon(getClass().getResource("/Archivos/group.png")).getImage());

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btArticulo = new javax.swing.JButton();
        btCertificado = new javax.swing.JButton();
        btJusticacion = new javax.swing.JButton();
        btEmpleado = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblLegajo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblApellido = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
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
        lblNotificacion = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(30, 129, 53), 1, true));
        jPanel1.setForeground(new java.awt.Color(254, 254, 254));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(30, 129, 53), 1, true));

        btArticulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Archivos/articulo_add.png"))); // NOI18N
        btArticulo.setText("Articulo");
        btArticulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btArticuloActionPerformed(evt);
            }
        });

        btCertificado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Archivos/certificado_add.png"))); // NOI18N
        btCertificado.setText("Certificado");

        btJusticacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Archivos/pencil.png"))); // NOI18N
        btJusticacion.setText("Justificación");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btArticulo)
                .addGap(18, 18, 18)
                .addComponent(btCertificado, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btJusticacion, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btArticulo, btCertificado, btJusticacion});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btArticulo)
                    .addComponent(btCertificado)
                    .addComponent(btJusticacion))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btEmpleado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Archivos/group.png"))); // NOI18N
        btEmpleado.setText("Empleado");
        btEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEmpleadoActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(30, 129, 53), 1, true));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(30, 129, 53), 1, true));

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(9, 146, 231));
        jLabel1.setText("Legajo:");

        lblLegajo.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        lblLegajo.setForeground(new java.awt.Color(81, 186, 109));
        lblLegajo.setText("..");

        jLabel2.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(9, 146, 231));
        jLabel2.setText("Apellido:");

        jLabel3.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(9, 146, 231));
        jLabel3.setText("Nombre:");

        lblNombre.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        lblNombre.setForeground(new java.awt.Color(81, 186, 109));
        lblNombre.setText("..");

        lblApellido.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        lblApellido.setForeground(new java.awt.Color(81, 186, 109));
        lblApellido.setText("..");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(lblLegajo, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(lblApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblLegajo)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNombre)
                    .addComponent(lblApellido))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(30, 129, 53), 1, true));
        jPanel5.setForeground(new java.awt.Color(255, 255, 255));
        jPanel5.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N

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
        lblDecNomb.setText("..");

        lblRevista.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        lblRevista.setForeground(new java.awt.Color(53, 114, 25));
        lblRevista.setText("..");

        lblServicio.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        lblServicio.setForeground(new java.awt.Color(53, 114, 25));
        lblServicio.setText("..");

        lblEscalafon.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        lblEscalafon.setForeground(new java.awt.Color(53, 114, 25));
        lblEscalafon.setText("..");

        lblAgrupamiento.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        lblAgrupamiento.setForeground(new java.awt.Color(53, 114, 25));
        lblAgrupamiento.setText("..");

        lblFunReal.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        lblFunReal.setForeground(new java.awt.Color(53, 114, 25));
        lblFunReal.setText("..");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel9)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8))
                                .addGap(40, 40, 40)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblDireccion)
                                    .addComponent(LblLocalidad)
                                    .addComponent(lblCP)
                                    .addComponent(lblTelefono)
                                    .addComponent(lblMovil)))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(lblFecNac, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(72, 72, 72)
                                .addComponent(lblDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel11)
                            .addComponent(jLabel13)
                            .addComponent(jLabel14)
                            .addComponent(jLabel15))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblAptitud)
                            .addComponent(lblEstCivil)
                            .addComponent(lblCUIL)
                            .addComponent(lblMail)
                            .addComponent(lblCarpMed, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(jLabel21)
                                        .addGap(9, 9, 9))
                                    .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                        .addComponent(jLabel19)
                                        .addGap(26, 26, 26))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                        .addComponent(jLabel18)
                                        .addGap(37, 37, 37))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                        .addComponent(jLabel17)
                                        .addGap(39, 39, 39)))
                                .addGap(43, 43, 43)))
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblFunReal, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(lblAgrupamiento, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(lblEscalafon, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(lblServicio, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(lblRevista, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addComponent(lblDecNomb, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(51, Short.MAX_VALUE))
        );

        jPanel5Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {LblLocalidad, lblCP, lblDNI, lblDireccion, lblFecNac, lblMovil, lblTelefono});

        jPanel5Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {lblAptitud, lblCUIL, lblCarpMed, lblEstCivil, lblMail});

        jPanel5Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {lblAgrupamiento, lblDecNomb, lblEscalafon, lblFunReal, lblRevista, lblServicio});

        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(lblFecNac, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(lblDireccion))
                                .addGap(14, 14, 14)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(LblLocalidad))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(lblCP))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(lblTelefono)))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel11)
                                    .addComponent(lblCarpMed)
                                    .addComponent(lblDNI))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel12)
                                    .addComponent(lblAptitud))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(jLabel13)
                                        .addGap(14, 14, 14)
                                        .addComponent(jLabel14)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel15))
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(lblEstCivil)
                                        .addGap(15, 15, 15)
                                        .addComponent(lblCUIL)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lblMail)))))
                        .addGap(13, 13, 13)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(lblMovil)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(lblDecNomb))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel18)
                                .addGap(14, 14, 14)
                                .addComponent(jLabel19)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel20)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel21))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(111, 111, 111)
                                .addComponent(lblFunReal))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(lblRevista)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblServicio)
                                .addGap(14, 14, 14)
                                .addComponent(lblEscalafon)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblAgrupamiento))))))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(156, 156, 156)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btEmpleado)
                .addGap(4, 4, 4)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblNotificacion.setFont(new java.awt.Font("Ubuntu", 0, 10)); // NOI18N
        lblNotificacion.setText("..");
        lblNotificacion.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(243, 31, 55), 1, true));

        jMenu1.setText("Archivo");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblNotificacion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblNotificacion)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEmpleadoActionPerformed

        BuscarEmpleados sEmpleados = new BuscarEmpleados();
        sEmpleados.setVisible(true);

    }//GEN-LAST:event_btEmpleadoActionPerformed

    private void btArticuloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btArticuloActionPerformed

        ArticulosAdd articuloadd = new ArticulosAdd();

        articuloadd.setVisible(true);

    }//GEN-LAST:event_btArticuloActionPerformed

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
            java.util.logging.Logger.getLogger(Sistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Sistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Sistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Sistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Sistema().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JLabel LblLocalidad;
    private javax.swing.JButton btArticulo;
    private javax.swing.JButton btCertificado;
    private javax.swing.JButton btEmpleado;
    private javax.swing.JButton btJusticacion;
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JTextField jTextField1;
    public static javax.swing.JLabel lblAgrupamiento;
    public static javax.swing.JLabel lblApellido;
    public static javax.swing.JLabel lblAptitud;
    public static javax.swing.JLabel lblCP;
    public static javax.swing.JLabel lblCUIL;
    public static javax.swing.JLabel lblCarpMed;
    public static javax.swing.JLabel lblDNI;
    public static javax.swing.JLabel lblDecNomb;
    public static javax.swing.JLabel lblDireccion;
    public static javax.swing.JLabel lblEscalafon;
    public static javax.swing.JLabel lblEstCivil;
    public static javax.swing.JLabel lblFecNac;
    public static javax.swing.JLabel lblFunReal;
    public static javax.swing.JLabel lblLegajo;
    public static javax.swing.JLabel lblMail;
    public static javax.swing.JLabel lblMovil;
    public static javax.swing.JLabel lblNombre;
    public static javax.swing.JLabel lblNotificacion;
    public static javax.swing.JLabel lblRevista;
    public static javax.swing.JLabel lblServicio;
    public static javax.swing.JLabel lblTelefono;
    // End of variables declaration//GEN-END:variables
}
