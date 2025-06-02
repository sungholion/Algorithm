import java.io.*;
import java.util.*;

class Person{
    int age;
    String name;

    Person(int age, String name){
        this.age = age;
        this.name = name;
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
            p[i] = new Person(Integer.parseInt(st.nextToken()), st.nextToken());
        }

        Arrays.sort(p, new Comparator<Person>(){
            public int compare(Person o1, Person o2){
                return o1.age - o2.age;
            }
        });

        for(int i = 0; i < N; i++){
            sb.append(p[i].age).append(" ").append(p[i].name).append("\n");
        }

        br.close();
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
