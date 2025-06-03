import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] commands = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            commands[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = N -1 ; i >= 0; i--) {
            int command = commands[i];
            int card = N - i;

            if(command == 1)
                deque.addFirst(card);
            else if(command == 2){
                int first = deque.pollFirst();
                deque.addFirst(card);
                deque.addFirst(first);
            }
            else if(command == 3)
                deque.addLast(card);
        }

        for(int num : deque)
            sb.append(num).append(" ");

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }
}