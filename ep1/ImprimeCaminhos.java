/* 

Este programa usa a busca em largura para calcular os caminhos
m�nimos (com menor quantidade de arcos).
Entrada: Um grafo (sem pesos nos arcos) e um �ndice de um 
         v�rtice inicial.
Saida: Os caminhos obtidos a partir do v�rtice inicial.

*/

// Declara��o deste pacote.
package ep1;

// Usaremos as classes do pacote ep0.
import ep0.*;

public class ImprimeCaminhos {

    public static void main( String args[] ) {
        // Cria uma inst�ncia de um grafo (n�o-ponderado).
        Grafo G = new Grafo();
        // Faz a leitura do grafo via teclado.
        G.leDoTeclado();
        
        // Faz a leitura de um �ndice de um v�rtice.
        int indice = Teclado.leInteiros()[0];

        // Executa a busca em largura a partir do v�rtice
        // inicial.
        BFS bfs = new BFS(G, indice);

        // Para cada par de v�rtices a partir do v�rtice inicial,
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
