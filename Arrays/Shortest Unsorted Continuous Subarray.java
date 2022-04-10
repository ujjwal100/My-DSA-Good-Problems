// Problem (Uber OA) : https://leetcode.com/problems/shortest-unsorted-continuous-subarray/
//
// Link : https://leetcode.com/problems/shortest-unsorted-continuous-subarray/
//
// Problem Statement : Given an integer array nums, you need to find one continuous subarray that 
// if you only sort this subarray in ascending order, then the whole array will be sorted in ascending order.
//
// O(N) TC + O(1) SC

Return the shortest such subarray and output its length.
class Solution {
    public int findUnsortedSubarray(int[] arr) {
        int l=0, r=0, n = arr.length;
        for (int i=1; i < n; i++) {
            if (arr[i] < arr[i-1]) {
                l = i;
                break;
            }
        }
        if (l > 0) {
            int min = arr[l];
        for (int i=l+1;i<n;i++)
            min = Math.min(min, arr[i]);
        
        int left = upperBound(arr, l, min);
            
            
            for (int i = n-2; i >=0;i--) {
                if (arr[i] > arr[i+1]) {
                    r=i;
                    break;
                }
            }
            
            int max = arr[r];
            for (int i=r;i >=0;i--){
                max = Math.max(max, arr[i]);
            }
            
            int right = lowerBound(arr, r+1, max);
            
          
            return right - left + 1;
        }
        
        
        return 0;        
        
    }
    
    int upperBound(int[] arr, int n, int min) {
        for (int i=0; i < n; i++)
            if (arr[i] > min)
                return i;
        return -1;
    }
    
    int lowerBound(int[] arr, int start, int max) {
        for (int i = arr.length - 1; i >= start; i--) {
            if (arr[i] < max)
                return i;
        }
        
        return -1;
    }
}
