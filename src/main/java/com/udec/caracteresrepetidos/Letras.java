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
 * 
 * Clase que se encarga de analizar el primer caracter que menos se ha repedito en un string 
 */
public class Letras {

    //variable donde se guarda la cadena entrante
    private String palabra;
    /**
     * array de caracteres en el cual se guardan los caracteres separados de la
     * frase
     */
    private char[] caracteres;
    /**array que nos sirve para llevar cuenta de cuantas veces lleva repetida 
    *una letra hasta esa posicion al momento de recorrer la frase
    */
    private byte[] acumuladorLetra;
    /**
     * variable que nos sirve para llevar control de la posicion de la palabra
     * que estamos analizando
     */
    private byte contador = 1;
    //variable que lleva la letra que menos se repite
    private char identificadorLetraMenor;
    //variable que sirve para llevar cantidad de la letra siguiente
    private byte cantidad=50;
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
        acumuladorLetra = new byte [palabra.length()];
        //Convierte la frase a un array de caracteres
        caracteres = palabra.toCharArray();
        inicializaArray();
        analizaCaracteres();

    }

    /**
     *Metodo que compara el array una letra vs todas las demas y cuenta la 
     *cantidad que se repite cada una en el array y guarda esa cantidad en 
     * acumuladorLetra[]
     */
    public void analizaCaracteres() {
        System.out.println("Frase: " + palabra);
        for (byte i = 0; i < palabra.length(); i++) {
            System.out.println("Leyendo: " + caracteres[i] + " ");
            for (byte j = 0; j < palabra.length(); j++) {
                if (caracteres[i] == caracteres[j]) {
                    acumuladorLetra[i]++;
                }
                //System.out.print(acumuladorLetra[j]);
            }
            imprimeMenorVecesRepetido();
            contador++;
        }
    }
    /**
     *Metodo que inicializa todas las posiciones del array en cero
     */
    public void inicializaArray(){
        for(byte i =0; i< palabra.length();i++){
            acumuladorLetra[i]=0;
        }
    }
    /**
     * metodo que compara cual es el que menos se repite en el array acumuladorLetra[]
     * e imprime el menor
     */
    public void imprimeMenorVecesRepetido(){
        contador--;
        for(byte i = contador;i< palabra.length();i++){
            for(byte j = contador;j<palabra.length();j++){
                if(acumuladorLetra[i]<cantidad && acumuladorLetra[i]!=0){
                    cantidad=acumuladorLetra[i];
                    identificadorLetraMenor = caracteres[i];
                }
            }
        }
        System.out.println(" la primera letra que menos se repite es: "+ identificadorLetraMenor);
    }
}

