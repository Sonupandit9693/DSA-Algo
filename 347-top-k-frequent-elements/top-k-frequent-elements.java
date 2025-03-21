import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Step 1: Count frequency of each number
        HashMap<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Create an array of lists (buckets)
        List<Integer>[] bucket = new List[nums.length + 1]; // Max frequency can be nums.length
        for (int i = 0; i <= nums.length; i++) {
            bucket[i] = new ArrayList<>();
        }

        // Step 3: Fill the bucket
        for (int num : countMap.keySet()) {
            int frequency = countMap.get(num);
            bucket[frequency].add(num);
        }

        // Step 4: Extract the k most frequent elements
        List<Integer> result = new ArrayList<>();
        for (int i = nums.length; i >= 0 && result.size() < k; i--) {
            result.addAll(bucket[i]); // Add numbers from higher frequency bucket first
        }

        // Convert list to array
        return result.stream().mapToInt(i -> i).toArray();
    }
}
