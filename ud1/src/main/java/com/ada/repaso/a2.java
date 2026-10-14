package com.ada.repaso;

import java.io.File;

public class a2 {
    public static void main(String[] args) {
        //CON EL LIST, LISTAMOS
        File d = new File ("d");

        //AL SER UNA LISTA TIENE QUE SER UN ARRAY
        String[]contenido=d.list();

        //PARA VER LA LISTA TIENE QUE HABER UN BUCLE
        for(int i=0; i<contenido.length; i++){
            System.out.println(contenido[i]);
        }
    }
    
}
