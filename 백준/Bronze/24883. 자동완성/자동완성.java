import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String ch = br.readLine();
        String result = "Naver Whale";
        if (ch.equals("N") || ch.equals("n")) {
            result = "Naver D2";
        }
        System.out.print(result);
    }

}