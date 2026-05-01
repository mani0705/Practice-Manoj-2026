package com.example.neetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*Given an integer array nums that may contain duplicates, return all possible subsets (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.



Example 1:

Input: nums = [1,2,2]
Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
Example 2:

Input: nums = [0]
Output: [[],[0]]*/


public class Subsets2 {


    public static void main(String[] args) {
        Subsets2 subsets2 = new Subsets2();
        //int[] nums = {1,2,2};  //Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
        //int[] nums = {0}; //Output: [[],[0]]
        //int[] nums = {4,4,4,1,4}; //Output: [[],[1],[1,4],[1,4,4],[1,4,4,4],[1,4,4,4,4],[4],[4,4],[4,4,4],[4,4,4,4]]
        //int[] nums = {1,2,2,2}; //Output: [[],[1],[1,2],[1,2,2],[1,2,2,2],[2],[2,2],[2,2,2]]
        int[] nums = {1,1,2,2}; //Output: [[],[1],[1,1],[1,1,2],[1,1,2,2],[1,2],[1,2,2],[2],[2,2]]
        System.out.println(subsets2.subsetsWithDup(nums));
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> subsets = new ArrayList<>();
        Arrays.sort(nums);
        generateSubsets2(nums,0,subsets,list);
        return subsets;
    }

    private void generateSubsets2(int[] nums, int i, List<List<Integer>> subsets , List<Integer> list){
        if(i<nums.length){
            list.add(nums[i]);
            generateSubsets2(nums,i+1,subsets,list);
            list.remove(list.size()-1);
            while(i+1< nums.length && nums[i+1]==nums[i]){
                    i++;
            }
            generateSubsets2(nums,i+1,subsets,list);
        }
        else{
            subsets.add(new ArrayList<>(list));
        }
    }
}
