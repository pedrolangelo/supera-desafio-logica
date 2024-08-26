import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DesafioSnail {
    public static void main(String[] args) throws Exception {
        List<Integer> resultado = new ArrayList<>();
        List<Integer> listaAux = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Digite a dimensão da matriz N x N: ");
        int n = scanner.nextInt();
        
        if (n == 0 ) System.out.println("Matriz vazia ");
        else 
        {
            int[][] matriz = new int[n][n];
            
            System.out.println("Digite os valores da matriz: ");
            for(int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matriz[i][j] = scanner.nextInt();
                }
            }
            
            n -= 1;
            int linha = 0, coluna = n, aux = 0;
            while(linha != n && coluna != 0)
            {
                // Começa o for no começo da primeira linha da matriz ate a ultima coluna
                // No caso de uma matriz 3x3 começa na linha 0 e vai ate a coluna 2
                for(int i = linha; i <= coluna; i++) {
                    resultado.add(matriz[linha][i]);                   // Preenche a lista com a primeira linha ex: 1, 2, 3
                    if(i < coluna) listaAux.add(matriz[i+1][coluna]);   // Preenche uma lista auxiliar com a ultima coluna ex: 6, 9
                                                                            //(menos o primeiro valor que ja esta na primeira linha)
                }
    
                // Adiciona a lista auxiliar nos resultados. ex: 1, 2, 3 + 6, 9 = 1, 2, 3, 6, 9
                resultado.addAll(listaAux);
                listaAux.clear();
    
                // Inverte para ir do final da matriz pro começo
                aux = coluna;
                coluna = linha;
                linha = aux;
    
                for(int i = linha - 1; i >= coluna; i--) {
                    resultado.add(matriz[linha][i]);               // Preenche a lista principal com a ultima linha ex: 8, 7
                    if(i > coluna) listaAux.add(matriz[i][coluna]); // Preenche a lista auxiliar com a primeira coluna ex 4
                                                                        //(menos primeiro valor da ultima linha que esta foi adicionado)
                }
    
                // Adiciona a lista auxiliar nos resultados. ex 1, 2, 3, 6, 9, 8, 7 + 4  = 1, 2, 3, 6, 9, 8, 7, 4
                resultado.addAll(listaAux);
                listaAux.clear();
    
                // Desinverte para voltar ao começo da matriz
                aux = linha;
                linha = coluna;
                coluna = aux;
    
                // Como começou na primeira linha e ultima coluna, agora vai pra segunda linha e penultima coluna
                coluna--;
                linha++;
            }
    
            System.out.println(resultado);
        }
        scanner.close();
    }
}
