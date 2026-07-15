package leetCode;

//There are n houses evenly lined up on the street, and each house is beautifully painted. You are given a
// 0-indexed integer array colors of length n, where colors[i] represents the color of the ith house.
//
//Return the maximum distance between two houses with different colors.
//
//The distance between the ith and jth houses is abs(i - j), where abs(x) is the absolute value of x.

//Input: colors = [1,1,1,6,1,1,1]
//Output: 3
//Explanation: In the above image, color 1 is blue, and color 6 is red.
//The furthest two houses with different colors are house 0 and house 3.
//House 0 has color 1, and house 3 has color 6. The distance between them is abs(0 - 3) = 3.
//Note that houses 3 and 6 can also produce the optimal answer.

//Input: colors = [1,8,3,8,3]
//Output: 4
//Explanation: In the above image, color 1 is blue, color 8 is yellow, and color 3 is green.
//The furthest two houses with different colors are house 0 and house 4.
//House 0 has color 1, and house 4 has color 3. The distance between them is abs(0 - 4) = 4.

//Input: colors = [0,1]
//Output: 1
//Explanation: The furthest two houses with different colors are house 0 and house 1.
//House 0 has color 0, and house 1 has color 1. The distance between them is abs(0 - 1) = 1.

public class TwoFurthestHousesWithDifferentColors {
    public static void main(String[] args) {
        System.out.println(maxDistance(new int[]{1, 8, 3, 8, 3}));
        System.out.println(maxDistance(new int[]{0,1,1}));
        System.out.println(maxDistance(new int[]{1, 1, 1, 6, 1, 1, 1}));

    }

    public static int maxDistance(int[] colors) {
        if (colors[0] != colors[colors.length - 1]) {
            return colors.length - 1;
        }

        int maxDistance = 0;
        for (int i = 0; i < colors.length; i++) {

            if (colors[0] != colors[i]) {
                maxDistance = Math.max(maxDistance, i);
            }

            if (colors[i] != colors[colors.length - 1]) {
                maxDistance = Math.max(maxDistance, colors.length - i - 1);
            }
        }

        return maxDistance;
    }
}
