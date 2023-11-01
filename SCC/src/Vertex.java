import java.util.ArrayList;

public class Vertex {
    private ArrayList<Integer> out = new ArrayList<Integer>();
    private int id;
    private ArrayList<Integer> in = new ArrayList<Integer>();

    private int size;
    private Boolean Visited1;
    private Boolean Visited2;

    public int getSize() {
        return size;
    }

    public void addSize(){
        this.size++;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Boolean getVisited1() {
        return Visited1;
    }

    public void setVisited1(Boolean visited) {
        Visited1 = visited;
    }

    public Boolean getVisited2() {
        return Visited2;
    }

    public void setVisited2(Boolean visited2) {
        Visited2 = visited2;
    }

    public int getId() {
        return id;
    }

    public ArrayList<Integer> getIn() {
        return in;
    }

    public ArrayList<Integer> getOut() {
        return out;
    }

    public Vertex(int id){
        this.id = id;
        this.Visited1 = false;
        this.Visited2 = false;
    }
}
