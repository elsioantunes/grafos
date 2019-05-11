/*

Algoritmo de busca em largura para calcular uma matriz de distancias.
Entrada: um grafo (sem pesos nos arcos) e um �ndice de um v�rtice s.
Saida: cada v�rtice v tem um atributo v.d com a dist�ncia de s at� v.
       Desta forma, podemos calcular um vetor de dist�ncias, onde
       vetorDeDistancias[i] = distancia de s at� o v�rtice com �ndice i.

*/

// Declara��o deste pacote.
package ep1;

// Usaremos as classes do pacote ep0.
import ep0.*;

// Usaremos a classe LinkedList do Java.
import java.util.LinkedList;

public class BFS {
    private int[] vetorDeDistancias;         // Distancias calculadas.

    // O construtor recebe o grafo e um �ndice de um v�rtice inicial.
    // A execucao do algoritmo pode ser feita aqui mesmo,
    // dentro do construtor.
    public BFS(Grafo G, int indiceDoVertice_s) {
        int n = G.getTotalDeVertices();
        Vertice[] vertices = G.getVertices();
        Vertice s = vertices[indiceDoVertice_s];
        // Inicializacao: todos os vertices sao pintados de branco,
        // com o atributo "d" inicialmente infinito.
        for (int i = 0; i < n; i++) {
            Vertice v = vertices[i];
            v.d = Constantes.INFINITO;
            v.cor = Cores.BRANCO;
            v.PI = null;
        }
        // Para o vertice inicial s, s.d = 0 e � pintado de cinza.
        s.d = 0;
        s.cor =  Cores.CINZA;
        s.PI = null;
        Fila Q = new Fila();
        Q.insereNaFila(s);
        
        // Execucao do algoritmo.
        // Enquanto a fila nao estiver vazia, o algoritmo examina
        // os vizinhos brancos do v�rtice u.
        while (!Q.filaVazia()) {
            Vertice u = (Vertice)Q.removeDaFila();
            LinkedList[] listaDeAdjacencia = G.getListaDeAdjacencia();
            // Visita os vizinhos brancos, atualiza as suas distancias,
            // pinta de cinza e insere na fila.
            for(int j = 0; j < listaDeAdjacencia[u.getIndice()].size(); j++) {
                Arco a = (Arco)listaDeAdjacencia[u.getIndice()].get(j);
                Vertice v = a.getDestino();
                if (v.cor == Cores.BRANCO) {
                	v.d = u.d+1;
                	v.PI = u;
                	v.cor = Cores.CINZA;
                	Q.insereNaFila(v);
                }
            }
            // Finaliza u com a cor preta, pois todos os seus vizinhos
            // ja foram visitados.
            u.cor = Cores.PRETO;
        }

        // Guarda os resultados em um vetor de distancias.
        vetorDeDistancias = new int[n];
        for (int i = 0; i < n; i++) {
            Vertice v = vertices[i];
            vetorDeDistancias[i] = v.d;
        }
    }
    
    // Devolve o vetor das distancias a partir do vertice inicial s.
    public int[] getVetorDeDistancias() {
        return vetorDeDistancias;
    }

}


            