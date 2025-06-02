import java.io.*;
import java.util.*;


public class Main {
    static final int MOD = 1234567891;
    static final int R = 31;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] card = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<card.length; i++){
            card[i] = Integer.parseInt(st.nextToken());
        }

        int Max = 0;
        for(int i=0; i<card.length-2; i++){
            int sum = 0;

            for(int j=i+1; j<card.length-1; j++){
                for(int k=j+1; k<card.length; k++){
                    sum = card[i] + card[j] + card[k];
                    if((sum <= M) && sum > Max){
                        Max = sum;
                    }
                }
            }
        }

        sb.append(Max);
        br.close();
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}