class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // check if strs is empty list
        if(strs.length == 0){
            return new ArrayList<>();
        }

        HashMap<String, List> ansMap = new HashMap<>();

        // create charater array of size 26
        int count [] = new int [26];

        for(String s: strs){
            // intialize count arrya value with 0
            Arrays.fill(count, 0);
            for(int c: s.toCharArray()){
                count[c - 'a'] ++;
            }

            // create hashkey for match group of nanagram
            StringBuilder sb = new StringBuilder("");
            // go for 26 charcter to genrate hashKey
            for(int i=0; i<26; i++){
                sb.append("#");
                sb.append(count[i]);
            }

            String key = sb.toString();
            if(! ansMap.containsKey(key)){
                ansMap.put(key, new ArrayList<>());
            }
            ansMap.get(key).add(s);
        }

        return new ArrayList(ansMap.values());
    }
}