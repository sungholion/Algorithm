import java.beans.Visibility;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point{
	int x;
	int y;
	
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
}

public class Main{
	static int n, m;
	static int[][] map;
//	static boolean[][] visited;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static ArrayList<Point> ice = new ArrayList<>();
	static int time;
	
    public static void main(String[] args) throws IOException{
        //System.setIn(new FileInputStream("src/input.txt"));
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        
        for(int i=0; i<n; i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j=0; j<m; j++) {
        		map[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        int res = 0;
        while(true) {
        	int iceCnt = getIceCnt();
        	if(iceCnt >= 2) {
        		sb.append(res + "");
        		break;
        	}
        	
        	if(iceCnt == 0) {
        		res = 0;
        		sb.append(res + "");
        		break;
        	}
        	
        	melt();
        	res++;
        }
        
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
        
    }
    
    static int getIceCnt() {
    	boolean[][] visited = new boolean[n][m];
    	int iceCnt = 0;	// 빙하 덩이 갯수
    	for(int i=0; i<n; i++) {
    		for(int j=0; j<m; j++) {
    			if(map[i][j]!=0 && !visited[i][j]) {
    				dfs(i, j, visited);
    				iceCnt++;
    			}
    		}
    	}
    	
    	return iceCnt;
    }
    
    static void dfs(int x, int y, boolean[][] visited) {
    	visited[x][y] = true;
    	
    	for(int i=0; i<4; i++) {
    		int nx = x + dx[i];
    		int ny = y + dy[i];
    		
    		if(nx < 0 || ny < 0 || nx >= n || ny > m) continue;
    	
    		if(!visited[nx][ny] && map[nx][ny]!=0) {
    			dfs(nx, ny, visited);
    			
    		}
    	}
    }
    
    static void melt() {
    	Queue<Point> q = new LinkedList<>();
    	boolean[][] visited = new boolean[n][m];
    	
    	for(int i=0; i<n; i++) {
    		for(int j=0; j<m; j++) {
    			if(map[i][j]!=0) {
    				q.offer(new Point(i, j));
    				visited[i][j] = true;
    			}
    		}
    	}
    	
    	while(!q.isEmpty()) {
    		Point cur = q.poll();
    		int seaCnt = 0;
    		
    		for(int i=0; i<4; i++) {
    			int nx = cur.x + dx[i];
    			int ny = cur.y + dy[i];
    			
    			if(nx < 0 || ny < 0 || nx > n || ny > m) continue;
    			
    			if(!visited[nx][ny] && map[nx][ny] == 0)
    				seaCnt++;
    			
    		}
    		
    		if(map[cur.x][cur.y] - seaCnt < 0)
    			map[cur.x][cur.y] = 0;
    		else {
    			map[cur.x][cur.y] -= seaCnt;
    		}
    	}
    	
    	
    }
    
}