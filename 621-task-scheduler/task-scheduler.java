class Solution {
    public int leastInterval(char[] tasks, int n) {
        // count the frequency of each task
        Map<Character, Integer> freqMap = new HashMap<>();
        for(char task : tasks){
            freqMap.put(task, freqMap.getOrDefault(task, 0) + 1);
        }

        // build max heap to store frequency count of character
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(
            (a,b) -> b - a
        ); // automatic store frequency in desc order

        maxHeap.addAll(freqMap.values());

        // process tasks of cpu to take interval no.

        int interval = 0;
        while(! maxHeap.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            for(int i = 0; i < n + 1; i++){
                if(! maxHeap.isEmpty()){
                    temp.add(maxHeap.poll());
                }
            }

            for(int freq : temp){
                if(-- freq > 0){
                    maxHeap.add(freq);
                }
            }

            // and update interval after each frequency being processed
            interval += maxHeap.isEmpty() ? temp.size() : n + 1;
        }

        // finally have all interval are possible
        return interval;
    }

}