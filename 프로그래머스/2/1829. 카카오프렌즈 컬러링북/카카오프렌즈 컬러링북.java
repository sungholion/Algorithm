import java.util.*;
class Solution {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        boolean[][] vis = new boolean[m][n];
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                int area = 0;
                if(!vis[i][j] && picture[i][j] != 0){
                    numberOfArea++;
                    area = bfs(picture, vis, i, j, picture[i][j]);
                }
                maxSizeOfOneArea = Math.max(maxSizeOfOneArea, area);
            }
        }
        
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
    
    static int bfs(int[][] p, boolean[][] vis, int x, int y, int color){
        ArrayDeque<int[]> q = new ArrayDeque<>();
        vis[x][y] = true;
        q.offer(new int[]{x, y});
        int cnt = 1;
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];
            
            for(int i=0; i<4; i++){
                int nx = r + dx[i];
                int ny = c + dy[i];
                
                if(nx < 0 || ny < 0 || nx >= p.length || ny >= p[0].length) continue;
                if(vis[nx][ny] || p[nx][ny] != color) continue;
                
                vis[nx][ny] = true;
                q.offer(new int[]{nx, ny});
                cnt++;
            }
        }
        
        return cnt;
    }
}