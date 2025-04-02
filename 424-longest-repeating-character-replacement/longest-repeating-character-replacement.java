class Solution {
    public int characterReplacement(String s, int k) {
        int occurences[] = new int [26];
        int maxOccurences = 0;
        int left = 0;
        int ans = 0;

        for(int right=0; right < s.length(); right ++){
            occurences[s.charAt(right) - 'A'] ++;
            maxOccurences = Math.max(maxOccurences, occurences[s.charAt(right) - 'A']);

            while(right - left + 1 - maxOccurences > k){
                occurences[s.charAt(left) - 'A'] --;
                left ++;
            }

            ans = Math.max(ans, right - left + 1);
        }

        return ans;
    }
}