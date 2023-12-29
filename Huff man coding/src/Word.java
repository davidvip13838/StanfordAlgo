import java.util.ArrayList;

public class Word {
    public ArrayList<Integer> indices = new ArrayList<Integer>(); // stores indices of words in this "meta word"
    public int weights; // cummaltive weight of all words in this meta word

    public int getWeights() {
        return weights;
    }

    public Word(ArrayList<Integer> indices1, ArrayList<Integer> indices2, int weight1, int weight2){
        for(int i : indices1){
            this.indices.add(i);
        }
        for(int j : indices2){
            this.indices.add(j);
        }
        this.weights = weight1 + weight2;
    }
    public Word(int index, int weight){
        this.indices.add(index);
        this.weights = weight;
    }
}
