package com.example.neetcode.linkedlists;

import java.util.Arrays;

public class FindTheDuplicateNumber {
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        int result = 0 ;
        int pos = 0;
        Arrays.sort(nums);
        for(int i=0;i<n;i++){
            if(i+1!=n){
                result = nums[i]^nums[i+1];
                if(result==0){
                    pos = i;
                    break;
                }
            }
        }
        return nums[pos];
    }

    public int findDuplicateOther(int[] nums) {
        int len = nums.length;
        for(int i=0;i<len;i++){
            int sign = Math.abs(nums[i]);
            if(nums[sign-1]<0){
                return sign;
            }else{
                nums[sign-1] = -nums[sign-1];
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,4,2,2};
        //int[] nums = {3,1,3,4,2};
        //int[] nums = {1,1};
        //int[] nums = {1,1,2};
        FindTheDuplicateNumber findTheDuplicateNumber = new FindTheDuplicateNumber();
        System.out.println("the duplicate number is " + findTheDuplicateNumber.findDuplicateOther(nums));
    }
}
