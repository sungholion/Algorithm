import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;	

class Lecture implements Comparable<Lecture>{
	int start;
	int end;
	
	Lecture(int start, int end){
		this.start = start;
		this.end = end;
	}

	@Override
	public int compareTo(Lecture o) {
		if(this.start == o.start)
			return this.end - o.end;
		return this.start - o.start;
	}
}

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		ArrayList <Lecture> l = new ArrayList<>();
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			l.add(new Lecture(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		
		Collections.sort(l);
		
		
		pq.offer(l.get(0).end);
		
		for(int i=1; i<n; i++) {
			if(l.get(i).start >= pq.peek()) {
				pq.poll();
			}
			
			pq.offer(l.get(i).end);
			
		}
		
		System.out.println(pq.size());
		
	}
}