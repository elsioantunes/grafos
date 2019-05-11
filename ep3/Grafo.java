/*

Representacao de um grafo com listas de adjacencia e matriz de adjacencia.
Tanto as listas de adjacencia quanto a matriz de adjacencia possuem
referencias para arcos.
Neste caso, temos fácil acesso aos arcos e seus atributos: 
o vizinho v (para o arco uv) e o peso do arco.

Operacoes:

.leDoTeclado(): faz a leitura de um grafo pela entrada padrão via teclado.

.imprimeNaTela(): imprime listas de adjacencia e matriz de adjacencia.

.getVertices(): devolve um vetor de referências aos vertices do grafo.

.getListaDeAdjacencia(): devolve as listas de adjacencia do grafo.

.getMatrizDeAdjacencia(): devolve uma matriz de adjacencia. 

.getTotalDeVertices(): devolve o total de vertices do grafo.

.getTotalDeArcos(): devolve o total de arcos do grafo.

.getGrafoTransposto(): devolve o grafo transposto como uma nova instância
                       da classe Grafo. 
                       O grafo transposto é obtido invertendo-se o sentido de 
                       todos os arcos do grafo original.
*/

// Declaração deste pacote.
package ep0;

// Usaremos a classe LinkedList.
import java.util.LinkedList;

public class Grafo {
    // Declaracao dos atributos do grafo.
    // Os atributos declarados como protected poderão ser diretamente acessados
    // pelas classes herdeiras.
    protected int totalDeVertices, // Total de vertices no grafo.
                    totalDeArcos;   // Total de arestas no grafo.

    // Vetor de vertices: cada elemento é uma referência para um Vertice.
    // Note que numeramos os N vertices de 0 a N-1, usados como índices
    // no vetor.
    protected Vertice[] vertices;  

    // Listas de adjacencia do grafo, com referencias para arcos.
    protected LinkedList[] listaDeAdjacencia; 

    // Matriz  de adjacencia do grafo, com referencias para arcos.
    protected Arco[][] matrizDeAdjacencia; 
    
