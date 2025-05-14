package SlidingWindow;

public class minimumWindowSubstring {
    public static String minWindow(String s,String t){
        if(s.length()<t.length()){
            return "";
        }
        int tfreq[]=new int[128];
        for(char c:t.toCharArray()){
            tfreq[c]++;
        }
        int left=0;
        int right=0;
        int minLen=Integer.MAX_VALUE;
        int minStart=0;
        int required=t.length();

        while(right<s.length()){
            char rChar=s.charAt(right);
            if(tfreq[rChar]>0){
                required--;
            }
            tfreq[rChar]--;
            right++;
            while(required==0){
                if(right-left<minLen){
                    minLen=right-left;
                    minStart=left;
                }
                char lChar=s.charAt(left);
                tfreq[lChar]++;
                if(tfreq[lChar]>0){
                    required++;
                }
                left++;
            }
        }
        return minLen==Integer.MAX_VALUE ? "" : s.substring(minStart, minStart+minLen);
    }
    public static void main(String args[]){
        String s="ADOBECODEBANC";
        String t="ABC";
        System.out.println("Minimum window substring: " + minWindow(s, t)); // Output: "BANC"
    }

}

// Time Complexity: O(n) where n is the length of s. The while loop iterates through the string s, and the inner while loop iterates through the substring of s. The overall time complexity is O(n).