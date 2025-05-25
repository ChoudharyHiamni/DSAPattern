package MonotonicStack;
import java.util.*;
public class largestRectnagleInHistogram {
    public static int LargestRectangleArea(int[] heights){
        Stack<Integer> stack=new Stack<>();
        int maxArea=0;
        int n=heights.length;
        for(int i=0;i<=n;i++){
            int currHeight=(i==n)?0:heights[i];
            while(!stack.isEmpty() && currHeight<heights[stack.peek()]){
                int height=heights[stack.pop()];
                int width=stack.isEmpty()?i:i-stack.peek()-1;
                int area=height*width;
                maxArea=Math.max(maxArea,area);
            }
            stack.push(i);
        }
        return maxArea;
    }

    
    public static void main(String args[]){
        int[] heights={2,1,5,6,2,3};
        System.out.println(LargestRectangleArea(heights));
    }
}

// Time Complexity: O(n) for the entire process, as each element is pushed and popped from the stack at most once.
// Space Complexity: O(n) for the stack in the worst case, where all elements are in increasing order.