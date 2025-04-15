class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        // step1 : build a map of character array -> its rank in alien dictinary

        int alienOrder[] = new int[26];
        for(int i=0; i< order.length(); i++){
            alienOrder[order.charAt(i) - 'a'] = i;
        }

        // step 2 : Compare each word with the next
        for(int i=0; i< words.length - 1; i++){
            if(! inCorrectOrder(words[i], words[i+1], alienOrder)){
                return false;
            }
        }

        return true;

    }

    private  boolean inCorrectOrder(String word1, String word2, int alienOrder[]){
        int len = Math.min(word1.length(), word2.length());

        for(int i=0; i< len; i++){
            char c1 = word1.charAt(i);
            char c2 = word2.charAt(i);

            if( c1 != c2){
                return alienOrder[c1 - 'a'] <= alienOrder[c2 - 'a'];
            }
        }

        // word are indentical up to min length, shorter word should be come first
        return word1.length() <= word2.length();
    } 
}