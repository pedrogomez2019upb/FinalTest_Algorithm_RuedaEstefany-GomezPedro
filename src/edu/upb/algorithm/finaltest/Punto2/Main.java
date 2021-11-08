// #########################
// Punto 2
// #########################
package edu.upb.algorithm.finaltest.Punto2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

    static final int MAX = 1005;
    static int padre[] = new int[MAX];
    static void creacionSet(int n){
        for( int i = 1 ; i <= n ; ++i ) padre[ i ] = i;
    }
    static int encontrar(int x){
        return ( x == padre[ x ] ) ? x : ( padre[ x ] = encontrar( padre[ x ] ) );
    }
    static void unionPuntos(int x , int y){
        padre[ encontrar( x ) ] = encontrar( y );
    }
    static boolean igualValores(int x , int y){
        if( encontrar( x ) == encontrar( y ) ) return true;
        return false;
    }
    static int vertices , aristas;
    static class Edge implements Comparator<Edge> {
        int origen;
        int destino;
        int peso;
        Edge(){}
        public int compare(Edge e1 , Edge e2 ) {
            return e1.peso - e2.peso;
        }
    };

    static Edge arista[] = new Edge[ MAX ];
    static Edge MST[] = new Edge[ MAX ];

    static void creacionMST(){
        int origen , destino , peso;
        int total = 0;
        int numAristas = 0;
        creacionSet( vertices );
        Arrays.sort( arista , 0 , aristas , new Edge() );

        for( int i = 0 ; i < aristas ; ++i ){
            origen = arista[ i ].origen;
            destino = arista[ i ].destino;
            peso = arista[ i ].peso;
            if( !igualValores(origen , destino) ){
                total += peso;
                MST[ numAristas++ ] = arista[ i ];
                unionPuntos( origen , destino );
            }
        }
        if( vertices - 1 != numAristas ){
            System.out.println("No existe MST valido para el grafo ingresado, el grafo debe ser conexo.");
            return;
        }
        System.out.println("\n################");
        System.out.println("\nRespuesta");
        System.out.println("\n################");
        for( int i = 0 ; i < numAristas ; ++i )
            System.out.println("("+MST[i].origen+" , "+MST[i].destino+") -> "+MST[i].peso);
        System.out.println("\n################");
        System.out.printf( "\nCosto MST: "+ total );
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        vertices = sc.nextInt();
        aristas = sc.nextInt();

        for( int i = 0 ; i < aristas ; ++i ){
            arista[ i ] = new Edge();
            arista[ i ].origen = sc.nextInt();
            arista[ i ].destino = sc.nextInt();
            arista[ i ].peso = sc.nextInt();
        }
        creacionMST();
    }
}
//Desarrollado por Estefany Rueda & Pedro Felipe Gomez