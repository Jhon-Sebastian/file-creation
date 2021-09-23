package org.sebas.archivos.ejemplos;

import org.sebas.archivos.ejemplos.service.ArchivoServicio;

public class EjemploLeerArchivo {
    public static void main(String[] args) {

        ArchivoServicio servicio = new ArchivoServicio();
        String nombreArchivo = "C:\\Cursos\\Java\\archivo\\java.txt";
        System.out.println(servicio.leerArchivo2(nombreArchivo));

    }
}
