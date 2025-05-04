package MonotonicStack;
import java.util.*;
public class findNextGreaterElement {
    public static int[] nextGreaterElements(int nums[]){
        int n=nums.length;
        int result[]=new int[n];
        Stack<Integer>stack=new Stack<>();
        Arrays.fill(result,-1);

        for (int i = 0; i < n; i++) {
            // Resolve next greater for previous smaller elements
            while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                int index = stack.pop();
                result[index] = nums[i];
            }
            stack.push(i); // Store index, not value
        }

        return result;
    }

    public static void main(String args[]){
        int[] arr = {4, 5, 2, 10, 8};
        int[] nge = nextGreaterElements(arr);
        System.out.println("Next Greater Elements: " + Arrays.toString(nge));
    }
}
// Time Complexity: O(n) for the entire process, as each element is pushed and popped from the stack at most once.
