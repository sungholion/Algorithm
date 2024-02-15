import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] call = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) call[i] = Integer.parseInt(st.nextToken());

        //영식
        int tot_y = 0;
        for(int i=0; i<n; i++){
            int money = call[i] / 30;
            tot_y+= 10*(money+1);
        }

        //민식
        int tot_m = 0;
        for(int i=0; i<n; i++){
            int money = call[i] / 60;
            tot_m+= 15*(money+1);
        }

        if(tot_y < tot_m) System.out.println("Y" + " " + tot_y);
        else if(tot_m < tot_y) System.out.println("M" + " " + tot_m);
        else if(tot_m == tot_y) System.out.println("Y" + " " + "M" + " " + tot_m);
    }
}
