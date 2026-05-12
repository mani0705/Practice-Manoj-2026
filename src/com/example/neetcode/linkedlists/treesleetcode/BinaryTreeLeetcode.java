package com.example.neetcode.linkedlists.treesleetcode;

import com.example.neetcode.trees.Node;
import com.sun.source.tree.Tree;

import java.util.Scanner;

import static java.lang.Math.max;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

public class BinaryTreeLeetcode {

    public static void main(String[] args) {
        TreeNode root = create();
        inorder(root);
        //TreeNode invertRoot = invert(root);
        //inorder(invertRoot);
        System.out.print("the heigh of the tree is "+maxDepth(root));
    }

    static Scanner sc = new Scanner(System.in);
    public static TreeNode create(){
        System.out.println("Enter data ");
        int data = sc.nextInt();
        if(data==-1)
            return null;
        TreeNode root = new TreeNode(data , create() , create());
        return root;
    }

    /* Inorder tree traversal is a depth-first method that visits binary tree nodes in
        Left -> Root -> Right order. It is commonly used on binary search trees
            (BST) to retrieve node values in ascending order, traversing
    the left subtree, then the root, and finally the right subtree*/
    public static void inorder(TreeNode root){
        if(root!=null){
            inorder(root.left);
            System.out.print(root.val);
            inorder(root.right);
        }
    }

    public static TreeNode invert(TreeNode root) {
            // Base case
        if(root==null){
            return root;
        }
        // Swap left/right
        TreeNode temp ;
        temp = root.left;
        root.left = root.right;
        root.right = temp;
        // Recurse both children
        invert(root.left);
        invert(root.right);
        return root;
    }


/*    Given the root of a binary tree, return its maximum depth.

    A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.



    Example 1:


    Input: root = [3,9,20,null,null,15,7]
    Output: 3
    Example 2:

    Input: root = [1,null,2]
    Output: 2


    Constraints:

    The number of nodes in the tree is in the range [0, 104].
            -100 <= Node.val <= 100*/
    public static int maxDepth(TreeNode root) {

        if(root==null)
            return 0;
        return max(maxDepth(root.left),maxDepth(root.right))+1;
    }

 /*   Given the root of a binary tree, return the length of the diameter of the tree.

    The diameter of a binary tree is the length of the longest path between any
    two nodes in a tree. This path may or may not pass through the root.

    The length of a path between two nodes is represented by the number of edges between them.



    Example 1:


    Input: root = [1,2,3,4,5]
    Output: 3
    Explanation: 3 is the length of the path [4,2,1,3] or [5,2,1,3].
    Example 2:

    Input: root = [1,2]
    Output: 1


    Constraints:

    The number of nodes in the tree is in the range [1, 104].
            -100 <= Node.val <= 100*/
    public static int diameterOfBinaryTree(TreeNode root) {
        if(root==null)
            return 0;
        int leftmax = maxDepth(root.left);
        int rightmax = maxDepth(root.right);
        int max = Math.max(leftmax,rightmax,max);
    }
}
