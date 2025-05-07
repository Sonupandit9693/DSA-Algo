class Solution {
    public int rob(int[] nums) {
        int maxProduct = Math.max(
            helper(Arrays.copyOfRange(nums, 1, nums.length)),
            helper(Arrays.copyOfRange(nums, 0, nums.length -1))
        );

        return Math.max(nums[0], maxProduct);
    }

    private int helper(int[] nums){
        int rob1=0, rob2=0;

        for(int num: nums){
            int maxRob = Math.max(num + rob1, rob2);
            rob1 = rob2;
            rob2 = maxRob;
        }

        return rob2;
    }
}