import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class MST {
    public Hashtable<Integer,Vertex> vertices = new Hashtable<Integer,Vertex>();
    public PriorityQueue<Vertex> heap = new PriorityQueue<>(Comparator.comparingInt(p -> p.key));
    public ArrayList<Vertex> processed = new ArrayList<Vertex>();
    public int total_weight = 0;

    public static void main(String[] args) {
        MST mst = new MST();
        mst.data("C:\\Users\\13109\\IdeaProjects\\StanfordAlgo\\prims MST\\prim.txt");
        mst.heapify();
        System.out.println(mst.prim());
    }

    public int prim(){
        while (processed.size() < 500){
            Vertex v = heap.poll();
            processed.add(v); // add to finished set
            v.processed =  true;
            total_weight =  total_weight + vertices.get(v.id).key; // record edge weight
            for(int[] edge: vertices.get(v.id).edges){
                if(vertices.get(edge[0]).processed == false){
                    heap.remove(vertices.get(edge[0]));
                    vertices.get(edge[0]).key = Math.min(vertices.get(edge[0]).key,edge[1]);
                    heap.add(vertices.get(edge[0]));
                }
            }
        }
        return total_weight;
    }

    public void data(String pathname){
        File file = new File(pathname);
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        int num_vertices = scanner.nextInt();
        for(int i = 1; i <= num_vertices; i++){
            vertices.put(i,new Vertex(i));
        }
        scanner.nextInt(); // discard edge number
        while(scanner.hasNextInt()){
            int v1 = scanner.nextInt();
            int v2 = scanner.nextInt();
            int cost = scanner.nextInt();
            vertices.get(v2).edges.add(new int[]{v1,cost});
            vertices.get(v1).edges.add(new int[]{v2,cost});
        }
        scanner.close();
    }

    public void heapify(){
        processed.add(vertices.get(1)); // set vertex 1 as explored
        vertices.get(1).processed = true;
        //compute keys(min edge to processed vertices)
        for(int i = 2; i <= vertices.size(); i++){
            int min_cost = 1000000;
            for(int[] edge: vertices.get(i).edges){
                if(edge[0] == 1){
                    if(edge[1] < min_cost){
                        min_cost = edge[1];
                    }
                }
            }
            vertices.get(i).key = min_cost;
        }
        // insert all in heap
        for(int i = 2; i <= vertices.size(); i++){
            heap.add(vertices.get(i));
        }
    }

}
