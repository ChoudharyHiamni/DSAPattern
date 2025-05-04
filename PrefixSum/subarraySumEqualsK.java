package PrefixSum;
import java.util.*;

public class subarraySumEqualsK {
    public static int subarraySum(int[] nums, int k) {
        // Map to store prefixSum and their counts
        HashMap<Integer, Integer> prefixSumCount = new HashMap<>();
        prefixSumCount.put(0, 1); // Important: to handle case where subarray starts from index 0
        
        int count = 0;
        int prefixSum = 0;

        for (int num : nums) {
            prefixSum += num;

            // Check if there is a prefix sum that would lead to a subarray sum of k
            if (prefixSumCount.containsKey(prefixSum - k)) {
                count += prefixSumCount.get(prefixSum - k);
            }

            // Add/update current prefixSum in map
            prefixSumCount.put(prefixSum, prefixSumCount.getOrDefault(prefixSum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3};
        int k = 3;
        System.out.println("Total subarrays with sum " + k + ": " + subarraySum(nums, k)); // Output: 2
    }
}
