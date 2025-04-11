class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        // create a map to list of destination for each departure airport
        Map<String, List<String>> graph = new HashMap<>();

        for(List<String> ticket : tickets){
            String from = ticket.get(0);
            String to = ticket.get(1);

            graph.computeIfAbsent(from, k -> new ArrayList<>()).add(to);
        }

        // Sort the destination for ech departure airport in lexical order
        for(List<String> destination: graph.values()){
            Collections.sort(destination);
        }

        // Start the itinerary from "JFK"
        LinkedList<String> itinerary = new LinkedList<>();
        dfs("JFK", graph, itinerary);

        return itinerary;
    }

    private void dfs(String airport, Map<String, List<String>> graph, LinkedList<String> itinerary){
        List<String> destinations = graph.get(airport);

        while(destinations != null && !destinations.isEmpty()){
            // Remove the next destination to avoid reviisting the same path
            String nextAirport = destinations.remove(0);
            dfs(nextAirport, graph, itinerary);
        }

        // add the airport to the itinery at the beginning to build the itinerary in reverse order
        itinerary.addFirst(airport);
    } 
}