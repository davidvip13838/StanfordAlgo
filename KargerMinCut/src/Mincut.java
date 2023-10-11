import java.util.ArrayList;

public class Mincut {
    public int mincut(ArrayList<Edge> edges , ArrayList<Vertex> vertices){
        while(vertices.size() > 2){
            Edge edge = pickRandom(edges);
            edges = merge(edge);
        }
        return vertices.get(0).edges.size();
    }

    public ArrayList<Edge>merge
}
