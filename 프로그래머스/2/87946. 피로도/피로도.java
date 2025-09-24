class Solution {
    static int answer;
    static boolean[] visited;
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        dfs(k, dungeons, 0);
        return answer;
    }
    static void dfs(int life, int[][] dungeons, int cnt){
        answer = Math.max(answer, cnt);
        
        for(int i=0; i<dungeons.length; i++){
            if(!visited[i] && life >= dungeons[i][0]){
                visited[i] = true;
                dfs(life-dungeons[i][1], dungeons, cnt+1);
                visited[i] = false;
            }
        }
    }
}