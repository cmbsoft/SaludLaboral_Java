/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloBD;

/**
 *
 * @author baci
 */
public class tablaUsuarios {

    private int CODIGO_OPE;
    private String Nombre;
    private String clave;
    private int JERARQUIA;
    private String comentario;
    private String alias;
    private String DS_SUB_JERARQUIA;
    private String dni;
    private String TypeUser;

    public tablaUsuarios() {
    }

    public tablaUsuarios(int CODIGO_OPE, String Nombre, String clave, int JERARQUIA, String comentario, String alias, String DS_SUB_JERARQUIA, String dni, String TypeUser) {
        this.CODIGO_OPE = CODIGO_OPE;
        this.Nombre = Nombre;
        this.clave = clave;
        this.JERARQUIA = JERARQUIA;
        this.comentario = comentario;
        this.alias = alias;
        this.DS_SUB_JERARQUIA = DS_SUB_JERARQUIA;
        this.dni = dni;
        this.TypeUser = TypeUser;
    }

    public int getCODIGO_OPE() {
        return CODIGO_OPE;
    }

    public void setCODIGO_OPE(int CODIGO_OPE) {
        this.CODIGO_OPE = CODIGO_OPE;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public int getJERARQUIA() {
        return JERARQUIA;
    }

    public void setJERARQUIA(int JERARQUIA) {
        this.JERARQUIA = JERARQUIA;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getDS_SUB_JERARQUIA() {
        return DS_SUB_JERARQUIA;
    }

    public void setDS_SUB_JERARQUIA(String DS_SUB_JERARQUIA) {
        this.DS_SUB_JERARQUIA = DS_SUB_JERARQUIA;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getTypeUser() {
        return TypeUser;
    }

    public void setTypeUser(String TypeUser) {
        this.TypeUser = TypeUser;
    }

    @Override
    public String toString() {
        return "Usuarios{" + "CODIGO_OPE=" + CODIGO_OPE + ", Nombre=" + Nombre + ", clave=" + clave + ", JERARQUIA=" + JERARQUIA + ", comentario=" + comentario + ", alias=" + alias + ", DS_SUB_JERARQUIA=" + DS_SUB_JERARQUIA + ", dni=" + dni + ", TypeUser=" + TypeUser + '}';
    }

}
