class Trie{
    Trie children [] = new Trie[26];
    boolean isword;
}

class WordDictionary {
    Trie root;
    public WordDictionary() {
        root = new Trie();
    }
    
    public void addWord(String word) {
        Trie node = root;
        for(char ch : word.toCharArray()){
            if(node.children[ch - 'a'] == null){
                node.children[ch - 'a'] = new Trie();
            }
            node = node.children[ch - 'a'];
        }

        node.isword = true;
    }
    
    public boolean search(String word) {
        return searchHelper(word, 0, root);
    }
    
    private boolean searchHelper(String word, int pos, Trie node) {
        if(pos == word.length()) {
            return node.isword;
        }
        
        char ch = word.charAt(pos);
        if(ch == '.') {
            for(Trie child : node.children) {
                if(child != null && searchHelper(word, pos + 1, child)) {
                    return true;
                }
            }
            return false;
        } else {
            if(node.children[ch - 'a'] == null) {
                return false;
            }
            return searchHelper(word, pos + 1, node.children[ch - 'a']);
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */