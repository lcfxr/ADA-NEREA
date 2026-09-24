package com.ada.file;

import java.io.File;

public class ej04 {
    public static void nombrar(File d, String extension){
        String []contenido_d=d.list();

        for (int i = 0; i < contenido_d.length; i++) {//RECORREMOS EL ARRAY
    
            //A VER. EL ENDS WITH ES PARA SABER SI ACABA EN UNA EXTENSION, POR LO QUE
            //HACEMOS UN IF E IMPRIMIRIA LOS ARCHIVOS QUE ACABAN EN TXT
            if(contenido_d[i].endsWith(extension)){
                System.out.println(contenido_d[i]);
            }
        }
    }
    public static void main(String[] args) {
        File d = new File("d");

        nombrar(d, ".txt");
    }
    
}
