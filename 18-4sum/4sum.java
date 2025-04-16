class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        if (n < 4) return ans;

        Arrays.sort(nums);

        for (int i = 0; i < n - 3; i++) {
            // Skip duplicates for i
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            // Early termination if the smallest possible sum is already > target
            if ((long)nums[i] + nums[i+1] + nums[i+2] + nums[i+3] > target) break;
            // Early continuation if the largest possible sum is still < target
            if ((long)nums[i] + nums[n-1] + nums[n-2] + nums[n-3] < target) continue;

            for (int j = i + 1; j < n - 2; j++) {
                // Skip duplicates for j
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                // Same early prunings for this j
                if ((long)nums[i] + nums[j] + nums[j+1] + nums[j+2] > target) break;
                if ((long)nums[i] + nums[j] + nums[n-1] + nums[n-2] < target) continue;

                int k = j + 1, l = n - 1;
                while (k < l) {
                    long sum = (long)nums[i] + nums[j] + nums[k] + nums[l];
                    if (sum == target) {
                        ans.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                        // move both pointers and skip duplicates
                        k++; l--;
                        while (k < l && nums[k] == nums[k - 1]) k++;
                        while (k < l && nums[l] == nums[l + 1]) l--;
                    } else if (sum < target) {
                        k++;
                    } else {
                        l--;  // ← this was the bug fix
                    }
                }
            }
        }
        return ans;
    }
}
