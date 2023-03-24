package hackerrank;

import java.util.ArrayList;
import java.util.List;

/*
A left rotation operation on an array of size  shifts each of the array's elements  unit to the left. Given an integer, , rotate the array that many steps left and return the result.

        Example


        After  rotations, .

        Function Description

        Complete the rotateLeft function in the editor below.

        rotateLeft has the following parameters:

        int d: the amount to rotate by
        int arr[n]: the array to rotate
        Returns

        int[n]: the rotated array
        Input Format

        The first line contains two space-separated integers that denote , the number of integers, and , the number of left rotations to perform.
        The second line contains  space-separated integers that describe .

        Sample Input

        5 4
        1 2 3 4 5
        Sample Output

        5 1 2 3 4
*/

public class RotateLeft {

    public static void main(String[] args) {
        var list = List.of(1, 2, 3, 4, 5);

        System.out.println(rotateLeft(4, list));
    }

    public static List<Integer> rotateLeft(int d, List<Integer> arr) {

        var output = new ArrayList<Integer>();

        for (int i = 0; i < arr.size(); i++) {
            output.add(arr.get(d));

            if (d == arr.size() - 1) {
                d = 0;
            } else {
                d++;
            }
        }

        return output;

    }
}
