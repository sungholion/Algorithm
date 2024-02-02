import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {
	static int[] pw;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int tc = 1; tc <= 10; tc++) {
			int t = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			pw = new int[8];

			for (int i = 0; i < 8; i++)
				pw[i] = Integer.parseInt(st.nextToken());

			int temp = 1;

			int cycle = 1;
			while(true) {
			
				temp = pw[0] - (cycle++);
				if(cycle == 6)
					cycle -= 5;
				if (temp <= 0)
					temp = 0;
				for (int i = 1; i < 8; i++) 
					pw[i - 1] = pw[i];
				pw[7] = temp;
				
				if(temp <=0 )
					break;
			}
        	bw.write("#" + t + " ");
        	for(int i=0; i<8; i++)
        		bw.write(pw[i] + " ");
        	bw.write("\n");
        	
		}
		bw.flush();
		bw.close();
		br.close();
	}
}