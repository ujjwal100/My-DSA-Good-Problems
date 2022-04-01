// O(NlogN) Time + O(N) Space 
// Link : https://github.com/ujjwal100/LC-Premium/blob/main/Min%20Cost%20To%20Connect%20Sticks.png
class Solution {
    public int connectSticks(int[] sticks) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int cost=0;
        for (int i : sticks)
            pq.add(i);
        
        while (pq.size() > 1){
            int  len = pq.poll() + pq.poll();
            cost+=len;
            pq.add(len);
        }
        return cost;
        
    }
}
