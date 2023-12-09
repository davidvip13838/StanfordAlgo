import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Clustering2 {
    public static void main(String[] args) throws FileNotFoundException {
        // Create an ArrayList to store integer representations
        ArrayList<Integer> intRepresentations = new ArrayList<>();
        // create hash table to store all nodes and its decimal representation
        HashMap<Integer,Integer> nodes = new HashMap<>(); // (decimal,node number)

        // Create a Scanner to read input
        File file = new File("C:\\Users\\13109\\IdeaProjects\\StanfordAlgo\\max spacing k clustering\\clustering_big.txt");
        Scanner scanner = new Scanner(file);

        UnionFind unionFind = new UnionFind(200000);

        // Call the processData method to handle the data
        processData(scanner, intRepresentations,nodes,unionFind);

        // Close the Scanner
        scanner.close();

        // Display the integer representations in the ArrayList
        System.out.println("Integer Representations:");
        for (Integer representation : intRepresentations) {
            System.out.println(representation);
        }

        System.out.println("The number of nodes is "+  intRepresentations.size());


        //call the clustering algorithm
        clustering(intRepresentations,nodes,unionFind);

        System.out.println(unionFind.getClusters());


    }

    private static void clustering(ArrayList<Integer> intRepresentations, HashMap<Integer,Integer> nodes,UnionFind unionFind) {
        // find all distances of 1
        for(int i =  0; i < intRepresentations.size() ; i++){
            for (int j = 0; j < 24; j++) {
                int numberWithFlippedBit = intRepresentations.get(i) ^ (1 << j);
                if(nodes.containsKey(numberWithFlippedBit)){
                    if(!unionFind.isConnected(i,nodes.get(numberWithFlippedBit))){
                        unionFind.union(i,nodes.get(numberWithFlippedBit));
                    }
                }
            }
        }
        for(int i = 0; i < intRepresentations.size(); i++){
            for (int j = 0; j < 23; j++) {
                for (int k = j + 1; k < 24; k++) {
                    int numberWithFlippedBits = intRepresentations.get(i) ^ (1 << j) ^ (1 << k);
                    if(nodes.containsKey(numberWithFlippedBits)){
                        if(!unionFind.isConnected(i,nodes.get(numberWithFlippedBits))){
                            unionFind.union(i,nodes.get(numberWithFlippedBits));
                        }
                }
            }
        }
        }

    }

    // Method to process data and populate the ArrayList
    private static void processData(Scanner scanner, ArrayList<Integer> intRepresentations, HashMap<Integer,Integer> nodes,UnionFind unionFind) {
        // Read each line until there is no more input
        scanner.nextInt();
        scanner.nextInt();
        int node_num = 0;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim(); // Read the line and remove leading/trailing whitespaces

            // Remove spaces and check if the line is a valid binary string
            String binaryString = line.replaceAll(" ", "");
            if (binaryString.matches("[01]+")) {
                // Convert the binary string to an integer and add it to the ArrayList
                int intRepresentation = Integer.parseInt(binaryString, 2);
                intRepresentations.add(intRepresentation);
                // check for identical nodes
                if(nodes.containsKey(intRepresentation)){
                    unionFind.union(nodes.get(intRepresentation), node_num);
                }else {
                    nodes.put(intRepresentation, node_num);
                }
                node_num++;
            } else {
                System.out.println("Invalid input: " + line);
            }
        }
    }

}
