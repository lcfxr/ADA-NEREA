package com.ada.repaso;

import java.io.File;

public class a3 {
    public static void main(String[] args) {
         File d = new File ("d");
         listar(d);
        
    }

    public static void listar(File d){

        String[]contenido=d.list();

        if(contenido!=null){
            for(int i=0; i<contenido.length; i++){
                System.out.println(contenido[i]);
                File hijo = new File (d, contenido[i]);

                if (hijo.isDirectory()){
                    listar(hijo);
                }
                
            }
        }
    }
    
}
