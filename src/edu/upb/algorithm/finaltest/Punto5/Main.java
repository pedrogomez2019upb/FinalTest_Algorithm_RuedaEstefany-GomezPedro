// #########################
// Punto 5
// #########################
package edu.upb.algorithm.finaltest.Punto5;

import java.util.Scanner;

public class Main {
    static int buscarCiclo(int[][] distancia, boolean[] ciudadVisitada, int posicion, int cantCiudades, int contador, int costo, int ciclo)
    {
        if (contador == cantCiudades && distancia[posicion][0] > 0)
        {
            ciclo = Math.min(ciclo, costo + distancia[posicion][0]);
            return ciclo;
        }
        for (int i = 0; i < cantCiudades; i++)
        {
            if (ciudadVisitada[i] == false && distancia[posicion][i] > 0)
            {
                ciudadVisitada[i] = true;
                ciclo = buscarCiclo(distancia, ciudadVisitada, i, cantCiudades, contador + 1, costo + distancia[posicion][i], ciclo);
                ciudadVisitada[i] = false;
            }
        }
        return ciclo;
    }
    public static void main(String[] args)
    {
        int ciudades;
        Scanner sc = new Scanner(System.in);
        System.out.println("Cuantas ciudades va a visitar el viajero?:");
        ciudades = sc.nextInt();
        int distancia[][] = new int[ciudades][ciudades];
        for( int i = 0; i < ciudades; i++){
            for( int j = 0; j < ciudades; j++){
                System.out.println("Cuanto es la distancia entre la ciudad#"+ (i+1) +" hasta la ciudad#"+ (j+1) +": ");
                distancia[i][j] = sc.nextInt();
            }
        }
        boolean[] ciudadesVisitadas = new boolean[ciudades];
        ciudadesVisitadas[0] = true;
        int hamiltonianCycle = Integer.MAX_VALUE;
        hamiltonianCycle = buscarCiclo(distancia, ciudadesVisitadas, 0, ciudades, 1, 0, hamiltonianCycle);
        System.out.println("\nCosto de Ruta: "+hamiltonianCycle);
    }
}
//Desarrollado por Estefany Rueda & Pedro Felipe Gomez