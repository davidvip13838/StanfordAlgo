import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WIS {
    public long[] maxw;
    public int[] graph;

    public int[] used; // 1 if index is used in maxw. 0 if not (index 0 represents vertex 1)

    public static void main(String[] args) throws FileNotFoundException {
        WIS wis = new WIS();
        wis.data(); // data input to fill maxw and graph
        wis.fill(); // fills max w
        for(long i : wis.maxw){
            System.out.println(i);
        }
        wis.reconstuct();
        for(int i = 0; i < wis.used.length ; i++){ // first vertex is 1
            System.out.println("The state of vertex " + (i+1) + " is " + wis.used[i]);
        }
    }

    public void reconstuct() {
        used = new int[graph.length];
        int i = graph.length-1;
        while(i >= 1){
            if(maxw[i-1] >= maxw[i-2] + graph[i]){
                i--;
            }
            else{
                used[i] = 1;
                i = i-2;
            }
        }
    }

    public void data() throws FileNotFoundException {
        File file = new File("/Users/ng161/IdeaProjects/StanfordAlgo/Weighted independent set of path graph/WIS.txt");
        Scanner scanner = new Scanner(file);
        int length = scanner.nextInt();
        maxw = new long[length];
        graph = new int[length];
        for(int i = 0; i < length ; i++){
            graph[i] = scanner.nextInt();
        }
        scanner.close();
    }

    public void fill(){
        maxw[0] = graph[0]; // base case: A[0] = w1
        maxw[1] = Math.max(graph[0] , graph[1]); // base case: A[1] = max(w1,w2)
        for(int i = 2; i < graph.length ; i++){
            maxw[i] = Math.max(maxw[i-1], maxw[i-2] + graph[i]);
        }
    }
}
