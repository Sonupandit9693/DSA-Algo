class Solution {
    public int maxProduct(int[] nums) {
        int maxProduct = Integer.MIN_VALUE;

        for(int start=0; start<nums.length; start++){
            int product = 1;
            for(int end=start; end<nums.length; end++){
                product *= nums[end];

                if(product > maxProduct){
                    maxProduct = product;
                }
            }
        }

        return maxProduct;
    }
}