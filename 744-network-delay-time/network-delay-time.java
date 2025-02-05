import java.util.*;

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        // Create an adjacency list for the graph
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] time : times) {
            graph.putIfAbsent(time[0], new ArrayList<>());
            graph.get(time[0]).add(new int[]{time[1], time[2]});
        }
        
        // Use a priority queue (Min-Heap) for Dijkstra's algorithm
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.add(new int[]{k, 0}); // Start from node k with a delay of 0
        
        // Distance map to store the shortest known distances
        Map<Integer, Integer> dist = new HashMap<>();
        
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int node = current[0], time = current[1];
            
            if (dist.containsKey(node)) continue; // Skip if already visited
            dist.put(node, time);
            
            if (!graph.containsKey(node)) continue; // No outgoing edges
            
            for (int[] neighbor : graph.get(node)) {
                int nextNode = neighbor[0], weight = neighbor[1];
                if (!dist.containsKey(nextNode)) {
                    pq.add(new int[]{nextNode, time + weight});
                }
            }
        }
        
        // If not all nodes are reached, return -1
        if (dist.size() < n) return -1;
        
        // Return the maximum time taken to reach any node
        return Collections.max(dist.values());
    }
}