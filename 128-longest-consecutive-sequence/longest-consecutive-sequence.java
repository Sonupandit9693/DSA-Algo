class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;

        HashSet<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int longestSubSequence = 0;

        for (int num : numSet) {
            // Check if `num` is the start of a sequence
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int count = 1;

                while (numSet.contains(currentNum + 1)) {
                    currentNum++;
                    count++;
                }

                longestSubSequence = Math.max(longestSubSequence, count);
            }
        }

        return longestSubSequence;
    }
}

