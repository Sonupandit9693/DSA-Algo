class Solution {
    public boolean isAnagram(String s, String t) {
        // first check if both string length not eqal then not anagram return false
        if(s.length() != t.length()){
            return false;
        }

        // crate charter array to mange count
        int charAnagram[] = new int[26]; // only have 26 alaphabets

        for(int i=0; i < s.length(); i++){
            charAnagram[s.charAt(i) - 'a'] ++;
            charAnagram[t.charAt(i) - 'a'] --;
        }

        for(int c: charAnagram){
            if(c != 0){
                return false;
            }
        }

        return true;
    }
}