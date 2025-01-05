import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        char c1 = str.charAt(0);

        double grade = 0;

        if (c1 == 'A') grade = 4;
        else if (c1 == 'B') grade = 3;
        else if (c1 == 'C') grade = 2;
        else if (c1 == 'D') grade = 1;
        else if (c1 == 'F') {
            grade = 0;
            bw.write(grade + "\n");
            bw.flush();
            bw.close();
            return;
        }

        char c2 = str.charAt(1);
        if (c2 == '+') {
            grade += 0.3;
        } else if (c2 == '-') {
            grade -= 0.3;
        }

        bw.write(grade + "\n");
        bw.flush();
        bw.close();
    }
}
