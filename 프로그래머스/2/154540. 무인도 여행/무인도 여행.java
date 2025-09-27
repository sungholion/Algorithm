import java.util.*;
class Solution {
    static int n, m;
    static int[][] g;
    static boolean[][] vis;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static List<Integer> list = new ArrayList<>();
    public int[] solution(String[] maps) {
        n = maps.length;
        m = maps[0].length();
        g = new int[n][m];
        vis = new boolean[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                char ch = maps[i].charAt(j);
                if(ch == 'X') g[i][j] = -1;
                else g[i][j] = ch - '0';
            }
        }
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(!vis[i][j] && g[i][j] != -1){
                    bfs(i, j);
                }
            }
        }
        if(list.size() == 0) return new int[]{-1};
        int[] answer = new int[list.size()];
        
        Collections.sort(list);
        for(int i=0; i<list.size(); i++)
            answer[i] = list.get(i);
        
        return answer;
    }
    
    static void bfs(int x, int y){
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{x, y});
        vis[x][y] = true;
        int cnt = g[x][y];
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];
            
            for(int i=0; i<4; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                
                if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if(vis[nx][ny] || g[nx][ny] == -1) continue;
                vis[nx][ny] = true;
                q.offer(new int[]{nx, ny});
                cnt+= g[nx][ny];
            }
        }
        list.add(cnt);
    }
}