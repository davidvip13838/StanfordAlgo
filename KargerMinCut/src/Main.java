import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        ArrayList<Edge> edges = new ArrayList<Edge>(); // make the list of vertices and edges
        ArrayList<Vertex> vertices = new ArrayList<Vertex>();
        for(int i = 0 ; i < 200 ; i++){
            vertices.add(new Vertex());
        }

        File file = new File("C:\\Users\\13109\\IdeaProjects\\StanfordAlgo\\KargerMinCut\\src\\mincuts.txt");
        System.out.println("file found...");
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
            scanner.useDelimiter("[\\t\\n]");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        // take in input
        while(scanner.hasNext()){
            String line = scanner.nextLine();
            Scanner lineScanner = new Scanner(line);
            int curr_vertex = lineScanner.nextInt() -1; // index of vertex

            while(lineScanner.hasNextInt()){
                int target = lineScanner.nextInt();
                System.out.println("Edge between: " + (curr_vertex +1) + " and " + target );
                Edge edge = new Edge(vertices.get(curr_vertex),vertices.get(target -1));
                vertices.get(curr_vertex).addEdges(edge);
                edges.add(edge);
            }
            lineScanner.close();
        }
        //take  in output ends

        scanner.close();
        Mincut mincut = new Mincut();
        System.out.print("test");
        int f = mincut.mincut(edges,vertices);
        System.out.print("the min amount of crossings are" + f+ "in this trail");

        System.out.println(vertices.size());
        System.out.println(vertices.get(1).getEdges().size());
    }
}