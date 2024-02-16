import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String alpa = "abcdefghijklmnopqrstuvwxyz";

		int N = Integer.parseInt(br.readLine());
		
		for(int loop=0; loop<N; loop++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String org = st.nextToken();
			String strfry = st.nextToken();
			int[] alpa_cnt_org = new int[26];
			int[] alpa_cnt_strfry = new int[26];
			
			for(int i=0; i<org.length(); i++) {
				for(int j=0; j<alpa.length(); j++) {
					if(org.charAt(i) == alpa.charAt(j)) alpa_cnt_org[j]++;
				}
			}
			
			for(int i=0; i<strfry.length(); i++) {
				for(int j=0; j<alpa.length(); j++) {
					if(strfry.charAt(i) == alpa.charAt(j)) alpa_cnt_strfry[j]++;
				}
			}
			
			int cnt = 0;
			for(int i=0; i<alpa_cnt_org.length; i++) {
				if(alpa_cnt_org[i] == alpa_cnt_strfry[i]) cnt++;
			}
			
			if(cnt == 26) System.out.println("Possible");
			else System.out.println("Impossible");
			
			
			
		}
		
	}
}