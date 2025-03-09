class Solution {
  
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] vis = new boolean[n];
        
        for(int i = 0; i < n; i++){
            if(vis[i] == false){
                answer++;
                dfs(i, vis, computers);
            }            
        }
        
        return answer;
    }
    
    public void dfs(int node, boolean[] vis, int[][] computers){
        vis[node] = true;
        
        for(int i = 0; i < computers.length; i++){
            if(vis[i] == false && computers[node][i] == 1){
                dfs(i, vis, computers);
            }
        }
    }
}