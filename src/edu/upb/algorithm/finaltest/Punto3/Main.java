// #########################
// Punto 3
// #########################
package edu.upb.algorithm.finaltest.Punto3;

import java.util.ArrayList;

public class Main {

    public static boolean llenado(int tonBuqueRes, int tonConte) {
        boolean respuesta = false;
        if (tonBuqueRes >= tonConte) {
            respuesta = true;
        }
        return respuesta;
    }

    public static long maxConte(int tonBuque, int conte[]) {
        int contContainer = 0;
        for (int conActual : conte) {
            if (llenado(tonBuque, conActual)) {
                contContainer++;
                tonBuque = tonBuque - conActual;

            } else {
                break;
            }
        }
        return contContainer;
    }

    public static ArrayList<Integer> maxTon(int conte[], int tonBuque) {
        int buqueAux=tonBuque;
        ArrayList<Integer> sum1 = new ArrayList<Integer>();
        ArrayList<Integer> sum2 = new ArrayList<Integer>();
        int suma1=0;
        int suma2=0;
        for (int conActual : conte) {
            if (llenado(tonBuque, conActual)) {
                sum1.add(conActual);
                tonBuque = tonBuque - conActual;
                suma1= suma1 +conActual;
            } else {
                break;
            }
        }
        for (int i = conte.length ; i >= 0; i--) {
            int conActual = conte[i-1];
            if (llenado(buqueAux, conActual)) {
                sum2.add(conActual);
                buqueAux = buqueAux - conActual;
                suma2= suma2 +conActual;
            } else {
                break;
            }
        }
        if (suma1>suma2) {
            return sum1;
        }else {
            return sum2;
        }
    }

    public static void main(String[] args) {
        int buque = 700;
        int containers[] = {100,155,50,112,70,80,60,118,110,55};

        System.out.println(maxConte(buque, containers));
        for (long l : maxTon(containers, buque)) {
            System.out.println(l);
        }
    }
}
//Desarrollado por Estefany Rueda & Pedro Felipe Gomez