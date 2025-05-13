class Solution {

    private final int MOD = 1_000_000_007;

    public int lengthAfterTransformations(String s, int t) {
        int[] map = new int[26];

        for (char ch : s.toCharArray()) {
            map[ch - 'a']++;
        }

        for (int step = 1; step <= t; step++) {
            int[] temp = new int[26];
            for (int i = 0; i < 26; i++) {
                int freq = map[i];

                if (i != 25) { // not 'z'
                    temp[i + 1] = (temp[i + 1] + freq) % MOD;
                } else { // 'z'
                    temp[0] = (temp[0] + freq) % MOD;
                    temp[1] = (temp[1] + freq) % MOD;
                }
            }
            map = temp;
        }

        int result = 0;
        for (int i = 0; i < 26; i++) {
            result = (result + map[i]) % MOD;
        }

        return result;
    }
}
