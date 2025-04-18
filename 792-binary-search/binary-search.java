class Solution {
    public int search(int[] nums, int target) {
        int N = nums.length;
        int left=0;
        int right = N -1;

        while(left <= right){
            int mid = left + (right - left) / 2;

            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] < target){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }

        return -1;
    }
}