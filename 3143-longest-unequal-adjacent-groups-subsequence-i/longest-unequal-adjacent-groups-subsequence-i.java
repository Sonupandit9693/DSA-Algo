class Solution {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        if(words.length == 0){
            return new ArrayList<>();
        }

        List<String> result = new ArrayList<>();
        int last_group = groups[0];
        result.add(words[0]);

        for(int i=0; i<words.length; i++){
            if(last_group != groups[i]){
                result.add(words[i]);
                last_group = groups[i];
            }
        }

        return result;
    }
}