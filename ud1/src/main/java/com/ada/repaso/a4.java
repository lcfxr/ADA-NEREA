package com.ada.repaso;

import java.io.File;

public class a4 {
    public static void mostrar(File d, String ext){
        String[]contenido=d.list();

        for(int i=0; i<contenido.length; i++){
            if(contenido[i].endsWith(ext)){
                System.out.println(contenido[i]);
            }
        }
    }
    public static void main(String[] args) {
        File d = new File("d");
        mostrar(d, ".txt");
    }
    
}
