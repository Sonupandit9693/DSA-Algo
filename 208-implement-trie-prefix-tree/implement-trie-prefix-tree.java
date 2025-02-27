class TrieNode{
    private TrieNode links [];
    private final int R = 26;
    private boolean isEnd;

    public TrieNode(){
        links = new TrieNode[R];
    }

    public boolean containsKey(char ch){
        return links[ch - 'a'] != null;
    }

    public TrieNode get(char ch){
        return links[ch - 'a'];
    }

    public void put(char ch, TrieNode node){
        links[ch - 'a'] = node;
    }

    public void setEnd(){
        isEnd = true;
    }

    public boolean isEnd(){
        return isEnd;
    }
}

class Trie {
    private TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode node = root;
        for(int i=0; i<word.length(); i++){
            char currentChar = word.charAt(i);
            if(! node.containsKey(currentChar)){
                node.put(currentChar, new TrieNode());
            }
            node = node.get(currentChar);
        }

        node.setEnd();
    }
    
    public TrieNode searchPrefix(String word) {
        TrieNode node = root;
        for(int i=0; i<word.length(); i++){
            char currentChar = word.charAt(i);
            if(node.containsKey(currentChar)){
                node = node.get(currentChar);
            }
            else{
                return null;
            }
        }
        return node;
    }

    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node != null && node.isEnd();
    }
    
    public boolean startsWith(String prefix) {
        TrieNode node = searchPrefix(prefix);
        return node != null;
    }
}






// class TreeNode{
//     TreeNode children[] = new TreeNode[26];
//     boolean isword;
// }

// class Trie {
//     TreeNode root;
//     public Trie() {
//         root = new TreeNode();
//     }
    
//     public void insert(String word) {
//         TreeNode node = root;
//         for(char ch : word.toCharArray()){
//             if(node.children[ch - 'a'] == null){
//                 node.children[ch - 'a'] = new TreeNode();
//             }
//             node = node.children[ch - 'a'];
//         }
//         node.isword = true;
//     }
    
//     public boolean search(String word) {
//         TreeNode node = root;
//         for(char ch : word.toCharArray()){
//             if (node.children[ch - 'a'] == null) return false;
//             node = node.children[ch - 'a'];
//         }

//         return node.isword;
//     }
    
//     public boolean startsWith(String prefix) {
//         TreeNode node = root;
//         for(char ch : prefix.toCharArray()){
//             if(node.children[ch - 'a'] == null) return false;
//             node = node.children[ch - 'a'];
//         }
//         return true;

//     }
// }




/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */