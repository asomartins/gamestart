package gamestart.ui;

import java.io.FileNotFoundException;
import java.util.Scanner;

import static gamestart.ui.MenuAdmin.*;
import static gamestart.ui.MenuCliente.*;

public class MenuPrincipal {

    /**
     * Função para exibir o menu de seleção do tipo de usuário
     *
     * @throws FileNotFoundException
     */

    public static void exibirMenuTipoUsuario() throws FileNotFoundException {
        String opcao, senha;
        Scanner inputUser = new Scanner(System.in);

        do {
            System.out.println("\n***************************************************************");
            System.out.println("::: Menu - LOGIN :::");
            System.out.println("Selecione o tipo de usuário: (ADMIN || CLIENTE)");
            System.out.println("1. ADMIN");
            System.out.println("2. CLIENTE");
            System.out.println("3. SAIR");
            System.out.println("***************************************************************");
            System.out.print("Digite a opção: ");

            opcao = inputUser.nextLine();

            switch (opcao) {
                case "1":
                    System.out.print("Insira a senha: ");
                    senha = inputUser.nextLine();
                    if (senha.equals("cesae")) {
                        System.out.println("Olá, admin.");
                        exibirMenuAdmin();
                    } else {
                        System.out.println("Senha inválida.");
                    }
                    break;
                case "2":
                    System.out.println("Olá, cliente.");
                    exibirMenuCliente();
                    break;
                case "3":
                    System.out.println("Opção selecionada: Sair. Até logo :)");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (!opcao.equals("3"));
    }
}


//public class MenuPrincipal {
//
//    /**
//     * Função para exibir o menu de seleção do tipo de usuário
//     *
//     * @throws FileNotFoundException
//     */
//    public static void exibirMenuTipoUsuario() throws FileNotFoundException {
//        String opcao;
//
//        do {
//            System.out.println("\n***************************************************************");
//            System.out.println("::: Menu - LOGIN :::");
//            System.out.println("Selecione o tipo de usuário: (ADMIN || CLIENTE)");
//            System.out.println("1. ADMIN");
//            System.out.println("2. CLIENTE");
//            System.out.println("3. SAIR");
//            System.out.println("***************************************************************");
//            System.out.print("Digite a opção: ");
//            Scanner inputUser = new Scanner(System.in);
//            opcao = inputUser.next();
//
//            exibirMenuUsuarioSelecionado(opcao);
//        } while (!opcao.equals("3"));
//    }
//
//    /**
//     * Função para exibir as opções de menu de acordo com o usuário selecionado
//     *
//     * @param opcao
//     * @throws FileNotFoundException
//     */
//    public static void exibirMenuUsuarioSelecionado(String opcao) throws FileNotFoundException {
//        switch (opcao) {
//            case "1":
//                Scanner inputSenha = new Scanner(System.in);
//                System.out.print("Insira a senha: ");
//                String senha = inputSenha.next();
//                if (senha.equals("cesae")) {
//                    System.out.println("Olá, admin.");
//                    exibirMenuAdmin();
//                } else {
//                    System.out.println("Senha inválida.");
//                }
//                break;
//            case "2":
//                System.out.println("Olá, cliente.");
//                exibirMenuCliente();
//                break;
//            case "3":
//                System.out.println("Opção selecionada: Sair. Até logo :)");
//                break;
//            default:
//                System.out.println("Opção inválida.");
//        }
//    }
//}

