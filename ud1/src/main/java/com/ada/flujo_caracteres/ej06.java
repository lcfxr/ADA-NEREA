package com.ada.flujo_caracteres;
import java.io.*;
import java.util.Scanner;
public class ej06 {
    public static void main(String[] args) throws IOException{

        //PRIMERO PEDIMOS POR PANTALLA QUE NOS DEN UN DATO
        String dato;
        Scanner sc = new Scanner(System.in);//LLAMAMOS AL OBJETO SCANNER
        System.out.println("Dame una palabra clave");
        dato=sc.nextLine();

        File d = new File ("ud1/src/main/java/com/ada/flujo_caracteres/texto.txt"); //CREA LA RUTA
        FileReader fr = new FileReader(d);
        BufferedReader br = new BufferedReader(fr);

        PrintWriter pw = new PrintWriter(new FileWriter("ud1/src/main/java/com/ada/flujo_caracteres/resultado.txt"));

        String palabra;
        int numLinea=0;
        int contador=0;
        while((palabra=br.readLine())!=null){
            numLinea++;
            if(palabra.contains(dato)){
                pw.println("Linea " +numLinea+ "; " +palabra);
                contador++;
            }
        }
        br.close();
        pw.close();
        System.out.println("Numero de lineas : " +numLinea);
        System.out.println("Coincidencias encontradas: " +contador);
    }
    
}
