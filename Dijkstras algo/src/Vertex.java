import java.util.ArrayList;

public class Vertex {
    public int ID;
    public int dist;

    public Boolean proccesed;
    public ArrayList<int[]> edges = new ArrayList<int[]>();

    public Vertex(int id, int dist, Boolean processed){
        this.ID = id;
        this.dist = dist;
        this.proccesed = processed;
    }
}
