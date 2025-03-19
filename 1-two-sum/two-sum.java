class Solution {
    public int[] twoSum(int[] nums, int target) {
        // create map to validate complement of tagrget
        Map<Integer, Integer> map = new HashMap<>(); // store the indes

        // iterate on nums arry
        for(int i=0; i<nums.length; i++){
            int complement = target - nums[i]; // find next value
            if(map.containsKey(complement)){
                return new int[] {map.get(complement), i};
            }

            map.put(nums[i], i);
        }

        // if not find then return {-1, -1}
        return new int[] {-1, -1};
    }
}