import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(int x : scoville) q.offer(x);
        
        int cnt = 0;
        while(q.peek() < K){
            if(q.size() == 1 && q.peek() < K) return -1;
            cnt++;
            int mix = q.poll() + (q.poll() * 2);
            q.offer(mix);
        }
        return cnt;
    }
}