 
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
 
public class Main {
    public static void main(String args[]) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
 
        int table[] = new int[n + 1]; 
        int ele[] = new int[n + 1]; 
 
 
        table[1] = 0;
 
        for(int i = 2; i <= n; i++) {
            table[i] = table[i - 1] + 1;
            ele[i] = i - 1;
 
            if (i % 3 == 0 && table[i / 3] + 1 < table[i]) {
                table[i] = table[i / 3] + 1;
                ele[i] = i / 3;
            }
            if (i % 2 == 0 && table[i / 2] + 1 < table[i]) {
                table[i] = table[i / 2] + 1;
                ele[i] = i / 2;
            }
        }
        bw.write(table[n] + "\n");
 
        String str = "";
        
        
        while(n > 0){
            str += n + " ";
            n = ele[n];
        }
 
        bw.write(str);
 
        bw.flush();
        bw.close();
        br.close();
        
    }
}
