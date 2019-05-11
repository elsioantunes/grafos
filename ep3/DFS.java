
package ep3;
import ep0.*;
import java.util.LinkedList;

public class DFS {
    private int instante; 

    private int[] finalizacoes;

    private String expressaoDeParenteses;

    public DFS(Grafo G) {
        int n = G.getTotalDeVertices();
        int[] ordemUsual = new int[n];
        for (int i = 0; i < n; i++)
            ordemUsual[i] = i; // A ordem usual ser� pelo �ndice do v�rtice.
        inicializaDFS(G, ordemUsual);
    }

    public DFS(Grafo G, int[] ordemDosVertices) {
        inicializaDFS(G, ordemDosVertices);
    }

    public void inicializaDFS(Grafo G, int[] ordemDosVertices) {
        int n = G.getTotalDeVertices();
        expressaoDeParenteses = "";
        
        Vertice[] vertices = G.getVertices();
        for (int i = 0; i < n; i++) {
            Vertice u = vertices[i];

            u.cor = Cores.BRANCO;
        }

        instante = 0;

        for (int i = 0; i < n; i++) {
            int j = ordemDosVertices[i];
            Vertice u = vertices[j];
            if (u.cor == Cores.BRANCO)
                visitaDFS(G,u);
        }
        
        finalizacoes = new int[n];
        for (int i = 0; i < n; i++) {
            Vertice u = vertices[i];
            finalizacoes[i] = u.f;
        }
    }
    
    private void visitaDFS(Grafo G, Vertice u) {
        instante++;


        u.d = instante;
        u.cor = Cores.CINZA;

        expressaoDeParenteses += "("+u.getIndice()+" ";

        LinkedList[] listaDeAdjacencia = G.getListaDeAdjacencia();
        for(int j = 0; j < listaDeAdjacencia[u.getIndice()].size(); j++){
            Arco a = (Arco)listaDeAdjacencia[u.getIndice()].get(j);
            Vertice v = a.getDestino();
            if (v.cor == Cores.BRANCO) {


            	visitaDFS(G,v);
            }
        }

        instante++;


        u.f = instante;
        u.cor = Cores.PRETO;

        expressaoDeParenteses += u.getIndice()+") ";
    }
    
    public int[] getInstantesDeFinalizacao() {
        return finalizacoes;
    }

    public String getExpressaoDeParenteses() {
        return expressaoDeParenteses;
    }
    
}




