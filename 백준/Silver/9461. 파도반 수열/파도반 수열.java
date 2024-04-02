import java.io.*;

public class Main {
	static long[] wave = new long[101];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		wave[0] = 0L;
		wave[1] = 1L;
		wave[2] = 1L;
		wave[3] = 1L;
		
		waveHalf();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int loop = 0; loop < T; loop++) {
			int n = Integer.parseInt(br.readLine());
			sb.append(wave[n]+"\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void waveHalf() {
		for(int i = 4; i< 101; i++)
			wave[i] = wave[i-2] + wave[i-3];
	}
}
