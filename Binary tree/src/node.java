public class node {
    public node(int num){
        this.value = num;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    private int value;

    public node getLeft() {
        return left;
    }

    public void setLeft(node left) {
        this.left = left;
    }

    private node left;

    public node getRight() {
        return right;
    }

    public void setRight(node right) {
        this.right = right;
    }

    private node right;
}
