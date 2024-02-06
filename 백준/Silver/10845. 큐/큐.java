import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine()); // 명령어 수
		Queue<Integer> q = new LinkedList<>();
		int[] arr = new int[n];
		
		int start = 0;
		int end = 0;
		for(int tc=0; tc<n; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String ord = st.nextToken();
			if(ord.equals("push")) {
				int x = Integer.parseInt(st.nextToken());
				arr[end++] = x;
			}
			else if(ord.equals("pop")) {
				if(end == start)
					bw.write(-1 + "\n");
				else
					bw.write(arr[start++] + "\n");
			}
			else if(ord.equals("size")) {
				bw.write(end-start + "\n");
			}
			else if(ord.equals("empty")) {
				if(end == start) bw.write(1 + "\n");
				else bw.write(0 + "\n");
			}
			else if(ord.equals("front")) {
				if(end == start)
					bw.write(-1 + "\n");
				else
					bw.write(arr[start] + "\n");
			}
			else if(ord.equals("back")) {
				if(end == start)
					bw.write(-1 + "\n");
				else
					bw.write(arr[end-1] + "\n");
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}	
}