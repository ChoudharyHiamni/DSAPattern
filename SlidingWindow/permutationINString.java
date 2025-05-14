package SlidingWindow;
import java.util.*;
public class permutationINString {
    public static boolean checkInclusion(String s1,String s2){
        if (s1.length() > s2.length()) return false;
        int freq1[]=new int[26];
        int freq2[]=new int[26];
        for(int i=0;i<s1.length();i++){
            freq1[s1.charAt(i)-'a']++;
            freq2[s2.charAt(i)-'a']++;

        }
        if(Arrays.equals(freq1,freq2)){
            return true;
        }
        
        for(int i=s1.length();i<s2.length();i++){
            freq2[s2.charAt(i)-'a']++;  //add character coming into the window
            freq2[s2.charAt(i-s1.length())-'a']--;  //remove character going out of the window
            if(Arrays.equals(freq1,freq2)){
                return true;
            }
        }
        return false;
    }

    
    public static void main(String args[]){
        String s1="ab";
        String s2="eidbaooo";
        System.out.println("Is s1 a permutation of s2? " + checkInclusion(s1, s2)); // Output: true (s1 is a permutation of s2)
    }
}


// Time Complexity: O(n) where n is the length of s2. The for loop runs n times, and the Arrays.equals method takes O(1) time since the frequency arrays have a fixed size of 26 (for lowercase English letters). Thus, the overall time complexity is O(n).