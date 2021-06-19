package Binary_Tree;

import java.util.*;

import Binary_Tree.Node;

public class BinaryTree {
    Node root;

    int height(Node node) {

        if (node == null) {
            return 0;
        } else {
            int heightLeft = height(node.leftChild);
            int heightRight = height(node.rightChild);

            if (heightLeft > heightRight) {
                return (heightLeft + 1);
            } else {
                return (heightRight + 1);
            }
        }
    }

    void insert(Node node, int key) {
        Queue<Node> q = new LinkedList<Node>();
        q.add(node);

        while (!q.isEmpty()) {
            Node temp = q.poll();

            if (temp == null)
                return;

            if (temp.leftChild == null) {
                temp.leftChild = new Node(key);
                break;
            } else {
                q.add(temp.leftChild);
            }

            if (temp.rightChild == null) {
                temp.rightChild = new Node(key);
                break;
            } else {
                q.add(temp.rightChild);
            }

        }
    }

    void deleteDeepest(Node node, Node del_node) {
        Queue<Node> q = new LinkedList<Node>();
        q.add(node);
        Node temp = null;
        while (!q.isEmpty()) {
            temp = q.poll();
            if (temp == null) {
                return;
            }

            if (temp.rightChild != null) {
                if (temp.rightChild == del_node) {
                    temp.rightChild = null;
                    del_node = null;
                    return;
                } else {
                    q.add(temp.rightChild);
                }
            }

            if (temp.leftChild != null) {
                if (temp.leftChild == del_node) {
                    temp.leftChild = null;
                    del_node = null;
                    return;
                } else {
                    q.add(temp.leftChild);
                }
            }
        }
    }

    void delete(Node node, int key) {
        Queue<Node> q = new LinkedList<Node>();
        q.add(node);

        Node key_node = null;
        Node temp = null;
        while (!q.isEmpty()) {
            temp = q.poll();
            if (temp == null) {
                return;
            }
            if (temp.key == key) {
                key_node = temp;
            }

            if (temp.leftChild != null) {
                q.add(temp.leftChild);
            }

            if (temp.rightChild != null) {
                q.add(temp.rightChild);
            }
        }
        int x = temp.key;
        deleteDeepest(root, temp);
        key_node.key = x;

    }

    // Inorder Traversal
    void printInorder(Node node) {

        if (node == null) {
            return;
        }

        // Recuring Left Subtree
        printInorder(node.leftChild);

        // Printing Data of Node
        System.out.print(node.key + " ");

        // Recurong Right Subtree
        printInorder(node.rightChild);
    }

    // Preorder traversal
    void printPreorder(Node node) {
        if (node == null)
            return;

        // Printing the value of node
        System.out.print(node.key + " ");

        // Traversing the left Sub Tree
        printPreorder(node.leftChild);

        // Traversing the right Sub Tree
        printPreorder(node.rightChild);

    }

    // Postorder traversal
    void printPostorder(Node node) {
        if (node == null)
            return;

        // Traversing the left Sub Tree
        printPostorder(node.leftChild);

        // Traversing the right Sub Tree
        printPostorder(node.rightChild);

        // Printing the value of node
        System.out.print(node.key + " ");
    }

    // Levelorder Traversal
    void printLevelorder(Node node) {
        Queue<Node> q = new LinkedList<Node>();

        q.add(node);
        while (!q.isEmpty()) {
            Node temp = q.poll();
            if (temp == null)
                return;

            System.out.print(temp.key + " ");

            // Enqueue leftChild
            if (temp.leftChild != null)
                q.add(temp.leftChild);

            if (temp.rightChild != null)
                q.add(temp.rightChild);
        }

    }

    void printReverseLevelOrder(Node node) {
        Stack<Node> stack = new Stack<>();
        Queue<Node> q = new LinkedList<Node>();

        q.add(node);
        while (!q.isEmpty()) {
            Node temp = q.poll();

            if (temp == null)
                break;

            stack.push(temp);

            if (temp.rightChild != null) {
                q.add(temp.rightChild);
            }

            if (temp.leftChild != null) {
                q.add(temp.leftChild);
            }
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop().key + " ");
        }
    }

    // Wrapper function for above recursive function
    void printInorder() {
        printInorder(root);
    }

    void printPreorder() {
        printPreorder(root);
    }

    void printPostorder() {
        printPostorder(root);
    }

    void printLevelorder() {
        printLevelorder(root);
    }

    void printReverseLevelOrder() {
        printReverseLevelOrder(root);
    }

    int height() {
        return height(root);
    }

    void insert(int key) {
        insert(root, key);
    }

    void delete(int key) {
        delete(root, key);
    }

    public static void main(String[] args) {
        BinaryTree BT = new BinaryTree();
        BT.root = new Binary_Tree.Node(1);
        BT.root.leftChild = new Binary_Tree.Node(2);
        BT.root.rightChild = new Binary_Tree.Node(3);
        BT.root.leftChild.leftChild = new Binary_Tree.Node(4);
        BT.root.leftChild.rightChild = new Binary_Tree.Node(5);
        BT.root.rightChild.leftChild = new Binary_Tree.Node(6);
        BT.root.rightChild.rightChild = new Binary_Tree.Node(7);
        System.out.println("\nInorder traversal of binary tree is ");
        BT.printInorder();
        System.out.println("\nPreorder traversal of binary tree is ");
        BT.printPreorder();
        System.out.println("\nPostorder traversal of binary tree is ");
        BT.printPostorder();

        System.out.println("\nLevelorder traversal of binary tree is ");
        BT.printLevelorder();

        System.out.println("\nReverseLevelOrder traversal of binary tree is ");
        BT.printReverseLevelOrder();

        System.out.print("\nHeight of the Binary tree is ");
        System.out.println(BT.height());

        BT.insert(8);
        BT.insert(9);
        BT.insert(10);
        BT.insert(11);
        BT.insert(12);
        BT.insert(13);
        BT.insert(14);
        BT.insert(15);
        System.out.println("\nLevelorder traversal of binary tree after inserting elements is ");
        BT.printLevelorder();

        BT.delete(4);
        System.out.println("\nLevelorder traversal of binary tree after deleting element is ");
        BT.printLevelorder();
        System.out.println();
    }
}