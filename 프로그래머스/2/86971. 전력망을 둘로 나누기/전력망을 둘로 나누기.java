import java.util.*;
class Solution {
    static int min = Integer.MAX_VALUE;
    static List<Integer>[] g;
    static boolean[] visited;
    public int solution(int n, int[][] wires) {
        int l = wires.length;
        g = new ArrayList[n+1];
        for(int i=1; i<=n; i++) g[i] = new ArrayList<>();
        for(int i=0; i<wires.length; i++){
            int a = wires[i][0];
            int b = wires[i][1];
            g[a].add(b); g[b].add(a);
        }
        
        for(int i=0; i<l; i++){
            int v1 = wires[i][0];
            int v2 = wires[i][1];
            visited = new boolean[n+1];
            int cnt1 = bfs(v1, v1, v2);
            int cnt2 = n - cnt1;
            min = Math.min(min, Math.abs(cnt1 - cnt2));
        }
        return min;
    }
    
    static int bfs(int start, int cutU, int cutV){
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(start);
        visited[start] = true;
        int cnt = 1;
        
        while(!q.isEmpty()){
            int cur = q.poll();
            for(int next : g[cur]){
                if((cur == cutU && next == cutV) || (cur == cutV && next == cutU)) continue;
                if(!visited[next]){
                    visited[next] = true;
                    q.offer(next);
                    cnt++;
                }
            }
        }
        return cnt;
    }
    
}