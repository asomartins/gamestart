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

        //Ler ficheiro
        File ficheiroJogos = new File("projeto/GameStart_V2.csv");

        //Primeiro leitor para determinar o número de linhas
        Scanner scannerLinhas = new Scanner(ficheiroJogos);

        //Segundo leitor para realizar a leitura do ficheiro normalmente
        Scanner scanner = new Scanner(ficheiroJogos);

        String linha, linha2, tituloJogo;

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

        //Linha de cabeçalho do segundo leitor
        linha2 = scanner.nextLine();

        //Ciclo para preencher a matriz de título de jogos, sem repetições
        while (scanner.hasNextLine()) {
            linha2 = scanner.nextLine();
            String[] itensLinha = linha2.split(";");
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

        //Ler ficheiro
        File ficheiroJogos = new File("projeto/GameStart_V2.csv");

        //Primeiro leitor para determinar o número de linhas
        Scanner scannerLinhas = new Scanner(ficheiroJogos);

        //Segundo leitor para realizar a leitura do ficheiro normalmente
        Scanner scanner = new Scanner(ficheiroJogos);

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
        String[][] matrizEditoraCategoriaTituloJogos =  new String[numeroLinhas][3];

        //Arrays para rastrear editoras e categorias únicas
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
                    System.out.println("\n_____   " + matrizEditoraCategoriaTituloJogos[linhaMatriz][1] + "   _____" );
                    categoriasExibidas[contadorCategoriasAdicionadas] = matrizEditoraCategoriaTituloJogos[linhaMatriz][1];
                    contadorCategoriasAdicionadas++;
                }

                System.out.println(matrizEditoraCategoriaTituloJogos[linhaMatriz][2]);

            }
        }

        scannerLinhas.close();
        scanner.close();
    }
}
