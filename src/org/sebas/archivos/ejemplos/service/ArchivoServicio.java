package org.sebas.archivos.ejemplos.service;

import java.io.*;
import java.util.Scanner;

public class ArchivoServicio {


    /*
        Cada ves que se crea un archivo se utiliza la clase File,
        el cual representa un archivo
     */
    public void crearArchivo(String nombre){
        //Le pasamos como argumento la ruta completa donde se va crear el file
        File archivo = new File(nombre);

        /*
            TODO = FileWriter
            -> Por cada invocacion de append,writer lo que hace
            es ir al sistema y escribir en el disco en el archivo
            * Si tenemos 100 veces append, va ir 100 veces al disco
            no es tan optimizado

            TODO = BufferedWriter
            Acumula cierta cantidad de caracteres y cuando llegue al limite (8192)
            recien escribe en el disco, utiliza menos recurso
         */

        try {
            //Segundo argumento para indicar que se va ir agregando contenido al archivo ya creado
            //FilWrite se encarga de crear el archivo y mirar si esta creado o no el archivo
            //BufferedWriter -> Se encarga de escribir
            BufferedWriter buffer = new BufferedWriter(new FileWriter(archivo, true));
            //Escribir datos dentro del archivo de forma encadenada
            buffer.append("Hola que tal amigos!").append("todo bien? ")
                    .append("yo aca escribiendo un archivo")
                    .append(", hasta luego Jose");

            //Se encarga de cerrar el archivo y subir los cambios
            buffer.close();
            System.out.println("El archivo se ha creado con éxito");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void crearArchivo2(String nombre){

        File archivo = new File(nombre);

        try {
            /*
                Esta mas optimizado que FileWriter
                Nos permite utilizar el println ,print ,printf
                Escribir en un archivo como si fuera una consola
                Se puede dar mas formato

                Por debajo llama al BufferedWriter
             */
            PrintWriter buffer = new PrintWriter(new FileWriter(archivo, true));
            buffer.println("\nHola que tal amigos!");
            buffer.println("Todo bien? yo acá escribiendo un archivo...");
            buffer.printf("Hasta luego %s", "Lucas");

            buffer.close();
            System.out.println("El archivo se ha creado con éxito");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String leerArchivo(String nombre){
        //Se utiliza al Reader -> BufferedReader, FileReader
        StringBuilder sb = new StringBuilder();
        File archivo = new File(nombre);
        try {
            BufferedReader reader = new BufferedReader(new FileReader(archivo));
            String linea;
            while( (linea = reader.readLine()) != null ){
                sb.append(linea).append("\n");
            }
            //No es obligatorio pero se recomienda para optimizar, se libera recursos
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    public String leerArchivo2(String nombre){
        //Se utiliza al Reader -> BufferedReader, FileReader
        StringBuilder sb = new StringBuilder();
        File archivo = new File(nombre);
        try {
            Scanner s = new Scanner(archivo);
            s.useDelimiter("\n");

            while( s.hasNext() ){
                sb.append(s.next()).append("\n");
            }
            //No es obligatorio pero se recomienda para optimizar, se libera recursos
            s.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

}
