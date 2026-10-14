package com.ada.repaso;

import java.io.File;

public class a5 {
    public static void borra(File d, String ext){
        String[]contenido=d.list();
        for(int i=0; i<contenido.length; i++){
            if(contenido[i].endsWith(ext)){
                File borrarArchivo= new File(d, contenido[i]);
                borrarArchivo.delete();
            }
        }
    }
    public static void main(String[] args) {
        File d = new File("d");
        borra(d, ".txt");
    }
    
}
