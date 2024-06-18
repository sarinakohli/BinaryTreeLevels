 import java.util.*;

public class Binary 
{

    public static void main(String[] args) 
    {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the numbers to insert: ");
        String[] list = s.nextLine().split(",");
        BinaryTree tree = new BinaryTree();
        for (int i = 0; i < list.length; i++) {
            tree.insert(Integer.parseInt(list[i]));
        }
        System.out.println("The resulting Binary Tree has " + tree.levels(tree.root) + " levels.");
    }
}
class Node 
{
    int key;
    Node left, right;

    public Node(int key) {
        this.key = key;
        left = right = null;
    }
}

class BinaryTree 
{
    Node root;

    void insert(int data)
     {
        Node node = new Node(data);
        if (root == null) 
        {
            root = node;
            return;
        }

        Node current = root;
        Node parent;
        while (true) 
        {
            parent = current;
            if (data < current.key) 
            {
                current = current.left;
                if (current == null) 
                {
                    parent.left = node;
                    return;
                }
            } 
            else 
            {
                current = current.right;
                if (current == null) 
                {
                    parent.right = node;
                    return;
                }
            }
        }
    }
    public int levels(Node node)
 {
    if (node == null) {
        return 0;
    }
    int rightSide = levels(node.right);
    int leftSide = levels(node.left);

    return Math.max(rightSide, leftSide) + 1;
}
}

