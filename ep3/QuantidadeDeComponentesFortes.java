/* 

C�lculo dos componentes fortemente conectados.
Entrada: Um grafo nao-ponderado.
Saida: A express�o dos componentes fortemente conectados.

*/

// Declara��o deste pacote.
package ep3;

// Usaremos as classes do pacote ep0.
import ep0.*;

public class QuantidadeDeComponentesFortes {

    public static void main( String args[] ) {
        Grafo G = new Grafo();
        G.leDoTeclado();

        // 1o DFS no grafo original G.
        // Queremos calcular os instantes de finalizacao dos vertices.
        DFS dfs1 = new DFS(G);

        // cria grafo transposto com verts em ordem decrescente de v.f
        int[] finalizacao = dfs1.getInstantesDeFinalizacao();
        OrdenaPorInsercao oi = new OrdenaPorInsercao(finalizacao);
        int[] indicesOrdenados = oi.getIndicesOrdenados(); // Ordem crescente.

        // Cria um grafo transposto.
        Grafo Gt = G.getGrafoTransposto();

        // 2o DFS no grafo transposto.
        // Escolhe ordem decrescente para visita DFS.
        int n = G.getTotalDeVertices();
        int[] decrescente = new int[n];
        for (int i = 0; i < n; i++)
            decrescente[n-1-i] = indicesOrdenados[i];
        DFS dfs2 = new DFS(Gt, decrescente);

        String expressao = dfs2.getExpressaoDeParenteses();
        System.out.println(expressao);
        
        
        
        
        int k = 0, count = 0;
        for (int i = 0; i < expressao.length(); i++){
        	char c = expressao.charAt(i);
        	if(c=='(') k++;
        	if(c==')') {
        		k--;
        		if(k==0) count++;
        	}
        }
        
        System.out.println(count + " componente(s) forte(s)");
        
        
        
        
        
        
        
        
        
    }

} // fim da classe ComponentesFortes.
