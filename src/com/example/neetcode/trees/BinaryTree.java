package com.example.neetcode.trees;

import java.util.Scanner;

public class BinaryTree {

    static Scanner sc = new Scanner(System.in);
    public static Node create(){
        System.out.println("Enter data ");
        int data = sc.nextInt();
        if(data==-1)
            return null;
        Node root = new Node(data);
        System.out.println("Enter data for left of "+data);
        root.setLeft(create());
        System.out.println("Enter data for right of "+data);
        root.setRight(create());
        return root;
    }

    public static void main(String[] args) {
        Node root = create();
        inorder(root);
        Node invertRoot = invert(root);
        inorder(invertRoot);
    }

   /* Inorder tree traversal is a depth-first method that visits binary tree nodes in
        Left -> Root -> Right order. It is commonly used on binary search trees
            (BST) to retrieve node values in ascending order, traversing
    the left subtree, then the root, and finally the right subtree*/
    public static void inorder(Node root){
        if(root!=null){
            inorder(root.getLeft());
            System.out.print(root.data);
            inorder(root.getRight());
        }
    }

    public static Node invert(Node root) {
        // Base case
        if(root==null){
            return root;
        }
        // Swap left/right
        Node temp ;
        temp = root.left;
        root.left = root.right;
        root.right = temp;
        // Recurse both children
        root.setLeft(invert(root.left));
        root.setRight(invert(root.right));
        return root;
    }
}
