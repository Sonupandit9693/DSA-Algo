class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int num1Pointer = m -1;
        int num2Pointer = n -1;
        int storePointer = m + n - 1;

        // iterate from both array from back
        while(num1Pointer >= 0 && num2Pointer>=0){
            if(nums1[num1Pointer]  >= nums2[num2Pointer]){
                nums1[storePointer] = nums1[num1Pointer];
                storePointer --;
                num1Pointer --;
            }else{
                nums1[storePointer] = nums2[num2Pointer];
                storePointer --;
                num2Pointer --;
            }
        }

        // remaing element from nums2 store in nums1
        while(num2Pointer >= 0){
            nums1[storePointer] = nums2[num2Pointer];
            storePointer --;
            num2Pointer --;
        }
    }
}