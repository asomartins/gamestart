package gamestart.servicos;

import static gamestart.utils.MathUtils.numeroTriangular;

public class EstacionamentoServico {

    /**
     * Função para verificar as vagas de estacionamento disponíveis
     *
     */
    public static void verificarVagasEstacionamento() {
        int tamanho = 0, contador = 0;

        System.out.println("\n************************     Vagas     ************************\n");

        // Critério fornecido: números triangulares múltiplos de 5, limitados a 121 vagas

        //primeiro ciclo para determinar o tamanho do array
        //percorre até o limite de 121 vagas
        for (int num = 1; num <= 121; num++) {
            //verifica se o número é triangular e múltiplo de 5
            if (numeroTriangular(num) && (num % 5 == 0)) {
                    tamanho++;
                }
        }

        int[] vagas = new int[tamanho];

        //repete o ciclo anterior e preenche o array já com um tamanho definido
        for (int num = 1; num <= 121; num++) {
            if (numeroTriangular(num) && (num % 5 == 0)) {
                    vagas[contador] = num;
                    contador++;
                }
        }

        //imprime os elementos do array preenchido
        for (int i = 0; i < vagas.length; i++) {
            System.out.print(vagas[i] + "\t");
        }
        System.out.println("\n");
    }
}
