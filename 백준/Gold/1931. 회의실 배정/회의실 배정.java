import java.io.*;
import java.util.*;
class Meeting{
    int start;
    int end;

    Meeting(int start, int end){
        this.start = start;
        this.end = end;
    }

}
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Meeting[] meetings = new Meeting[N];
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            meetings[i] = new Meeting(start, end);
        }

        Arrays.sort(meetings, (a, b) -> {
            if(a.end != b.end) return Integer.compare(a.end, b.end);
            return Integer.compare(a.start, b.start);
        });

        int cnt = 0;
        int last = 0;
        for(int i = 0; i < meetings.length; i++){
            if(meetings[i].start >= last){
                cnt++;
                last = meetings[i].end;
            }
        }

        System.out.println(cnt);

    }
}
