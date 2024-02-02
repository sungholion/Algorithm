import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int R, C, K;
	static char[][] map;
	static int cnt;
	static int total;
	static int[] dx = {1, 0, -1, 0};	// 북 동 남 서 
	static int[] dy = {0, 1, 0, -1};
	
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        
        for(int i=0; i<R; i++) {
        	String str = br.readLine();
        	for(int j=0; j<C; j++) {
        		map[i][j] = str.charAt(j);
        	}
        }
        
        cnt = 1;
        dfs(R-1, 0, 0);
        
        bw.write(total + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
    
    static void dfs(int x, int y, int cnt) {
    	
    	if(cnt == K -1) {
    		if(x == 0 && y == C-1) total++;
    		return;
    	}
    	
    	for(int i=0; i<4; i++) {
    		int nx = x + dx[i];
    		int ny = y + dy[i];
    		if(nx>=0 && ny>=0 && nx<R && ny<C && map[nx][ny]!= 'T') {
    			map[x][y] = 'T';
    			dfs(nx, ny, cnt+1);
    			map[x][y] = '.';
    		}
    		
    	}
    	
    }
}