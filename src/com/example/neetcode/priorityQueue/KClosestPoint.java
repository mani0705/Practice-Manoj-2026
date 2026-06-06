package com.example.neetcode.priorityQueue;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class KClosestPoint {

    public static void main(String[] args) {
            int[][] points = {{1,3},{-2,2}};
            int k = 1;
            KClosestPoint kClosestPoint = new KClosestPoint();
            int[][] result = kClosestPoint.kClosest(points, k);
            for(int i=0;i<result.length;i++) {
                System.out.println("the closest point is " + result[i][0] + "," + result[i][1]);
            }
    }

    public int[][] kClosest(int[][] points, int k) {
        Map myMap = calculateDistance(points);
        Queue<int[]> myQueue = new PriorityQueue<>();
        for(int i=0;i< points.length;i++){
            if(myQueue.size()>=k){
                double currentValue = (double) myMap.get(myQueue.peek());
                double valeFromMap = (double) myMap.get(points[i]);
                if(currentValue>valeFromMap){
                    myQueue.poll();
                    myQueue.offer(points[i]);
                }
            }else {
                myQueue.offer(points[i]);
            }
        }
        int x=0;
        int[][] result = new int[myQueue.size()][];
        while(x<myQueue.size()){
            result[x] = myQueue.poll();
            x++;
        }
        return result;
    }

    private int calculateDistance(int[][] points) {
        double distance;
        Map<int[], Double> myMap = new HashMap<>();
        for(int i=0;i<points.length;i++){
            distance = Math.sqrt(Math.pow(points[i][0],2)+Math.pow(points[i][1],2));
            myMap.put(points[i],distance);
        }
        return myMap;
    }
}
