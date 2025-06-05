import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        Map<String, Double> map = new HashMap<>();
        map.put("A+", 4.5);
        map.put("A0", 4.0);
        map.put("B+", 3.5);
        map.put("B0", 3.0);
        map.put("C+", 2.5);
        map.put("C0", 2.0);
        map.put("D+", 1.5);
        map.put("D0", 1.0);
        map.put("F", 0.0);

        int N = 20;
        double value_sum = 0;
        double sum = 0;
        while(N-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            double value = Double.parseDouble(st.nextToken());
            String grade = st.nextToken();

            if(grade.equals("P"))
                continue;

            value_sum += value;
            sum += value * map.get(grade);
        }

        sb.append(sum/value_sum).append("\n");

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}