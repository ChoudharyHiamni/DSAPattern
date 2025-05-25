package PrefixSum;

public class findPivotIndex {
    public static int pivotIndex(int nums[]){
        int n=nums.length;
        int prefixSum[]=new int[n];
        prefixSum[0]=nums[0];
        for(int i=1;i<n;i++){
            prefixSum[i]=prefixSum[i-1]+nums[i];
        }
        for(int i=0;i<n;i++){
            int leftSum=(i==0)? 0: prefixSum[i-1];
            int rightSum=prefixSum[n-1]-prefixSum[i];
            if(leftSum==rightSum){
                return i;
            }
        }
        return -1;
    }
    public static void main(String args[]){
        int nums[]={1,7,3,6,5,6};
        System.out.println("Pivot Index: " + pivotIndex(nums)); // Output: 3
    }
}

//Time complexity:O(n)