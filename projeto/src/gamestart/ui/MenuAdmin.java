package gamestart.ui;

import java.io.FileNotFoundException;
import java.util.Scanner;

import static gamestart.servicos.VendaServico.*;
import static gamestart.servicos.ClienteServico.*;
import static gamestart.servicos.JogoServico.*;
import static gamestart.ui.MenuPrincipal.exibirMenuTipoUsuario;

public class MenuAdmin {
    /**
     * Função para exibir as opções do menu ADMIN
     *
     * @throws FileNotFoundException
     */
    public static void exibirMenuAdmin() throws FileNotFoundException {
        String opcao, inputIdCliente;
        Scanner inputUser = new Scanner(System.in);

        do {
            System.out.println("\n***************************************************************");
            System.out.println("::: Menu - ADMIN :::");
            System.out.println("1. Imprimir ficheiro");
            System.out.println("2. Exibir total de vendas e valor total acumulado");
            System.out.println("3. Calcular lucro total");
            System.out.println("4. Exibir informações de cliente");
            System.out.println("5. Exibir jogo mais caro e clientes que compraram");
            System.out.println("6. Exibir o melhor cliente e lista de jogos comprados");
            System.out.println("7. Voltar ao menu inicial");
            System.out.println("***************************************************************");
            System.out.print("Digite a opção: ");
            opcao = inputUser.nextLine();

            switch (opcao) {
                case "1":
                    exibirConteudoVendas();
                    break;
                case "2":
                    exibirTotalVendas();
                    break;
                case "3":
                    calcularLucroTotal();
                    break;
                case "4":
                    System.out.print("Insira o id do cliente: ");
                    inputIdCliente = inputUser.nextLine();
                    consultarCliente(inputIdCliente);
                    break;
                case "5":
                    exibirJogoMaisCaro();
                    break;
                case "6":
                    exibirMelhorCliente();
                    break;
                case "7":
                    System.out.println("Opção selecionada: Voltar ao menu inicial");
                    return;
                default:
                    System.out.println("Opção inválida.\n");
            }

        } while (!opcao.equals("7"));
    }
}
