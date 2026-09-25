package com.ada.flujo_caracteres;
import java.io.*;

public class ej01 {
    public static void main(String[] args) throws IOException {
        FileWriter fw = new FileWriter("ud1/src/main/java/com/ada/flujo_caracteres/texto.txt");
        PrintWriter pw = new PrintWriter(fw);
        pw.print("Hola Mundo");
        pw.flush();
        pw.close();
        

    }
    
}
