package com.example.neetcode;

/*
You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).

Find two lines that together with the x-axis form a container, such that the container contains the most water.

Return the maximum amount of water a container can store.

Notice that you may not slant the container.

Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49
Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
Example 2:

Input: height = [1,1]
Output: 1


Constraints:

n == height.length
2 <= n <= 105
0 <= height[i] <= 104

*/

import java.util.Random;

public class ContainerWithMostWater {
    public static void main(String[] args) {

        //int[] height = {1,8,6,2,5,4,8,3,7};
        //int[] height = {1,1};
        int[] height = {0,1};
        //System.out.println("the brute force solution is " +bruteforcesolution(height));
        System.out.println("the optimal solution is " +optimalSolution(height));

    }

    private static String optimalSolution(int[] height) {

        int maxArea = -1;
        int left = 0;
        int right = height.length-1;

        while(left<right){
            if(height[right]>height[left]){
                maxArea = Math.max(maxArea, (right-left)* height[left]);
                left++;
            }
            else{
                maxArea = Math.max(maxArea, (right-left)* height[right]);
                right--;
            }
        }
        return  maxArea+"";
    }

    /*
    The time complexity of `bruteforcesolution` is **O(n²)** because it uses two nested
    loops to check all possible pairs of lines.

    The space complexity is **O(1)** since it only uses a constant amount of extra space
    for variables, regardless of input size.

    */
    private static String bruteforcesolution(int[] height) {

        int maxArea = -1;
        int tall = -1;
        for(int i=0;i<height.length;i++){
            for(int j=i+1;j<height.length;j++){
                tall = Math.min(height[i],height[j]);
                maxArea = Math.max(maxArea , (j - i) * tall);
                if(height[j]>height[i])
                    break;
            }
        }

        return maxArea+"";
    }


}
