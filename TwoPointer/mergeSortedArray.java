package TwoPointer;

public class mergeSortedArray {
    public static void merge(int nums1[],int m,int nums2[],int n){
        int p1=m-1;
        int p2=n-1;
        int p=m+n-1;
        while(p1>=0 && p2>=0){
            if(nums1[p1]>nums2[p2]){
                nums1[p--]=nums1[p1--];
            }else{
                nums1[p--]=nums2[p2--];
            }
        }
        while (p2 >= 0) {
            nums1[p--] = nums2[p2--];
        }
    }
    public static void main(String args[]){
        int nums1[]={1,2,3,0,0,0};
        int nums2[]={2,5,6};
        int m=3;
        int n=3;
        merge(nums1,m,nums2,n);
        for(int i=0;i<m+n;i++){
            System.out.print(nums1[i]+" ");
        }
    }
}

// Time Complexity: O(m+n) where m and n are the lengths of the two arrays.