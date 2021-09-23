package org.sebas.archivos.ejemplos;

import org.sebas.archivos.ejemplos.service.ArchivoServicio;

public class EjemploCrearArchivo {
    public static void main(String[] args) {

        //La ruta debe existir, si no existe el archivo lo va crear y luego actualiza
        String nombreArchivo = "C:\\Cursos\\Java\\archivo\\java.txt";
        ArchivoServicio servicio = new ArchivoServicio();
        servicio.crearArchivo2(nombreArchivo);

    }
}
