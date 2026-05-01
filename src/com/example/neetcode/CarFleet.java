package com.example.neetcode;

import java.util.*;

public class CarFleet {

    public static void main(String[] args) {
        int target = 12;
        int[] position = {10,8,0,5,3};
        int[] speed = {2,4,1,1,3};
        // expected output 3

        //int target = 10;
        //int position[] = {6,8};
        //int speed[] = {3,2};
        // expected output 2

        //int target = 100;
        //int position[] = {0,2,4};
        //int speed[] = {4,2,1};

        // expected output 1

        //int target = 10;
        //int[] position = {0,4,2};
        //int[] speed = {2,1,3};
        // expected output 1

        //int target = 10;
        //int[] position = {8,3,7,4,6,5};
        //int[] speed = {4,4,4,4,4,4};
        //expected output 1
        System.out.println("Number of car fleets: " + carFleet2dArray(target, position, speed));
    }

    public static  int carFleet2dArray(int target , int[] position , int[] speed){
        if(position.length==1)
            return 1;

        double[][] time = new double[position.length][2];

        for(int i=0;i< position.length;i++){
            time[i][0] = position[i];
        }
        for(int i =0;i< position.length;i++){
            time[i][1] = (target - position[i]) / speed[i];
        }

        int[] sortedPosition = Arrays.stream(position)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .mapToInt(Integer::intValue)
                .toArray();

        for(int i=0;i< position.length;i++)
        {
            
        }


        System.out.println(Arrays.toString(time));
        return 0;

    }


    public static  int carFleet(int target , int[] position , int[] speed){

        if(position.length==1)
            return 1;
        double[] time = new double[position.length];


        HashMap<Integer,Double> mapRes = new HashMap<>();

        for(int i =0;i<position.length;i++){
            time[i] = (double)(target - position[i]) / speed[i];
            mapRes.put(position[i], time[i]);
        }

        int[] sortedPosition = Arrays.stream(position)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .mapToInt(Integer::intValue)
                .toArray();

        List<Integer> fleetList = new ArrayList<>();
        int fleet = 0;
        for(int i=0;i<sortedPosition.length-1;i++){
            if(mapRes.get(sortedPosition[i+1])<= mapRes.get(sortedPosition[i])){
                mapRes.put(sortedPosition[i+1],mapRes.get(sortedPosition[i]));
                fleet++;
            }else{
                fleetList.add(fleet);
                fleet = 0;
            }
        }
        if(mapRes.get(sortedPosition[sortedPosition.length-1])<=
                mapRes.get(sortedPosition[sortedPosition.length-2])) {
            fleet++;
        }
        fleetList.add(fleet);

        return fleetList.size();
    }
}


