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

        //Validação para campos vazios
        if (nomeCliente.length() == 0) {
            System.out.println("Não foi possível registrar o cliente. Campo cliente vazio.");
        } else if (contatoCliente.length() == 0) {
            System.out.println("Não foi possível registrar o cliente. Campo contato vazio.");
        } else if (emailCliente.length() == 0) {
            System.out.println("Não foi possível registrar o cliente. Campo email vazio.");
        } else {

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

        //Validação para o idcliente
        boolean clienteEncontrado = false;

        //Linha de cabeçalho do leitor
        linha = scanner.nextLine();

        //Ciclo para ler o ficheiro
        while (scanner.hasNextLine() && !clienteEncontrado) {
            linha = scanner.nextLine();
            String[] itensLinha = linha.split(";");

            //Verifica se a linha contém o id do cliente
            if (itensLinha[1].equals(inputIdCliente)) {
                clienteEncontrado = true;
                nomeCliente = itensLinha[2];
                contactoCliente = itensLinha[3];
                emailCliente = itensLinha[4];

                //Imprime a informação do cliente
                System.out.println("\n***********************     Cliente     ***********************\n");
                System.out.println("Nome do cliente: " + nomeCliente + "\nContacto: " + contactoCliente + "\nE-mail: " + emailCliente);
            }
        }
        //Exibe uma mensagem para o id não encontrado
        if (!clienteEncontrado) {
            System.out.println("\nCliente não encontrado. Id: " + inputIdCliente);
        }
        scanner.close();
    }

    /**
     * Função que consulta o ficheiro de vendas e gera uma matriz de todos os clientes, sem repetições
     *
     * @return - String[][]
     * @throws FileNotFoundException
     */
    public static String[][] obterMatrizClientes() throws FileNotFoundException {

        //Caminho do ficheiro
        File ficheiroVendas = new File(VendaServico.obterFicheiroVendas());

        //Primeiro leitor para determinar o número de linhas
        Scanner scannerLinhas = new Scanner(ficheiroVendas);

        //Segundo leitor para realizar a leitura do ficheiro
        Scanner scanner = new Scanner(ficheiroVendas);

        String linha, idCliente, nomeCliente, contactoCliente, emailCliente;

        int numeroLinhas = 0;

        //Linha de cabeçalho do primeiro leitor
        linha = scannerLinhas.nextLine();

        //ciclo para contar o número de linhas que vai ser utilizado na matriz de clientes que será criada
        while (scannerLinhas.hasNextLine()) {
            linha = scannerLinhas.nextLine();
            numeroLinhas++;
        }

        //Cria a matriz de clientes com 4 colunas (idCliente, nome, contacto, email)
        String[][] matrizClientesPrimaria = new String[numeroLinhas][4];

        //Contador para verificar quantos clientes (não duplicados) serão adicionados na matriz de clientes
        int contadorClientesAdicionados = 0;

        //Linha de cabeçalho do segundo leitor
        linha = scanner.nextLine();

        //Ciclo para preencher a matriz de clientes, sem repetições
        while (scanner.hasNextLine()) {
            linha = scanner.nextLine();
            String[] itensLinha = linha.split(";");
            idCliente = itensLinha[1];
            nomeCliente = itensLinha[2];
            contactoCliente = itensLinha[3];
            emailCliente = itensLinha[4];

            //Verifica se o idCliente já foi adicionado na matriz
            boolean idClienteAdicionado = false;
            for (int i = 0; i < contadorClientesAdicionados; i++) {
                if (matrizClientesPrimaria[i][0].equals(idCliente)) {
                    idClienteAdicionado = true;
                }
            }

            //Se ainda não foi adicionado, o idCliente, o nome, o contacto e o email são então inseridos na matriz
            if (!idClienteAdicionado) {
                matrizClientesPrimaria[contadorClientesAdicionados][0] = idCliente;
                matrizClientesPrimaria[contadorClientesAdicionados][1] = nomeCliente;
                matrizClientesPrimaria[contadorClientesAdicionados][2] = contactoCliente;
                matrizClientesPrimaria[contadorClientesAdicionados][3] = emailCliente;
                contadorClientesAdicionados++;
            }
        }

        //Cria uma matriz de clientes nova com o tamanho ajustado (a partir do contador de clientes não duplicados),
        //Preenche a matriz nova apenas com registros não nulos e retorna a matriz ajustada
        String[][] matrizClientes = new String[contadorClientesAdicionados][4];

        for (int i = 0; i < matrizClientes.length; i++) {
            for (int j = 0; j < matrizClientesPrimaria[i].length; j++) {
                matrizClientes[i][j] = matrizClientesPrimaria[i][j];
            }
        }
        //fecha os leitores
        scannerLinhas.close();
        scanner.close();

        return matrizClientes;
    }

    /**
     * Função que exibe o cliente que mais gastou e os jogos comprados a partir da consulta às matrizes de gastos e de vendas por cliente
     *
     * @throws FileNotFoundException
     */
    public static void exibirMelhorCliente() throws FileNotFoundException {

        String idCliente = "", nomeCliente = "", contactoCliente = "", emailCliente = "", tituloJogo = "", listaTitulosJogos = "";
        double valorGastoAtual = 0, valorGastoMaisAlto = 0;

        //Obtém a matriz de gastos dos clientes
        String[][] matrizTotalGastoPorCliente = VendaServico.obterMatrizTotalGastoPorCliente();

        //Percorre a matriz de gastos dos clientes para encontrar o gasto mais alto
        for (int i = 0; i < matrizTotalGastoPorCliente.length; i++) {
            valorGastoAtual = Double.parseDouble(matrizTotalGastoPorCliente[i][4]);

            //mapeia as informações do cliente que teve o maior gasto (melhor cliente)
            if (valorGastoAtual > valorGastoMaisAlto) {
                idCliente = matrizTotalGastoPorCliente[i][0];
                nomeCliente = matrizTotalGastoPorCliente[i][1];
                contactoCliente = matrizTotalGastoPorCliente[i][2];
                emailCliente = matrizTotalGastoPorCliente[i][3];
                valorGastoMaisAlto = valorGastoAtual;
            }
        }

        //Imprime a informação do melhor cliente
        System.out.println("\n*******************     Melhor Cliente     ********************\n");
        System.out.println("Nome do cliente: " + nomeCliente);
        System.out.println("Contacto: " + contactoCliente);
        System.out.println("E-mail: " + emailCliente);
        System.out.printf("Total gasto: %.2f€ %n", valorGastoMaisAlto);

        //Obtém a matriz de vendas do cliente
        String[][] matrizVendasCliente = VendaServico.obterMatrizVendasPorCliente(idCliente);

        //Ciclo para percorrer as linhas da matriz de vendas de um cliente, obter os títulos de jogos que o cliente comprou e adicionar em uma lista de jogos
        for (int i = 0; i < matrizVendasCliente.length; i++) {
            tituloJogo = matrizVendasCliente[i][7];
            listaTitulosJogos += tituloJogo + "\n";
        }

        //Imprime os jogos comprados pelo melhor cliente
        System.out.println("\n*******************     Jogos Comprados     *******************\n");
        System.out.println(listaTitulosJogos);
    }
}