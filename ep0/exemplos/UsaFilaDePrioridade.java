
/*

Esta classe ilustra o uso da classe Fila.

*/

// Note que este pacote � o subdiret�rio  ep0/exemplos/
package ep0.exemplos;

// Usaremos as classes do pacote ep0.
import ep0.*;

public class UsaFilaDePrioridade {

    public static void main( String args[] ) {
        Grafo k33 = Grafo.getK33();
        k33.imprimeNaTela();
        
        Vertice[] vertices = k33.getVertices();
        FilaDePrioridade q = new FilaDePrioridade(vertices);
        int n = k33.getTotalDeVertices();
        for (int i = 0; i < n; i++) {
            Vertice v = vertices[i];
            v.chave = n-i;
        }
        System.out.println("Ordem de prioridade na fila: ");
        while (!q.filaVazia()) {
            Vertice u = (Vertice)q.extraiMinimo(); // Cast necessario.
            System.out.print(u.getIndice()+"(chave="+u.chave+"), ");
        }
        System.out.println();
    }

} // Fim da classe UsaFilaDePrioridade.
