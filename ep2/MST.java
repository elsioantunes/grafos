/*

Esta programa usa o algoritmo de Prim para calcular uma 
�rvore geradora minima.
Entrada: um grafo ponderado.
Saida: imprime o peso de uma �rvore geradora minima.

*/

// Declara��o deste pacote.
package ep2;

// Usaremos as classes do pacote ep0.
import ep0.*;

public class MST {

    public static void main( String args[] ) {
        // Cria uma inst�ncia de um grafo ponderado (com pesos nos arcos).
        GrafoPonderado G = new GrafoPonderado();
        // Faz a leitura do grafo via teclado.
        G.leDoTeclado();

        // Chama o algoritmo de Prim, com o �ndice 0
        // para o v�rtice inicial.
        Prim mst = new Prim(G, 0);
        // Imprime na tela o peso da �rvore calculada.
        System.out.println(mst.getPesoDaArvoreGeradoraMinima());
    }

} // Fim da classe MST.

