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
public class Articulos {

    private int id;
    private String Idarticulo;
    private int Tipo;
    private String des;
    private String causa;
    private int cant_anio;
    private int cant_mes;
    private int hor_mes;
    private int baja;
    private String justifica;
    private String dias;
    private int alternado;
    private int Licencia;
    private int Salud;
    private String Inciso;
    private String Nombre;
    private int Tipo_art;
    private int art_tipo;
    private int vencimiento;
    private int edita;
    private int certificado;
    private String tope;
    private int cargahoraria;
    private int sumaresta;
    private int factor;
    private int lsgh;
    private int treintapor;
    private int distrib;
    private int cant_carrera;
    private int periodo_acumula;

    public Articulos() {
    }

    public Articulos(int id, String Idarticulo, int Tipo, String des, String causa, int cant_anio, int cant_mes, int hor_mes, int baja, String justifica, String dias, int alternado, int Licencia, int Salud, String Inciso, String Nombre, int Tipo_art, int art_tipo, int vencimiento, int edita, int certificado, String tope, int cargahoraria, int sumaresta, int factor, int lsgh, int treintapor, int distrib, int cant_carrera, int periodo_acumula) {
        this.id = id;
        this.Idarticulo = Idarticulo;
        this.Tipo = Tipo;
        this.des = des;
        this.causa = causa;
        this.cant_anio = cant_anio;
        this.cant_mes = cant_mes;
        this.hor_mes = hor_mes;
        this.baja = baja;
        this.justifica = justifica;
        this.dias = dias;
        this.alternado = alternado;
        this.Licencia = Licencia;
        this.Salud = Salud;
        this.Inciso = Inciso;
        this.Nombre = Nombre;
        this.Tipo_art = Tipo_art;
        this.art_tipo = art_tipo;
        this.vencimiento = vencimiento;
        this.edita = edita;
        this.certificado = certificado;
        this.tope = tope;
        this.cargahoraria = cargahoraria;
        this.sumaresta = sumaresta;
        this.factor = factor;
        this.lsgh = lsgh;
        this.treintapor = treintapor;
        this.distrib = distrib;
        this.cant_carrera = cant_carrera;
        this.periodo_acumula = periodo_acumula;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdarticulo() {
        return Idarticulo;
    }

    public void setIdarticulo(String Idarticulo) {
        this.Idarticulo = Idarticulo;
    }

    public int getTipo() {
        return Tipo;
    }

    public void setTipo(int Tipo) {
        this.Tipo = Tipo;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getCausa() {
        return causa;
    }

    public void setCausa(String causa) {
        this.causa = causa;
    }

    public int getCant_anio() {
        return cant_anio;
    }

    public void setCant_anio(int cant_anio) {
        this.cant_anio = cant_anio;
    }

    public int getCant_mes() {
        return cant_mes;
    }

    public void setCant_mes(int cant_mes) {
        this.cant_mes = cant_mes;
    }

    public int getHor_mes() {
        return hor_mes;
    }

    public void setHor_mes(int hor_mes) {
        this.hor_mes = hor_mes;
    }

    public int getBaja() {
        return baja;
    }

    public void setBaja(int baja) {
        this.baja = baja;
    }

    public String getJustifica() {
        return justifica;
    }

    public void setJustifica(String justifica) {
        this.justifica = justifica;
    }

    public String getDias() {
        return dias;
    }

    public void setDias(String dias) {
        this.dias = dias;
    }

    public int getAlternado() {
        return alternado;
    }

    public void setAlternado(int alternado) {
        this.alternado = alternado;
    }

    public int getLicencia() {
        return Licencia;
    }

    public void setLicencia(int Licencia) {
        this.Licencia = Licencia;
    }

    public int getSalud() {
        return Salud;
    }

    public void setSalud(int Salud) {
        this.Salud = Salud;
    }

    public String getInciso() {
        return Inciso;
    }

    public void setInciso(String Inciso) {
        this.Inciso = Inciso;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getTipo_art() {
        return Tipo_art;
    }

    public void setTipo_art(int Tipo_art) {
        this.Tipo_art = Tipo_art;
    }

    public int getArt_tipo() {
        return art_tipo;
    }

    public void setArt_tipo(int art_tipo) {
        this.art_tipo = art_tipo;
    }

    public int getVencimiento() {
        return vencimiento;
    }

    public void setVencimiento(int vencimiento) {
        this.vencimiento = vencimiento;
    }

    public int getEdita() {
        return edita;
    }

    public void setEdita(int edita) {
        this.edita = edita;
    }

    public int getCertificado() {
        return certificado;
    }

    public void setCertificado(int certificado) {
        this.certificado = certificado;
    }

    public String getTope() {
        return tope;
    }

    public void setTope(String tope) {
        this.tope = tope;
    }

    public int getCargahoraria() {
        return cargahoraria;
    }

    public void setCargahoraria(int cargahoraria) {
        this.cargahoraria = cargahoraria;
    }

    public int getSumaresta() {
        return sumaresta;
    }

    public void setSumaresta(int sumaresta) {
        this.sumaresta = sumaresta;
    }

    public int getFactor() {
        return factor;
    }

    public void setFactor(int factor) {
        this.factor = factor;
    }

    public int getLsgh() {
        return lsgh;
    }

    public void setLsgh(int lsgh) {
        this.lsgh = lsgh;
    }

    public int getTreintapor() {
        return treintapor;
    }

    public void setTreintapor(int treintapor) {
        this.treintapor = treintapor;
    }

    public int getDistrib() {
        return distrib;
    }

    public void setDistrib(int distrib) {
        this.distrib = distrib;
    }

    public int getCant_carrera() {
        return cant_carrera;
    }

    public void setCant_carrera(int cant_carrera) {
        this.cant_carrera = cant_carrera;
    }

    public int getPeriodo_acumula() {
        return periodo_acumula;
    }

    public void setPeriodo_acumula(int periodo_acumula) {
        this.periodo_acumula = periodo_acumula;
    }

    @Override
    public String toString() {
        return "Articulos{" + "id=" + id + ", Idarticulo=" + Idarticulo + ", Tipo=" + Tipo + ", des=" + des + ", causa=" + causa + ", cant_anio=" + cant_anio + ", cant_mes=" + cant_mes + ", hor_mes=" + hor_mes + ", baja=" + baja + ", justifica=" + justifica + ", dias=" + dias + ", alternado=" + alternado + ", Licencia=" + Licencia + ", Salud=" + Salud + ", Inciso=" + Inciso + ", Nombre=" + Nombre + ", Tipo_art=" + Tipo_art + ", art_tipo=" + art_tipo + ", vencimiento=" + vencimiento + ", edita=" + edita + ", certificado=" + certificado + ", tope=" + tope + ", cargahoraria=" + cargahoraria + ", sumaresta=" + sumaresta + ", factor=" + factor + ", lsgh=" + lsgh + ", treintapor=" + treintapor + ", distrib=" + distrib + ", cant_carrera=" + cant_carrera + ", periodo_acumula=" + periodo_acumula + '}';
    }

}
