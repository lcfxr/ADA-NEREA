package com.ada.file;

import java.io.File;

public class ej01 {
    public static void main(String[] args) {
        
        File d = new File("d");
        d.mkdir();

        File d1 = new File (d, "d1");
        d1.mkdir();
        File d2 = new File (d, "d2");
        d2.mkdir();
        File d3 = new File (d, "d3");
        d3.mkdir();

        File f11 = new File (d1, "f11");
        f11.mkdir();
        File f12 = new File (d1, "f12");
        f12.mkdir();

        File d21 = new File (d2, "d21");
        d21.mkdir();
        File f21 = new File (d2, "f21");
        f21.mkdir();
        File d22 = new File (d2, "d22");
        d22.mkdir();

        File f222 = new File (d22, "f222");
        f222.mkdir();

        File d31 = new File (d3, "d31");
        d31.mkdir();
    }
}
