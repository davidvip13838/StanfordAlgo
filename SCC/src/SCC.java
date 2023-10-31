import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;

public class SCC {
    public Hashtable<Integer,Vertex> vertices = new Hashtable<Integer, Vertex>();

    public void read_file(String file_name) throws FileNotFoundException {
        File file = new File("C:\\Users\\13109\\IdeaProjects\\StanfordAlgo\\SCC\\SCC.txt");
        Scanner scanner = new Scanner(file);
        for(int i = 1; i < 875715 ; i++){
            vertices.put(i,new Vertex());
        }
        if(vertices.size() == 875714){
            System.out.println("Size of vertices list is correct");
        }
        else{
            System.out.print("Size of vertices list is incorrect");
        }
        while(scanner.hasNext()){
            int v_out = scanner.nextInt();
            int v_in = scanner.nextInt();
            Edge edge = new Edge(v_out,v_in);
            vertices.get(v_out).getOut().add(edge); // add edge to "out" edge list of starting vertex
            vertices.get(v_in).getIn().add(edge); // add edge to "in" edge list of ending vertex
        }
        if(vertices.get(8).getOut().size() == 10){
            System.out.println("added edges sucessful");
        }
        else{
            System.out.println("added edges failed");
        }
        scanner.close();
    }


    public static void main(String[] args) throws FileNotFoundException {
        SCC scc = new SCC();
        scc.read_file("SCC.txt");
    }
}
