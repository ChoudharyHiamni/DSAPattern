package TwoPointer;
import java.util.*;
public class pairWithTargetSum {
    public static boolean hasPairSum(int arr[],int target){
        Arrays.sort(arr);
        int left=0;
        int right=arr.length-1;
        while(left<right){
            int sum=arr[left]+arr[right];
            if(sum==target){
                return true;
            }else if(sum<target){
                left++;
            }else{
                right--;
            }

        }
        return false;
    }
    public static void main(String args[]){
        int[] arr = {4, 7, 1, -3, 2};
        int target = 5;
        System.out.println(hasPairSum(arr, target)); // Output: true
    }
}

// Time Complexity: O(nlogn) for sorting + O(n) for the two-pointer traversal = O(nlogn)
// Space Complexity: O(1) for the two-pointer approach