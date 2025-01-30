import java.util.*;

class Solution {
    public int shortestPathLength(int[][] graph) {
        int n = graph.length;
        if (n == 1) return 0;  // If there's only one node, no movement is needed.

        // Queue stores (node, bitmask state, distance)
        Queue<int[]> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        // Initialize BFS from all nodes
        for (int i = 0; i < n; i++) {
            int mask = 1 << i;  // Bitmask with only 'i' visited
            q.add(new int[]{i, mask, 0});
            visited.add(i + "," + mask);
        }

        int targetMask = (1 << n) - 1; // All nodes visited (111...1 in binary)

        // BFS traversal
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int node = cur[0], mask = cur[1], dist = cur[2];

            // If all nodes are visited, return the shortest path
            if (mask == targetMask) return dist;

            // Explore neighbors
            for (int neighbor : graph[node]) {
                int nextMask = mask | (1 << neighbor); // Update bitmask
                String state = neighbor + "," + nextMask;
                
                if (!visited.contains(state)) {
                    visited.add(state);
                    q.add(new int[]{neighbor, nextMask, dist + 1});
                }
            }
        }

        return -1; // This should never be reached in a connected graph
    }
}
