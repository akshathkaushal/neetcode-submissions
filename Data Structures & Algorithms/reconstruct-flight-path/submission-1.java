class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String,PriorityQueue<String>> adj = new HashMap<>();
        for(List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);
            if(!adj.containsKey(from)) 
                adj.put(from, new PriorityQueue<>());
            adj.get(from).add(to);
        }

        List<String> result = new ArrayList<>();
        helper("JFK",adj,result);
        Collections.reverse(result);
        return result;
    }
    private void helper(String from, Map<String,PriorityQueue<String>> adj, List<String> result) {
        if(from == null) return;

        while(adj.containsKey(from) && !adj.get(from).isEmpty()) {
            String to = adj.get(from).poll();
            helper(to, adj, result);
        }
        result.add(from);
    }
}
