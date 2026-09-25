package com.ada.flujo_caracteres;
import java.io.*;
public class ej03 {
    public static void main(String[] args) throws IOException {
        try {
            File d = new File ("ud1/src/main/java/com/ada/flujo_caracteres/texto.txt"); //CREA LA RUTA
            FileReader fr = new FileReader(d); //LEE LO QUE HAYA EN LA RUTA
            int caracter = fr.read(); //A VER FILE READER LEE POR CARACTERES, POR LO QUE TIENES QUE CREAR UN INT Y ASOCIARLO AL FR CON EL READ, CUANDO HAYA UN -1NSIGNIFICA QUE YA NO HABRA MAS LETRAS
            while (caracter!=-1){ //ESTE WHILE RECORRE EL TEXTO HASTA LLEGAR AL -1
                System.out.println((char)caracter);
                caracter=fr.read(); //VOLVEMOS A LEER LA LETRA
            }
        } catch (FileNotFoundException e) {
            // TODO: handle exception
        }
        

    }
    
}
