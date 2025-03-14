class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);  // Sort the array to use two-pointer technique
        int closestSum = nums[0] + nums[1] + nums[2]; // Initialize closest sum

        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1, right = nums.length - 1;

            while (left < right) {
                int currentSum = nums[i] + nums[left] + nums[right];

                // Update closestSum if currentSum is closer to target
                if (Math.abs(target - currentSum) < Math.abs(target - closestSum)) {
                    closestSum = currentSum;
                }

                if (currentSum < target) {
                    left++;  // Move left pointer right to increase sum
                } else if (currentSum > target) {
                    right--; // Move right pointer left to decrease sum
                } else {
                    return currentSum;  // Exact match found, return immediately
                }
            }
        }

        return closestSum;
    }
}