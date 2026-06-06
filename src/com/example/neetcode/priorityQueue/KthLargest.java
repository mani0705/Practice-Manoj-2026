package com.example.neetcode.priorityQueue;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */

public class KthLargest {

    public static void main(String[] args) {
            int k = 3;
            int[] nums = {4,5,8,2};
            KthLargest kthLargest = new KthLargest(k, nums);
            System.out.println(kthLargest.add(3));
            System.out.println(kthLargest.add(5));
            System.out.println(kthLargest.add(10));
            System.out.println(kthLargest.add(9));
            System.out.println(kthLargest.add(4));
    }

    Queue<Integer> myQueue = null;
    int k;
    public KthLargest(int k, int[] nums) {
        this.k=k;
        myQueue = new PriorityQueue<>();
        for(int i=0;i< nums.length;i++){
            validateAndOffer(k, nums[i]);
        }
    }

    private void validateAndOffer(int k, int nums) {
        if (myQueue.size() < k) {
            myQueue.offer(nums);
        } else {
            if (nums > myQueue.peek()) {
                myQueue.poll();
                myQueue.offer(nums);
            }
        }
    }

    public int add(int val) {
        validateAndOffer(k, val);
        return myQueue.peek();
    }
}
