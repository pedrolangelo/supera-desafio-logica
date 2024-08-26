import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class DesafioResistores {
    public static void main(String[] args) throws Exception {
        Scanner ler = new Scanner(System.in);
        String padrao = "^(\\d+(\\.\\d+)?[kM]?\\s+ohms)$";
        
        int converter = 0;
        do {
            System.out.println("O padrão exigido para converter o valor é: ");
            System.out.println("Para menores de 100, valor seguido de ohms. Ex.:'47 ohms'");
            System.out.println("Para maiores de 1000 e menores de 1000000, valor dividido por 1000 com um k no final. Ex.: 1k ohms");
            System.out.println("Para maiores de 1000000, valor dividido por 1000000 e seguido por M. Ex.: 2M ohms");

            System.out.println("Digite o valor a ser convertido: ");
            String valor = ler.nextLine();
    
            if(valor.matches(padrao))
            {
                String[] separar = valor.split(" ");
                if(separar[0].endsWith("k"))
                {
                    String numeroStr = separar[0].replace("k", "");
                    double numero = Double.parseDouble(numeroStr);
                    converter = (int) (numero * 1000);
                }
                else if(separar[0].endsWith("M"))
                {
                    String numeroStr = separar[0].replace("M", "");
                    double numero = Double.parseDouble(numeroStr);
                    converter = (int) (numero * 1000000);
                }else converter = Integer.parseInt(separar[0]);
            }
            else System.out.println("O valor não segue o padrão exigido.");        

        } while(converter == 0);

        Map<Integer, String> cores = new HashMap<>();
        cores.put(0, "preto");
        cores.put(1, "marrom");
        cores.put(2, "vermelho");
        cores.put(3, "laranja");
        cores.put(4, "amarelo");
        cores.put(5, "verde");
        cores.put(6, "azul");
        cores.put(7, "violeta");
        cores.put(8, "cinza");
        cores.put(9, "branco");

        int aux = converter;
        StringBuilder valor_convertido = new StringBuilder();
        
        if(aux >= 100 && aux < 1000) aux /= 10;
        else if(aux >= 1000 && aux < 1000000) aux /= 100;
        else if(aux >= 1000000) aux /= 100000;

        do 
        {
            valor_convertido.insert(0, cores.get(aux%10));
            valor_convertido.insert(0, " ");          

            aux /= 10;
        }while(aux != 0);
        valor_convertido.deleteCharAt(0);
        valor_convertido.append(" ");

        String quantidadeAlgarismos = Integer.toString(converter);
        int potencia = quantidadeAlgarismos.length();
        valor_convertido.append(cores.get(potencia - 2));

        valor_convertido.append(" ");
        valor_convertido.append("dourado");

        System.out.println(valor_convertido);
        ler.close();
    }
}
