class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates, result, new ArrayList<>(), target, 0);
        return result;
    }

    private void backtrack(int[] nums, List<List<Integer>> result, List<Integer> current, int target, int index){
        if(target == 0){
            result.add(new ArrayList(current));
            return;
        }

        for(int i=index; i<nums.length; i++){
            if( i > index  && nums[i] == nums[i-1]){
                continue;
            }
            if(nums[i] > target){
                break;
            }

            current.add(nums[i]);
            backtrack(nums, result, current, target - nums[i], i+1);
            current.remove(current.size() - 1);
        }
    }
}