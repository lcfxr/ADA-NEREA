package com.ada.file;

import java.io.File;

public class ej02 {
    public static void main(String[] args) {
        
        File d = new File("d");; //Apuntamos al directorio del ej1

        //LISTAMOS
        String[]contenido_d=d.list();

        //No lo podemos ver, esto lo lista pero no nos lo enseña por lo que tenemos que recorrer la lista y enseñarla
        for(int i=0; i<contenido_d.length; i++){
            System.out.println(contenido_d[i]);

        //La cosa es que no entiendo porque solo se ve solo las primeras subcarpetas y no todo
        }
    }
}
