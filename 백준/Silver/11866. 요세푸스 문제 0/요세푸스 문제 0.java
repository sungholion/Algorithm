import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main{
	public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	StringTokenizer st = new StringTokenizer(br.readLine());
	int N = Integer.parseInt(st.nextToken());
	int K = Integer.parseInt(st.nextToken());
	
	LinkedList<Integer> lst = new LinkedList<>();
	for(int i=1; i<=N; i++) lst.add(i);
	
	bw.write("<");
	int next = 0;
	while(!lst.isEmpty()) {
		next = (next + K -1) % lst.size();
		bw.write(String.valueOf(lst.get(next)));
		if(lst.size()!=1) bw.write(", ");
		lst.remove(next);
	}
	bw.write(">");
	
	bw.flush();
	bw.close();
	br.close();
	
	}
}