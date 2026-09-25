package com.ada.flujo_caracteres;
import java.io.*;
public class ej05 {
    public static void main(String[] args) throws IOException {

        //CREAMOS LA RUTA PARA LEER Y EL BR ES QUE EL LEE POR LINEAS DE TEXTO
        File d = new File ("ud1/src/main/java/com/ada/flujo_caracteres/texto.txt"); //CREA LA RUTA
        FileReader fr = new FileReader(d);
        BufferedReader br = new BufferedReader(fr);
        String linea;
        int contador=0; //INICIALIZAMOS EL CONTADOR

        //EL EJERCICIO TE PÌDE QUE CUENTES CUANTAS PALABRAS HAY, POR LO QUE LO MEJOR SERA CONTAR LOS ESPACIOS.
        while((linea=br.readLine())!=null){ //HACEMOS UN WHILE CON UNA CONDICION QUE DIGA QUE MIENTRAS HAYA LINEAS QUE LEER SE SIGA BUSCANDO
            if(!linea.trim().isEmpty()){ //SE CREA UNA CONDICION PARA CONTAR ESPACIOS
                String[]palabra=linea.trim().split("\\s+"); //HACEMOS UN ARRAY DONDE DENTRO HAY PALABRAS
                contador+=palabra.length;//CREA EL CONTADOR CO N LA SUMA DE TODAS LAS PALABRAS
            }

        }
        br.close();
        System.out.println("Numero total de palabras: " +contador);


        
    }
}
