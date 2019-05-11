/* 

Este programa usa a busca em largura para calcular uma matriz de distancias.
Entrada: Um grafo (sem pesos nos arcos).
Saida: Uma matriz de distancias (baseada nos indices dos vertices).

*/

// Declara��o deste pacote.
package ep1;

// Usaremos as classes do pacote ep0.
import ep0.*;

public class MatrizDeDistancias {

    public static void main( String args[] ) {
        // Cria uma inst�ncia de um grafo (n�o-ponderado).
        Grafo G = new Grafo();
        // Faz a leitura do grafo via teclado.
        G.leDoTeclado();

        // Aloca espa�o para a matriz de distancias.
        int n = G.getTotalDeVertices();
        int[][] matrizDeDistancias = new int[n][];

        // Calcula a matriz de distancias usando BFS.
        for (int i = 0; i < n; i++) {
            // Executa a busca em largura a partir de cada v�rtice
            // com indice i.
            BFS bfs = new BFS(G,i);
            // Cada linha da matriz � preenchida com um vetor das
            // dist�ncias calculadas.
            matrizDeDistancias[i] = bfs.getVetorDeDistancias();
        }

        // Imprime a matriz de dist�ncias na tela.
        // Se a dist�ncia � INFINITA, imprime '*'.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrizDeDistancias[i][j] < Constantes.INFINITO)
                    System.out.print(matrizDeDistancias[i][j]+" ");
                else
                    System.out.print("* ");
            }
            System.out.println();
        }
    }

} // Fim da classe MatrizDeDistancias
