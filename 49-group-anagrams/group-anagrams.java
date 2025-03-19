class Solution {
    private HashMap<String, List<String>> ans = new HashMap<>();
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length == 0){
            return new ArrayList<>();
        }else{
            for(int i=0; i<strs.length; i++){
                char chars[] = strs[i].toCharArray();
                Arrays.sort(chars);
                String key = new String(chars);
                if(ans.containsKey(key)){
                    List<String> list1 = ans.get(key);
                    list1.add(strs[i]);
                }else{
                    List<String> list2 = new ArrayList<>();
                    list2.add(strs[i]);
                    ans.put(key, list2);
                }
            }
        }

        return new ArrayList(ans.values());
    }
}