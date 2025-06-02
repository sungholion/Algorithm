import java.io.*;
import java.util.*;

class Person{
    int weight;
    int height;

    Person(int weight, int height){
        this.weight = weight;
        this.height = height;
    }
}

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        Person[] p = new Person[N];

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            p[i] = new Person(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        for(int i = 0; i < N; i++){
            int cnt = 1;
            for(int j = 0; j < N; j++){
                if((p[i].weight == p[j].weight) && (p[i].height == p[j].height)){
                    continue;   // 같은 원소 비교 x
                } else if((p[i].weight < p[j].weight) && (p[i].height < p[j].height)){
                    cnt++;
                }
            }
            sb.append(cnt).append(" ");

        }

        br.close();
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
