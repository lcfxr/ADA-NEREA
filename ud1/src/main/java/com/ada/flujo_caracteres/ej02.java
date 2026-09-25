package com.ada.flujo_caracteres;
import java.io.*;
public class ej02 {
    public static void main(String[] args) throws IOException{
        FileWriter fw = new FileWriter("ud1/src/main/java/com/ada/flujo_caracteres/texto.txt", true); //PARA SOBRE ESCRIBIR PONEMOS TRUE Y ASI SE GUARDA TODO
        PrintWriter pw = new PrintWriter(fw);
        pw.print("Hola Caracola"); //SI PUSIERAMOS PRINTLN SERIA MAS ESTETICO
        pw.flush();
        pw.close();
        
    }
    
}
