/* 

Da entrada padrão, le um grafo ponderado e uma sequencia de vertices.
Na saida, imprime se a sequencia é ou nao um caminho no grafo.

*/

// Note que este pacote é o subdiretório  ep0/exemplos/
package ep0.exemplos;

// Usaremos as classes do pacote ep0.
import ep0.*;

public class VerificaCaminhoPonderado {

    public static void main( String args[] ) {
        Grafo G = new Grafo();
        // Leitura do grafo via teclado.
        G.leDoTeclado();

        // Leitura da sequencia de vertices.
        int[] sequencia = Teclado.leInteiros();
        
        // verifica se a sequencia é um caminho no grafo
        boolean sequenciaÉCaminho = true;
        Arco[][] madj = G.getMatrizDeAdjacencia();
        int i = sequencia[0];
        for (int k = 1; k < sequencia.length; k++) {
            int j = sequencia[k];
            // Se algum par consecutivo nao estiver conectado,
            // entao o caminho é invalido.
            if (madj[i][j] == null) {
                sequenciaÉCaminho = false;
                break;
            }
            i = j;
        }
        // Se a sequencia é um caminho:
        if (sequenciaÉCaminho) {
            System.out.print("A sequencia é um caminho de comprimento "
                             +(sequencia.length-1)+".");
        }
        // Se nao é caminho:
        else
            System.out.println("A sequencia nao é um caminho.");
    }

} // Fim da classe VerificaCaminhoPonderado.
