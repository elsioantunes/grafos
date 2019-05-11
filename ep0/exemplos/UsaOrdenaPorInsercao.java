/*

Esta classe ilustra o uso da classe OrdenaPorInsercao.

*/

// Note que este pacote é o subdiretório  ep0/exemplos/
package ep0.exemplos;

// Usaremos as classes do pacote ep0.
import ep0.*;

public class UsaOrdenaPorInsercao {
    // Um exemplo simples para testar o algoritmo.
    public static void main( String args[] ) {
        System.out.println("\nValores originais sem ordenacao:");
        int[] v1 = {5, 3, 2, 1, 4};
        int tot = v1.length;
        for (int i = 0; i < tot; i++)
            System.out.print(v1[i]+", ");

        System.out.println("\nValores ordenados:");
        OrdenaPorInsercao s = new OrdenaPorInsercao(v1);
        int[] v2 = s.getValoresOrdenados();
        for (int i = 0; i < tot; i++)
            System.out.print(v2[i]+", ");

        System.out.println("\nIndices ordenados:");
        int[] ind = s.getIndicesOrdenados();
        for (int i = 0; i < tot; i++)
            System.out.print(ind[i]+", ");
        System.out.println();
    }
}
