import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        ArrayList<Edge> edges = new ArrayList<Edge>(); // make the list of vertices and edges
        ArrayList<Vertex> vertices = new ArrayList<Vertex>();

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
            Vertex vertex = new Vertex();

            // Skip the first number (vertex number)
            lineScanner.nextInt();

            while(lineScanner.hasNextInt()){
                int target = lineScanner.nextInt();
                System.out.println("Read target: " + target);
                System.out.println("Vertices size: " + vertices.size());
                if(target <= vertices.size() + 1){  // check if particular edge have already appeared
                    Edge incident = new Edge(vertices.get(target-1), vertex );
                    vertex.addEdges(incident); // add incident edge to vertex
                    edges.add(incident);
                }
            }
            vertices.add(vertex);
            lineScanner.close();
        }
        //take  in output ends

        scanner.close();

        System.out.println(vertices.size());
        System.out.println(vertices.get(199).getEdges().size());
    }
}