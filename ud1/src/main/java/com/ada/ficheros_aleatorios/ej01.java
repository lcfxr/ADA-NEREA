package com.ada.ficheros_aleatorios;

import java.io.IOException;
import java.io.RandomAccessFile;

public class ej01 {

    public static void main(String[] args) throws IOException {
        /**
         * Escribe un programa que, dado un fichero como entrada, modifique el fichero eliminando los espacios en blanco y convirtiendo 
         * las minúsculas en mayúsculas. 
         */
        RandomAccessFile miRAFile;//CREAMOS VARIABLE DE FICHERO
        miRAFile=new RandomAccessFile("ud1/src/main/java/com/ada/flujo_caracteres/texto.txt", "rw");//LLAMAMOS AL FICHERO QUE QEUREMOS Y PONEMOS RW PORQUE ES DE LECTURA Y ESCRITURA
        long posicion = 0; //PARA GUARDAR LA POSICION QUE QUEREMOS
        int b; //variable para leer los bytes
        while((b=miRAFile.read())!=-1){//ESTAMOS ASIGNADO LOS BYTES A B Y LOS ESTAMOS LEYENDO Y SE PARA CUANDO SEA -1
            long posicionLectura=miRAFile.getFilePointer();//GUARDAMOS LA POSICION
            if(b!=' '){//SI B NO ES UN ESPACIO
                b=Character.toUpperCase((char) b);//CAMBIAMOS A MAYUSCULA
                miRAFile.seek(posicion);//NOS MOVEMOS A LA POSICION INICIAL
                miRAFile.writeByte(b);
                posicion=miRAFile.getFilePointer();
            }
            miRAFile.seek(posicionLectura);
            
        }
        miRAFile.setLength(posicion); //PASA A LA NUEVA LONGITUD
        miRAFile.close();
    }
    
}
