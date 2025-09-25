import java.util.*;
class Solution {
    static int n, m;
    static int[][] island;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static List<Integer> life = new ArrayList<>();
    public int[] solution(String[] maps) {
        int[] answer = {};
        n = maps.length;
        m = maps[0].length();
        island = new int[n][m];
        visited = new boolean[n][m];
    
        for(int i=0; i<n; i++){
            String temp = maps[i];
            for(int j=0; j<m; j++){
                char ch = temp.charAt(j);
                if(ch == 'X') island[i][j] = 0;
                else island[i][j]= ch - '0';
            }
        }
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(!visited[i][j] && island[i][j] != 0){
                    bfs(i, j);
                }
            }
        }
        
        if(life.size() == 0) return new int[]{-1};
        Collections.sort(life);
        answer = new int[life.size()];
        for(int i=0; i<life.size(); i++)
            answer[i] = life.get(i);
        return answer;
    }
    
    static void bfs(int x, int y){
        ArrayDeque<int[]> q = new ArrayDeque<>();
        visited[x][y] = true;
        q.offer(new int[]{x, y});
        int cnt = island[x][y];
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];
            for(int i=0; i<4; i++){
                int nx = r + dx[i];
                int ny = c + dy[i];
                
                if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if(visited[nx][ny] || island[nx][ny] == 0) continue;
                visited[nx][ny] = true;
                q.offer(new int[]{nx, ny});
                cnt += island[nx][ny];
                
            }
        }
        life.add(cnt);
    }
}