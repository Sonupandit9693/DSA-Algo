class Solution {
    public int largestPathValue(String colors, int[][] edges) {
        int n = colors.length();
        List<List<Integer>> graph = new ArrayList<>();
        int[] indegree = new int[n];

        // Initialize graph
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
        for (int[] e : edges) {
            graph.get(e[0]).add(e[1]);
            indegree[e[1]]++;
        }

        // Queue for topological sort
        Queue<Integer> q = new LinkedList<>();
        // 26 letters, so colorCount[node][colorIndex]
        int[][] colorCount = new int[n][26];

        // Start with nodes of indegree 0
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) q.add(i);
        }

        int visited = 0;
        int maxColorValue = 0;

        while (!q.isEmpty()) {
            int node = q.poll();
            visited++;

            int colorIdx = colors.charAt(node) - 'a';
            colorCount[node][colorIdx]++;
            maxColorValue = Math.max(maxColorValue, colorCount[node][colorIdx]);

            for (int neighbor : graph.get(node)) {
                // Propagate color counts to neighbors
                for (int i = 0; i < 26; i++) {
                    colorCount[neighbor][i] = Math.max(colorCount[neighbor][i], colorCount[node][i]);
                }

                indegree[neighbor]--;
                if (indegree[neighbor] == 0) q.add(neighbor);
            }
        }

        // Cycle check
        return visited == n ? maxColorValue : -1;
    }
}
