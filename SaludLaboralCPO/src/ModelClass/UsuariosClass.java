/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelClass;

import static Logica.FuncionesPropias.getMD5;
import ModeloBD.Usuarios;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author baci
 */
public class UsuariosClass {

    private List<Usuarios> usuarios, usuarioList, listUsuarios, listUsuario;

    public List<Usuarios> getUsuarios() {
        return usuarioList;
    }

    public Object[] login(String usuario, String password) {
        listUsuario.clear();
        listUsuarios = usuarioList.stream().filter(P -> P.getAlias().equals(usuario)).collect(Collectors.toList());

        if (0 < listUsuarios.size()) {
            try {
                String pass = getMD5(listUsuarios.get(0).getClave());
                if (pass.equals(password)) {
                    listUsuario = listUsuarios;
                    int codoperador = listUsuarios.get(0).getCODIGO_OPE();
                    String nombre = listUsuarios.get(0).getNombre();
                    String user = listUsuarios.get(0).getAlias();
                    int jerarquia = listUsuarios.get(0).getJERARQUIA();

                }
            } catch (Exception ex) {

            }
        }

        Object[] objects = {listUsuario};
        return objects;

    }

}
