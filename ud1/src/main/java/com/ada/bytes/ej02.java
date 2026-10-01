package com.ada.bytes;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class ej02 {
    //EN ESTE EJERCICIO USAREMOS EL DATAOUTPUT QUE SE USA PARA ESCRIBIR DATOS
    public static void main(String[] args) throws IOException{
        FileOutputStream fo = new FileOutputStream("ud1/src/main/java/com/ada/bytes/datos.txt", true);//ESTO LEE EL ARCHIVO Y AÑADIMOS EN EL FINAL DE LA RUTA COMO QUEREMOS QUE SE LLAME EL NUEVO ARCHIVO
        //PREGUNTA: NO SE SUPONE QUE EN INPUT ES PARA CREAR LA RUTA? NO DEBERIAMOS DE CREAR PRIMERO UN INPUT?
        /**
            Input (Entrada): Se usa para leer un archivo que ya existe (como hicimos con la imagen original). Trae los datos desde el archivo hacia tu programa.
            Output (Salida): Se usa para escribir y crear un archivo nuevo. Lleva los datos desde tu programa hacia el archivo.
         */
        DataOutputStream ds = new DataOutputStream(fo);//ESTE LO ESCRIBE
        Scanner sc = new Scanner (System.in);//CREAMOS SCANNER
        System.out.println("Introduce uno o dos numeros");//PEDIMOS POR PANTALLA
        //SI HACEMOS SC.NEXTINT SE PARA AL ESCRIBIR UN INTRO POR LO QUE TENDREMOS QUE HACER UN SC.NEXTLINE Y PARANOS CUANDO ESCRIBAMOS UN INTRO
        //CON EL WRITE SOLO ESCRIBIMOS UN SOLO BYTE, AL SER NUMEROS ES MEJOR USAR EN EL DATAOUT UN WRITEINT
        String linea=sc.nextLine();
        while(!linea.isEmpty()){
            String[]partes=linea.split(" ");//ESTO COGERA LOS ESPACIO Y LOS QUITARA
            int numero1=Integer.parseInt(partes[0]);//ESTO COGE LA PRIMERA PARTE DEL STRING Y LO PASA A NUMERO
            ds.writeInt(numero1);//ESCRIBE EL NUMERO
            int numero2=Integer.parseInt(partes[1]);
            ds.writeInt(numero2);
            System.out.println("Introduce uno o dos numeros");
            linea=sc.nextLine();
        }
        ds.close();
        sc.close();
        fo.close();
    }
    
}
