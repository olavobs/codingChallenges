package algoexpert;

public class FirstDuplicatedValue {

    public static void main(String[] args) {
        var array = new int[]{7, 1, 5, 2, 3, 3, 4};

        System.out.println(firstDuplicateValue(array));
    }

    public static int firstDuplicateValue(int[] array) {

        for (int i = 0; i < array.length; i++) {
            int newIndex = Math.abs(array[i]) - 1;
            if (array[newIndex] < 0) {
                return Math.abs(array[i]);
            }
            array[newIndex] = array[newIndex] * -1;
        }

        return -1;
    }

}
