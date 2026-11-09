class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        Arrays.sort(hand);
        Map<Integer,Integer> map = new HashMap<>();
        for(int i : hand) {
            if(!map.containsKey(i)) 
                map.put(i,0);
            map.put(i,map.get(i)+1);
        }
        
        for(int i=0;i<hand.length;i++) {
            int start = hand[i];
            if(map.get(start) == 0) continue;

            for(int j=0;j<groupSize;j++) {
                int card = start+j;
                if(map.getOrDefault(card,0) == 0) return false;
                map.put(card,map.get(card)-1);
            }
        }
        return true;
    }
}
