/*

   Esta classe é usada para entrar dados via teclado.
   O método estático usado para leitura de grafos será:
     leInteiros() 

*/

// Declaração deste pacote.
package ep0;

// Usaremos as classes de entrada e saída e de processamento de tokens.
import java.io.*;
import java.util.*;

public class Teclado
  {
  private static InputStreamReader is = new InputStreamReader(System.in);
  private static BufferedReader br = new BufferedReader(is);
  private static StringTokenizer st;
  private static String nt;
  
// Este método é privado e é usado internamente nesta classe.
  private static StringTokenizer getToken() throws IOException, 
      NullPointerException
    {
    String s = br.readLine();
    return new StringTokenizer(s);
    }

// Leitura de uma linha com uma sequencia de valores inteiros separados por espaço.
// Devolve os inteiros em um vetor.
  public static int[] leInteiros() 
    {
    try
      {
      LinkedList inteiros = new LinkedList();
      st = getToken();  // Lê os tokens da linha.
      while (st.hasMoreTokens()) {
          nt = st.nextToken();  
          int i = Integer.parseInt(nt);
          inteiros.addLast(i);
      }
      int[] vetorDeInteiros = null;
      int total = inteiros.size();
      vetorDeInteiros = new int[total];
      for(int j = 0; j < inteiros.size(); j++)
        {
        int i = ((Integer)inteiros.get(j)).intValue();
        vetorDeInteiros[j] = i;
        }
      return vetorDeInteiros;
      }
    catch (IOException ioe)  // Se erro de leitura.
      {
      System.err.println("Teclado:: Erro de entrada e saída.");
      return null;
      }
    catch (NumberFormatException nfe)  // Se erro de conversão.
      {
      System.err.println("Teclado:: Erro de conversão para inteiro.");
      return null;
      }
    catch (NoSuchElementException nsee)  // Se não houver tokens.
      {
      System.err.println("Teclado:: A entrada não contém um inteiro.");
      return null;
      }
    }

  } // Fim da classe Teclado.
