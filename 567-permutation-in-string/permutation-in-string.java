class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()){
            return false;
        }

        int s1map[] = new int [26];
        int s2map[] = new int [26];

        for(int i=0; i<s1.length(); i++){
            s1map[s1.charAt(i) - 'a'] ++;
            s2map[s2.charAt(i) - 'a'] ++;
        }

        // compare both map with help of slide window
        for(int i=0; i< s2.length() - s1.length(); i++){
            if(match(s1map, s2map)){
                return true;
            }
            s2map[s2.charAt(i + s1.length()) - 'a'] ++; // add new Elenent in window;
            s2map[s2.charAt(i) - 'a'] --; // remove previous window element
        }

        return match(s1map, s2map);
    }

    public boolean match(int s1map[], int s2map[]){
        for(int i=0; i< 26; i++){
            if(s1map[i] != s2map[i]){
                return false;
            }
        }
        return true;

    }
}