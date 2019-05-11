/*

Algoritmo de Prim para calcular uma arvore geradora minima.
Entrada: um grafo ponderado (e conexo).
Saida: calcula o peso de uma árvore geradora mínima
       (a árvore pode ser obtida pelo atributo "pai").

*/

// Declaração deste pacote.
package ep2;

// Usaremos as classes do pacote ep0.
import ep0.*;

// Usaremos a classe LinkedList do Java.
import java.util.LinkedList;

public class Prim {
    // Peso da arvore geradora minima calculada.
    private int pesoDaMST;
    
    // O construtor recebe um grafo ponderado e um vertice inicial para
    // calcular uma arvore geradora minima.
    // (O vértice inicial r será a raiz da MST.)
    public Prim(GrafoPonderado G, int indiceDoVertice_r) { 
        int n = G.getTotalDeVertices();
        Vertice[] vertices = G.getVertices();
        Vertice r = vertices[indiceDoVertice_r];
        // Inicializacao do algoritmo de Prim.
        // Todas as chaves sao infinitas e pai vazios.
        for (int i = 0; i < n; i++) {
            Vertice v = vertices[i];
            v.chave = Constantes.INFINITO;
            v.pai = null; 
        }

        r.chave = 0;  
        FilaDePrioridade Q = new FilaDePrioridade(vertices);
        
        LinkedList[] listaDeAdjacencia = G.getListaDeAdjacencia();
        while (!Q.filaVazia()) {
            Vertice u = Q.extraiMinimo();
            for(int j = 0; j < listaDeAdjacencia[u.getIndice()].size(); j++) {
                Arco e = (Arco)listaDeAdjacencia[u.getIndice()].get(j);
                Vertice v = (Vertice) e.getDestino();
                int w_uv = e.getPeso();
                if (Q.estaNaFila(v) && w_uv < v.chave) {
                	v.chave = w_uv;
                	v.pai = u;
                }
            }
        }

        // Calcula o peso total da arvore geradora minima.
        // Este valor pode ser obtido a partir do atributo "chave" dos vertices.
        pesoDaMST = 0;
        for (int i = 0; i < n; i++)
            pesoDaMST += vertices[i].chave;
    }
    
    // Devolve o peso da arvore geradora minima.
    public int getPesoDaArvoreGeradoraMinima() {
        return pesoDaMST;
    }
    
} // Fim da classe Prim.
