/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parqueeolicocliente;

/**
 *
 * @author Ayo
 */
public enum Estado {
    
    DESACTIVADO(new String[]{"desactivado","disabled","désactivée"}),
    ACTIVADO(new String[]{"activado","activated","activé"});

    public String[] idiomas;

    Estado(String[] idiomas){
        this.idiomas = idiomas;
    }
}
