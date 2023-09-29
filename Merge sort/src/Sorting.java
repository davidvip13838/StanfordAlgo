import java.util.Arrays;

public class Sorting {
    public static void main(String[] args) {
        int[] nums = {1,3,4,5,6,2,7,9};
        Sorting sorting = new Sorting();
        nums = sorting.merge(nums);
        System.out.println(Arrays.toString(nums));
    }

    public int[] merge(int [] nums) {
        if(nums.length <= 1) { // base case
            return nums;
        }
        int midpoint = nums.length/2;
        int[] left = merge(Arrays.copyOfRange(nums,0,midpoint));
        int[] right = merge(Arrays.copyOfRange(nums,midpoint,nums.length));
        return combine(left, right);
    }

    public int[] combine(int[] left, int[] right) {
        int[] merged = new int[left.length + right.length];
        int l = 0, r = 0, i = 0;

        while (l < left.length && r < right.length) {
            if (left[l] < right[r]) {
                merged[i++] = left[l++];
            } else {
                merged[i++] = right[r++];
            }
        }

        // Copy any remaining elements from left and right (if any)
        while (l < left.length) {
            merged[i++] = left[l++];
        }

        while (r < right.length) {
            merged[i++] = right[r++];
        }

        return merged;
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
