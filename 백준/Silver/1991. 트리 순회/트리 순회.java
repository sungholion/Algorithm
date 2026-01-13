import java.io.*;
import java.util.*;

public class Main {
    static int[][] tree = new int[26][2];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            char p = st.nextToken().charAt(0);
            char l = st.nextToken().charAt(0);
            char r = st.nextToken().charAt(0);

            int idx = p - 'A';

            tree[idx][0] = (l == '.') ? -1 : l - 'A';
            tree[idx][1] = (r == '.') ? -1 : r - 'A';
        }

        preorder(0);
        System.out.println();
        inorder(0);
        System.out.println();
        postorder(0);
    }

    static void preorder(int node){
        if(node == -1) return;
        System.out.print((char)(node + 'A'));
        preorder(tree[node][0]);
        preorder(tree[node][1]);
    }

    static void inorder(int node){
        if(node == -1) return;
        inorder(tree[node][0]);
        System.out.print((char)(node + 'A'));
        inorder(tree[node][1]);
    }

    static void postorder(int node){
        if(node == -1) return;
        postorder(tree[node][0]);
        postorder(tree[node][1]);
        System.out.print((char)(node + 'A'));
    }
}
