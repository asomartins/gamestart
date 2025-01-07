package gamestart.ui;

import java.io.FileNotFoundException;
import java.util.Scanner;

import static gamestart.servicos.ClienteServico.*;
import static gamestart.servicos.EstacionamentoServico.*;
import static gamestart.servicos.JogoServico.*;

public class MenuCliente {
    /**
     * Função para exibir as opções para o menu CLIENTE
     *
     * @throws FileNotFoundException
     */
    public static void exibirMenuCliente() throws FileNotFoundException {
        String opcao, inputEditora;

        do {
            System.out.println("\n***************************************************************");
            System.out.println("::: Menu - CLIENTE :::");
            System.out.println("1. Inserir novo cliente");
            System.out.println("2. Verificar vagas de estacionamento");
            System.out.println("3. Exibir todos os jogos");
            System.out.println("4. Exibir jogos por editora");
            System.out.println("5. Voltar ao menu inicial");
            System.out.println("***************************************************************");
            System.out.print("Digite a opção: ");
            Scanner inputUserMenu = new Scanner(System.in);
            opcao = inputUserMenu.next();

            switch (opcao) {
                case "1":
                    inserirNovoCliente();
                    break;
                case "2":
                    verificarVagasEstacionamento();
                    break;
                case "3":
                    exibirTitulosJogos();
                    break;
                case "4":
                    Scanner inputUserEditora = new Scanner(System.in);
                    System.out.print("Insira a editora: ");
                    inputEditora = inputUserEditora.nextLine();
                    exibirJogosPorEditora(inputEditora);
                    break;
                case "5":
                    break;
                default:
                    System.out.println("Opção inválida.\n");
            }

        } while (!opcao.equals("5"));
    }
}
