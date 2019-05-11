/* 

Este programa usa a busca em largura para calcular os caminhos
mínimos (com menor quantidade de arcos).
Entrada: Um grafo (sem pesos nos arcos) e um índice de um 
         vértice inicial.
Saida: Os caminhos obtidos a partir do vértice inicial.

*/

// Declaração deste pacote.
package ep1;

// Usaremos as classes do pacote ep0.
import ep0.*;

public class ImprimeCaminhos {

    public static void main( String args[] ) {
        // Cria uma instância de um grafo (não-ponderado).
        Grafo G = new Grafo();
        // Faz a leitura do grafo via teclado.
        G.leDoTeclado();
        
        // Faz a leitura de um índice de um vértice.
        int indice = Teclado.leInteiros()[0];

        // Executa a busca em largura a partir do vértice
        // inicial.
        BFS bfs = new BFS(G, indice);

        // Para cada par de vértices a partir do vértice inicial,
        // imprime o caminho obtido, caso exista.
        int n = G.getTotalDeVertices();
        Vertice[] vertices = G.getVertices();
        for (int i = 0; i < n; i++)
            if (i != indice){
                System.out.print("Caminho de "+indice+" ate "+i+": ");
                imprime(vertices[i]);
                System.out.println();
            }
    }
    
    public static void imprime(Vertice v) {
        if (v.PI == null)
            System.out.print(v.getIndice()+" ");
        else {
            imprime(v.PI);
            System.out.print(v.getIndice()+" ");
        }
    }

} // Fim da classe ImprimeCaminhos.
