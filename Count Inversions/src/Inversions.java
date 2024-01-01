import java.util.Arrays;

public class Inversions {
    public double inversions = 0;

    public double getInversions() {
        return inversions;
    }

    public int[] count(int[] nums){
        if(nums.length == 1){
            return nums;
        }
        int mid = nums.length/2;
        int[] left = count(Arrays.copyOfRange(nums,0,mid));
        int[] right = count(Arrays.copyOfRange(nums,mid,nums.length));
        return merge(left,right);
    }

    public int[] merge(int[] left, int[] right){
        int[] merged = new int[left.length + right.length];
        int l = 0;
        int r = 0;
        int i = 0;
        while((l < left.length) && (r < right.length)){
            if(left[l] < right[r]){
                merged[i++] = left[l++];
            }
            else{
                this.inversions = this.inversions + (left.length - l);
                merged[i++] = right[r++];
            }
        }
        if(l < left.length){ // if left pointer is not done
            while(l < left.length){
                merged[i++] = left[l++];
            }
        }
        if(r < right.length){
            while(r < right.length){
                merged[i++] = right[r++];
            }
        }
        System.out.println("the number of inversons for this level is " + inversions);
        return merged;
    }
}
