import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
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
	static char[][] map;
	static boolean[][] visited;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int cnt;

    public static void main(String[] args) throws IOException{
//        System.setIn(new FileInputStream("src/input.txt"));
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n][m];
        visited = new boolean[n][m];
        Point start = new Point(0, 0);
        
        for(int i=0; i<n; i++) {
        	String str = br.readLine();
        	for(int j=0; j<m; j++) {
        		map[i][j] = str.charAt(j);
        		if(map[i][j] == 'I') {
        			start = new Point(i, j);
        		}
        	}
        }
        
        bfs(start);
        
        if(cnt == 0) {
        	sb.append("TT");
        }
        else {
        	sb.append(cnt + "\n");
        }
        
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
        
    }
    
    static void bfs(Point node) {
    	Queue<Point> q = new LinkedList<>();
    	q.offer(node);
    	visited[node.x][node.y] = true;
    	
    	while(!q.isEmpty()) {
    		Point cur = q.poll();
    		
    		for(int i=0; i<4; i++) {
    			int nx = cur.x + dx[i];
    			int ny = cur.y + dy[i];
    			
    			if(!rangeCheck(nx, ny)) continue;
    			
    			if(map[nx][ny] == 'O') {
    				q.offer(new Point(nx,ny));
    				visited[nx][ny] = true;
    			}
    			
    			else if(map[nx][ny] == 'P') {
    				q.offer(new Point(nx,ny));
    				visited[nx][ny] = true;
    				cnt++;
    			}
    		}
    	}
    }
    
    static boolean rangeCheck(int x, int y) {
    	if(x>=0 && y>=0 && x<n && y<m && !visited[x][y] && map[x][y]!='X') {
    		return true;
    	}
    	return false;
    }
    
}