package com.ada.repaso.examen_simulado;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ej1_2 {
    public static void main(String[] args) throws IOException {
        File carpeta = new File("C:/Users/nerea/Desktop/ADA-NEREA/ud1/src/main/java/com/ada/repaso/examen_simulado/textos");
        if(!carpeta.isDirectory()){
            System.out.println("ERROR");
        }
        PrintWriter pw = new PrintWriter(new FileWriter("resumen.txt"));
        int total=0;
        for (File f : carpeta.listFiles()) {
            if (f.getName().endsWith(".txt")) {
                BufferedReader bf = new BufferedReader(new FileReader(f));
                int contador = 0;
                while (bf.readLine() != null) {
                    contador++;
                }
                pw.println(f.getName() +contador+ "Lineas");
                bf.close();
                total+=contador;
            }
            System.out.println(total);

        }
        pw.close();
    }
}
