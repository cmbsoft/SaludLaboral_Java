/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelClass;

import ModeloBD.Articulos;
import java.util.List;
import Datos.ArticulosDatos;
import java.util.stream.Collectors;
import javax.swing.JComboBox;

/**
 *
 * @author bacinet
 */
public class ArticulosClass extends ArticulosDatos {

    private List<Articulos> articulos, articulosFilter;
    private String legajo;
    private String sql;
    private Object[] object;
    private String SQL = "";

    public List<Articulos> getArticulos() {

        return articulos;
    }

    public void searchArticulo(JComboBox combobox, String campo, int num_registro, int reg_por_pagina, int baja) {

        SQL = "SELECT Idarticulo, des FROM articulos WHERE art_tipo=3 ORDER BY des";

        articulos = articulos(SQL);

        if (campo.equals("")) {

            articulosFilter = articulos.stream()
                    .skip(num_registro).limit(reg_por_pagina)
                    .collect(Collectors.toList());
        } else {

            articulosFilter = (List<Articulos>) articulos.stream()
                    .filter(C -> C.getIdarticulo().startsWith(campo) || C.getDes().startsWith(campo))
                    .skip(num_registro).limit(reg_por_pagina)
                    .collect(Collectors.toList());

        }

        articulosFilter.forEach(item -> {
            combobox.addItem(item.getDes());
        });

    }

}
