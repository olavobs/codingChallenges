package codewars;

/*In this little assignment you are given a string of space separated numbers, and have to return the highest and lowest number.
        Examples
        highAndLow("1 2 3 4 5")  // return "5 1"
        highAndLow("1 2 -3 4 5") // return "5 -3"
        highAndLow("1 9 3 4 -5") // return "9 -5"
*/

public class HighestAndLowest {

    public static void main(String[] args) {
        System.out.println(highAndLow("8 3 -5 42 -1 0 0 -9 4 7 4 -4"));
    }

    public static String highAndLow(String numbers) {
        var lowestNumber = Integer.MAX_VALUE;
        var highestNumber = Integer.MIN_VALUE;

        var numbersArray = numbers.split(" ");

        for (int i = 0; i < numbersArray.length; i++) {
            var number = Integer.valueOf(numbersArray[i]);
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
