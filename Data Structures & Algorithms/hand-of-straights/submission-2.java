class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        Arrays.sort(hand);
        Map<Integer,Integer> map = new HashMap<>();
        for(int i : hand) {
            map.put(i,map.getOrDefault(i,0)+1); 
        }
        
        for(int i=0;i<hand.length;i++) {
            int start = hand[i];
            if(map.get(start) == 0) continue;

            for(int j=0;j<groupSize;j++) {
                int card = start+j;
                int cardFreq = map.getOrDefault(card,0);
                if(cardFreq == 0) return false;
                map.put(card,cardFreq-1);
            }
        }
        return true;
    }
}
