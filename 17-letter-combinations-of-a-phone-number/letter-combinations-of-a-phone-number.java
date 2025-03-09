class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();

        if(digits == null || digits.length() == 0){
            return ans;
        }

        Map<Character, String> digitToLetters = new HashMap<>();
        digitToLetters.put('2', "abc");
        digitToLetters.put('3', "def");
        digitToLetters.put('4', "ghi");
        digitToLetters.put('5', "jkl");
        digitToLetters.put('6', "mno");
        digitToLetters.put('7', "pqrs");
        digitToLetters.put('8', "tuv");
        digitToLetters.put('9', "wxyz");

        solve(digits, 0, new StringBuilder(), ans, digitToLetters);
        return ans;
    }

    private void solve(String digits, int idx, StringBuilder comb, List<String> ans, Map<Character, String> digitToLetters){
        if (idx == digits.length()){
            ans.add(comb.toString());
            return;
        }

        String dialnumber = digitToLetters.get(digits.charAt(idx));
        for (char number : dialnumber.toCharArray()){
            comb.append(number);
            solve(digits, idx+1, comb, ans, digitToLetters);
            comb.deleteCharAt(comb.length() - 1);
        }
    }
}