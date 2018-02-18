/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.text.SimpleDateFormat;
import java.util.Date;

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
}
