package com.ada.xml;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;//PARA XML RECUERDA ESTOS, NO LOS OTRO QAUE TE DE, SIEMPRE LOS DE W3C
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class Ej01 {
    public static void main(String[] args) throws Exception {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();// ESTO ES LO 1º QUE SE PONE PARA CREAR UN
                                                                          // DOCUMENTO
        DocumentBuilder db = dbf.newDocumentBuilder();// ESTO ES LO 2º
        Document doc = db.newDocument();// SI EL DOCUMENTO ESTA EN BLANDO PONEMOS NEW DOCUMENT, SI QUEREMOS AÑADIR UN XML YA CREADO HACEMOS PARSE(NEW FILE("RUTA DEL XML"))

        // AHORA PASAMOS A CREAR EL DOCUMENTO XML
        // HACEMOS PRIMERO LA RAIZ QUE SERA LIBRERIA
        Element libreria = doc.createElement("libreria");// ES LA ETIQUETA PRINCIPAL Y DENTRO HAY HIJITOS
        doc.appendChild(libreria); // LA UNIMOS AL DOCUMENTO

        Element nombre = doc.createElement("nombre");
        nombre.setTextContent("Libreria Pepe");// ESTAMOS CREANDO UNA ETIQUETA SENCILLA SOLO CON EL NOMBRE DE LA LIBRERIA
        libreria.appendChild(nombre);// LA UNIMOS AL PADRE

        Element libros = doc.createElement("libros");// CREAMOS LA ETIQUETA LIBROS, SERIA COMO LA CAJA QUE GUARDA LOS DOS LIBROS
        libreria.appendChild(libros);// LA UNIMOS AL PADRE

        Element libro1 = doc.createElement("libro");// CREAMOS LA NIETA DE LIBRERIA
        libro1.setAttribute("isbn", "1234567890");// LE AÑADIMOS LOS ATRIBUTOS
        libros.appendChild(libro1);// UNIMOS A LIBROS

        Element titulo1 = doc.createElement("titulo");
        titulo1.setTextContent("Don Quijote de la Mancha");
        libro1.appendChild(titulo1);

        Element autor1 = doc.createElement("autor");
        autor1.setTextContent("Miguel de Cervantes");
        libro1.appendChild(autor1);

        Element libro2 = doc.createElement("libro");
        libro2.setAttribute("isbn", "4567890123");
        libros.appendChild(libro2);

        Element titulo2 = doc.createElement("titulo");
        titulo2.setTextContent("Lazarillo de Tormes");
        libro2.appendChild(titulo2);

        Element autor2 = doc.createElement("autor");
        autor2.setTextContent("Anonimo");
        libro2.appendChild(autor2);

        Element libro3 = doc.createElement("libro");
        libro3.setAttribute("isbn", "2345678901");
        libros.appendChild(libro3);

        Element titulo3 = doc.createElement("titulo");
        titulo3.setTextContent("La vida es sueño");
        libro3.appendChild(titulo3);

        Element autor3 = doc.createElement("autor");
        autor3.setTextContent("Pedor Calderón de la Barca");
        libro3.appendChild(autor3);

        /**
         * <?xml version="1.0" encoding="UTF-8" standalone="no"?>
         * <libreria>
         * <nombre>Librería Pepe</nombre>
         * <libros>
         * <libro isbn="1234567890">
         * <titulo>Don Quijote de la Mancha</titulo>
         * <autor>Miguel de Cervantes</autor>
         * </libro>
         * <libro isbn="2345678901">
         * <titulo>Lazarillo de Tormes</titulo>
         * <autor>Anónimo</autor>
         * </libro>
         * <libro isbn="45678910123">
         * <titulo>La vida es sueño</titulo>
         * <autor>Pedro Calderón de la Barca</autor>
         * </libro>
         * </libros>
         * </libreria>
         */

        Transformer t = TransformerFactory.newInstance().newTransformer();// ESTO ES PARA QUE JAVA RECORRA EL DOCUMENTO Y SE LEA POR PANTALLA
        t.setOutputProperty(OutputKeys.INDENT, "yes");
        t.transform(new DOMSource(doc), new StreamResult(System.out));

        // EJERCICIO 2 //RECORRER LOS ELEMENTOS DE LA LISTA
        System.out.println("Libreria" + nombre.getTextContent());

        // NODE ES EL NOMBRE PARA CUALQUIER TROZO DEL ARBOL XML  SIRVE PARA GUAERDAR DISTINTAS COSAS JUNTAS

        NodeList lista = doc.getElementsByTagName("libro");// SIRVE PARA GUARDAR TODO LO QUE SE ENCUENTRE EN LA ETIQUETA LIBRO

        for (int i = 0; i < lista.getLength(); i++) {// RECORRE LA LISTA DE ETIQUETAS DE LIBROS
            Element libro = (Element) lista.item(i);// LISTA.ITEM ES PARA COGER UN LIBRO DE LA LISTA, HACE UN CAST PORQUE EN EL NODE LO QUE ESTAMOS COGIENDO SON ELEMENTS (ETIQUETAS)

            String isbn = libro.getAttribute("isbn"); // CREAMOS LA VARIABLE ISBN Y LA ASOCIAMOS AL ISBN DE LA ETQIETA LIBRO
            String titulo = libro.getElementsByTagName("titulo").item(0).getTextContent();// PONEMMOS ITEM 0 PARA QUE NOS SALGA DESDE EL LIBRO 1
            String autor = libro.getElementsByTagName("autor").item(0).getTextContent();

            System.out.println("LIBRO: " + (i + 1));
            System.out.println("TITULO: " + titulo);
            System.out.println("ISBN: " + isbn);
            System.out.println("AUTOR: " + autor);
        }

        // EJ3 CREAR EL XML A PARTIR DE DOOM ESTE EJERCICIO LO TENEMOS EN MEMORIA PERO NO TENEMOS UN ARCHIVO XML GUARDADO, VAMOS A CREARLO

        File archivo = new File("libreria.xml");// CREA EL ARCHIVO XML
        Transformer transformer = TransformerFactory.newDefaultInstance().newTransformer();
        /**
         * TRANSFORMER ES EL TRANSFOPRMADOR QUE CONVIERTE EL ARBOL EN XML
         * TransformerFactory FABRICA DE TRANSFORMADORES
         * .newInstance() CREA UNA FABRICA NUEVA
         * .newTransformer() HAZME UN TRASNFORMADOR
         */
        transformer.setOutputProperty(OutputKeys.INDENT, "yes"); // EL INDENT ES UNA SANGRIA, EL XML SALE ORDENADO
        transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");// EL UTF 8 ES PARA QUE SE VEAN LAS TILDES Y LAS Ñ YDEMAS

        DOMSource origen = new DOMSource(doc);// EL ORIGEN ES EL ARBOL DOOM doc
        StreamResult destino = new StreamResult(archivo);// EL DESTINO ES archivo QUE ES DONDE HEMOS GUARDADO LA RUTA PARA CREAR EL ARCHIVO libreri.xml

        transformer.transform(origen, destino);// COGE EL ARBOL Y ESCRIBELO EN EL DESTINO

        System.out.println("ARCHIVO CREADO EN: " + archivo.getAbsolutePath());// TE MUESTRA LA RUTA

        // EJERCICIO 4, AÑADIR UN LIBRO YA TENEMOS LO MAS COMPLICADO QUE ES CREAR EL ARBOLD OOM, CON LAS ETIQUETAS Y GUARDARLO EN UN ARCHIVO XML

        Element libro4 = doc.createElement("libro");
        libro4.setAttribute("isbn", "8901234567");
        libros.appendChild(libro4);

        Element titulo4 = doc.createElement("titulo");
        titulo4.setTextContent("100 años de soledad");
        libro4.appendChild(titulo4);

        Element autor4 = doc.createElement("autor");
        autor4.setTextContent("Gabriel Garcia Marquez");
        libro4.appendChild(autor4);

        t.transform(new DOMSource(doc), new StreamResult(System.out));// PARA MOSTRA EL XML DESDE EL ORIGEN, EL DOC DE DOOM A DESTINO EL SYSO

        //EJERCICIO 5 INTRODUCR ERTIQUETA DIRECCION
        Element direccion = doc.createElement("dirección");
        direccion.setTextContent("C/ Amiel 26");
        libreria.appendChild(direccion);
        libreria.insertBefore(direccion, libros); //ASI CUANDO SALGA SALDRA EN ORDEN

        t.transform(new DOMSource(doc), new StreamResult(System.out));// PARA MOSTRA EL XML DESDE EL ORIGEN, EL DOC DE DOOM A DESTINO EL SYSO

        //EJERCICIO 6 ELIMINAR EL SEGUNDO LIBRO

        NodeList listaLibros = doc.getElementsByTagName("libro");//BUSCAMOS TODOS LOS LIBROS
        Element segundo = (Element)listaLibros.item(1);//EL ITEM 1 ES EL SEGUNDO LIBRO
        libros.removeChild(segundo);//BORRAMOS

        t.transform(new DOMSource(doc), new StreamResult(System.out));// PARA MOSTRA EL XML DESDE EL ORIGEN, EL DOC DE DOOM A DESTINO EL SYSO

        //EJERCICIO 7 CAMBIAR LA DIRECCION
        direccion.setTextContent("C/ Amiel 26");
        t.transform(new DOMSource(doc), new StreamResult(System.out));// PARA MOSTRA EL XML DESDE EL ORIGEN, EL DOC DE DOOM A DESTINO EL SYSO


        //EJERCICIO 8. AÑADE EL ATRIBUTO ESTADO A LOS LIBROS E INDICA SU VALOR

        listaLibros=doc.getElementsByTagName("libro");

        for (int i=0; i<listaLibros.getLength(); i++){
            Element libro = (Element)listaLibros.item(i);
            libro.setAttribute("estado", "Disponible");
        }
        t.transform(new DOMSource(doc), new StreamResult(System.out));// PARA MOSTRA EL XML DESDE EL ORIGEN, EL DOC DE DOOM A DESTINO EL SYSO

        //EJERCICIO 9 ELIMINAR ESTADO DE 1º Y 3º LIBRO
        Element primero = (Element)listaLibros.item(0);
        Element segundol = (Element)listaLibros.item(2);

        primero.removeAttribute("estado");
        segundol.removeAttribute("estado");
        t.transform(new DOMSource(doc), new StreamResult(System.out));// PARA MOSTRA EL XML DESDE EL ORIGEN, EL DOC DE DOOM A DESTINO EL SYSO

    }

}
