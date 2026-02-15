import java.io.*;
import java.util.*;

public class Main {
    
    static int[] parent;
    
    static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }
    
    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        
        if (a != b) parent[b] = a;
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }
        
        st = new StringTokenizer(br.readLine());
        int truthCount = Integer.parseInt(st.nextToken());
        
        int[] truth = new int[truthCount];
        for (int i = 0; i < truthCount; i++) {
            truth[i] = Integer.parseInt(st.nextToken());
        }
        
        List<List<Integer>> parties = new ArrayList<>();
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int count = Integer.parseInt(st.nextToken());
            
            List<Integer> party = new ArrayList<>();
            
            for (int j = 0; j < count; j++) {
                party.add(Integer.parseInt(st.nextToken()));
            }
            
            parties.add(party);
            
            for (int j = 1; j < party.size(); j++) {
                union(party.get(0), party.get(j));
            }
        }
        
        int answer = 0;
        
        for (List<Integer> party : parties) {
            boolean canLie = true;
            
            for (int person : party) {
                for (int t : truth) {
                    if (find(person) == find(t)) {
                        canLie = false;
                        break;
                    }
                }
                if (!canLie) break;
            }
            
            if (canLie) answer++;
        }
        
        System.out.println(answer);
    }
}
