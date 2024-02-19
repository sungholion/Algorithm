import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int[] q = new int[2000000];
		int head = 0, tail = 0;
		int size = 0;
		
		for(int loop=0; loop<N; loop++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String ord = st.nextToken();
			if(ord.equals("push")) {
				int x = Integer.parseInt(st.nextToken());
				q[tail++] = x;
				size++;
			}
			else if(ord.equals("pop")) {
				if(size == 0) bw.write(-1 + "\n");
				else {
					bw.write(q[head++] + "\n");
					size--;
				}
			}
			else if(ord.equals("size")) {
				bw.write(size + "\n");
			}
			else if(ord.equals("empty")) {
				if(size == 0) bw.write(1 + "\n");
				else bw.write(0 + "\n");
			}
			else if(ord.equals("front")) {
				if(size == 0) bw.write(-1 + "\n");
				else bw.write(q[head] + "\n");
			}
			else if(ord.equals("back")) {
				if(size == 0) bw.write(-1 + "\n");
				else bw.write(q[tail-1] + "\n");
			}
		}
		
		bw.flush();
		bw.close();
		br.close();
		
	}
}
