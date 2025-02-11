class Solution {
    public int characterReplacement(String s, int k) {
        int[] occurrences = new int[26];
        int left = 0;
        int maxOccurrences = 0;
        int ans = 0;

        for (int right = 0; right < s.length(); right++) {
            occurrences[s.charAt(right) - 'A']++;
            maxOccurrences = Math.max(maxOccurrences, occurrences[s.charAt(right) - 'A']);

            // Check if the remaining characters (window size - maxOccurrences) exceed k
            while (right - left + 1 - maxOccurrences > k) {
                occurrences[s.charAt(left) - 'A']--;
                left++;
            }

            ans = Math.max(ans, right - left + 1);
        }

        return ans;
    }
}
