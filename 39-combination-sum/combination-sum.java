class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> combination = new ArrayList<>();
        backTrack(target, combination, 0, candidates, res);
        return res;
    }

    private void backTrack(int target, List<Integer> combination, int index, int[] candidates, List<List<Integer>> res){
        // base case
        if(target == 0){
            res.add(new ArrayList<>(combination));
        }
        else if(target < 0){
            return;
        }

        for (int i = index; i < candidates.length; i++){
            combination.add(candidates[i]);
            backTrack(target - candidates[i], combination, i, candidates, res);

            // backtracking
            combination.remove(combination.size() - 1);
        }
    }
}