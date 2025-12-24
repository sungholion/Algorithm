import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        String A = st.nextToken();
        String B = st.nextToken();
        StringBuffer newA = new StringBuffer(A);
        A = newA.reverse().toString();
        StringBuffer newB = new StringBuffer(B);
        B = newB.reverse().toString();

        int numA = Integer.parseInt(A);
        int numB = Integer.parseInt(B);

        if(numA >= numB) System.out.println(numA);
        else System.out.println(numB);
    }
}