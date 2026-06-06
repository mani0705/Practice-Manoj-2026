package com.example.neetcode.treesleetcode;

import java.util.*;

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
        preOrder(root);
        //TreeNode invertRoot = invert(root);
        //inorder(invertRoot);
        /*System.out.println("the heigh of the tree is "+maxDepth(root));
        System.out.println("the diameter of the tree is "+diameterOfBinaryTree(root));
        System.out.println("is the tree balanced ?"+isBalanced(root));
        TreeNode rootAnother = create();
        System.out.println("the heigh of the other tree is "+maxDepth(rootAnother));
        System.out.println("the diameter of the other tree is "+diameterOfBinaryTree(rootAnother));
        System.out.println("is the other tree balanced ?"+isBalanced(rootAnother));
        boolean sameTree = isSameTree(root,rootAnother);
        System.out.println("are the two trees same ?" +sameTree);
        System.out.println("going to check tree and subtree problem ");
        boolean checkSubTree = isSubtree(root , rootAnother);
        System.out.println("is rootAnother a sub tree of root? "+checkSubTree);
        TreeNode lca = lowestCommonAncestor(root,root.left.right,root.right.left);
        out.println();
        out.println("lowest common ancestor is "+lca.val);
        out.print(levelOrder(root));
        out.print(rightSideView(root));
        out.println("number of good nodes in this tree are "+goodNodes(root));
        out.println(" is the tree a valid BST ? "+isValidBST(root));
        out.println(" kth smallest element is "+kthSmallest(root,1));
        out.print(" tree built is "+buildTree(new int[]{3,9,20,15,7} , new int[]{9,3,15,20,7}));
        out.print("binary tree max path sum is "+maxPathSum(root));*/
        TreeNode rootDes = deserialize(serialize(root));
        inorder(rootDes);
    }

    public static void preOrder(TreeNode root){
        if(root!=null){
            System.out.print(root.val);
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    static String serialize = "";
    private static void preOrderTraversal(TreeNode root){
        if(root!=null){
            serialize = serialize + root.val +",";
            preOrderTraversal(root.left);
            preOrderTraversal(root.right);
        }else
            serialize = serialize + "%" + ",";
    }

    public static String serialize(TreeNode root) {
        preOrderTraversal(root);
        System.out.println("the string is "+serialize);
        return serialize;
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        if(data.isEmpty())
            return null;
        String[] input = data.split(",");
        return deserializeHelper(input);
    }

    static int preOrderSeq = 0;
    private static TreeNode deserializeHelper(String[] data) {
        if(preOrderSeq==data.length || data[preOrderSeq].equals("%")){
            preOrderSeq++;
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(String.valueOf(data[preOrderSeq++])));
        root.left = deserializeHelper(data);
        root.right = deserializeHelper(data);
        return root;
    }

    static int maxSum = Integer.MIN_VALUE;
    public static int maxPathSum(TreeNode root) {
        gainToParent(root);
        return maxSum;
    }

    private static int gainToParent(TreeNode root) {
        if(root==null)
            return 0;
        int leftGain = Math.max(gainToParent(root.left),0);
        int rightGain = Math.max(gainToParent(root.right),0);
        int throughRoot  = root.val + leftGain + rightGain;
        maxSum = Math.max(maxSum,throughRoot);
        return root.val + Math.max(leftGain , rightGain);

    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode rootB = null;
        rootB = buildUsingIndex(preorder,inorder,0,inorder.length-1);
        inorder(rootB);
        return rootB;
    }

    static int preIndex = 0;
    private static TreeNode buildUsingIndex(int[] preorder, int[] inorder,int start , int end) {

        if(start>end)
            return null;
        TreeNode root = new TreeNode(preorder[preIndex++]);
        int p=start;
        while(start<=end){
            if(inorder[p]==root.val){
               break;
            }
            p++;
        }
        root.left = buildUsingIndex(preorder,inorder,start,p-1);
        root.right = buildUsingIndex(preorder,inorder,p+1,end);
        return root;
    }


    static int counter = 0;
    static int result = -1;
    public static int kthSmallest(TreeNode root, int k) {
        inordertraversal(root,k);
        return result;
    }

    private static void inordertraversal(TreeNode root, int k) {
        if(root==null)
            return;
        inordertraversal(root.left,k);
        counter++;
        if(counter==k)
            result = root.val;
        else
            inordertraversal(root.right,k);
    }

    public static boolean isValidBST(TreeNode root) {
        return  validateBST(root,Long.MIN_VALUE, Long.MAX_VALUE)==1?true:false;
    }

    private static int validateBST(TreeNode root , long min , long max) {
        if(root==null)
            return 1;
        if(root.val<=min || root.val>=max)
            return -1;
        int valLeft = validateBST(root.left,min,root.val);
        if(valLeft<0)
            return -1;
        int valRight = validateBST(root.right,root.val,max);
        if(valRight<0)
            return -1;
        return 1;
    }

    static int goodNodes = 0;
    public static int goodNodes(TreeNode root) {
        if(root==null)
            return 0;
        lookForGoodNode(root , Integer.MIN_VALUE);
        return goodNodes;
    }

    private static void lookForGoodNode(TreeNode root , int max) {
        if(root==null)
            return;
        if(root.val>=max){
            max=root.val;
            goodNodes++;
        }
        lookForGoodNode(root.left , max);
        lookForGoodNode(root.right , max );
    }

    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root==null)
            return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int levelSize = queue.size();
            TreeNode tree = null;
            for(int i=0;i<levelSize;i++){
                tree = queue.poll();
                if(tree.left!=null) {
                    queue.offer(tree.left);
                }
                if(tree.right!=null) {
                    queue.offer(tree.right);
                }
            }
            result.add(tree.val);
        }
        return result;
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root==null)
            return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            List<Integer> level = new ArrayList<>();
            int levelSize = queue.size();
            for(int i=0;i<levelSize;i++){
                TreeNode tree = queue.poll();
                level.add(tree.val);
                if(tree.left!=null) {
                    queue.offer(tree.left);
                }
                if(tree.right!=null) {
                    queue.offer(tree.right);
                }
            }
            result.add(level);
        }
        return result;
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null || root==p || root==q)
            return root;
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right  = lowestCommonAncestor(root.right,p,q);
        if(left!=null && right!=null)
            return root;
        return left!=null?left:right;
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
    static int max;
    public static int diameterOfBinaryTree(TreeNode root) {
        max = 0;
        if(root==null)
            return 0;
        heightOfTree(root);
        return max;
    }

    public static int heightOfTree(TreeNode root){
        if(root==null)
            return 0;
        int left = heightOfTree(root.left);
        int right = heightOfTree(root.right);
        max = Math.max(max , left+right);
        return Math.max(left , right)+1;
    }

    public static boolean isBalanced(TreeNode root) {
        return heightOfTreeBalanced(root)==-1?false:true;
    }
    public static int heightOfTreeBalanced(TreeNode root){
        if(root==null)
            return 0;
        int left = heightOfTreeBalanced(root.left);
        if(left==-1){
            return -1;
        }
        int right = heightOfTreeBalanced(root.right);
        if (right==-1){
            return -1;
        }
        if(Math.abs(left-right)>1){
            return -1;
        }
        return Math.max(left , right)+1;
    }



    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if((p!=null) && (q==null))
            return false;
        if((q!=null) && (p==null))
            return false;
        if(p==null && q==null)
            return true;
        if(p.val!=q.val)
            return false;
        boolean leftCheck= isSameTree(p.left,q.left);
        if(leftCheck==false)
            return false;
        boolean rightCheck = isSameTree(p.right,q.right);
        if(rightCheck==false)
            return false;
        return true;
    }

    public static boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(isSameTree(root,subRoot))
            return true;
        if(root!=null) {
            boolean leftCheck = isSubtree(root.left, subRoot);
            if (leftCheck == true)
                return leftCheck;
            boolean rightCheck = isSubtree(root.right, subRoot);
            if (rightCheck == true)
                return rightCheck;
        }
        return false;
    }
}
