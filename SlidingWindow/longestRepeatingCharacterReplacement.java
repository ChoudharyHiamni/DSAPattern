package SlidingWindow;

public class longestRepeatingCharacterReplacement {
    public static int characterReplacement(String s,int k){
        int freq[]=new int[26];
        int maxLength=0;
        int maxFreq=0;
        int left=0;
        for(int right=0;right<s.length();right++){
            freq[s.charAt(right) - 'A']++;
            maxFreq = Math.max(maxFreq, freq[s.charAt(right) - 'A']);

            while ((right - left + 1) - maxFreq > k) {
                freq[s.charAt(left) - 'A']--;
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;

        }

    
    
    public static void main(String args[]){
        String s="AABABBA";
        int k=1;
        System.out.println("Length of longest substring with at most k replacements: " + characterReplacement(s, k)); // Output: 4 (AABA or ABBA)
    }
}

// Time Complexity: O(n) where n is the length of the string s. The while loop runs at most n times, and the for loop runs n times as well. Thus, the overall time complexity is O(n).
// Space Complexity: O(1) since the frequency array has a fixed size of 26 (for uppercase English letters).