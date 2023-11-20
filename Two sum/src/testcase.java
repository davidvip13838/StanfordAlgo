import java.util.HashSet;
import java.util.Hashtable;

public class testcase {
    public static void main(String[] args) {
        int[] nums = {-3 ,-1 ,1 ,2 ,9 ,11 ,7 ,6 ,2};
        Hashtable<Integer,Integer> pairs = new Hashtable<Integer,Integer>();
        int values = 0;
        for(int i = 0; i< nums.length; i++){
            pairs.put(nums[i],1);
        }
        System.out.println(pairs.size());
        for(int target = 3; target<= 10 ; target++){
            for(int i = 0; i < nums.length; i++){
                if(pairs.containsKey(target-nums[i]) && (target-nums[i]) != nums[i]){
                    values++;
                    break;
                }
            }
        }
        System.out.println(pairs.size());
        System.out.println(values);
    }
}
