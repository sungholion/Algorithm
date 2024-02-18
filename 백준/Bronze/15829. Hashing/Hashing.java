import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int L = Integer.parseInt(br.readLine());
        String str = br.readLine();

        long ans = 0;
        long pow = 1;
        for(int i=0; i<str.length(); i++){
            ans += (str.charAt(i) - 'a' + 1) * pow;
            pow = (pow * 31) % 1234567891;
        }

        System.out.println(ans % 1234567891);
    }
}