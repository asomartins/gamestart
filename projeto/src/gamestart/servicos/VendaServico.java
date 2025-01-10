package gamestart.servicos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class VendaServico {

    /**
     * Função para retornar o caminho do ficheiro
     *
     * @return - String
     */
    public static String obterFicheiroVendas() {
        return "projeto/clientes/GameStart_V2.csv";
    }

    /**
     * Função para exibir o conteúdo do ficheiro de vendas na tela
     *
     * @throws FileNotFoundException
     */
    public static void exibirConteudoVendas() throws FileNotFoundException {

        //Caminho do ficheiro
        File ficheiroVendas = new File(obterFicheiroVendas());

        //Leitor para o ficheiro
        Scanner scanner = new Scanner(ficheiroVendas);

        String linha;

        //Ciclo para ler o ficheiro
        while(scanner.hasNextLine()) {
            linha = scanner.nextLine();
            System.out.println(linha);
        }
        scanner.close();
    }

    /**
     * Função para exibir o número total de vendas realizadas e o valor total acumulado
     *
     * @throws FileNotFoundException
     */
    public static void exibirTotalVendas() throws FileNotFoundException {

        //Caminho do ficheiro
        File ficheiroVendas = new File(obterFicheiroVendas());

        //Leitor para o ficheiro
        Scanner leitor = new Scanner(ficheiroVendas);

        //Linha de cabeçalho do leitor
        String linha = leitor.nextLine();

        int contadorVendas = 0;
        double valorJogo, totalVendas = 0;

        //Ciclo para percorrer as linhas do ficheiro, somar os valores dos jogos e obter a quantidade de vendas
        while(leitor.hasNextLine()){
            linha = leitor.nextLine();
            String[] itensLinha = linha.split(";");
            valorJogo = Double.parseDouble(itensLinha[8]);
            totalVendas += valorJogo;
            contadorVendas++;
        }
        System.out.println("Número total de vendas: " +contadorVendas);
        System.out.printf("Valor total de vendas: %.2f€ %n", +totalVendas);

        //Fecha o leitor
        leitor.close();
    }

    /**
     * Função para calcular o lucro total das vendas
     *
     * @throws FileNotFoundException
     */
    public static void calcularLucroTotal() throws FileNotFoundException {

        //Caminho do ficheiro
        File ficheiroVendas = new File(obterFicheiroVendas());

        //Leitor para o ficheiro
        Scanner leitor = new Scanner(ficheiroVendas);

        //Linha de cabeçalho do leitor
        String linha = leitor.nextLine();

        double valorJogo, totalVendas = 0, totalVendasLucro = 0, lucroTotal;

        //Ciclo para percorrer o ficheiro, somar os valores dos jogos para obter o total de vendas
        while(leitor.hasNextLine()){
            linha = leitor.nextLine();
            String[] itensLinha = linha.split(";");
            valorJogo = Double.parseDouble(itensLinha[8]);
            totalVendas += valorJogo;
        }

        //Calcula o valor total de vendas já com o lucro, considerando 20% de lucro em cada jogo
        totalVendasLucro = totalVendas * 1.2;

        //Calcula o lucro total das vendas
        lucroTotal = totalVendasLucro - totalVendas;

        System.out.printf("Lucro total: %.2f€ %n", lucroTotal);

        //Fecha o leitor
        leitor.close();
    }
}