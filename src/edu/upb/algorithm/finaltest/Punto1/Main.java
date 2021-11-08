// #########################
// Punto 1
// #########################
package edu.upb.algorithm.finaltest.Punto1;

public class Main {
    static int numFactorial (int n){
        if (n==0){
            return 1;
        }
        return n * numFactorial(n-1);
    }

    public static void main(String[] args) {
        System.out.println("\nNumeros Factoriales hasta el número 4");
        System.out.println(numFactorial(4));
    }
}
//Desarrollado por Estefany Rueda & Pedro Felipe Gomez