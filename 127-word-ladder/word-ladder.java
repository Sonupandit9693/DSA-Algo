class Pair{
    String word;
    int step;
    Pair(String word, int step){
        this.word = word;
        this.step = step;
    }
}

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(beginWord, 1));

        Set<String> st = new HashSet<String>();
        int len = wordList.size();
        for(int i=0; i<len; i++){
            st.add(wordList.get(i));
        }

        st.remove(beginWord);

        while(! q.isEmpty()){
            String word = q.peek().word;
            int step = q.peek().step;
            q.remove();

            if(word.equals(endWord) == true) return step;

            for(int i=0; i< word.length(); i++){
                for(char ch ='a'; ch <= 'z'; ch++){
                    char replacedArray [] = word.toCharArray();
                    replacedArray[i] = ch;
                    String replacedWord = new String(replacedArray);
                    if(st.contains(replacedWord) == true){
                        st.remove(replacedWord);
                        q.add(new Pair(replacedWord, step + 1));
                    }
                }
            }
        }

        return 0;

    }
}