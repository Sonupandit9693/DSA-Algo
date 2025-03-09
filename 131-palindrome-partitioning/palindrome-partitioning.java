class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), s, 0);
        return result;
    }

    private void backtrack(List<List<String>> result, List<String> current, String s, int start){
        // base case if our start reach to end of the string then we add our partitioning
        if(start == s.length()){
            result.add(new ArrayList<>(current));
            return;
        }

        // iterate over the loop and check if palindrome through recurion
        for(int end=start; end < s.length(); end ++){
            if(isPalindrome(s, start, end)){
                current.add(s.substring(start, end + 1));

                // call for next index to check paildrome
                backtrack(result, current, s, end + 1);

                // after backtracking we clear current list for store next iteration to partition
                current.remove(current.size() - 1);
            }
        }
    }

    boolean isPalindrome(String s, int start, int end){
        while(start < end){
            if(s.charAt(start ++) != s.charAt(end --)){
                return false;
            }
        }

        return true;
    }
}