import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());
		
		
		ArrayList<Point> pointList;
		ArrayList<ArrayList<Integer>> map;
		
		for(int tc = 0; tc < TC; tc++) {
			int n = Integer.parseInt(br.readLine());
			
			pointList = new ArrayList<>();
			
			for(int i = 0; i < n+2; i++) {	// 집, 편의점, 페스티벌 위치 저장
				StringTokenizer st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				pointList.add(new Point(x,y));
			
			}
			
			map = new ArrayList<>();
			for(int i=0; i <n+2; i++) {
				map.add(new ArrayList<>());
			}
			
			for(int i=0; i < n+2; i++) {
				for(int j= i+1; j <n+2; j++) {
					if(getDistance(pointList.get(i), pointList.get(j)) <= 1000) {
						map.get(i).add(j);
						map.get(j).add(i);
					}
				}
			}
			
			if(bfs(map, n) == true)
				sb.append("happy" + "\n");
			else
				sb.append("sad" + "\n");
			
			
			
		}
		System.out.println(sb.toString());
	}
	
	public static int getDistance(Point p1, Point p2) {
		return Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);
	}
	
	public static boolean bfs(ArrayList<ArrayList<Integer>> map, int n) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(0);
		
		boolean[] visited = new boolean[n+2];
		visited[0] = true;
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			if(cur == n + 1) {
				return true;
			}
			
			for(int next : map.get(cur)) {
				if(!visited[next]) {
					visited[next] = true;
					q.offer(next);
				}
			}
		}
		
		return false;
	}
	
}

