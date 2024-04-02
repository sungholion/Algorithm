import java.io.*;
import java.util.*;

public class Main {
	static long[] wave = new long[101];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i< 101; i++)
			wave[i] = -1;
		
		wave[0] = 0L;
		wave[1] = 1L;
		wave[2] = 1L;
		wave[3] = 1L;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int loop = 0; loop < T; loop++) {
			int n = Integer.parseInt(br.readLine());
			bw.write(waveHalf(n)+"\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
	
	static long waveHalf(int n) {
		if(wave[n] == -1)
			wave[n] = waveHalf(n-2) + waveHalf(n-3);
		return wave[n];
	}
}
