class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();

        genrateParentheses(result, "", 0, 0, n);
        return result;
    }

    public void genrateParentheses(List<String> result, String currentString, int open, int close, int max){

        // check if string completed
        if(currentString.length() == max * 2){
            result.add(currentString);
            return;
        }

        // add then open parentheses
        if(open < max){
            genrateParentheses(result, currentString + "(" , open + 1, close, max);
        }

        // add close parentheses
        if(close < open){
            genrateParentheses(result, currentString + ")", open, close + 1, max);
        }
    }
}