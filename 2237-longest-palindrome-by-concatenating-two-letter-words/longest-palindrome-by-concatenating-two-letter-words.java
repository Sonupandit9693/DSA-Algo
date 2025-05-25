class Solution {
    public int longestPalindrome(String[] words) {
        Map<String, Integer> map = new HashMap<>();

        int result = 0;

        for(String word: words){
            String reverseWord = new StringBuilder(word).reverse().toString();
            if(map.getOrDefault(reverseWord, 0) > 0){
                result += 4;
                map.put(reverseWord, map.get(reverseWord) - 1);
            }else{
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }

        for(String key: map.keySet()){
            int count = map.get(key);

            if(key.charAt(0) == key.charAt(1) && count > 0){
                result += 2;
                break;
            }
        }

        return result;

    }
}