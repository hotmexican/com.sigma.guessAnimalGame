public class DesTreeNode<T> {
    private String data;
    private DesTreeNode<T> leftChild;
    private DesTreeNode<T> rightChild;

    public DesTreeNode(String data, DesTreeNode<T> leftChild, DesTreeNode<T> rightChild) {
        this.data = data;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public DesTreeNode<T> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(DesTreeNode<T> leftChild) {
        this.leftChild = leftChild;
    }

    public DesTreeNode<T> getRightChild() {
        return rightChild;
    }

    public void setRightChild(DesTreeNode<T> rightChild) {
        this.rightChild = rightChild;
    }

    public boolean isLeaf( )
    {
        return (leftChild == null) && (rightChild == null);
    }
}
