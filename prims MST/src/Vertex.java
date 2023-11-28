import java.util.ArrayList;

public class Vertex {
    public int id;
    public int key;

    public Boolean processed = false;
    public ArrayList<int[]> edges = new ArrayList<int[]>(); // [target_vertex,cost]
    public Vertex(int id){
        this.id = id;
    }

}
