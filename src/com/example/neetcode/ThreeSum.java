package com.example.neetcode;

import java.util.*;

/*
Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.

Example 1:

Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Explanation:
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
The distinct triplets are [-1,0,1] and [-1,-1,2].
Notice that the order of the output and the order of the triplets does not matter.
Example 2:

Input: nums = [0,1,1]
Output: []
Explanation: The only possible triplet does not sum up to 0.
Example 3:

Input: nums = [0,0,0]
Output: [[0,0,0]]
Explanation: The only possible triplet sums up to 0.


Constraints:

        3 <= nums.length <= 3000
        -105 <= nums[i] <= 105


*/
public  class ThreeSum{

    public static void main(String[] args) {
        //int[] nums = {-1, 0, 1, 2, -1, -4};
        //int[] nums = {0,0,0 ,0};
        //int[] nums = {-2,0,1,1,2};
        int[] nums = {2,-3,0,-2,-5,-5,-4,1,2,-2,2,0,2,-4,5,5,-10};
        //List<List<Integer>> result = optimalSolution(nums);
        List<List<Integer>> result = usingTwoPointers(nums);
        System.out.println(result);
        /*int[] nums = {3,1,8,10,6,5};
        int target = 11;
        int[] result = twoSum(nums , target);
        System.out.println(Arrays.toString(result));*/
    }

    // int[] nums = {1,0,-1,}
    //int[] nums = {-1, 0, 1, 2, -1, -4};  [[-1,-1,2],[-1,0,1]]
    public static List<List<Integer>> optimalSolution(int[] nums) {

        Set<List<Integer>> result = new HashSet<>();
        // [2,-3,0,-2,-5,-5,-4,1,2,-2,2,0,2,-4,5,5,-10]
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        for(int i=0;i< nums.length;i++){
            if(i>0 && nums[i]==nums[i-1])
                continue;
            twoSumForThreeSum(nums, i, result);
        }
        return new ArrayList<>(result);
    }

    private static void twoSumForThreeSum(int[] nums , int i , Set<List<Integer>> result) {
        Set<Integer> mySet = new HashSet<>();
        for(int k=i+1;k<nums.length;k++){
            /*if(k>0 && nums[k]==nums[k-1])
                continue;*/
            int complement = -(nums[i]+nums[k]);
            if(mySet.contains(complement)){
                result.add(Arrays.asList(nums[i],nums[k],complement));
                mySet.remove(complement);
            }else{
                mySet.add(nums[k]);
            }
        }
    }

    //  -1

    private static List<List<Integer>> usingTwoPointers(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i< nums.length;i++){
            if(nums[i]>0)
                break;
            int left = i+1;
            int right = nums.length-1;
            if(i>0 && nums[i-1]==nums[i])
                continue;
            int target = -nums[i];
            while(left<right){
                if(left>i+1 && nums[left]==nums[left-1]) {
                    left++;
                    continue;
                }
                if(right<nums.length-1 && nums[right]==nums[right+1]) {
                    right--;
                    continue;
                }
                if(nums[left]+nums[right]>target){
                    right--;
                }else if(nums[left]+nums[right]<target){
                    left++;
                }else{
                    result.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    /*while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }*/
                    left++;
                    right--;
                }
            }
        }
        return result;
    }

    //{3,1,8,10,6,5}    tagetSum = 11
    public static int[] twoSum(int[] nums , int targetSum){
        HashMap<Integer,Integer> myMap = new HashMap<>();
        int index = -1;
        for(int i=0;i<nums.length;i++){
            int required = targetSum - nums[i]; // 8` = 11 - 3
            if(myMap.containsKey(nums[i])){
                index = myMap.get(nums[i]);
                return new int[]{index,i};
            }else {
                myMap.put(required , i);  //put 8
            }
        }
        return new int[]{};
    }
}
