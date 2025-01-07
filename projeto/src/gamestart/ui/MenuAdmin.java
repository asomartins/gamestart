package gamestart.ui;

import java.io.FileNotFoundException;
import java.util.Scanner;

import static gamestart.servicos.VendaServico.*;

public class MenuAdmin {
    /**
     * Função para exibir as opções para o menu ADMIN
     *
     * @throws FileNotFoundException
     */
    public static void exibirMenuAdmin() throws FileNotFoundException {
        String opcao, inputEditora;

        do {
            System.out.println("\n***************************************************************");
            System.out.println("::: Menu - ADMIN :::");
            System.out.println("1. Exibir vendas");
            System.out.println("2. Exibir total de vendas e valor total acumulado");
            System.out.println("3. Calcular lucro total");
            System.out.println("4. Exibir informações de clientes");
            System.out.println("5. Exibir jogo mais caro - clientes que compraram");
            System.out.println("6. Exibir melhor cliente - jogos comprados");
            System.out.println("7. Voltar ao menu inicial");
            System.out.println("***************************************************************");
            System.out.print("Digite a opção: ");
            Scanner inputUserMenu = new Scanner(System.in);
            opcao = inputUserMenu.next();

            switch (opcao) {
                case "1":
                    exibirVendas();
                    break;
                case "2":


                    break;
                case "3":

                    break;
                case "4":

                    break;
                case "5":
                    break;
                case "6":
                    break;
                case "7":
                    break;
                default:
                    System.out.println("Opção inválida.\n");
            }

        } while (!opcao.equals("7"));
    }
}
