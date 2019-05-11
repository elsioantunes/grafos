/*

Representacao de um vertice:
- possui um indice de identificacao;
- como atributos adicionais, pode possuir os atributos:
  "d" (distancia ou instante de descoberta), 
  "chave",
  "cor",
  "f" (instante de finalizacao),
  "PI" (ou predecessor) 
  e "pai".

*/

// Declaração deste pacote.
package ep0;

public class Vertice {
    private int indice; // Indice do vertice no grafo.

    // Publicos intencionalmente para serem acessados diretamente pelos algoritmos.
    public int d;     // Guarda uma distancia ou um instante de descoberta 
                       // de uma busca em profundidade.
    public int chave; // Uma chave para FilaDePrioridade.
    public int f;   // Um instante de finalizacao de uma busca em profundidade.
    public Cores cor; // Guarda uma Cor.
    public Vertice PI;  // Guarda o vertice predecessor em um caminho.
    public Vertice pai; // Guarda o pai do vertice em uma arvore.
    
    // O construtor recebe o indice do vertice.
    public Vertice(int i) {
        indice = i; 
        d = 0; chave = 0; cor = Cores.SEMCOR; PI = null; pai = null;
    }

    // Devolve o indice do vertice.
    public int getIndice() {
        return indice;
    }

} // Fim da classe Vertice.
