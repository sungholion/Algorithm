import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.ListIterator;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for(int loop=0; loop<T; loop++) {
            String str = br.readLine();

            LinkedList<Character> list = new LinkedList<>();
            ListIterator<Character> it = list.listIterator();
            
            for(int i=0; i<str.length(); i++) {
                char x = str.charAt(i);

                if(x == '<') {
                    if(it.hasPrevious()) {
                        it.previous();
                    }
                }
                else if(x == '>') {
                    if(it.hasNext()) {
                        it.next();
                    }
                }
                else if(x == '-') {
                    if(it.hasPrevious()) {
                        it.previous();
                        it.remove();
                    }
                }
                else {
                    it.add(x); // '-'가 아니면 현재 커서 위치에 문자 추가
                }
            }

            for(char c : list) bw.write(c);
            bw.write("\n");
        }

        bw.flush();
        bw.close();
        br.close();

    }
}
