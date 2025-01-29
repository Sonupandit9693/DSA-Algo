import java.util.*;

class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }

        int indegree [] = new int[n];
        for(int i=0; i<n; i++){
            for(int it : graph[i]){
                adj.get(it).add(i);
                indegree[i] ++;
            }
        }

        Queue<Integer> q = new LinkedList<Integer>();
        List<Integer> safenode = new ArrayList<>();

        for(int i=0; i<n; i++){ 
            if(indegree[i] == 0){
                q.add(i);
            }
        }

        while(! q.isEmpty()){
            int node = q.peek();
            q.remove();

            safenode.add(node);

            for(int it : adj.get(node)){
                indegree[it] --;
                if(indegree[it] == 0){
                    q.add(it);
                }
            }
        }

        Collections.sort(safenode);
        return safenode;
    }
}
