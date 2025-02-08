class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0){
            return 0;
        }

        Arrays.sort(nums);
        for(int i=0; i<nums.length; i++){
            System.out.print(nums[i] + " ");
        }
        int lastSmaller = Integer.MIN_VALUE;
        int count = 0;
        int longest = 1;

        for(int i=0; i<nums.length; i++){
            if(nums[i] - 1 == lastSmaller){
                count++;
                lastSmaller = nums[i];
            }else if(nums[i] != lastSmaller){
                count = 1;
                lastSmaller = nums[i];
            }

            longest = Math.max(longest, count);
        }

        return longest;
    }
}