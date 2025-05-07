class Solution {
    public int maxProduct(int[] nums) {
        // int maxProduct = Integer.MIN_VALUE;

        // for(int start=0; start<nums.length; start++){
        //     int product = 1;
        //     for(int end=start; end<nums.length; end++){
        //         product *= nums[end];

        //         if(product > maxProduct){
        //             maxProduct = product;
        //         }
        //     }
        // }

        // return maxProduct;


        if(nums == null || nums.length == 0){
            return 0;
        }


        int currMax = nums[0];
        int currMin = nums[0];
        int max_product = nums[0];

        // iterate from 1 index
        for(int i=1; i<nums.length; i++){
            int temp = currMax;
            currMax = Math.max(nums[i], Math.max(currMax * nums[i], currMin * nums[i]));

            currMin = Math.min(nums[i], Math.min(temp * nums[i], currMin * nums[i]));

            // upadte product
            max_product = Math.max(currMax, max_product);
        }

        return max_product;

    }
}