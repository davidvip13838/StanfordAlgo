import java.io.File;
import java.io.FileNotFoundException;
import java.util.Hashtable;
import java.util.Scanner;

public class Twosum {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("C:\\Users\\13109\\IdeaProjects\\StanfordAlgo\\Two sum\\2sum.txt");
        Scanner scanner = new Scanner(file);
        Hashtable<Long,Integer> hashtable = new Hashtable<Long, Integer>();
        Long[] nums = new Long[1000000];
        for(int i = 0; i < 1000000; i++){
            nums[i] = scanner.nextLong();
            hashtable.put(nums[i],1);
        }
        int values = 0;
        for(int target = -10000; target <= 10000; target++){
            for(int i = 0; i < nums.length; i++){
                if(hashtable.containsKey(target-nums[i]) && (target-nums[i]) != nums[i]){
                    values++;
                    break;
                }
            }
        }
        System.out.println(values);
        scanner.close();
    }
}
