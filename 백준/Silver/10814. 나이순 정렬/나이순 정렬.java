import java.io.*;
import java.util.*;

class Member{
    int age;
    String name;

    Member(int age, String name){
        this.age = age;
        this.name = name;
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Member[] members = new Member[N];
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken(); 
            members[i] = new Member(age, name);
        }

        Arrays.sort(members, (a, b) -> a.age - b.age);

        for(Member m : members)
            sb.append(m.age).append(" ").append(m.name).append("\n");
        System.out.println(sb.toString());
    }
}