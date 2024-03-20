import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        parent = new int[n];
        for (int i = 0; i < n; i++)
            parent[i] = i;

        for (int i = 1; i <= m; i++) {
        	
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            a = find(a);
            b = find(b);
            if (a == b) {
                bw.write(i+"");
                break;
            }
            union(a, b);
            if(i == m)
            	bw.write(0+"");
        }
        
        bw.flush();
        bw.close();
        br.close();
        
    }

    static int find(int x) {
        if (parent[x] != x)
            parent[x] = find(parent[x]);

        return parent[x];
    }

    static void union(int a, int b) {
        int A = find(a);
        int B = find(b);

        if(A != B)
            parent[B] = A;
    }
}