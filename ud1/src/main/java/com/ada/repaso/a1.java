package com.ada.repaso;

import java.io.File;
import java.io.IOException;

public class a1 {
    public static void main(String[] args) throws IOException {
        File d = new File ("d");
        d.mkdir();//LO QUE CREA SON CARPETAS

        File d1 = new File (d, "d1");
        d1.mkdir();

        File d2 = new File (d, "d2");
        d2.mkdir();

        File d3 = new File (d, "d3");
        d3.mkdir();

        File f11 = new File (d1, "f11");
        f11.createNewFile();//CREA FICHEROS

        File f12 = new File (d1, "f12");
        f12.createNewFile();

        File d21 = new File (d2, "d21");
        d21.mkdir();
        
        File f21 = new File (d21, "f21");
        f21.createNewFile();

        File d22 = new File (d2, "d22");
        d22.mkdir();

        File f222 = new File (d22, "f222");
        f222.createNewFile();

        File d31 = new File (d3, "d31");
        d31.mkdir();
        
    }
    
}
