import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Median {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("C:\\Users\\13109\\IdeaProjects\\StanfordAlgo\\min-max heap\\nums.txt");
        Scanner scanner = new Scanner(file);
        System.out.println("file found ");
        ArrayList<Integer> medians = new ArrayList<Integer>();
        PriorityQueue<Integer> min = new PriorityQueue<Integer>();
        PriorityQueue<Integer> max = new PriorityQueue<Integer>(Comparator.reverseOrder());
        for(int i = 1; i < 10001 ; i++){
            int num = scanner.nextInt();
            if(i < 3){
                max.add(num);
            }
            else {
                if (num <= max.peek()) {
                    max.add(num);
                } else if (num >= min.peek()) {
                    min.add(num);
                } else {
                    max.add(num);
                }
            }
            if((max.size() - min.size() < 0)) {
                max.add(min.poll());
            }
            if((max.size() - min.size()) > 1) {
                min.add(max.poll());
            }
            medians.add(max.peek());
        }
        int sum  = 0;
        for(int num : medians){
            sum = sum + num;
        }
        System.out.println(sum%10000);
        scanner.close();
        }

    }

