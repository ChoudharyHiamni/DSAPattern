package PrefixSum;

public class rangeSumQuery{
     public static int rangeSum(int nums[],int left,int right){
        int n=nums.length;
        int[] prefixSum=new int[n+1];
        // prefixSum[0]=0;
        for(int i=0;i<n;i++){
            prefixSum[i+1]=prefixSum[i]+nums[i];

        }
        return prefixSum[right+1]-prefixSum[left];
     }

    public static void main(String args[]){
        int[] nums = {1, 2, 3, 4, 5};
        int left = 1;
        int right = 3;
        System.out.println("Sum of elements from index " + left + " to " + right + ": " + rangeSum(nums, left, right)); // Output: 9
    }
}

// Time Complexity: O(n) for the prefix sum array creation, and O(1) for each range sum query.