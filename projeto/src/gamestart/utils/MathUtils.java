package gamestart.utils;

public class MathUtils {
    /**
     * Função que avalia se um número inteiro é triangular
     *
     * @param num
     * @return - True quando o número é triangular
     */
    public static boolean numeroTriangular(int num) {
        int soma = 0;

        for (int contador = 1; contador < num; contador++) {
            soma += contador;
            if (soma == num) {
                return true;
            }
        }
        return false;
    }
}
