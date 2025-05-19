class Solution {
    public String triangleType(int[] nums) {
        // Check if the sides can form a valid triangle
        if (nums[0] + nums[1] <= nums[2] || 
            nums[0] + nums[2] <= nums[1] || 
            nums[1] + nums[2] <= nums[0]) {
            return "none";
        }
        
        // Check the type of triangle
        if (nums[0] == nums[1] && nums[1] == nums[2]) {
            return "equilateral";
        } else if (nums[0] == nums[1] || nums[1] == nums[2] || nums[0] == nums[2]) {
            return "isosceles";
        } else {
            return "scalene";
        }
    }
}