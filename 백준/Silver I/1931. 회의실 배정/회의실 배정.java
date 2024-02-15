import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;	

class Meeting implements Comparable<Meeting>{
	int start;
	int end;
	
	Meeting(int start, int end){
		this.start = start;
		this.end = end;
	}

	@Override
	public int compareTo(Meeting o) {
		if(this.end == o.end)
			return this.start - o.start;
		return this.end - o.end;
	}
}

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		//	입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		ArrayList <Meeting> m = new ArrayList<>();
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			m.add(new Meeting(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		
		Collections.sort(m);
		

		
		int cnt = 1; // 최악의 경우에도 1개는 가능
		int compare_endtime = m.get(0).end;
		for(int i=1; i < m.size(); i++) {
			if(m.get(i).start >= compare_endtime) {
				compare_endtime = m.get(i).end;
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}
}