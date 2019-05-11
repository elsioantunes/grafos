/*

Representacao de grafo ponderado.
Nesta disciplina, assumimos pesos nao-negativos para os arcos,
ou seja, pesos >= 0.
Se não existir um dado arco, assumimos que seu peso vale zero.

Esta classe herda os atributos e métodos da classe ancestral Grafo.
Além das operacoes disponiveis na classe ancestral Grafo, temos as seguintes
operacoes:

.leDoTeclado(): faz a leitura de um grafo pela entrada padrão via teclado.
                (Sobrepõe o método original para leitura de grafos 
                ponderados).
.imprimeNaTela(): imprime listas de adjacencia e matriz de adjacencia.
                (Sobrepõe método original para impressao de grafos 
                ponderados).

*/

// Declaracao deste pacote.
package ep0;

// Usaremos a classe LinkedList.
import java.util.LinkedList;

public class GrafoPonderado extends Grafo {
    
    // O construtor chama o construtor da classe ancestral, usando
    // a palavra-chave "super".
    public GrafoPonderado() {
        super();
    }

    // Metodo para leitura de um grafo a partir do teclado.
    // O formato basico de entrada de um grafo é:
    // <total de vertices N>
    // <total de arcos M>
    // <triplas de inteiros representado indices de origem e destino 
    //  dos arcos, e o peso do arco>
    public void leDoTeclado() {
        // Leitura do total de vertices N.
        totalDeVertices = Teclado.leInteiros()[0];
        // Aloca espaco para o vetor de vertices.
        vertices = new Vertice[totalDeVertices];
        // Cria N vértices com índices de 0..N-1.
        for (int i = 0; i < totalDeVertices; i++) {
            Vertice v = new Vertice(i);
            vertices[i] = v;
        }
        // Aloca espaco para as listas de adjacencia.
        listaDeAdjacencia = new LinkedList[totalDeVertices]; 
        for (int i = 0; i < totalDeVertices; i++)
            listaDeAdjacencia[i] = new LinkedList();
        // Aloca espaco para a matriz de adjacencia e a inicializa com nulls.
        matrizDeAdjacencia = new Arco[totalDeVertices][totalDeVertices];
        for (int i = 0; i < totalDeVertices; i++)
            for (int j = 0; j < totalDeVertices; j++)
                matrizDeAdjacencia[i][j] = null;
        // Leitura do total de arcos.
        totalDeArcos = Teclado.leInteiros()[0];
        for (int k = 0; k < totalDeArcos; k++) {
            int[] inteiros = Teclado.leInteiros();
            int i = inteiros[0];
            int j = inteiros[1];
            int p = inteiros[2];
            // Insere arco ponderado ij no grafo.
            Arco ap = new Arco(vertices[i],vertices[j],p);
            listaDeAdjacencia[i].addLast(ap);
            matrizDeAdjacencia[i][j] = ap;
        }
    }

    // Metodo para imprimir os atributos do grafo na tela.
    // Imprime as listas de adjacencia, a matriz de adjacencia,
    // e o total de vertices e de arcos.
    public void imprimeNaTela() {
        // Imprime as listas de adjacência.
        //System.out.println("\nListas de Adjacencia:");
        for (int i = 0; i < totalDeVertices; i++) {
            System.out.print(i+": ");
            // Visita cada um dos vizinhos do vértice i.
            // Para isto, devemos percorrer a lista de adjacencia do vértice i.
            for(int j = 0; j < listaDeAdjacencia[i].size(); j++)
            {
                Arco ap = (Arco)listaDeAdjacencia[i].get(j); // Cast é necessário.
                Vertice v = ap.getDestino(); // O vizinho é a ponta final do arco.
                // Imprime o índice e o peso do vizinho v.
                System.out.print(v.getIndice()+"("+ap.getPeso()+"), ");
            }
            System.out.println();
        }

        // Imprime a matriz de adjacência.
        //System.out.println("\nMatriz de Adjacencia:");
        for (int i = 0; i < totalDeVertices; i++) {
            for (int j = 0; j < totalDeVertices; j++)
                if (matrizDeAdjacencia[i][j] != null) // Imprime o peso se existe arco.
                    System.out.print(matrizDeAdjacencia[i][j].getPeso()+" ");
                else
                    System.out.print("0 "); // Imprime 0 caso contrário.
            System.out.println();
        }
        
        System.out.println("Total de vertices: "+totalDeVertices);
        System.out.println("Total de arcos: "+totalDeArcos);
    }
    
} // Fim da classe GrafoPonderado.



