package gamestart.servicos;

import java.util.Scanner;

public class ClienteServico {

    /**
     * Função para registrar um novo cliente
     *
     */
    public static void inserirNovoCliente() {
        System.out.println("\n***************************************************************");
        System.out.println("::: Menu - CLIENTE ::: -> Inserir novo cliente");
        System.out.print("Insira o nome: ");
        Scanner input = new Scanner(System.in);
        String nomeCliente = input.nextLine();
        System.out.print("Insira o contato: ");
        String contatoCliente = input.next();
        System.out.print("Insira o e-mail: ");
        String emailCliente = input.next();
        System.out.println("\nCliente inserido com sucesso:");
        System.out.print(nomeCliente + "\t|\t");
        System.out.print(contatoCliente + "\t|\t");
        System.out.print(emailCliente + "\t|\n\n");
    }
}
