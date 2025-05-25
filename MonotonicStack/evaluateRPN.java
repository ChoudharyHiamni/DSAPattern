// Leetcode 150. Evaluate Reverse Polish Notation
package MonotonicStack;
import java.util.*;
public class evaluateRPN {
    public static int evaluateRPNS(String tokens[]){
        Stack<Integer> stack = new Stack<>();
        for(String token : tokens){
            if(isOperator(token)){
                int b = stack.pop();
                int a = stack.pop();
                int result = applyOperator(a, b, token);
                stack.push(result);
            } else {
                stack.push(Integer.parseInt(token)); // Fixed: use 'stack', not 'Stack'
            }
        }
        return stack.pop();
    }

    // Make isOperator static
    public static boolean isOperator(String token){
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }

    // Make applyOperator static
    public static int applyOperator(int a, int b, String op){
        switch (op) {
            case "+": return a + b;
            case "-": return a - b;
            case "*": return a * b;
            case "/": return a / b; // integer division
            default: throw new IllegalArgumentException("Invalid operator");
        }
    }
    
    public static void main(String args[]){
        String tokens[] = {"2", "1", "+", "3", "*"};
        System.out.println(evaluateRPNS(tokens));
    }
}

// time complexity: O(n)