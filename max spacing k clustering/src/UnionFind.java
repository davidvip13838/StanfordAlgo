public class UnionFind {
    private int[] parent;
    private int[] rank;

    private int clusters;

    public UnionFind(int size) {
        parent = new int[size];
        rank = new int[size];
        clusters = size;

        // Initialize each element as a separate set with rank 0
        for (int i = 0; i < size; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    // Find the representative (root) of the set containing the element
    private int find(int element) {
        if (parent[element] != element) {
            // Path compression: Set the parent to the representative recursively
            parent[element] = find(parent[element]);
        }
        return parent[element];
    }

    // Union two sets based on their ranks
    public void union(int set1, int set2) {
        int root1 = find(set1);
        int root2 = find(set2);

        clusters--;

        if (root1 != root2) {
            // Union by rank: Attach the shorter tree to the root of the taller tree
            if (rank[root1] < rank[root2]) {
                parent[root1] = root2;
            } else if (rank[root1] > rank[root2]) {
                parent[root2] = root1;
            } else {
                // If ranks are equal, arbitrarily choose one as the root and increment its rank
                parent[root1] = root2;
                rank[root2]++;
            }
        }
    }

    // Check if two elements are in the same set
    public boolean isConnected(int element1, int element2) {
        return find(element1) == find(element2);
    }

    public static void main(String[] args) {
        UnionFind uf = new UnionFind(5);

        uf.union(0, 1);
        uf.union(2, 3);
        uf.union(1, 4);

        System.out.println(uf.isConnected(0, 4)); // Should print true
        System.out.println(uf.isConnected(2, 4)); // Should print false
    }

    public int getClusters() {
        return clusters;
    }
}