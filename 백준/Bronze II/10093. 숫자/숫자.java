import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n1 = Integer.parseInt(st.nextToken());
        int n2 = Integer.parseInt(st.nextToken());
        
        int a = 0, b = 0;
        if(n1 <= n2){
            a = n1;
            b = n2;
        }
        else{
            a = n2;
            b = n1;
        }
        
        if(a!=b){
            System.out.println(b-a-1);
            for(int i=a+1; i<b; i++)
                System.out.print(i + " ");
        }
        else System.out.println(0);

    }
}
