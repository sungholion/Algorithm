import java.util.*;

class Solution {
    
    static class Coord{
        int x;
        int y;
        
        public Coord(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    
    static int n, m;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] vis;
    
    public int solution(int[][] maps) {
        int answer = 0;
        
        n = maps.length;
        m = maps[0].length;
        vis = new int[n][m];
        
        bfs(maps);
        
        if(vis[n-1][m-1] == 0){
            answer = -1;
        } else {
            answer = vis[n-1][m-1];
        }
        
        
        return answer;
    }
    
    static void bfs(int[][] maps){
        Queue<Coord> q = new ArrayDeque<>();
        q.offer(new Coord(0, 0));
        vis[0][0] = 1;
        
        while(!q.isEmpty()){
            Coord cur = q.poll();
            
            for(int i=0; i<4; i++){
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                
                if(nx < 0 || ny < 0 || nx >= n || ny >= m || maps[nx][ny] == 0 || vis[nx][ny] !=0){
                
                    continue;
                }
                   
                    vis[nx][ny] = vis[cur.x][cur.y] + 1;
                    q.offer(new Coord(nx, ny));
            }
        }
    }
}