package com.ada.ficheros_aleatorios;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Ej02 {
    /*
    Escribe un programa que guarde en un fichero tantos enteros como el usuario quiera, una vez el usuario termine se deberá cambiar todos 
    los enteros con valor 5 por el valor 0. 
    */
    public static void main(String[] args) throws IOException {
        RandomAccessFile miRAFile;//CREAMOS VARIABLE DE FICHERO
        miRAFile=new RandomAccessFile("ud1/src/main/java/com/ada/ficheros_aleatorios/aleatorio.txt", "rw");
        Scanner sc = new Scanner (System.in);
        int numero=0;
        do{
            System.out.println("Dime un numero");
            numero=sc.nextInt();
            if (numero >= 0) {
            miRAFile.writeInt(numero);
}
        }while (numero>-1);
        miRAFile.seek(0);

        while (miRAFile.getFilePointer() < miRAFile.length()) {
        
            int valor = miRAFile.readInt(); // Lee 4 bytes y avanza el puntero 4 bytes

            if (valor == 5) {
                // Como readInt() ha avanzado 4 bytes hacia adelante,
                // retrocedemos 4 bytes para ponernos encima del 5 que acabamos de leer:
                miRAFile.seek(miRAFile.getFilePointer() - 4);

                // Sobreescribimos ese 5 con un 0 (esto vuelve a avanzar 4 bytes):
                miRAFile.writeInt(0);
            }
        }
    }
}
