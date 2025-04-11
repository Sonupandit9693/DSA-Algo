class Solution {
    // creating Pair for to have atribute word and number of steps
    class Pair{
        String word;
        int step;
        Pair(String word, int step){
            this.word = word;
            this.step = step;
        }
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // i use BFS to check Sortest path of step
        Queue<Pair> queue = new LinkedList<>();
        // add beging word in queue
        queue.add(new Pair(beginWord, 1));

        // creating a Hashset to manage alredy process word of wordlist
        Set<String> st = new HashSet<>();
        int n = wordList.size();
        for(int i=0; i < n; i++){
            st.add(wordList.get(i));
        }
        st.remove(beginWord);

        while(! queue.isEmpty()){
            String word = queue.peek().word;
            int step = queue.peek().step;
            queue.remove();

            if(word.equals(endWord) == true) return step;

            for(int i=0; i<word.length(); i++){
                for(char ch='a'; ch <= 'z'; ch ++){
                    char replaceArray[] = word.toCharArray();
                    replaceArray[i] = ch;
                    String replaceWord = new String(replaceArray);
                    if(st.contains(replaceWord) == true){
                        st.remove(replaceWord);
                        queue.add(new Pair(replaceWord, step+1));
                    }
                }
            }
        }

        return 0;

    }
}