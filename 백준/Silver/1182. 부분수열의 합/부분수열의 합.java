import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, S;
    static int[] arr;
    static boolean[] visited;
    static int target, target_cnt;
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = new int[N];
        visited = new boolean[N];
        
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++)
        	arr[i] = Integer.parseInt(st.nextToken());
        
        target_cnt = 0;
        getSubSetSum(0, 0);
        
        if(S == 0)
        	target_cnt --;
        
        bw.write(target_cnt + "\n");	// 공집합 제외
        bw.flush();
        bw.close();
        br.close();
    }
    static void getSubSetSum(int cnt, int sum) {
    	
    	if(cnt == N) {
    		if(sum == S) 
    			target_cnt++;
    		return;
    	}
    	
    	visited[cnt] = true;
    	getSubSetSum(cnt+1, sum+arr[cnt]);
    	visited[cnt] = false;
    	getSubSetSum(cnt+1, sum);
    }
}

