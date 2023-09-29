public class tree {
    public static void main(String[] args) {
        tree binarytree = new tree();
        node parent = new node(4);
        binarytree.insert(4,parent);
        int[] nums = {2,5,6,7,3,18};
        for (int number : nums) {
            binarytree.insert(number,parent);
        }
        binarytree.inorder(parent);

    }
    public void insert(int value, node parent){
        if (value < parent.getValue()) {
            if (parent.getLeft() == null) {
                parent.setLeft(new node(value));
            }
            insert(value,parent.getLeft());
        }
        if (value > parent.getValue() ) {
            if (parent.getRight() == null) {
                parent.setRight(new node(value));
            }
            insert(value, parent.getRight());
        }
    }

    public void inorder(node parent){
        if (parent == null){
            return;
        }
       
        inorder(parent.getLeft());
        System.out.println(parent.getValue());
        inorder(parent.getRight());
    }
}
