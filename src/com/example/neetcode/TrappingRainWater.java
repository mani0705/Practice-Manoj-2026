package com.example.neetcode;


/*
*Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
Example 2:

Input: height = [4,2,0,3,2,5]
Output: 9

* */
public class TrappingRainWater {

    public static void main(String[] args) {
        //int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        //int[] height = {4,2,0,3,2,5};
        int[] height = {4,2,3};
        System.out.println("The amount of water trapped using brute force solution " +
                " is " + optimumSolution(height));
    }

    // optimum so
    // solution using left and right pointers
    private static String optimumSolution(int[] height){

        int totalWater = 0;
        int leftMax = 0;
        int rightMax = 0;
        int current = 0;

        int left = 0, right = height.length-1;

        while(left<right){
            if(leftMax<height[left]){
                leftMax = height[left];
            }
            if(rightMax<height[right]){
                rightMax = height[right];
            }
            if(leftMax<rightMax) {
                current = left;
                left++;
            }
            else{
                current = right;
                right--;
            }

            int minHeight = Math.min(leftMax , rightMax);

            if(height[current] < minHeight){
                totalWater=totalWater+minHeight-height[current];
            }

        }
        return totalWater+"";

    }

    // find left max
    // find right max
    // if the current height is less than the neigbours height , only then water will be stored
    private static String bruteForceSolution(int[] height) {

        int totalWater = 0;
        for(int i=0;i<height.length;i++){
            int leftMax = 0;
            int rightMax = 0;
            // find the left max
            for(int j = 0;j<=i;j++){
                leftMax = Math.max(leftMax , height[j]);
            }
            for(int k=i+1;k< height.length;k++){
                rightMax = Math.max(rightMax,height[k]);
            }

            int minHeight = Math.min(leftMax , rightMax);

            if(minHeight>height[i]){
                totalWater+= minHeight - height[i];
            }
        }

        return totalWater + "";
    }
}
