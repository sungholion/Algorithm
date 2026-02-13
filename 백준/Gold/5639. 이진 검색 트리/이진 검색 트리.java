import java.io.*;
import java.util.*;

public class Main {
    static List<Integer> preorder = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;

        while ((str = br.readLine()) != null) {
            preorder.add(Integer.parseInt(str));
        }

        postOrder(0, preorder.size() - 1);

        System.out.print(sb);
    }

    static void postOrder(int start, int end) {

        if (start > end) return;
        int root = preorder.get(start);
        int mid = start + 1;

        while (mid <= end && preorder.get(mid) < root) {
            mid++;
        }

        postOrder(start + 1, mid - 1);
        postOrder(mid, end);
        sb.append(root).append('\n');
    }
}
