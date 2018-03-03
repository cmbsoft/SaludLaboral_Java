/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloBD;

import java.util.Date;

/**
 *
 * @author baci
 */
public class tablaEmpleados {

    private String legajo;
    private String codigo;
    private String sexo;
    private String tipo_documento;
    private String num_documento;
    private String apellido;
    private String nombre;

    private Date fecha_nacimiento;

    private String domicilio;
    private String telefono;
    private String estado_civil;
    private String muros;
    private String antiguedad_reconocida;

    private String toma_posecion;

    private String matricula_medico;
    private int codigo_ope;

    private String fecha_baja;

    private int idmotivobaja;
    private String legajo_baja;

    private String fecha_operacion;

    private String hora_operacion;
    private int cod_cargo;
    private int cod_categoria;
    private String telmovil;
    private int baja;
    private String obs;
    private String carp_medica;
    private String aptitud;
    private String codigopostal;
    private String lugarnacimiento;
    private String decreto_nom;
    private String cuil;
    private String Matricula_Turnos;
    private String TypeUser;
    private int nohuella;
    private String mail;

    public tablaEmpleados() {
    }

    public tablaEmpleados(String legajo, String codigo, String sexo, String tipo_documento, String num_documento, String apellido, String nombre, Date fecha_nacimiento, String domicilio, String telefono, String estado_civil, String muros, String antiguedad_reconocida, String toma_posecion, String matricula_medico, int codigo_ope, String fecha_baja, int idmotivobaja, String legajo_baja, String fecha_operacion, String hora_operacion, int cod_cargo, int cod_categoria, String telmovil, int baja, String obs, String carp_medica, String aptitud, String codigopostal, String lugarnacimiento, String decreto_nom, String cuil, String Matricula_Turnos, String TypeUser, int nohuella, String mail) {
        this.legajo = legajo;
        this.codigo = codigo;
        this.sexo = sexo;
        this.tipo_documento = tipo_documento;
        this.num_documento = num_documento;
        this.apellido = apellido;
        this.nombre = nombre;
        this.fecha_nacimiento = fecha_nacimiento;
        this.domicilio = domicilio;
        this.telefono = telefono;
        this.estado_civil = estado_civil;
        this.muros = muros;
        this.antiguedad_reconocida = antiguedad_reconocida;
        this.toma_posecion = toma_posecion;
        this.matricula_medico = matricula_medico;
        this.codigo_ope = codigo_ope;
        this.fecha_baja = fecha_baja;
        this.idmotivobaja = idmotivobaja;
        this.legajo_baja = legajo_baja;
        this.fecha_operacion = fecha_operacion;
        this.hora_operacion = hora_operacion;
        this.cod_cargo = cod_cargo;
        this.cod_categoria = cod_categoria;
        this.telmovil = telmovil;
        this.baja = baja;
        this.obs = obs;
        this.carp_medica = carp_medica;
        this.aptitud = aptitud;
        this.codigopostal = codigopostal;
        this.lugarnacimiento = lugarnacimiento;
        this.decreto_nom = decreto_nom;
        this.cuil = cuil;
        this.Matricula_Turnos = Matricula_Turnos;
        this.TypeUser = TypeUser;
        this.nohuella = nohuella;
        this.mail = mail;
    }

    public String getLegajo() {
        return legajo;
    }

