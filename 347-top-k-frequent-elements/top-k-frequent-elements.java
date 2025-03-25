import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // store frequency of the number
        HashMap<Integer, Integer> countMap = new HashMap<>();

        for(int num : nums){
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        // step 2 create a heap for max size can be nums array length
        Queue<Integer> heap = new PriorityQueue<>((a,b) -> countMap.get(a) - countMap.get(b));

        for(int n : countMap.keySet()){
            heap.add(n);
            if(heap.size() > k){
                heap.poll();
            }
        }

        int ans[] = new int [k];
        for(int i=0; i<k; i++){
            ans[i] = heap.poll();
        }

        return ans;

    }
}