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
        }
        int values = 0;
        for(int i = 0; i < 1000000 ; i++){
            Long x = nums[i];
            for(int target = -10000; target <= 10000; target++){
                if(hashtable.containsKey(target-x) && !hashtable.containsKey(x)){
                    values++;
                }
            }
            hashtable.put(x,1);
        }
        System.out.println(values);
        scanner.close();
    }
}
