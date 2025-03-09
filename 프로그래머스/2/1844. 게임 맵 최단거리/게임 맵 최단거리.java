import java.util.*;
import java.io.*;

class Coord{
    int x;
    int y;
    
    public Coord(int x, int y){
        this.x = x;
        this.y = y;
    }
}

class Solution {
    static int[][] vis;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int n, m;
    public int solution(int[][] maps) {
        int answer = 0;
        
        n = maps.length;
        m = maps[0].length;
        vis = new int[n][m];
        
        Coord start = new Coord(0, 0);
        bfs(maps, start);
        
        answer = vis[n-1][m-1];
        if(answer == 0){
            answer = -1;
        }
        
        return answer;
    }
    
    public void bfs(int[][] maps, Coord start){
        Queue<Coord> q = new ArrayDeque<>();
        vis[start.x][start.y] = 1;
        q.offer(start);
        
        while(!q.isEmpty()){
            Coord cur = q.poll();
            
            for(int i=0; i<4; i++){
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                
                if(nx < 0 || ny < 0 || nx >= n || ny >= m || 
                   maps[nx][ny] == 0 || vis[nx][ny] != 0){
                    continue;
                }
                
                vis[nx][ny] = vis[cur.x][cur.y] + 1;
                q.offer(new Coord(nx, ny));
            }
        }
    }
}