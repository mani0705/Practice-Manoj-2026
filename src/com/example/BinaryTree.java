package com.example;

import java.util.Scanner;

public class BinaryTree {


    private static Node root;

    public static Node create(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter data ");
        int data = sc.nextInt();
        if(data==-1)
            return null;
        root = new Node(data);

        System.out.println("Enter data for left of "+data);
        root.left = create();

        System.out.println("Enter data for right of "+data);
        root.right = create();

        return root;
    }

    public static void main(String[] args) {
        System.out.println(create().getData());
    }
}
