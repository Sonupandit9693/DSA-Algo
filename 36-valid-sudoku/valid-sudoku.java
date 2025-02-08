class Solution {
    public boolean isValidSudoku(char[][] board) {
        int N = 9;
        // Define Hash set for row, col, boxes
        HashSet<Character>[] row = new HashSet[N];
        HashSet<Character>[] col = new HashSet[N];
        HashSet<Character>[] boxes = new HashSet[N];

        // Initalize Hash set for row, col, boxes
        for(int i=0; i<N; i++){
            row[i] = new HashSet<Character>();
            col[i] = new HashSet<Character>();
            boxes[i] = new HashSet<Character>();
        }

        // iterate on matrix and check for row, col and boxes value is valid or not
        for(int r = 0; r<N; r++){
            for(int c=0; c<N; c++){

                // get index of value
                char val = board[r][c];

                // first check is empty character then skip
                if(val == '.'){
                    continue;
                }

                // check for row
                if(row[r].contains(val)){
                    return false;
                }
                row[r].add(val);

                // check for col
                if(col[c].contains(val)){
                    return false;
                }
                col[c].add(val);

                // check for boxes have formula to get box indx or box no.
                int idx = (r / 3) * 3 + c / 3;
                if(boxes[idx].contains(val)){
                    return false;
                }
                boxes[idx].add(val);
            }
        }
        return true;
    }
}