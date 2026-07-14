package leetCode;

public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4}));
    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int aux = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[aux - 1]) {
                nums[aux] = nums[i];
                aux++;
            }
        }
        return aux;
    }
}