    // O construtor inicializa os atributos de uma nova instancia 
    // de um grafo vazio, com zero vertices e zero arcos.
    public Grafo() {
        totalDeVertices = 0;
        totalDeArcos = 0;
    }

    
    // Metodo para leitura de um grafo a partir do teclado.
    // O formato de entrada de um grafo é:
    // < total de vertices N >
    // < total de arcos M >
    // < pares de inteiros com os indices de origem e destino dos arcos >
    public void leDoTeclado() {
        // Leitura do total de vertices N.
        totalDeVertices = Teclado.leInteiros()[0];
        // Aloca espaco para o vetor de vertices.
        vertices = new Vertice[totalDeVertices];
        // Cria instâncias para cada um dos N vertices.
        for (int i = 0; i < totalDeVertices; i++) {
            Vertice v = new Vertice(i); // Numera os vértices de 0..N-1.
            vertices[i] = v;
        }
        // Aloca espaco para o vetor das listas de adjacencia.
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
            // Insere arco ij no grafo.
            // Tanto as listas de adjacencia quanto a matriz de adjacencia
            // possuem referencias para arcos.
            Arco a = new Arco(vertices[i],vertices[j]);
            listaDeAdjacencia[i].addLast(a);
            matrizDeAdjacencia[i][j] = a;
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
                Arco a = (Arco)listaDeAdjacencia[i].get(j); // Cast é necessário.
                Vertice v = a.getDestino(); // O vizinho é a ponta final do arco.
                // Imprime o índice do vizinho v.
                System.out.print(v.getIndice()+", "); 
            }
            System.out.println();
        }

        // Imprime a matriz de adjacência.
        //System.out.println("\nMatriz de Adjacencia:");
        for (int i = 0; i < totalDeVertices; i++) {
            for (int j = 0; j < totalDeVertices; j++)
                if (matrizDeAdjacencia[i][j] != null)
                    System.out.print("1 "); // Imprime 1 se existe arco.
                else
                    System.out.print("0 "); // Imprime 0 caso contrário.
            System.out.println();
        }
        
        System.out.println("Total de vertices: "+totalDeVertices);
        System.out.println("Total de arcos: "+totalDeArcos);
    }
    
    // Métodos para acesso ao dados encapsulados nesta classe.
    // Os atributos podem ser encapsulados usando o modificador de acesso private.
    // Desta forma, eles só poderão ser acessados de fora desta classe através
    // de métodos publicos.

    // Devolve o vetor de vertices.
    public Vertice[] getVertices() {
        return vertices;
    }

    // Devolve o vetor das listas de adjacencia.
    public LinkedList[] getListaDeAdjacencia() {
        return listaDeAdjacencia;
    }

    // Devolve a matriz de adjacencia.
    public Arco[][] getMatrizDeAdjacencia() {
        return matrizDeAdjacencia;
    }
    
    // Devolve o total de vertices do grafo.
    public int getTotalDeVertices() {
        return totalDeVertices;
    }

    // Devolve o total de arcos do grafo.
    public int getTotalDeArcos() {
        return totalDeArcos;
    }
    
    // Constroi e devolve o grafo transposto.
    // O grafo transposto Gt é obtido invertendo-se o sentido de todos
    // os arcos do grafo original G.
    // Esta funcao será usada no calculo dos componentes fortemente
    // conectados (EP3).
    public Grafo getGrafoTransposto() {
        // Cria uma nova instancia para o grafo transposto.
        Grafo Gt = new Grafo();
        Gt.totalDeVertices = totalDeVertices;
        Gt.vertices = new Vertice[totalDeVertices];
        for (int i = 0; i < totalDeVertices; i++) {
            Vertice v = new Vertice(i); // Nova instancia de vertice.
            Gt.vertices[i] = v;
        }
        // Gt cria copias dos arcos de G, mas com o sentido invertido.
        Gt.listaDeAdjacencia = new LinkedList[totalDeVertices]; 
        for (int i = 0; i < totalDeVertices; i++)
            Gt.listaDeAdjacencia[i] = new LinkedList();
        Gt.matrizDeAdjacencia = new Arco[totalDeVertices][totalDeVertices];
        Gt.totalDeArcos = totalDeArcos;
        for (int i = 0; i < totalDeVertices; i++)
            for (int j = 0; j < totalDeVertices; j++)
                Gt.matrizDeAdjacencia[i][j] = null;
        for (int i = 0; i < totalDeVertices; i++)
            for (int j = 0; j < totalDeVertices; j++)
                // Se existe arco ij em G...
                if (matrizDeAdjacencia[i][j] != null) { 
                    // ...insere arco ji (direcao invertida)
                    // no grafo transposto.
                    Arco a = new Arco(Gt.vertices[j],Gt.vertices[i]);
                    Gt.listaDeAdjacencia[j].addLast(a);
                    Gt.matrizDeAdjacencia[j][i] = a;
                }
        return Gt;
    }
    
    // Este método é uma fábrica de instâncias.
    // Ele devolve uma nova instância de um grafo bipartido K_{3,3}.
    public static Grafo getK33() {
        Grafo k33 = new Grafo();
        k33.totalDeVertices = 6;
        k33.vertices = new Vertice[k33.totalDeVertices];
        for (int i = 0; i < k33.totalDeVertices; i++) {
            Vertice v = new Vertice(i);
            k33.vertices[i] = v;
        }
        k33.listaDeAdjacencia = new LinkedList[k33.totalDeVertices]; 
        for (int i = 0; i < k33.totalDeVertices; i++)
            k33.listaDeAdjacencia[i] = new LinkedList();
        k33.matrizDeAdjacencia = new Arco[k33.totalDeVertices][k33.totalDeVertices];
        k33.totalDeArcos = 9;
        for (int i = 0; i < k33.totalDeVertices; i++)
            for (int j = 0; j < k33.totalDeVertices; j++)
                k33.matrizDeAdjacencia[i][j] = null;
        for (int i = 0; i <= 2; i++)
            for (int j = 3; j <= 5; j++) {
                Arco a = new Arco(k33.vertices[i],k33.vertices[j]);
                k33.listaDeAdjacencia[i].addLast(a);
                k33.matrizDeAdjacencia[i][j] = a;
                Arco b = new Arco(k33.vertices[j],k33.vertices[i]);
                k33.listaDeAdjacencia[j].addLast(b);
                k33.matrizDeAdjacencia[j][i] = b;
            }
        return k33;
    }

} // Fim da classe Grafo.

