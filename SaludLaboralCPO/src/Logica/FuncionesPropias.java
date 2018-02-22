/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;

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
        SimpleDateFormat formato = new SimpleDateFormat("d/MM/yyyy");

        fechaformato = formato.format(fecha);

        return fechaformato;
    }

    //Metodo para convertir fechas yyyy/mm/dd --> dd/mm/yyyy
    //El variable fecha debe ser tipo DATE
    public String dFechaddmmyyyy(Date fecha) {

        SimpleDateFormat formato = new SimpleDateFormat("d/MM/yyyy");

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
                JOptionPane.showMessageDialog(null, "La fecha Hasta es mayor que la fecha Desde");
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
    
    
}
