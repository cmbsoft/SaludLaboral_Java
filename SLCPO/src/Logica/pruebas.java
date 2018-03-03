/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.time.LocalDate;
import java.util.Calendar;

/**
 *
 * @author baci
 */
public class pruebas {

    public static void main(String args[]) {
        LocalDate date = LocalDate.of(2018, 2, 10);
        int days = date.lengthOfMonth();

        System.out.println(days);
    }
}
