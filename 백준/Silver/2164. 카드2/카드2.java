import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        
        Queue<Integer> q = new LinkedList<>();
        for(int i=1; i<=n; i++)
        	q.add(i);
        
        while(q.size()!=1) {
        	q.poll();	// 제일 위 카드 버리기
        	int re_insert = q.poll();
        	q.add(re_insert);
        }
        
        bw.write(q.poll() + "\n");
        
   
        bw.flush();
        bw.close();
        br.close();
    }
}