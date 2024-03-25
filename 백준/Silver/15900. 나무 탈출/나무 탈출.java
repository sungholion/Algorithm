import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
 	트리 만들어서 정점(1)에 연결된 노드를 하나씩 타고 가면서, 내려가는 횟수 세아리기.
 	리프 노드이면 다음 정점 진행.
 	내려가는 횟수가 짝수이면 패배, 홀수이면 승리.
 	
 	부모-자식 관계 확인 : 나온적 없는 노드이면 간선 중에서 자식으로 바뀜
 */

public class Main {
	static ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
	static int ans = 0;
	static int n;
	static boolean[] visited;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		n = Integer.parseInt(br.readLine());	// 트리 정점 개수
		visited = new boolean[n+1];
		
		for(int i= 0; i<=n; i++) 
			tree.add(new ArrayList<>());
			
		for(int i=1; i<n; i++) {				// n-1개 간선 정보
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			tree.get(a).add(b);
			tree.get(b).add(a);
		}
		
//		for(int i=0; i<=n; i++) {
//			System.out.print(i + " : ");
//			for(int next : tree.get(i)) {
//				System.out.print(next + " ");
//			}
//			System.out.println();
//		}
		
		whoWin(1, 0, visited);
		
		if(ans % 2 == 1)
			bw.write("Yes");
		else
			bw.write("No");
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void whoWin(int cur, int depth, boolean[] visited) {
		visited[cur] = true;
		
		for(int next : tree.get(cur)) {
			if(!visited[next])
				whoWin(next, depth+1, visited);
		}
		
		if(cur != 1) {
			if(tree.get(cur).size() == 1)
				ans += depth;
		}
		
	}
}
