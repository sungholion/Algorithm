import java.io.*;
import java.util.*;

class Person{
    int age;
    String name;
    int order;

    Person(int age, String name, int order){
        this.age = age;
        this.name = name;
        this.order = order;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        List<Person> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            int order = i;
            list.add(new Person(age, name, order));
        }

        list.sort((a, b) -> {
           if(a.age == b.age) return a.order - b.order;
           return a.age - b.age;
        });

        for(Person p : list) {
            sb.append(p.age).append(" ").append(p.name).append("\n");
        }
        System.out.print(sb);
    }
}