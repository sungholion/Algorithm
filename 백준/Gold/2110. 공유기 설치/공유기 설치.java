import java.io.*;
import java.util.*;

public class Main {
    static int n, c;
    static int[] map;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        
        map = new int[n];
        for(int i = 0; i < n; i++) 
        	map[i] = Integer.parseInt(br.readLine());
        
        sb.append(findWifi());
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
    
    static int findWifi() {
    	Arrays.sort(map);	// 이분 탐색은 정렬된 배열에 사용 가능.\
    	
    	int low = 1;	// 최소 거리
    	int high = map[n-1] - map[0] + 1;	// 최대치는 왼쪽 끝에서 오른쪽 끝 집 간 거리
    	
    	while(low < high) {
    		int mid = (low + high) / 2;
    		
    		if(canInstall(mid) < c) {
    			high = mid;
    		}
    		else {
    			low = mid + 1;
    		}
    		
    	}
    	
    	return (low - 1);
    }
    
    static int canInstall(int d) {
    	int cnt = 1;
    	int lastLocate = map[0];
    	
    	for(int i=1; i < map.length; i++) {
    		int locate = map[i];
    		
    		if(locate - lastLocate >= d) {
    			cnt++;
    			lastLocate = locate;
    		}
    	}
    	
    	return cnt;
    }
}