    public void setLegajo(String legajo) {
        this.legajo = legajo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getTipo_documento() {
        return tipo_documento;
    }

    public void setTipo_documento(String tipo_documento) {
        this.tipo_documento = tipo_documento;
    }

    public String getNum_documento() {
        return num_documento;
    }

    public void setNum_documento(String num_documento) {
        this.num_documento = num_documento;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEstado_civil() {
        return estado_civil;
    }

    public void setEstado_civil(String estado_civil) {
        this.estado_civil = estado_civil;
    }

    public String getMuros() {
        return muros;
    }

    public void setMuros(String muros) {
        this.muros = muros;
    }

    public String getAntiguedad_reconocida() {
        return antiguedad_reconocida;
    }

    public void setAntiguedad_reconocida(String antiguedad_reconocida) {
        this.antiguedad_reconocida = antiguedad_reconocida;
    }

    public String getToma_posecion() {
        return toma_posecion;
    }

    public void setToma_posecion(String toma_posecion) {
        this.toma_posecion = toma_posecion;
    }

    public String getMatricula_medico() {
        return matricula_medico;
    }

    public void setMatricula_medico(String matricula_medico) {
        this.matricula_medico = matricula_medico;
    }

    public int getCodigo_ope() {
        return codigo_ope;
    }

    public void setCodigo_ope(int codigo_ope) {
        this.codigo_ope = codigo_ope;
    }

    public String getFecha_baja() {
        return fecha_baja;
    }

    public void setFecha_baja(String fecha_baja) {
        this.fecha_baja = fecha_baja;
    }

    public int getIdmotivobaja() {
        return idmotivobaja;
    }

    public void setIdmotivobaja(int idmotivobaja) {
        this.idmotivobaja = idmotivobaja;
    }

    public String getLegajo_baja() {
        return legajo_baja;
    }

    public void setLegajo_baja(String legajo_baja) {
        this.legajo_baja = legajo_baja;
    }

    public String getFecha_operacion() {
        return fecha_operacion;
    }

    public void setFecha_operacion(String fecha_operacion) {
        this.fecha_operacion = fecha_operacion;
    }

    public String getHora_operacion() {
        return hora_operacion;
    }

    public void setHora_operacion(String hora_operacion) {
        this.hora_operacion = hora_operacion;
    }

    public int getCod_cargo() {
        return cod_cargo;
    }

    public void setCod_cargo(int cod_cargo) {
        this.cod_cargo = cod_cargo;
    }

    public int getCod_categoria() {
        return cod_categoria;
    }

    public void setCod_categoria(int cod_categoria) {
        this.cod_categoria = cod_categoria;
    }

    public String getTelmovil() {
        return telmovil;
    }

    public void setTelmovil(String telmovil) {
        this.telmovil = telmovil;
    }

    public int getBaja() {
        return baja;
    }

    public void setBaja(int baja) {
        this.baja = baja;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public String getCarp_medica() {
        return carp_medica;
    }

    public void setCarp_medica(String carp_medica) {
        this.carp_medica = carp_medica;
    }

    public String getAptitud() {
        return aptitud;
    }

    public void setAptitud(String aptitud) {
        this.aptitud = aptitud;
    }

    public String getCodigopostal() {
        return codigopostal;
    }

    public void setCodigopostal(String codigopostal) {
        this.codigopostal = codigopostal;
    }

    public String getLugarnacimiento() {
        return lugarnacimiento;
    }

    public void setLugarnacimiento(String lugarnacimiento) {
        this.lugarnacimiento = lugarnacimiento;
    }

    public String getDecreto_nom() {
        return decreto_nom;
    }

    public void setDecreto_nom(String decreto_nom) {
        this.decreto_nom = decreto_nom;
    }

    public String getCuil() {
        return cuil;
    }

    public void setCuil(String cuil) {
        this.cuil = cuil;
    }

    public String getMatricula_Turnos() {
        return Matricula_Turnos;
    }

    public void setMatricula_Turnos(String Matricula_Turnos) {
        this.Matricula_Turnos = Matricula_Turnos;
    }

    public String getTypeUser() {
        return TypeUser;
    }

    public void setTypeUser(String TypeUser) {
        this.TypeUser = TypeUser;
    }

    public int getNohuella() {
        return nohuella;
    }

    public void setNohuella(int nohuella) {
        this.nohuella = nohuella;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Override
    public String toString() {
        return "Empleados{" + "legajo=" + legajo + ", codigo=" + codigo + ", sexo=" + sexo + ", tipo_documento=" + tipo_documento + ", num_documento=" + num_documento + ", apellido=" + apellido + ", nombre=" + nombre + ", fecha_nacimiento=" + fecha_nacimiento + ", domicilio=" + domicilio + ", telefono=" + telefono + ", estado_civil=" + estado_civil + ", muros=" + muros + ", antiguedad_reconocida=" + antiguedad_reconocida + ", toma_posecion=" + toma_posecion + ", matricula_medico=" + matricula_medico + ", codigo_ope=" + codigo_ope + ", fecha_baja=" + fecha_baja + ", idmotivobaja=" + idmotivobaja + ", legajo_baja=" + legajo_baja + ", fecha_operacion=" + fecha_operacion + ", hora_operacion=" + hora_operacion + ", cod_cargo=" + cod_cargo + ", cod_categoria=" + cod_categoria + ", telmovil=" + telmovil + ", baja=" + baja + ", obs=" + obs + ", carp_medica=" + carp_medica + ", aptitud=" + aptitud + ", codigopostal=" + codigopostal + ", lugarnacimiento=" + lugarnacimiento + ", decreto_nom=" + decreto_nom + ", cuil=" + cuil + ", Matricula_Turnos=" + Matricula_Turnos + ", TypeUser=" + TypeUser + ", nohuella=" + nohuella + ", mail=" + mail + '}';
    }

}
