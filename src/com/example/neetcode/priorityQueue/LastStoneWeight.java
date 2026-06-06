package com.example.neetcode.priorityQueue;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class LastStoneWeight {

    public static void main(String[] args) {
        int[] stones = {2,7,4,1,8,1};
        LastStoneWeight lastStoneWeight = new LastStoneWeight();
        System.out.println("the last stone weight is " + lastStoneWeight.lastStoneWeight(stones));
    }


    Queue<Integer> myQueue;
    public int lastStoneWeight(int[] stones) {
        myQueue = new PriorityQueue<>(Comparator.reverseOrder());
        for(int i=0;i<stones.length;i++) {
            myQueue.offer(stones[i]);
        }
        while(myQueue.size()>=2){
                int a = myQueue.poll();
                int b = myQueue.poll();
                if(a!=b){
                    myQueue.offer(a-b);
                }
            }
        return myQueue.isEmpty() ? 0 : myQueue.peek();    }
}
