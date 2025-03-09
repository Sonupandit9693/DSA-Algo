class Solution {
    // mapping digits to letter
    private String[] digitToLetter = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<>();
        // check if case digit is safe or not
        if(digits == null || digits.length() == 0){
            return combinations;
        }

        backtrack(combinations, digits, "", 0);
        return combinations;
    }

    private void backtrack(List<String> combinations, String digits, String currentCombo, int index){
        // base case
        if(index == digits.length()){
            combinations.add(currentCombo);
            return;
        }

        String letters = digitToLetter[digits.charAt(index) - '0'];
        
        for(char letter : letters.toCharArray()){
            backtrack(combinations, digits, currentCombo + letter, index + 1);
        }
    }
}