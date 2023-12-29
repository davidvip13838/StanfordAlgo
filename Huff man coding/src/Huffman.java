import java.io.File;
import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Huffman {
    public int[] merges; // index i represents word i and value of i represents # time i length of word
    public PriorityQueue<Word> heap = new PriorityQueue<>(Comparator.comparingInt(Word::getWeights)); // heap sorted using cummaltive weight

    public static void main(String[] args) throws FileNotFoundException {
        Huffman huffman = new Huffman();
        huffman.data();
        huffman.merge();
        System.out.println("The largest length word has length " + huffman.largest() +  " and the smallest has length " + huffman.smallest() );
    }

    public int largest(){
        int largest = merges[0];
        for(int i = 0; i < merges.length ; i++){
            if(merges[i] > largest){
                largest = merges[i];
            }
        }
        return largest;
    }

    public int smallest(){
        int smallest = merges[0];
        for(int i = 0; i < merges.length ; i++){
            if(merges[i] < smallest){
                smallest = merges[i];
            }
        }
        return smallest;
    }

    public void data() throws FileNotFoundException {
        File file = new File("/Users/ng161/IdeaProjects/StanfordAlgo/Huff man coding/huffman.txt");
        Scanner scanner = new Scanner(file);
        merges = new int[scanner.nextInt()];
        int index = 0;
        while(scanner.hasNextInt()){
            Word word = new Word(index,scanner.nextInt());
            heap.add(word);
            index++;
        }
        scanner.close();
    }

    public void merge(){
        while(heap.size() > 1){
            Word word1 = heap.poll();
            Word word2 = heap.poll();
            Word new_word = new Word(word1.indices,word2.indices,word1.weights,word2.weights);
            for(int index : new_word.indices){ // update the merges count for every word
                merges[index] = merges[index] + 1;
            }
            heap.add(new_word); // re-insert new word
        }
    }
}
