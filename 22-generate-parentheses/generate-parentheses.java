class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generate(result, "", 0, 0, n);
        return result;
    }

    private void generate(List<String> result, String current, int open, int close, int max) {
        // If the current string length equals the maximum possible length
        if (current.length() == max * 2) {
            result.add(current);
            return;
        }
        
        // Add an opening parenthesis if it's allowed
        if (open < max) {
            generate(result, current + "(", open + 1, close, max);
        }
        
        // Add a closing parenthesis if it's valid
        if (close < open) {
            generate(result, current + ")", open, close + 1, max);
        }
    }
}