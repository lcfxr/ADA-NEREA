package com.ada.bytes;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ej03 {
    public static void main(String[] args) throws IOException {
        FileInputStream fi = new FileInputStream("ud1/src/main/java/com/ada/bytes/datos.txt");//VAMOS AL ARCHIVO
        DataInputStream di = new DataInputStream(fi);//SACAMOS LOS DATOS DEL ARCHIVO
        int sumaNotas=0;//PARA GUARDAR LA SUMA DE LAS NOTAS
        int cantidad=0; //PARA GUARDAR LA CANTUDAD DE ESTAS
        int sumaPonderada=0; //PARA CALCULAR LA SUMA PONDERADA DE LOS NUMEROS
        int sumaPesos=0; //PARA LA PONDERACION
        try {//CON ESTE TRY CATCH EOF LO QUE HACE ESQUE PONE UN FIN CUANDO ACABA EL ARCHIVO, PONEMOS ESTE FOR ;; PARA QUE LEA CONTINUAMENTE Y SALIMOS DEL BLUCLE CON ESE TRY CATCH
            for(;;){
                int col1=di.readInt();//LEEMOS LOS NUMEROS DEL ARCHIVO Y LO PONEMOS EN UN INT
                sumaNotas+=col1;//SUMATORIO DE NUMEROS
                cantidad++;//SUMATORIO DE VUELTAS PARA SABER CUANTAS NOTAS TENEMOS
                int col2=di.readInt();
                sumaPesos+=col2;
                sumaPonderada+=(col1*col2);//LA SUMA PONDERADA ES UNA MULTIPLICACION DE LAS DOS COLUMNAS Y SU SUMATORIO
                //A VER ES SENCILLO, LA PRIMERA NOTA (12) POR EJEMPLO, VALE 1 Y LA 3º NOTA (8) POR EJEMPLO VALE 3, ENTONCES LO QUE HACEMOS ES MULTIPLICAR LA PRIMERA NOTA
                //CON EL NUMERO DE LA POSICION DE LA PRIMERA Y ASI Y DESPUES SE HACE UN SUMATORIO TOTAL.
            }
        } catch (EOFException e) {
            double media = (double)sumaNotas/cantidad;//ASI HACEMOS LA MEDIA
            System.out.println("La media es de: " +media);
            double mediaPonderada = (double) sumaPonderada / sumaPesos;
            System.out.println("La media ponderada es de: " +mediaPonderada);
        }
    }
    
}
