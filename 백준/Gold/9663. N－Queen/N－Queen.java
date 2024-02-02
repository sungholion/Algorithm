import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static int n;
	static int cnt;
	static int[] arr;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        
        nqueens(0);
        System.out.println(cnt);
        
    }
    
    static void nqueens(int d) {
    	if(d == n) {
    		cnt++;
    		return;
    	}
    	
    	for(int i=0; i<n; i++) {
    		arr[d] = i;
    		
    		if(promising(d)) {
    			nqueens(d+1);
    		}
    	}
    }
    
    static boolean promising(int col) {
    	for(int i=0; i< col; i++) {	// 같은 열
    		if(arr[col] == arr[i]) return false;
    		else if(Math.abs(col-i) == Math.abs(arr[col] - arr[i])) return false;
    	}
    	return true;
    }
}