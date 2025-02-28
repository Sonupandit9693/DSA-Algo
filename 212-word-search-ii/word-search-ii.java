class Solution {
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word = null;  // Store the complete word when we reach end
    }
    
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        
        // Build Trie
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                int idx = c - 'a';
                if (node.children[idx] == null) {
                    node.children[idx] = new TrieNode();
                }
                node = node.children[idx];
            }
            node.word = word;  // Mark end of word
        }
        
        // Search board using DFS
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(board, i, j, root, result);
            }
        }
        
        return result;
    }
    
    private void dfs(char[][] board, int i, int j, TrieNode node, List<String> result) {
        // Check boundaries and if cell is valid
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return;
        }
        
        char c = board[i][j];
        // If cell is already visited (marked '#') or no matching prefix in Trie
        if (c == '#' || node.children[c - 'a'] == null) {
            return;
        }
        
        // Move to next Trie node
        node = node.children[c - 'a'];
        
        // If we found a complete word
        if (node.word != null) {
            result.add(node.word);
            node.word = null;  // Avoid duplicates
        }
        
        // Mark cell as visited
        char temp = board[i][j];
        board[i][j] = '#';
        
        // Explore all 4 directions
        dfs(board, i+1, j, node, result);  // down
        dfs(board, i-1, j, node, result);  // up
        dfs(board, i, j+1, node, result);  // right
        dfs(board, i, j-1, node, result);  // left
        
        // Restore cell
        board[i][j] = temp;
    }
}