import java.util.*;
class Solution {
    static int n, m;
    static int[][] g;
    static int[][] vis;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int time;
    public int solution(String[] maps) {
        n = maps.length;
        m = maps[0].length();
        g = new int[n][m];
        vis = new int[n][m];
        for(int i=0; i<n; i++)
            for(int j=0; j<m; j++)
                vis[i][j] = -1;
        
        int[] start = new int[2];
        int[] end = new int[2];
        int[] button = new int[2];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                char ch = maps[i].charAt(j);
                if(ch == 'S'){
                    start[0] = i;
                    start[1] = j;
                    g[i][j] = 1;
                } else if(ch == 'E'){
                    end[0] = i;
                    end[1] = j;
                    g[i][j] = 1;
                } else if(ch == 'L'){
                    button[0] = i;
                    button[1] = j;
                    g[i][j] = 1;
                } else if(ch == 'O'){
                    g[i][j] = 1;
                }
            }
        }
        
        bfs(start, button);
        if(vis[button[0]][button[1]] == -1) return -1;
        time += vis[button[0]][button[1]];
        
        vis = new int[n][m];
        for(int i=0; i<n; i++)
            for(int j=0; j<m; j++)
                vis[i][j] = -1;
        bfs(button, end);
        if(vis[end[0]][end[1]] == -1) return -1;
        time += vis[end[0]][end[1]];
        return time;
    }
    
    static void bfs(int[] s, int[] e){
        ArrayDeque<int[]> q = new ArrayDeque<>();
        vis[s[0]][s[1]] = 0;
        q.offer(new int[]{s[0], s[1]});
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];
            for(int i=0; i<4; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                
                if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if(vis[nx][ny] != -1 || g[nx][ny] != 1) continue;
                vis[nx][ny] = vis[cx][cy] + 1;
                q.offer(new int[]{nx, ny});
                
                if(nx == e[0] && ny == e[1]) return;
            }
        }
    }
}