package MonotonicStack;
import java.util.*;
public class dailyTemperature {
    public static int[] dailyTemperatures(int temperature[]){
        int n=temperature.length;
        int answer[]=new int[n];
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && temperature[i]>temperature[stack.peek()]){
                int prevIndex = stack.pop();
                answer[prevIndex] = i - prevIndex;
            }
            stack.push(i);
        }
        return answer;

    }
    public static void main(String args[]){
        int temperature[]={73,74,75,71,69,72,76,73};
        int answer[]=dailyTemperatures(temperature);
        System.out.println(Arrays.toString(answer));
    }
}

//time complexity: O(n)