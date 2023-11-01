import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class SCC {

    public int t = 0;

    public Vertex S;
    public Hashtable<Integer,Vertex> vertices = new Hashtable<Integer, Vertex>();
    public ArrayList<Integer> f_times = new ArrayList<Integer>();

    public ArrayList<Integer> SCC_size = new ArrayList<Integer>();

    public void read_file(String file_name) throws FileNotFoundException {
        File file = new File("C:\\Users\\13109\\IdeaProjects\\StanfordAlgo\\SCC\\SCC.txt");
        Scanner scanner = new Scanner(file);
        for(int i = 1; i < 875715 ; i++){
            vertices.put(i,new Vertex(i));
        }
        if(vertices.get(100).getId() == 100){
            System.out.println("Id of each vertex is correct...");
        }
        else{
            System.out.println("id of vertex is incorrect");
        }
        if(vertices.size() == 875714){
            System.out.println("Size of vertices list is correct...");
        }
        else{
            System.out.print("Size of vertices list is incorrect");
        }
        while(scanner.hasNext()){
            int v_out = scanner.nextInt();
            int v_in = scanner.nextInt();
            vertices.get(v_out).getOut().add(v_in); // add edge to "out" edge list of starting vertex
            vertices.get(v_in).getIn().add(v_out); // add edge to "in" edge list of ending vertex
        }
        if(vertices.get(8).getOut().size() == 10){
            System.out.println("added edges sucessful...");
        }
        else{
            System.out.println("added edges failed");
        }
        System.out.println("The out going edges from vertex 8 are:");
        for(int vertex : vertices.get(8).getOut()){
            System.out.println(vertex);
        }
        scanner.close();
    }

    public void loop1(){
        for(int i = vertices.size(); i > 0 ; i--){
            if(vertices.get(i).getVisited1() == false){
                DFS1(i);
            }
        }
    }

    public void DFS1(int id){
        vertices.get(id).setVisited1(true);
        System.out.println("Currently at vertex" + vertices.get(id).getId());
        for(int j : vertices.get(id).getIn()){
            if(vertices.get(j).getVisited1() == false){
                DFS1(j);
            }
        }
        t++;
        f_times.add(id);
    }

    public void loop2(){
        for(int i = f_times.size() - 1; i >= 0; i-- ){
            if(vertices.get(f_times.get(i)).getVisited2() == false){
                S = vertices.get(f_times.get(i));
                DFS2(f_times.get(i));
                SCC_size.add(S.getSize());
            }
        }
    }

    public void DFS2(int id){
        vertices.get(id).setVisited2(true);
        for(int j : vertices.get(id).getOut()){
            if(vertices.get(j).getVisited2() == false){
                DFS2(j);
            }
        }
        S.addSize();
    }
    public static void main(String[] args) throws FileNotFoundException {
        SCC scc = new SCC();
        scc.read_file("SCC.txt");
        scc.loop1();
        if(scc.f_times.size() == 875714){
            System.out.println("finishing times list is correct size");
        }
        else{
            System.out.print("finishing list is not correct size ");
        }
        System.out.println(scc.SCC_size.size());

    }
}
