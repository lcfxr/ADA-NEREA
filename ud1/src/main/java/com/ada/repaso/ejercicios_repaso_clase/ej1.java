package com.ada.repaso.ejercicios_repaso_clase;

import java.io.File;
import java.io.IOException;

public class ej1 {
    public static void mostrarNombre(File ruta){
        if(!ruta.isDirectory()){
            System.out.println("ERROR");
        }
        for (File f : ruta.listFiles()){//HAY QUE LISTARRRRRRRRRRRRRRRRRRRRRRRRRRRRRR
            if(f.isDirectory()){
                System.out.println(f.getName());
            }else{
                System.out.println(f.getName());
            }
        }
        
    }

    public static void main(String[] args) throws IOException {
        File ruta = new File("d");
        mostrarNombre(ruta);
    }

}
