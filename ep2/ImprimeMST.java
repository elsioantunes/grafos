/*

Esta programa usa o algoritmo de Prim para calcular uma 
árvore geradora minima.
Entrada: um grafo ponderado.
Saida: imprime o peso de uma árvore geradora minima.

*/

// Declaração deste pacote.
package ep2;

// Usaremos as classes do pacote ep0.
import ep0.*;

public class ImprimeMST {

    public static void main( String args[] ) {
        // Cria uma instância de um grafo ponderado (com pesos nos arcos).
        GrafoPonderado G = new GrafoPonderado();
        // Faz a leitura do grafo via teclado.
        G.leDoTeclado();

        // Chama o algoritmo de Prim, com o índice 0
        // para o vértice inicial.
        Prim mst = new Prim(G, 0);
        
        int n = G.getTotalDeVertices();
        Vertice[] vertices = G.getVertices();
        
        for (int i = 0; i < n; i++){
        	Vertice v = vertices[i];
    		if(v.pai != null)
    			System.out.println(v.pai.getIndice() + " - " + v.getIndice());	
        }
    }
} 

