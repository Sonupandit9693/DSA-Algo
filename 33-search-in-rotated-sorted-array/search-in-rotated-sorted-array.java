class Solution {
    public int search(int[] nums, int target) {
        if(nums.length == 0){
            return -1;
        }

        int left = 0;
        int right = nums.length - 1;

        while(left <= right){
            int mid = left+ (right-left)/2;
            if(nums[mid] == target){
                return mid;
            }

            if(nums[left] <= nums[mid]){
                // left part is sorted
                if(nums[left] <= target && target < nums[mid]){
                    right = mid -1;
                }else{
                    left = mid +1;
                }
            }else{
                // check right part is sorted or not
                if(nums[mid] < target && target <= nums[right]){
                    left = mid+ 1;
                }else{
                    right = mid - 1;
                }
            }
        }

        return -1;
    }
}