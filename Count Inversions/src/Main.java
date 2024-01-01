import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Inversions inversions = new Inversions();
        int[] nums = new int[100000];
        try{
            File file = new File("nums.txt");
            Scanner scanner = new Scanner(file);
            int i = 0;
            while(scanner.hasNextInt()){
                nums[i] = scanner.nextInt();
                i++;
            }
            scanner.close();

        }catch (FileNotFoundException e){
            System.err.println("File not found: " + e.getMessage());
        }
        inversions.count(nums);
        System.out.println(inversions.inversions);
    }
}