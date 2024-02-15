import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] num = new int[3];
        for(int i=0; i<3; i++)
            num[i] = Integer.parseInt(st.nextToken());

        for(int i=0; i<2; i++){
            for(int j=i+1; j<3; j++){
                if(num[i] > num[j]){
                    int temp = num[i];
                    num[i] = num[j];
                    num[j] = temp;
                }
            }
        }

        for(int i=0; i<3; i++)
            System.out.print(num[i] + " ");

    }
}
