package com.archivos;

import com.archivos.Jcup.parser;
import com.archivos.Jflex.Lexico;

import java.io.StringReader;

public class Main {
    public static void main(String[] args) {
        String texto;
        texto = """
                const\s
                  MAX_ESTUDIANTES = 100;\s
                type\s
                    vector = array [ 1..25] of real;\s
                    aldo = 5 ... 10;\s
                    days, age = integer;\s
                    yes, trzsue = boolean;\s
                    name, city = string;\s
                    fees, expenses = real;\s
                    Books = record\s 
                        title: packed array [1..50] of char;\s 
                        author: packed array [1..50] of char; \s
                        subject: packed array [1..100] of char; \s
                        book_id: integer; \s
                    end;\s
                var\s
                    numEstudiantes: integer = 0;""";

        /*ddd = array [1 .. 25] of real;
                tyhh = 1 ... 10;*/
        interpretar(texto);
    }
    public static void interpretar(String text) {

        parser pars;
        try {
            System.out.println("path " + text);
            StringReader stringReader = new StringReader(text);
            pars = new parser(new Lexico(stringReader));
            pars.parse();
        } catch (Exception ex) {
            System.out.println("Error fatal en compilación de entrada.");
            System.out.println("Causa: "+ex.getCause());
        }
    }
}