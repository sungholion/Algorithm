import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String n = "-1";
        String ans = "";
        while(true) {
        	if(n.equals("0"))
        		break;
        	n = br.readLine();
        	
        	ans = "yes";
        	for(int i=0; i<n.length()/2; i++) {
        		if(n.charAt(i) != n.charAt(n.length()-i-1)) {
        			ans = "no";
        			break;
        		}
        	}
        	
        	if(!n.equals("0"))
        		System.out.println(ans);
        	
        }
     
        
        bw.flush();
        bw.close();
        br.close();
    }
}
