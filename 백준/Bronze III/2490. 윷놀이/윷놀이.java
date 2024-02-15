import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i=0; i<3; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int cnt = 0;
            for(int j=0; j<4; j++) {
                if (Integer.parseInt(st.nextToken()) == 0)
                    cnt++;
            }
            if(cnt == 0) System.out.println("E");
            else if(cnt == 1) System.out.println("A");
            else if(cnt == 2) System.out.println("B");
            else if(cnt == 3) System.out.println("C");
            else if(cnt == 4) System.out.println("D");


        }


    }
}
