package gamestart.servicos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ClienteServico {

    /**
     * Função para inserir um novo cliente
     *
     * @throws FileNotFoundException
     */
    public static void inserirCliente() throws FileNotFoundException {
        System.out.println("\n***************************************************************");
        System.out.println("::: Menu - CLIENTE ::: -> Inserir novo cliente");
        System.out.print("Insira o nome: ");
        Scanner input = new Scanner(System.in);
        String nomeCliente = input.nextLine();
        System.out.print("Insira o contato: ");
        String contatoCliente = input.nextLine();
        System.out.print("Insira o e-mail: ");
        String emailCliente = input.nextLine();
        System.out.println("\nCliente inserido com sucesso:");
        System.out.print(nomeCliente + "\t|\t");
        System.out.print(contatoCliente + "\t|\t");
        System.out.print(emailCliente + "\t|\n\n");

        //Caminho para guardar o ficheiro com o registro do novo cliente
        File ficheiroCliente = new File("projeto/clientes/cliente_" + nomeCliente + ".txt");

        //Máquina para escrever no ficheiro
        PrintWriter maquinaEscrever = new PrintWriter(ficheiroCliente);

        //Conteúdo do ficheiro
        String registroCliente = "Nome do cliente: " + nomeCliente + "\nContacto: " + contatoCliente + "\nE-mail: " + emailCliente;

        //Imprimir no ficheiro
        maquinaEscrever.println(registroCliente);

        //Fechar a máquina
        maquinaEscrever.close();

    }

    /**
     * Função que exibe as informações do cliente a partir da pesquisa pelo id do cliente
     *
     * @param inputIdCliente
     * @throws FileNotFoundException
     */
    public static void consultarCliente(String inputIdCliente) throws FileNotFoundException {
        //Caminho do ficheiro
        File ficheiroVendas = new File(VendaServico.obterFicheiroVendas());

        //Leitor do ficheiro
        Scanner scanner = new Scanner(ficheiroVendas);

        String linha, nomeCliente, contactoCliente, emailCliente;

        //Linha de cabeçalho do leitor
        linha = scanner.nextLine();

        //Ciclo para ler o ficheiro
        while (scanner.hasNextLine()) {
            linha = scanner.nextLine();
            String[] itensLinha = linha.split(";");

            //Verifica se a linha contém o id do cliente
            if (itensLinha[1].equals(inputIdCliente)) {
                nomeCliente = itensLinha[2];
                contactoCliente = itensLinha[3];
                emailCliente = itensLinha[4];

                //Imprime a informação do cliente
                System.out.println("\n************************     Cliente     ************************\n");
                System.out.println("Nome do cliente: " + nomeCliente + "\nContacto: " + contactoCliente + "\nE-mail: " + emailCliente);
                break;
            }
        }
        scanner.close();
    }

    /**
     * Função que exibe o jogo mais caro vendido e os clientes que o compraram
     *
     * @throws FileNotFoundException
     */
    public static void exibirJogoMaisCaro() throws FileNotFoundException {
        //Caminho do ficheiro
        File ficheiroVendas = new File(VendaServico.obterFicheiroVendas());

        //Leitor do ficheiro
        Scanner leitor1 = new Scanner(ficheiroVendas);

        String linha, jogoMaisCaro = "", nomeCliente = "";
        String[] itensLinha;
        double valorJogoAtual, valorJogoMaisCaro = 0;

        //Linha de cabeçalho do leitor
        linha = leitor1.nextLine();

        //Ciclo para encontrar o jogo mais caro
        while (leitor1.hasNextLine()) {
            linha = leitor1.nextLine();
            itensLinha = linha.split(";");
            valorJogoAtual = Double.parseDouble(itensLinha[8]);

            if (valorJogoAtual > valorJogoMaisCaro) {
                jogoMaisCaro = itensLinha[7];
                valorJogoMaisCaro = valorJogoAtual;
            }
        }

        //Segundo leitor para verificar quais os clientes que compraram o jogo mais caro
        Scanner leitor2 = new Scanner(ficheiroVendas);
        linha = leitor2.nextLine();

        System.out.println("\n*************   Jogo   *************");
        System.out.println("Título: " + jogoMaisCaro);
        System.out.println("Valor: " + valorJogoMaisCaro);

        System.out.println("\n*************   Clientes   *************");

        while (leitor2.hasNextLine()) {
            linha = leitor2.nextLine();
            itensLinha = linha.split(";");
            valorJogoAtual = Double.parseDouble(itensLinha[8]);

            //Verifica se o valor do jogo da linha atual é igual ao valor do jogo mais caro, para o caso de mais de um cliente comprar o mesmo jogo
            if (valorJogoAtual == valorJogoMaisCaro) {
                System.out.println(itensLinha[2]);
            }
        }

        leitor1.close();
        leitor2.close();
    }

    public static void exibirMelhorCliente() {

    }
}