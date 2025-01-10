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
    public static void inserirNovoCliente() throws FileNotFoundException {
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

        //Caminho para guardar o ficheiro com o registro do novo cliente
        File ficheiroCliente = new File("projeto/clientes/cliente_"+nomeCliente+".txt");

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
