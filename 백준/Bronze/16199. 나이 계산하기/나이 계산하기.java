import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int bornY = Integer.parseInt(st.nextToken());
        int bornM = Integer.parseInt(st.nextToken());
        int bornD = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int inputY = Integer.parseInt(st.nextToken());
        int inputM = Integer.parseInt(st.nextToken());
        int inputD = Integer.parseInt(st.nextToken());

        int firstAge = inputY - bornY;
        if(inputM < bornM || (inputM == bornM && inputD < bornD)) firstAge--;
        int secondAge = inputY - bornY + 1;
        int thirdAge = inputY - bornY;

        sb.append(firstAge).append("\n");
        sb.append(secondAge).append("\n");
        sb.append(thirdAge).append("\n");

        System.out.print(sb.toString());
    }
}
