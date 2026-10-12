package com.ada.xml;

import java.io.File;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class Ej10 {
    //EJERCICIO 10 LEER DOC USANDO SAX
        /**
         * DOM CARGABA TODO EL ARBOL Y LO LEIA COMPLETO SIN EMBARGO SAX LEE DE ARRIBA A ABAJO SOLO UNA VEZ Y VA AVISANDO DE LO QUE ENCUENTRA
         * CADA AVISO SE LLAMA EVENTO. SAX NO PUEDE MODIFICAR COMO CON DOOM
         */
    public static void main(String[] args) throws Exception {
        SAXParserFactory factory = SAXParserFactory.newInstance();//CREADOR DE SAX, LEE EL XML
        SAXParser parser = factory.newSAXParser();
        parser.parse(new File("libreria.xml"), new ManejadorLibreria());
        
    }
}

    class ManejadorLibreria extends DefaultHandler{
        @Override //REESCRIBIR
        public void startDocument()throws SAXException{//PARA ABRIR ARCHIVO
            System.out.println("EMPIEZA EL DOCUEMNTO");
        }
        @Override 
        public void startElement(String url, String localName, String qName, Attributes atts) throws SAXException{//PARA ABRIR ETIQUETA, AÑADIMOS NOMBRE DE ETIQUETAS, ATRIBUTOR Y DEMAS
            System.out.println("Abre: " +qName);
            for (int i=0; i<atts.getLength(); i++){
                System.out.println("Atributo: " +atts.getQName(i) +" = " +atts.getValue(i));
            }
        }
        @Override 
        public void characters(char[]ch, int start, int length) throws SAXException{//PARA EL TEXTO
            String texto = new String(ch, start, length).trim();//TRIM QUITA ESPACIOS Y SALTOS DE LINEA
            if(!texto.isEmpty()){
                System.out.println("Texto: " +texto);
            }
        }
        @Override 
        public void endElement(String url, String localName, String qName) throws SAXException{//CERRAR ETIQUETA
            System.out.println("Cierra: " +qName);
        }
        @Override 
        public void endDocument() throws SAXException{//CERRAR LIBRO
            System.out.println("TERMINA EL DOCUMENTO");
        }
}
