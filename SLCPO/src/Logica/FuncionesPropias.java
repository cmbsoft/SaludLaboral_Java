/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.awt.Dialog;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author baci
 */
public class FuncionesPropias {

    //Metodo para convertir fechas yyyy/mm/dd --> dd/mm/yyyy
    //El variable fecha debe ser tipo STRING
    public String sFechaddmmyyyy(String fecha) {
        String fechaformato = "";

        //Date dfecha = fecha;
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

        fechaformato = formato.format(fecha);

        return fechaformato;
    }

    //Metodo para convertir fechas yyyy/mm/dd --> dd/mm/yyyy
    //El variable fecha debe ser tipo DATE
    public String dFechaddmmyyyy(Date fecha) {

        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

        String fechaformato = formato.format(fecha);

        return fechaformato;

    }

    public long DifEntreFechas(Date Desde, Date Hasta) {
        long diferencia = 0;
        final long MILLSECS_PER_DAY = 24 * 60 * 60 * 1000; //Milisegundos al día

        if (Desde == null || Hasta == null) {
            diferencia = 0;
        } else {
            if (Desde.getTime() > Hasta.getTime()) {
                diferencia = 0;

                JOptionPane.showMessageDialog(null, "La fecha Hasta es mayor que la fecha Desde", "", JOptionPane.WARNING_MESSAGE);
                //Dialogo vdialogo = new Dialogo(null, true);
                //vdialogo.lblMensaje.setText("La fecha Hasta es mayor que la fecha Desde");
                //vdialogo.setVisible(true);

            } else {
                diferencia = ((Hasta.getTime() - Desde.getTime()) / MILLSECS_PER_DAY) + 1;
            }

        }

        return diferencia;
    }

    public static String getMD5(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            BigInteger number = new BigInteger(1, messageDigest);
            String hashtext = number.toString(16);

            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getEdad(Date fechaNacimiento) {
        if (fechaNacimiento != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            StringBuilder result = new StringBuilder();
            if (fechaNacimiento != null) {
                //result.append(sdf.format(fechaNacimiento));
                //result.append(" (");
                Calendar c = new GregorianCalendar();
                c.setTime(fechaNacimiento);
                result.append(calcularEdad(c));
                //result.append(" años)");
            }
            return result.toString();
        }
        return "";
    }

    private static int calcularEdad(Calendar fechaNac) {
        Calendar today = Calendar.getInstance();
        int diffYear = today.get(Calendar.YEAR) - fechaNac.get(Calendar.YEAR);
        int diffMonth = today.get(Calendar.MONTH) - fechaNac.get(Calendar.MONTH);
        int diffDay = today.get(Calendar.DAY_OF_MONTH) - fechaNac.get(Calendar.DAY_OF_MONTH);
        // Si está en ese año pero todavía no los ha cumplido
        if (diffMonth < 0 || (diffMonth == 0 && diffDay < 0)) {
            diffYear = diffYear - 1; // no aparecían los dos guiones del
            // postincremento 😐
        }
        return diffYear;
    }

    public void limpiarTabla(JTable tabla, DefaultTableModel modelo) {

        DefaultTableModel tb = (DefaultTableModel) tabla.getModel();
        int a = tabla.getRowCount() - 1;
        for (int i = a; i >= 0; i--) {
            tb.removeRow(tb.getRowCount() - 1);
        }

    }

    public static String ultimoDiaMes(int Mes, int Anio) {

        LocalDate date = LocalDate.of(Anio, Mes, 10);
        int days = date.lengthOfMonth();

        String fdiames;

        LocalDate fechaUltD = LocalDate.of(Anio, Mes, days);

        fdiames = fechaUltD.toString();

        return fdiames;
    }

    public static String primerDiaMes(int Mes, int Anio) {

        LocalDate date = LocalDate.of(Anio, Mes, 1);

        String pdiames;

        pdiames = date.toString();

        return pdiames;

    }

    public static int mesNumero(String mesTexto) {
        int numMes = 0;

        switch (mesTexto.toUpperCase()) {
            case "ENERO":
                numMes = 1;
                break;
            case "FEBRERO":
                numMes = 2;
                break;
            case "MARZO":
                numMes = 3;
                break;
            case "ABRIL":
                numMes = 4;
                break;
            case "MAYO":
                numMes = 5;
                break;
            case "JUNIO":
                numMes = 6;
                break;
            case "JULIO":
                numMes = 7;
                break;
            case "AGOSTO":
                numMes = 8;
                break;
            case "SEPTIEMBRE":
                numMes = 9;
                break;
            case "OCTUBRE":
                numMes = 10;
                break;
            case "NOVIEMBRE":
                numMes = 11;
                break;
            case "DICIEMBRE":
                numMes = 12;
                break;

        }

        return numMes;
    }

    public static String numeroMes(int mesNumero) {
        String mesTexto = null;

        switch (mesNumero) {

            case 1:
                mesTexto = "Enero";
                break;
            case 2:
                mesTexto = "Febrero";
                break;
            case 3:
                mesTexto = "Marzo";
                break;
            case 4:
                mesTexto = "Abril";
                break;
            case 5:
                mesTexto = "Mayo";
                break;
            case 6:
                mesTexto = "Junio";
                break;
            case 7:
                mesTexto = "Julio";
                break;
            case 8:
                mesTexto = "Agosto";
                break;
            case 9:
                mesTexto = "Septiembre";
                break;
            case 10:
                mesTexto = "Octubre";
                break;
            case 11:
                mesTexto = "Noviembre";
                break;
            case 12:
                mesTexto = "Diciembre";
                break;
        }

        return mesTexto;

    }

    public void cargaComboAnios(int anioActual, JComboBox combobox) {

        int anioIn = anioActual - 20;
        int anioFin = anioActual + 20;

        combobox.removeAllItems();

        for (int i = anioIn; i <= anioFin; i++) {

            combobox.addItem(i);
        }

        combobox.setSelectedItem(anioActual);
    }

    public void cargaMesActual(JComboBox combobox) {
        Date date = new Date();

        SimpleDateFormat sdf = new SimpleDateFormat("MM");
        String Anio = sdf.format(date);

        combobox.setSelectedItem(numeroMes(Integer.parseInt(Anio)));

    }

    public static String gregCalString(GregorianCalendar date) {

        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
        fmt.setCalendar(date);
        String dateFormatted = fmt.format(date.getTime());
        System.out.println(date);
        System.out.println(dateFormatted);

        return dateFormatted;

    }

    public static String convertirDateToString(LocalDate indate) {
        String dateString = null;
        SimpleDateFormat sdfr = new SimpleDateFormat("yyyy/MM/dd");

        try {
            dateString = sdfr.format(indate);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return dateString;
    }

}
