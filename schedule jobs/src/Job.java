import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Job {
    public ArrayList<J> job = new ArrayList<J>();
    public static void main(String[] args) throws FileNotFoundException {
        Job job1 = new Job();
        job1.data();
        System.out.println(job1.job.size());
        // sort according to diffrence
        Collections.sort(job1.job, Comparator.comparing(J::getDiffrence).thenComparing(J :: getWeight));
        Long diff = job1.calculate();
        // sort accoridng to ratio
        Collections.sort(job1.job, Comparator.comparing(J :: getRatio));
        Long ratio = job1.calculate();

        System.out.println("the result from diffrence is " + diff + " And the result from ratio is " + ratio );
    }

    public void data() throws FileNotFoundException {
        File file = new File("C:\\Users\\13109\\IdeaProjects\\StanfordAlgo\\schedule jobs\\jobs.txt");
        Scanner scanner = new Scanner(file);
        scanner.nextInt();
        while(scanner.hasNextInt()){
            J j = new J();
            j.weight = scanner.nextInt();
            j.length = scanner.nextInt();
            j.diffrence = j.weight - j.length;
            j.ratio = (double) j.weight/ (double) j.length;
            job.add(j);
        }
        scanner.close();
    }

    public Long calculate(){
        Long sum = Long.valueOf(0);
        int c = 0;
        for(int i = job.size()-1 ; i >= 0 ; i--){
            c = c + job.get(i).length;
            sum = sum + (long) c * job.get(i).weight;
            System.out.println(sum);
        }
        return sum;
    }

}
