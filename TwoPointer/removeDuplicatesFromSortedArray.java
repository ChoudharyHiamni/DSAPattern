package TwoPointer;

public class removeDuplicatesFromSortedArray {
    public static int removeDuplicates(int nums[]){
        int i=0;
        for(int j=0;j<nums.length;j++){
            if(nums[i]!=nums[j]){
                i++;
                nums[i]=nums[j];

        }
        }
          return i+1;
    }
    

    public static void main(String args[]){
        int[] nums={1,2,3,4,4,5,5,6};     
        int uniqueLength=removeDuplicates(nums);
        for(int i=0;i<uniqueLength;i++){
            System.out.print(nums[i]+" ");
        }
        System.out.println("Length is:"+ uniqueLength);
       
}
}
// Time Complexity: O(n)