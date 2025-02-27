class TreeNode{
    TreeNode children[] = new TreeNode[26];
    boolean isword;
}

class Trie {
    TreeNode root;
    public Trie() {
        root = new TreeNode();
    }
    
    public void insert(String word) {
        TreeNode node = root;
        for(char ch : word.toCharArray()){
            if(node.children[ch - 'a'] == null){
                node.children[ch - 'a'] = new TreeNode();
            }
            node = node.children[ch - 'a'];
        }
        node.isword = true;
    }
    
    public boolean search(String word) {
        TreeNode node = root;
        for(char ch : word.toCharArray()){
            if (node.children[ch - 'a'] == null) return false;
            node = node.children[ch - 'a'];
        }

        return node.isword;
    }
    
    public boolean startsWith(String prefix) {
        TreeNode node = root;
        for(char ch : prefix.toCharArray()){
            if(node.children[ch - 'a'] == null) return false;
            node = node.children[ch - 'a'];
        }
        return true;

    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */