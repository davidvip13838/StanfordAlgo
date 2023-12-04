import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Clustering1 {
    public UnionFind unionFind;
    public ArrayList<int[]> edges = new ArrayList<>();

    public static void main(String[] args) throws FileNotFoundException {
        Clustering1 clustering1 = new Clustering1();
        clustering1.data();
        System.out.println("The number of edges is " + clustering1.edges.size());
        System.out.println(clustering1.cluster());
    }

    public void data() throws FileNotFoundException {
        File file = new File("C:\\Users\\13109\\IdeaProjects\\StanfordAlgo\\max spacing k clustering\\clustering1.txt");
        Scanner scanner = new Scanner(file);
        unionFind = new UnionFind(scanner.nextInt());
        while (scanner.hasNextInt()) {
            // node number is adjusted so that node 1 becomes node 0, distance remains the same
            edges.add(new int[]{scanner.nextInt() - 1, scanner.nextInt() - 1, scanner.nextInt()});
        }
        scanner.close();
    }

    public int cluster() {
        // sorts all edges according to cost in ascending order
        Collections.sort(edges, Comparator.comparingInt(edges -> edges[2]));
        int clusters = 500;
        int edge_index = 0;
        while (clusters > 4) {
            // check if two node are in same cluster
            if(!unionFind.isConnected(edges.get(edge_index)[0],edges.get(edge_index)[1])){
                //if not in same cluster combine them
                unionFind.union(edges.get(edge_index)[0],edges.get(edge_index)[1]);
                clusters--;
                System.out.println("Mergring " + edges.get(edge_index)[0]+" and "+ edges.get(edge_index)[1] + " at cost " + edges.get(edge_index)[2]);
            }
            edge_index++;
        }
        // find the max spacing between two nodes belonging to diffrennt clusters
        while(true){
            if(!unionFind.isConnected(edges.get(edge_index)[0],edges.get(edge_index)[1])){
                return edges.get(edge_index)[2];
            }
            edge_index++;
        }
    }
}



