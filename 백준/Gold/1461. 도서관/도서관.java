import java.util.*;
import java.io.*;

public class Main{
    static int n, m;    // 책의 개수 n, 한 번에 들 수 있는 책의 개수 m
    static List<Integer> plusBook, minusBook;   // 책의 위치. 부호에 따라 양방향으로 나눠서 리스트 저장
    static int max; // 가장 멀리 있는 책의 위치. 가장 멀리 있는 책까지는 갔다가 돌아오지 않아도 된다.
    static int walk;    // 최소 걸음 수

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        plusBook = new ArrayList<Integer>();
        minusBook = new ArrayList<Integer>();
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            int loc = Integer.parseInt(st.nextToken());

            if(Math.abs(loc) > max) // 가장 먼 책의 위치를 갱신
                max = Math.abs(loc);

            if(loc > 0) // 책의 위치가 양수인 곳 plusBook에 저장
                plusBook.add(loc);
            else        // 책의 위치가 음수인 곳 minusBook에 저장
                minusBook.add(Math.abs(loc));
        }

        plusBook.sort(Collections.reverseOrder());  // 역순 정렬
        minusBook.sort(Collections.reverseOrder());

        for(int i=0; i<plusBook.size(); i++){
            if( (i % m == 0) && (plusBook.get(i) == max) )  // 최대 m권씩 들 수 있으므로 인덱스를 m으로 나눴을 때 0인 곳 && 가장 먼거리인 경우
                walk += plusBook.get(i);    // 돌아오지 않아도 되므로 걸음 수에 그냥 더하기
            else if(i % m == 0)             // 최대 m권
                walk += (plusBook.get(i) * 2);  // 돌아와야 하므로 왕복은 *2
        }

        for(int i=0; i<minusBook.size(); i++){
            if( (i % m == 0) && (minusBook.get(i) == max) )
                walk += minusBook.get(i);
            else if(i % m == 0)
                walk += (minusBook.get(i) * 2);
        }

        sb.append(walk).append("\n");
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}