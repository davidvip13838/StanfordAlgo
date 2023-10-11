import java.util.ArrayList;
public class Vertex {
    ArrayList<Edge> edges = new ArrayList<Edge>();

    public ArrayList<Edge> getEdges() {
        return edges;
    }

    public void addEdges(Edge edge){
        this.edges.add(edge);
    }




}
