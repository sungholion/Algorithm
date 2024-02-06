import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int n, m;
	static int[] snack;
	static boolean[] isSelected;
	static int max_num = 0;
	
    public static void main(String[] args) throws NumberFormatException, IOException {
        int t = Integer.parseInt(br.readLine());
        
        for(int tc=1; tc<=t; tc++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	n = Integer.parseInt(st.nextToken());
        	m = Integer.parseInt(st.nextToken());
        	st = new StringTokenizer(br.readLine());
        	snack = new int[n];
        	isSelected = new boolean[n];
        	for(int i=0; i<n; i++)
        		snack[i] = Integer.parseInt(st.nextToken());
        	
        	Arrays.sort(snack);
        	
        	max_num = -1;
        	generateSubsetSum(0, -1, 0);
        	
        	bw.write("#" + tc + " ");
        	bw.write(max_num + "\n");
        }
        
        bw.flush();
        bw.close();
        br.close();
        
    }
    
    static void generateSubsetSum(int cnt, int start, int sum) throws IOException {
    	if(sum > m) return;
    	
    	if(cnt == 2) {
    		if(sum > max_num && sum <= m) max_num = sum;
    		return;
    	}
    	
    	for(int i=start+1; i<n; i++) {
    		sum += snack[i];
    		
    		generateSubsetSum(cnt+1, i, sum);
    		sum -= snack[i];
    	}
    }

}
	
