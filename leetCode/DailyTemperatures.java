package leetCode;

//Given an array of integers temperatures represents the daily temperatures, return an array answer such that answer[i]
//is the number of days you have to wait after the ith day to get a warmer temperature.
//If there is no future day for which this is possible, keep answer[i] == 0 instead.

//Input: temperatures = [73,74,75,71,69,72,76,73]
//Output: [1,1,4,2,1,1,0,0]

//Input: temperatures = [30,40,50,60]
//Output: [1,1,1,0]

//Input: temperatures = [30,60,90]
//Output: [1,1,0]

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatures {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(dailyTemperatures(new int[]{30, 60, 50, 70, 65})));
    }

    public static int[] dailyTemperatures(int[] temperatures) {
        int[] answer = new int[temperatures.length];
        Arrays.fill(answer, 0);

        Stack<Integer> indexDays = new Stack<>();

        for (int i = 0; i < temperatures.length; i++) {
            while (!indexDays.isEmpty() && temperatures[i] > temperatures[indexDays.peek()]) {
                int index = indexDays.pop();
                answer[index] = i - index;
            }

            indexDays.push(i);
        }
        return answer;
    }
}
