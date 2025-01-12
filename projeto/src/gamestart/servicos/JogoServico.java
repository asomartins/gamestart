package gamestart.servicos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class JogoServico {

    /**
     * Função para exibir todos os títulos de jogos disponíveis (sem repetições)
     *
     * @throws FileNotFoundException
     */
    public static void exibirTitulosJogos() throws FileNotFoundException {

        //Caminho do ficheiro
        File ficheiroVendas = new File(VendaServico.obterFicheiroVendas());

        //Primeiro leitor para determinar o número de linhas
        Scanner scannerLinhas = new Scanner(ficheiroVendas);

        String linha, tituloJogo;

        int numeroLinhas = 0;

        //Linha de cabeçalho do primeiro leitor
        linha = scannerLinhas.nextLine();

        //ciclo para contar o número de linhas que vai ser utilizado na matriz de títulos de jogos que será criada
        while (scannerLinhas.hasNextLine()) {
            linha = scannerLinhas.nextLine();
            numeroLinhas++;
        }

        String[][] matrizTitulosJogos = new String[numeroLinhas][1];

        //contador para verificar quantos títulos (não duplicados) serão adicionados na matriz de títulos de jogos
        int contadorTitulosAdicionados = 0;

        //Segundo leitor para realizar a leitura do ficheiro
        Scanner scanner = new Scanner(ficheiroVendas);

        //Linha de cabeçalho do segundo leitor
        linha = scanner.nextLine();

        //Ciclo para preencher a matriz de título de jogos, sem repetições
        while (scanner.hasNextLine()) {
            linha = scanner.nextLine();
            String[] itensLinha = linha.split(";");
            tituloJogo = itensLinha[7];

            //Verifica se o título já foi adicionado na matriz
            boolean tituloAdicionado = false;
            for (int i = 0; i < contadorTitulosAdicionados; i++) {
                if (matrizTitulosJogos[i][0].equals(tituloJogo)) {
                    tituloAdicionado = true;
                }
            }

            //Se ainda não foi adicionado, o título é então inserido na matriz
            if (!tituloAdicionado) {
                matrizTitulosJogos[contadorTitulosAdicionados][0] = tituloJogo;
                contadorTitulosAdicionados++;
            }
        }

        System.out.println("\n************************     Jogos Disponíveis     ************************\n");

        //Ciclo para exibir a matriz de títulos de jogos não duplicados
        for (int j = 0; j < contadorTitulosAdicionados; j++) {
            System.out.println(matrizTitulosJogos[j][0]);
        }

        scannerLinhas.close();
        scanner.close();
    }


    /**
     * Função que lista as categorias e respectivos títulos de jogos publicados por editora
     *
     * @param inputEditora
     * @throws FileNotFoundException
     */
    public static void exibirJogosPorEditora(String inputEditora) throws FileNotFoundException {

        //Caminho do ficheiro
        File ficheiroVendas = new File(VendaServico.obterFicheiroVendas());

        //Primeiro leitor para determinar o número de linhas
        Scanner scannerLinhas = new Scanner(ficheiroVendas);

        //Segundo leitor para realizar a leitura do ficheiro normalmente
        Scanner scanner = new Scanner(ficheiroVendas);

        String linha, linha2, editora, categoria, tituloJogo;

        int numeroLinhas = 0;

        //Linha de cabeçalho do primeiro leitor
        linha = scannerLinhas.nextLine();

        //Ciclo para contar o número de linhas para o tamanho da matriz de editoras, categorias e títulos de jogos
        while (scannerLinhas.hasNextLine()) {
            linha = scannerLinhas.nextLine();
            numeroLinhas++;
        }

        //Matriz para editoras, categorias e títulos de jogos
        String[][] matrizEditoraCategoriaTituloJogos = new String[numeroLinhas][3];

        //Arrays para guardar as editoras e categorias únicas
        String[] editorasExibidas = new String[numeroLinhas];
        String[] categoriasExibidas = new String[numeroLinhas];

        //Contadores para editoras, categorias e títulos (não duplicados) adicionados na matriz
        int contadorTitulosAdicionados = 0, contadorEditorasAdicionadas = 0, contadorCategoriasAdicionadas = 0;

        //Linha de cabeçalho do segundo leitor
        linha2 = scanner.nextLine();

        //Ciclo para preencher a matriz de editoras, categorias e títulos de jogos, sem repetições de títulos
        while (scanner.hasNextLine()) {
            linha2 = scanner.nextLine();
            String[] itensLinha = linha2.split(";");

            editora = itensLinha[5];
            categoria = itensLinha[6];
            tituloJogo = itensLinha[7];

            // Verifica se o título já foi adicionado na matriz
            boolean tituloAdicionado = false;
            for (int i = 0; i < contadorTitulosAdicionados; i++) {
                if (matrizEditoraCategoriaTituloJogos[i][2].equals(tituloJogo)) {
                    tituloAdicionado = true;
                }
            }

            // Se ainda não foi adicionado, a editora, a categoria e o título são então inseridos na matriz
            if (!tituloAdicionado) {
                matrizEditoraCategoriaTituloJogos[contadorTitulosAdicionados][0] = editora;
                matrizEditoraCategoriaTituloJogos[contadorTitulosAdicionados][1] = categoria;
                matrizEditoraCategoriaTituloJogos[contadorTitulosAdicionados][2] = tituloJogo;
                contadorTitulosAdicionados++;
            }
        }

        //Ciclo para exibir a editora e as categorias apenas uma vez
        for (int linhaMatriz = 0; linhaMatriz < contadorTitulosAdicionados; linhaMatriz++) {
            if (matrizEditoraCategoriaTituloJogos[linhaMatriz][0].equals(inputEditora)) {

                //Verifica se a editora já foi exibida
                boolean editoraJaExibida = false;
                for (int linhaVetorEditoras = 0; linhaVetorEditoras < contadorEditorasAdicionadas; linhaVetorEditoras++) {
                    if (editorasExibidas[linhaVetorEditoras].equals(inputEditora)) {
                        editoraJaExibida = true;
                    }
                }

                //Se a editora ainda não foi exibida, imprime a editora
                if (!editoraJaExibida) {
                    System.out.println("\n*************   " + inputEditora + "   *************");
                    editorasExibidas[contadorEditorasAdicionadas] = inputEditora;
                    contadorEditorasAdicionadas++;
                }

                //Verifica se a categoria já foi exibida
                boolean categoriaJaExibida = false;
                for (int linhaVetorCategorias = 0; linhaVetorCategorias < contadorCategoriasAdicionadas; linhaVetorCategorias++) {
                    if (categoriasExibidas[linhaVetorCategorias].equals(matrizEditoraCategoriaTituloJogos[linhaMatriz][1])) {
                        categoriaJaExibida = true;
                    }
                }

                //Se a categoria ainda não foi exibida, imprime a categoria
                if (!categoriaJaExibida) {
                    System.out.println("\n_____   " + matrizEditoraCategoriaTituloJogos[linhaMatriz][1] + "   _____");
                    categoriasExibidas[contadorCategoriasAdicionadas] = matrizEditoraCategoriaTituloJogos[linhaMatriz][1];
                    contadorCategoriasAdicionadas++;
                }

                //Imprime os títulos dos jogos
                System.out.println(matrizEditoraCategoriaTituloJogos[linhaMatriz][2]);

            }
        }

        //Fecha os leitores
        scannerLinhas.close();
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
        Scanner scanner = new Scanner(ficheiroVendas);

        String linha, tituloJogoMaisCaro = "", listaClientes = "";
        String[] itensLinha;
        double valorJogoAtual, valorJogoMaisCaro = 0;

        //Linha de cabeçalho do leitor
        linha = scanner.nextLine();

        //Ciclo para encontrar o jogo mais caro
        while (scanner.hasNextLine()) {
            linha = scanner.nextLine();
            itensLinha = linha.split(";");
            valorJogoAtual = Double.parseDouble(itensLinha[8]);

            if (valorJogoAtual > valorJogoMaisCaro) {
                tituloJogoMaisCaro = itensLinha[7];
                valorJogoMaisCaro = valorJogoAtual;

                //inicia uma lista de clientes, para o caso de haver mais clientes que compraram o mesmo jogo
                listaClientes = itensLinha[2] + "\n";
            }
            //Verifica se o valor do jogo da linha atual é igual ao valor do jogo mais caro, adiciona o cliente a lista dos que compraram o mesmo jogo
            else if (valorJogoAtual == valorJogoMaisCaro) {
                listaClientes += itensLinha[2] + "\n";
            }
        }

        System.out.println("\n*************   Jogo Mais Caro   *************");
        System.out.println("Título: " + tituloJogoMaisCaro);
        System.out.println("Valor: " + valorJogoMaisCaro);

        System.out.println("\n*************   Clientes que compraram   *************");
        System.out.print(listaClientes);

        scanner.close();

    }

}
