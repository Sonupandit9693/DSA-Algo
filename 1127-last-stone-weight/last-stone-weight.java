class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b - a);

        for (int stone : stones){
            maxHeap.offer(stone);
        }

        while(maxHeap.size() > 1){

            int stone1 = maxHeap.poll();
            int stone2 = maxHeap.poll();
            int x = Math.min(stone1, stone2);
            int y = Math.max(stone1, stone2);
            if ( x != y){
                maxHeap.offer(y - x);
            }

            // for x == y do noting it will auto destroy
        }

        return maxHeap.isEmpty() ? 0: maxHeap.poll();
    }
}