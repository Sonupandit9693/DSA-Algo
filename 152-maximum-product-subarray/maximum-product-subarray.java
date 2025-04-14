class Solution {
    public int maxProduct(int[] nums) {
        if(nums.length == 0){
            return 0;

        }

        int minSum = nums[0];
        int maxSum = nums[0];
        int max = maxSum;

        for(int i=1; i<nums.length; i++){
            int currValue = nums[i];

            int temp = Math.max(currValue, Math.max(currValue * maxSum, currValue * minSum));
            minSum = Math.min(currValue, Math.min(currValue * minSum, currValue * maxSum));
            maxSum = temp;

            max = Math.max(max, maxSum);
        }

        return max;
    }
}