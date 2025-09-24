import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<int[]> q = new ArrayDeque<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0; i<priorities.length; i++){
            q.offer(new int[]{i, priorities[i]});
            pq.offer(priorities[i]);
        }
        
        int cnt = 0;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int idx = cur[0], pri = cur[1];
            
            if(pri == pq.peek()){
                cnt++;
                pq.poll();
                if(idx == location) return cnt;
            } else {
                q.offer(cur);
            }
        }
            
        return -1;
    }
}