import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;
import  java.util.*;

class Node implements Comparable<Node>{
    int A;
    int B;
    int val;

    Node(int A, int B, int val){
        this.A = A;
        this.B = B;
        this.val = val;
    }

    @Override
    public int compareTo(Node a){
        int val = a.val;

        if(this.val > val)
            return 1;
        else
            return -1;

    }

}

public class Main
{
    static int V, E;
    static List<Node> list = new ArrayList<>();
    static int[] parent;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        StringTokenizer st = new StringTokenizer(br.readLine());
        StringTokenizer st;

//        V = Integer.parseInt(st.nextToken());
//        E = Integer.parseInt(st.nextToken());

          V = Integer.parseInt(br.readLine());
          E = Integer.parseInt(br.readLine());

        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int val = Integer.parseInt(st.nextToken());
            list.add(new Node(A, B, val));
        }

        Collections.sort(list);

        int sum = 0;
        parent = new int[V+1];
        for(int i=1; i<=V; i++){
            parent[i] = i;
        }

        for(Node a : list){
            int A = a.A;
            int B = a.B;
            int val = a.val;

            if(find(A) == find(B))
                continue;

            sum += val;
            union(A, B);
        }

        System.out.println(sum);

    }

    static int find(int A){
        if(parent[A] == A)
            return A;
        else
            return find(parent[A]);
    }

    static void union(int A, int B){
        int a = find(A);
        int b = find(B);

        if(a != b)
            parent[b] = a;
    }

}