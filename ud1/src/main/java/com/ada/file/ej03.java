package com.ada.file;

import java.io.File;

public class ej03 {
     public static void listar(File d){//hacemos un metodo y llamamos al padre que es el File d
        //CREAMOS EL ARRAY DE LAS SUBCARPETAS COMO EL EJERCICIO 2
        String[]contenido_d=d.list();

        //ESTE IF ES POR SI LAS CARPETAS ESTAN VACIAS
        if(contenido_d!=null){
            //HACEMOS UN BUCLE PARA MOSTRAR LAS PRIMERAS SUBCARPETAS COMO EN EL 2
            for(int i=0; i<contenido_d.length; i++){
                System.err.println(contenido_d[i]);

                //CREAMOS EL FILE HIJO UNIENDO LA RUTA PADRE CON LA DE LAS SUBCARPETAS
                File hijo = new File (d, contenido_d[i]);

                //COMPROBAMOS SI ES DIRECTORIO
                if(hijo.isDirectory()){
                    listar(hijo);
                }
            }
        }
    }

    public static void main(String[] args) {
         File d = new File("d");

         listar(d);
    }
}
