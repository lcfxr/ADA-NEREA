package com.ada.flujo_caracteres;
import java.io.*;
public class ej04 {
    public static void main(String[] args) throws IOException {
        //PARA ESTE EJERCICIO EN VEZ DE USAR EL FILEREADER USAMOS EL BUFFER QUE LEE VARIAS LINEAS
        File d = new File ("ud1/src/main/java/com/ada/flujo_caracteres/texto.txt"); //CREA LA RUTA
        FileReader fr = new FileReader(d);
        BufferedReader br = new BufferedReader(fr);
        System.out.println(br.readLine());
    }
}
