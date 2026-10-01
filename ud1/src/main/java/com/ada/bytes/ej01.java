package com.ada.bytes;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ej01 {
    //Realiza un programa que realice una copia de una imagen que se encuentre en tu escritorio. 
    public static void main(String[] args) throws IOException {
        FileInputStream fi = new FileInputStream("C:/Users/noten/Pictures/IMG_20190817_142447.jpg");//EL FILEINPUT LEE EL ARCHIBO DE LA CARPETA
        FileOutputStream fo = new FileOutputStream("ud1/src/main/java/com/ada/bytes/copia.jpg"); // EL FILEOUTPUT HACE LA COPIA, EN EL INPUT HEMOS COPIADO LA RUTA DEL ARCHIVO Y EN EL OUTPUT COPIAMOS LA RUTA DONDE QUEREMOS QUE VAYA

        //IMPORTANTE ESTAMOS TRABAJANDO CON BYTES ENTONCES ESTA LEYENDO NUMERO POR NUMERO POR LO QUE TENEMOS QUE HACER UN BUCLE PARA QUE LEA TODOS LOS NUMEROS QUE SUPONEN EL ARCHIVO
        int datos; //DECLARAMOS LA VARIABLE
        datos=fi.read(); //ASI SE LEEN LOS BYTES DEL INPUT
        while (datos!=-1){ //TE ESTA DICIENDO QUE MIENTRAS DATOS SEA DIFERENTE DE -1, EN EL OUT SE ESCRIBE
            fo.write(datos);
            datos=fi.read(); //VOLVEMOS A LEER LOS DATOS
        }
        fi.close();
        fo.close();
    }
    
}
