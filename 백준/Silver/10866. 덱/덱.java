import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		Deque<Integer> d = new ArrayDeque<>();
		
		int x = 0;
		for(int loop=0; loop<N; loop++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String ord = st.nextToken();
			if(ord.equals("push_back")) {
				x = Integer.parseInt(st.nextToken());
				d.offerLast(x);
			}
			else if(ord.equals("push_front")) {
				x = Integer.parseInt(st.nextToken());
				d.offerFirst(x);
			}
			else if(ord.equals("pop_back")) {
				if(!d.isEmpty())
					bw.write(d.pollLast() + "\n");
				else
					bw.write(-1 + "\n");
			}
			else if(ord.equals("pop_front")) {
				if(!d.isEmpty())
					bw.write(d.pollFirst() + "\n");
				else
					bw.write(-1 + "\n");
			}
			else if(ord.equals("size")) {
				bw.write(d.size() + "\n");
			}
			else if(ord.equals("empty")) {
				if(!d.isEmpty()) bw.write(0 + "\n");
				else bw.write(1 + "\n");
			}
			else if(ord.equals("front")) {
				if(!d.isEmpty()) bw.write(d.peekFirst() + "\n");
				else bw.write(-1 + "\n");
			}
			else if(ord.equals("back")) {
				if(!d.isEmpty()) bw.write(d.peekLast() + "\n");
				else bw.write(-1 + "\n");
			}
		}
		
		bw.flush();
		bw.close();
		br.close();
		
	}
}
