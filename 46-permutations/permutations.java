class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean used[] = new boolean[nums.length];
        backtrac(result, new ArrayList<>(), nums, used);
        return result;
    }

    private void backtrac(List<List<Integer>> result, List<Integer> current, int[] nums, boolean [] used){
        // base case
        if(current.size() == nums.length){
            result.add(new ArrayList<>(current));
            return;
        }

        // iterate on list of nums genrate all posible permutation
        for(int i=0; i< nums.length; i++){
            if(! used[i]){
                current.add(nums[i]);
                used[i] = true;
                backtrac(result, current, nums, used);
                used[i] = false;
                current.remove(current.size() - 1);
            }
        }
    }
}