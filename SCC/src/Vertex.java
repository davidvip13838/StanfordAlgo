import java.util.ArrayList;

public class Vertex {
    private ArrayList<Edge> out = new ArrayList<Edge>();
    private ArrayList<Edge> in = new ArrayList<Edge>();
    private Vertex leader;
    private int f_time;
    private Boolean Visited = false;

    public ArrayList<Edge> getIn() {
        return in;
    }

    public ArrayList<Edge> getOut() {
        return out;
    }
}
