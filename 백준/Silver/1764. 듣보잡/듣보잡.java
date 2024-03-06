import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;


public class Main{
	static int n, m;
	
    public static void main(String[] args) throws IOException{
//        System.setIn(new FileInputStream("src/input.txt"));
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        HashSet<String> dontListen = new HashSet<String>();
        
        for(int i=0; i<n; i++) {
        	dontListen.add(br.readLine());
        }
        
        List<String> dontSeeListen = new ArrayList<>();
        for(int i=0; i<m; i++) {
        	String str = br.readLine();
        	if(dontListen.contains(str)) {
        		dontSeeListen.add(str);
        	}
        }
        
        Collections.sort(dontSeeListen);
        sb.append(dontSeeListen.size() + "\n");
        for(String str : dontSeeListen) {
        	sb.append(str + "\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
        
    }
    
    
}