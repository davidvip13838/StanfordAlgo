import java.util.ArrayList;
import java.util.Random;

public class Mincut {
    public int mincut(ArrayList<Edge> edges , ArrayList<Vertex> vertices){
        while(vertices.size() > 2){
            Edge edge = pickRandom(edges);
            Vertex v_i = edge.getVertexi();
            Vertex v_j = edge.getVertexj();

            ArrayList<Vertex> verticesToRemove = new ArrayList<>();

            for (Vertex v : vertices) {
                if (v.equals(v_i) || v.equals(v_j)) {
                    verticesToRemove.add(v);
                }
            }

            for (Vertex v : verticesToRemove) {
                vertices.remove(v);
            }

            /*for (Vertex v:vertices) { // remove vertices from vertex list
                if(v.equals(v_i)){
                    vertices.remove(v);
                }
                if(v.equals(v_j)){
                    vertices.remove(v);
                }
            }*/

            Vertex new_v = new Vertex();
            merge(v_i,v_j,new_v,edges);
            vertices.add(new_v);

        }
        return vertices.get(0).getEdges().size();
    }

    public Edge pickRandom(ArrayList<Edge> edges){
        Random random = new Random();
        int index = random.nextInt(edges.size());
        return edges.get(index);
    }

    public void merge(Vertex v1, Vertex v2, Vertex new_v,ArrayList<Edge> edges){
        ArrayList<Edge> merged = new ArrayList<Edge>();
        for(Edge e : v1.getEdges()){
            if(e.getVertexj() == v2){
                edges.remove(e);
            }
            else{
                edges.remove(e);
                Edge new_e = new Edge(new_v,e.getVertexj());
                edges.add(new_e);
                new_v.addEdges(new_e);
            }
        }

        for(Edge e : v2.getEdges()){
            if(e.getVertexj() == v1){
                edges.remove(e);
            }
            else{
                edges.remove(e);
                Edge new_e = new Edge(new_v,e.getVertexj());
                edges.add(new_e);
                new_v.addEdges(new_e);
            }
        }
    }

}
