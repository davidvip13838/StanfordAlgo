import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Dijkstra {
    public HashMap<Integer,Vertex> vertices = new HashMap<Integer, Vertex>();
    public ArrayList<Integer> processed = new ArrayList<Integer>();

    public void input() throws FileNotFoundException {
        File file = new File("C:\\Users\\13109\\IdeaProjects\\StanfordAlgo\\Dijkstras algo\\src\\Graph.txt");
        Scanner in = new Scanner(file);
        while(in.hasNext()){
            Scanner line = new Scanner(in.nextLine());
            line.useDelimiter(",|\\s+"); // Set the delimiter to ',' or one or more whitespaces
            int id = line.nextInt(); // id of current vertex
            System.out.println("Scanning vertex" + id);
            vertices.put(id,new Vertex(id,10000, false));
            while(line.hasNextInt()){
                int v = line.nextInt();
                int d = line.nextInt();
                int[] edge = {v,d};
                vertices.get(id).edges.add(edge);
            }
            line.close();
        }
        in.close();
    }

    public void shortest(){
        processed.add(1);
        vertices.get(1).proccesed = true;
        vertices.get(1).dist = 0;
        while(processed.size() < 200){
            System.out.println("size of processed is " + processed.size());
            int min_score = 10000;
            int l_vw = 0;
            int w_id = 0;
            int v_dist = 0;
            for(int v : processed){
                for(int[] edge : vertices.get(v).edges){
                    if(vertices.get(edge[0]).proccesed == false){
                        int score = vertices.get(v).dist + edge[1];
                        if(score < min_score){
                            min_score = score;
                            l_vw = edge[1];
                            w_id = edge[0];
                            v_dist = vertices.get(v).dist;
                        }
                    }
                }
            }
            System.out.println("vertex getting added to proccssed list is " + w_id);
            processed.add(w_id);
            vertices.get(w_id).proccesed = true;
            vertices.get(w_id).dist = v_dist + l_vw;
        }
    }

    public static void main(String[] args) throws FileNotFoundException{
        Dijkstra dijkstra = new Dijkstra();
        dijkstra.input();
        System.out.println("the size of vertices is " + dijkstra.vertices.size());
        dijkstra.shortest();
        System.out.println(dijkstra.vertices.get(7).dist);
        System.out.println(dijkstra.vertices.get(37).dist);
        System.out.println(dijkstra.vertices.get(59).dist);
        System.out.println(dijkstra.vertices.get(82).dist);
        System.out.println(dijkstra.vertices.get(99).dist);
        System.out.println(dijkstra.vertices.get(115).dist);
        System.out.println(dijkstra.vertices.get(133).dist);
        System.out.println(dijkstra.vertices.get(165).dist);
        System.out.println(dijkstra.vertices.get(188).dist);
        System.out.println(dijkstra.vertices.get(197).dist);

    }
}
