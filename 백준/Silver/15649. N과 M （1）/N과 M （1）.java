import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] num;
	static boolean[] visited;
	static int n;
	static int m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        num = new int[n];
        visited = new boolean[n];
      
        
        perm(0);
    }
    
    public static void perm(int cnt)
    {
    	if(cnt == m) {
    		for(int i=0; i<m; i++)
    			System.out.print(num[i] + " ");
    		System.out.println();
    		return;
    	}
    	
    	else {
    		for(int i=0; i<n; i++) {
    			if(visited[i] == true) continue;
    			num[cnt] = i + 1;
    			visited[i] = true;
    			perm(cnt+1);
    			visited[i] = false;
    		}
    	}
    }
}
