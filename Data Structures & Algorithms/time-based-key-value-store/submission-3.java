class TimeMap {
    private Map<String,List<Pair<Integer,String>>> timeMap;
    public TimeMap() {
        timeMap = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!timeMap.containsKey(key)) {
            timeMap.put(key, new ArrayList<>());
        }
        timeMap.get(key).add(new Pair<>(timestamp,value));    

        // printMap();
    }
    
    public String get(String key, int timestamp) {
        if(!timeMap.containsKey(key)) return "";

        List<Pair<Integer,String>> lst = timeMap.get(key);
        if(lst.size() == 0) return "";

        int l=0,r=lst.size()-1;
        int ans = -1;

        while(l<=r) {
            int m = l+(r-l)/2;
            
            if(lst.get(m).getKey()<=timestamp) {
                ans=m;
                l=m+1;
            } else {
                r=m-1;
            }
        }

        // printMap();
        return ans == -1 ? "" : lst.get(ans).getValue();
    }

    private void printMap() {
        this.timeMap.forEach((key,value) -> {
            System.out.print(key + ": ");

            for(Pair p : value) {
                System.out.print("{"+p.getKey()+","+p.getValue()+"}");
            }
            System.out.println();
        });
    }
}
