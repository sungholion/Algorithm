import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	static List<String> lst = new ArrayList<String>();
	
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        for(int tc=1; tc<=10; tc++) {
        	int n = Integer.parseInt(br.readLine());	// 원본 암호 길이
        	
        	st = new StringTokenizer(br.readLine());
        	for(int i=0; i<n; i++) {
        		lst.add(st.nextToken());
        	}
        	
        	int m = Integer.parseInt(br.readLine());	// 명령어 개수
        	st = new StringTokenizer(br.readLine());
        	
        	for(int none = 0; none<m; none++) {
        		String ins = st.nextToken();
        		int x = Integer.parseInt(st.nextToken());
        		int y = Integer.parseInt(st.nextToken());
            	
        		int cnt = y;
        		int i = x;
        		while(true) {
        			if(cnt == 0) break;
        			lst.add(i, st.nextToken());
        			i++;
        			cnt--;
        		}
        	
        	}
        	System.out.print("#" + tc + " ");
        	for(int i=0; i<10; i++)
        		System.out.print(lst.get(i) + " ");
        	System.out.println();
        	lst.clear();
        	
        }
        
    }	
}