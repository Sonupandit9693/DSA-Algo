import java.util.*;

class Solution {
    public int shortestPathLength(int[][] graph) {
        int n = graph.length;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][1 << n];
        
        for (int i = 0; i < n; i++) {
            queue.add(new int[]{i, 1 << i});
            visited[i][1 << i] = true;
        }
        
        int steps = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] state = queue.poll();
                int node = state[0];
                int mask = state[1];

                if (mask == (1 << n) - 1) return steps;

                for (int neighbor : graph[node]) {
                    int nextMask = mask | (1 << neighbor);
                    if (!visited[neighbor][nextMask]) {
                        queue.add(new int[]{neighbor, nextMask});
                        visited[neighbor][nextMask] = true;
                    }
                }
            }
            steps++;
        }

        return -1;
    }
}
