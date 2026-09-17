package codewars;

/*In this little assignment you are given a string of space separated numbers, and have to return the highest and lowest number.
        Examples
        highAndLow("1 2 3 4 5")  // return "5 1"
        highAndLow("1 2 -3 4 5") // return "5 -3"
        highAndLow("1 9 3 4 -5") // return "9 -5"
*/

public class BF_HighestAndLowest {

    public static void main(String[] args) {
        System.out.println(highAndLow("8 3 -5 42 -1 0 0 -9 4 7 4 -4"));
    }

    public static String highAndLow(String numbers) {
        var lowestNumber = Integer.MAX_VALUE;
        var highestNumber = Integer.MIN_VALUE;

        var numbersArray = numbers.split(" ");

        for (int i = 0; i < numbersArray.length; i++) {
            var number = Integer.parseInt(numbersArray[i]);
            if (number < lowestNumber) {
                lowestNumber = number;
            }
            if (number > highestNumber) {
                highestNumber = number;
            }
        }
        return highestNumber + " " + lowestNumber;
    }
}

/*
 * PASSO A PASSO DA SOLUÇÃO
 *
 * Desafio: Dada uma string de números separados por espaço, retornar o
 * maior e o menor número.
 *
 * 1. Separa a string de números em um array usando espaço como delimitador.
 * 2. Percorre o array convertendo cada item de String para inteiro.
 * 3. Compara cada número com o menor e o maior valor encontrados até
 *    agora, atualizando lowestNumber e highestNumber.
 * 4. Ao final, retorna uma string com o maior e o menor número, separados
 *    por espaço.
 *
 * Complexidade: O(n).
 */
