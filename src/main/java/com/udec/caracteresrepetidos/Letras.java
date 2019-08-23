/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udec.caracteresrepetidos;

import java.util.Scanner;

/**
 *
 * @author AndresChila, Tatiana Moreno
 */
public class Letras {

    //variable donde se guarda la cadena entrante

    private String palabra;
    /**
     * array de caracteres en el cual se guardan los caracteres separados de la
     * frase
     */
    private char[] caracteres;
    /**
     * variable que nos sirve para llevar control de la posicion de la palabra
     * que estamos analizando
     */
    private byte contador = 1;
    //variable que lleva la letra que menos se repite
    private char identificadorLetra;
    //variable para llevar cantidad de la letra que se esta analizando
    private byte acumuladorLetra = 0;
    //variable que sirve para llevar cantidad de la letra siguiente
    private byte cantidad;
    //variable para hacer que solo entre una vez al if
    private boolean soloPrimera;

    /**
     * Constructor de la clase donde se capturan los datos
     */
    public Letras() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite la palabra:  ");
        //Lectura de la palabra a analizar
        palabra = scanner.nextLine();
        //Se reemplazan los espacios en la frase
        palabra.replace(" ", "");
        //Se crea el array con la misma longitud de la frase entrante 
        caracteres = new char[palabra.length()];
        //Convierte la frase a un array de caracteres
        caracteres = palabra.toCharArray();

        analizaCaracteres();
    }

    /**
     *
     */
    public void analizaCaracteres() {
        System.out.println("Frase: " + palabra);
        for (byte i = 0; i < palabra.length(); i++) {
            System.out.println("Leyendo: " + caracteres[i] + " ");
            for (byte j = 0; j < palabra.length(); j++) {
                if (caracteres[i] == caracteres[j]) {
                    acumuladorLetra++;
                }
            }
            if (acumuladorLetra == 1 && soloPrimera == false) {
                System.out.println("La primera letra que no se repite: " + caracteres[i] + " ");
                soloPrimera = true;
            } else if (acumuladorLetra == 1 && soloPrimera == true) {
                System.out.println("La letra que no se repite: " + caracteres[i] + " ");
            }
            acumuladorLetra = 0;
        }
    }
}
