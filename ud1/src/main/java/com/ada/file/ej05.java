package com.ada.file;

import java.io.File;

public class ej05 {
    public static void borrar(File d, String extension){ //A VER ESTE EJERCICIO ES IGUAL QUE EL 4 PERO EN VEZ DE IMPRIMIR SE ELIMINARIA LOS ARCHIVOS TXT
        String []contenido_d=d.list();

        for (int i = 0; i < contenido_d.length; i++) {//RECORREMOS EL ARRAY
    
            //A VER. EL ENDS WITH ES PARA SABER SI ACABA EN UNA EXTENSION, POR LO QUE
            //HACEMOS UN IF E IMPRIMIRIA LOS ARCHIVOS QUE ACABAN EN TXT
            if(contenido_d[i].endsWith(extension)){
                File borrarArchivo = new File (d, contenido_d[i]); //CREAMOS UN NUEVO FILE PARA BORRAR ARCHIVOS
                borrarArchivo.delete();
                //YO ANTES HABIA PUESTO D.DELETE(); PERO ESO LO QUE HACE ES BORRAR LA CARPETA ENTERA, POR ESO TENEMOS QUE CREAR UN FILE
                //QUE CONTENGA LOS ARCHIVOS DENTROS, COMO UNA COPIA, DONDE SE BORRARAN LOS TXT
            }
        }
    }
    public static void main(String[] args) {
        File d = new File("d");

        borrar(d, ".txt");
    }
}
