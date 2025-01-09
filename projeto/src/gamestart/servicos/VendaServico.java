package gamestart.servicos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class VendaServico {

    public static void exibirConteudoVendas() throws FileNotFoundException {
        File ficheiroVendas = new File("projeto/clientes/GameStart_V2.csv");
        Scanner scanner = new Scanner(ficheiroVendas);

        String linha;

        while(scanner.hasNextLine()) {
            linha = scanner.nextLine();
            System.out.println(linha);
        }
        scanner.close();
    }

    public static void exibirTotalVendas() {

    }
}
