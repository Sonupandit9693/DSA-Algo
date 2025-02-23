class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }

        int characterCount[] = new int[26];

        for(int i=0; i<s.length(); i++){
            characterCount[s.charAt(i) - 'a'] ++;
            characterCount[t.charAt(i) - 'a'] --;
        }

        for( int c : characterCount){
            if(c != 0){
                return false;
            }
        }

        return true;
    }
}