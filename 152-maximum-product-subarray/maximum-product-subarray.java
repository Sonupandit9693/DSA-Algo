class Solution {
    public int maxProduct(int[] nums) {
        int maxProduct = nums[0]; // Store the max product found
        int currMax = nums[0]; // Max product at current index
        int currMin = nums[0]; // Min product at current index (for negative numbers)

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) {
                // Swap max and min when encountering a negative number
                int temp = currMax;
                currMax = currMin;
                currMin = temp;
            }

            // Compute current max and min product ending at index i
            currMax = Math.max(nums[i], nums[i] * currMax);
            currMin = Math.min(nums[i], nums[i] * currMin);

            // Update global max product
            maxProduct = Math.max(maxProduct, currMax);
        }

        return maxProduct;
    }
}
