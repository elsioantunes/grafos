/*

Representacao de um arco:
- possui duas extremidades, um vertice origem e um vertice destino;
- pode ter um atributo adicional, como o peso do arco, no caso de grafos ponderados.

No caso de grafos ponderados, assumimos pesos >= 0.
Se não existir um dado arco, podemos assumir que seu peso vale zero.

*/

// Declaração deste pacote.
package ep0;

public class Arco {
    private Vertice origem, destino; // As duas extremidades deste arco.
    private int peso;                // O peso deste arco.
    
    // O construtor recebe as duas extremidades do arco, a origem e o destino.
    public Arco(Vertice u, Vertice v) {
        origem = u; destino = v;
        peso = 0;   // O valor padrao de inicializacao será zero.
    }

    public Arco(Vertice u, Vertice v, int p) {
        this(u, v); // Usa o construtor anterior.
        peso = p;
    }

    // Devolve a extremidade de origem do arco.
    public Vertice getOrigem() {
        return origem;
    }
    
    // Devolve a extremidade de destino do arco.
    public Vertice getDestino() {
        return destino;
    }

    // Devolve o peso deste arco.
    public int getPeso() {
        return peso;
    }
    
} // Fim da classe Arco.

