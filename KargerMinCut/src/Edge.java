public class Edge {
    private Vertex vertexi = null;
    private Vertex vertexj = null;
    public Edge(Vertex i , Vertex j){
        this.vertexi = i;
        this.vertexj = j;
    }

    public Vertex getVertexi() {
        return vertexi;
    }

    public Vertex getVertexj() {
        return vertexj;
    }
}
