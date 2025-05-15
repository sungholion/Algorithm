class Solution {
    static int cnt;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        boolean[] vis = new boolean[n];
        for(int i=0; i<n; i++){
            if(vis[i] != true){
                dfs(i, computers, vis);
                cnt++;
            }
        }
        
        answer = cnt;
        return answer;
    }
    
    public static void dfs(int v, int[][] computers, boolean[] vis){
        vis[v] = true;
        
        for(int i = 0; i<computers.length; i++){
            if(computers[v][i] == 1 && !vis[i]){
                dfs(i, computers, vis);
            }
        }
    }
}