import java.io.FileNotFoundException;

import static gamestart.ui.MenuPrincipal.*;

public class GameStartMain {

    /**
     * Função principal que exibe o menu inicial para selecionar o tipo de usuário
     */

    public static void main(String[] args) throws FileNotFoundException {
        System.out.print("\n" +
                "                                                                                                                                                                                            \n" +
                "                                                                                                                                                                                            \n" +
                "        GGGGGGGGGGGGG                                                                                             tttt                                                        tttt          \n" +
                "     GGG::::::::::::G                                                                                          ttt:::t                                                     ttt:::t          \n" +
                "   GG:::::::::::::::G                                                                                          t:::::t                                                     t:::::t          \n" +
                "  G:::::GGGGGGGG::::G                                                                                          t:::::t                                                     t:::::t          \n" +
                " G:::::G       GGGGGG  aaaaaaaaaaaaa      mmmmmmm    mmmmmmm       eeeeeeeeeeee             ssssssssss   ttttttt:::::ttttttt      aaaaaaaaaaaaa  rrrrr   rrrrrrrrr   ttttttt:::::ttttttt    \n" +
                "G:::::G                a::::::::::::a   mm:::::::m  m:::::::mm   ee::::::::::::ee         ss::::::::::s  t:::::::::::::::::t      a::::::::::::a r::::rrr:::::::::r  t:::::::::::::::::t    \n" +
                "G:::::G                aaaaaaaaa:::::a m::::::::::mm::::::::::m e::::::eeeee:::::ee     ss:::::::::::::s t:::::::::::::::::t      aaaaaaaaa:::::ar:::::::::::::::::r t:::::::::::::::::t    \n" +
                "G:::::G    GGGGGGGGGG           a::::a m::::::::::::::::::::::me::::::e     e:::::e     s::::::ssss:::::stttttt:::::::tttttt               a::::arr::::::rrrrr::::::rtttttt:::::::tttttt    \n" +
                "G:::::G    G::::::::G    aaaaaaa:::::a m:::::mmm::::::mmm:::::me:::::::eeeee::::::e      s:::::s  ssssss       t:::::t              aaaaaaa:::::a r:::::r     r:::::r      t:::::t          \n" +
                "G:::::G    GGGGG::::G  aa::::::::::::a m::::m   m::::m   m::::me:::::::::::::::::e         s::::::s            t:::::t            aa::::::::::::a r:::::r     rrrrrrr      t:::::t          \n" +
                "G:::::G        G::::G a::::aaaa::::::a m::::m   m::::m   m::::me::::::eeeeeeeeeee             s::::::s         t:::::t           a::::aaaa::::::a r:::::r                  t:::::t          \n" +
                " G:::::G       G::::Ga::::a    a:::::a m::::m   m::::m   m::::me:::::::e                ssssss   s:::::s       t:::::t    tttttta::::a    a:::::a r:::::r                  t:::::t    tttttt\n" +
                "  G:::::GGGGGGGG::::Ga::::a    a:::::a m::::m   m::::m   m::::me::::::::e               s:::::ssss::::::s      t::::::tttt:::::ta::::a    a:::::a r:::::r                  t::::::tttt:::::t\n" +
                "   GG:::::::::::::::Ga:::::aaaa::::::a m::::m   m::::m   m::::m e::::::::eeeeeeee       s::::::::::::::s       tt::::::::::::::ta:::::aaaa::::::a r:::::r                  tt::::::::::::::t\n" +
                "     GGG::::::GGG:::G a::::::::::aa:::am::::m   m::::m   m::::m  ee:::::::::::::e        s:::::::::::ss          tt:::::::::::tt a::::::::::aa:::ar:::::r                    tt:::::::::::tt\n" +
                "        GGGGGG   GGGG  aaaaaaaaaa  aaaammmmmm   mmmmmm   mmmmmm    eeeeeeeeeeeeee         sssssssssss              ttttttttttt    aaaaaaaaaa  aaaarrrrrrr                      ttttttttttt  \n" +
                "                                                                                                                                                                                            \n" +
                "                                                                                                                                                                                            \n" +
                "                                                                                                                                                                                            \n");

        exibirMenuTipoUsuario();
    }
}