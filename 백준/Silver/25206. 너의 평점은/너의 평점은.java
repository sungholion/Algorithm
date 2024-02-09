import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        double total = 0;
        double cnt = 0;
        for (int tc = 0; tc < 20; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            st.nextToken();
            double score = Double.parseDouble(st.nextToken());
            String grade = st.nextToken();
            if (grade.equals("A+")) {

                total += score * 4.5;
                cnt+= score;
            } else if (grade.equals("A0")) {
                total += score * 4.0;
                cnt+= score;
            } else if (grade.equals("B+")) {
                total += score * 3.5;
                cnt+= score;
            } else if (grade.equals("B0")) {
                total += score * 3.0;
                cnt+= score;
            } else if (grade.equals("C+")) {
                total += score * 2.5;
                cnt+= score;
            } else if (grade.equals("C0")) {
                total += score * 2.0;
                cnt+= score;
            } else if (grade.equals("D+")) {
                total += score * 1.5;
                cnt+= score;
            } else if (grade.equals("D0")) {
                total += score * 1.0;
                cnt+= score;
            } else if (grade.equals("F")) {
                total += score * 0.0;
                cnt+= score;
            }


        }
        System.out.printf("%.6f", total/cnt);
    }
}