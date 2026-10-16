package com.ada.repaso.ejercicios_repaso_clase;

import java.io.File;
import java.io.IOException;

public class ej02 {
    public static void mostrarExtension(File ruta, String extension){
        if(!ruta.isDirectory()){
            System.out.println("error");
        }
        for(File r : ruta.listFiles()){
            if(extension.endsWith(".txt")){
                System.out.println(r.getName());
            }
        }

    }
    public static void main(String[] args) throws IOException{
        File ruta = new File("C:/Users/nerea/Desktop/ADA-NEREA/ud1/src/main/java/com/ada/repaso/examen_simulado/textos");
        mostrarExtension(ruta, ".txt");
    }
}
