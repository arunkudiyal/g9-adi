class Node {
    int data;
    Node left, right;
    Node(int data) {
        this.data = data;
        this.left = this.right = null;
    }
}

public class BinarySearchTree {
    Node root;
    BinarySearchTree() {
        root = null;
    }

    public void insert(int key) {
        root = insertData(root, key);
    }

    public void inOrder() {
        inOrderTraversal(root);
    }

    public boolean search(int key) {
        Node address = searchData(root, key);
        if(address == null) return false;
        return true;
    }

    public void delete(int key) {
        root = deleteKey(root, key);
    }

    public Node searchData(Node root, int key) {
        if(root == null || key == root.data) return root;
        if(key < root.data) return searchData(root.left, key);
        return searchData(root.right, key);
    }

    public Node insertData(Node root, int key) {
        // The data is inserted for the first time
        if(root == null) root = new Node(key);
        // left subtree
        else if(key < root.data) root.left = insertData(root.left, key);
        // right subtree
        else if(key > root.data) root.right = insertData(root.right, key);
        return root;
    }

    public int findMinVal(Node root) {
        int minValue = root.data;
        while(root.left != null) {
            minValue = root.left.data;
            root = root.left;
        }
        return minValue;
    }

    public Node deleteKey(Node root, int key) {
        if(root == null) return null;
        else {
            if(key > root.data) root.right = deleteKey(root.right, key);
            else if(key < root.data) root.left = deleteKey(root.left, key);
            else {
                if(root.left == null) return root.right;
                else if(root.right == null) return  root.left;
                 else {
                    root.data = findMinVal(root.right);
                    root.right = deleteKey(root.right, root.data);
                }
            }
        }
        return root;
    }

    public void inOrderTraversal(Node root) {
        if(root != null) {
            inOrderTraversal(root.left);
            System.out.print(root.data + " ");
            inOrderTraversal(root.right);
        }
    }

    public static void main(String[] args) {
        // root = null
        BinarySearchTree bst = new BinarySearchTree();

        // insertion
        bst.insert(24);
        bst.insert(39);
        bst.insert(14);
        bst.insert(56);
        bst.insert(49);
        bst.insert(12);
        bst.insert(17);

        // print
        bst.inOrder();
        System.out.println();

        boolean ans = bst.search(-1);
        if(ans) System.out.println("Yes, it exists");
        else System.out.println("No, it does not exist!");

        // delete
        bst.delete(24);
        bst.inOrder();
        System.out.println();
    }
}
