import java.io.*;
import java.util.*;

class Person{
    int kg;
    int cm;
    int rank;

    Person(int kg, int cm){
        this.kg = kg;
        this.cm = cm;
        this.rank = 1;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Person[] persons = new Person[N];

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int kg = Integer.parseInt(st.nextToken());
            int cm = Integer.parseInt(st.nextToken());
            persons[i] = new Person(kg, cm);
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(persons[i].cm < persons[j].cm && persons[i].kg < persons[j].kg){
                    persons[i].rank++;
                }
            }
        }

        for(int i = 0; i < N; i++){
            sb.append(persons[i].rank).append(" ");
        }

        System.out.print(sb.toString());
    }
}
