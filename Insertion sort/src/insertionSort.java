import java.util.Arrays;

public class insertionSort {
    public static void main(String[] args) {
        int[] nums = {2,4,5,6,123,7,5,4,4,2,3,3,4,5,6};
        insertionSort insertionSort = new insertionSort();
        nums = insertionSort.insertion(nums);
        System.out.println(Arrays.toString(nums));
    }
    public int[] insertion(int[] nums) {
        for (int i = 1; i < nums.length ; i++) {
            int j = i;
            while (nums[j - 1] > nums[j] && j > 0) {
                // swap element j and j-1
                int temp = nums[j];
                nums[j] = nums[j-1];
                nums[j-1] = temp;
                j--;// keep moving back the array
            }
        }
        return nums;
    }

}