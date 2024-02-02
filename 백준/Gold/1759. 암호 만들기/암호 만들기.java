import java.io.*;
import java.util.*;

public class Main {
	static int L, C;
	static char[] input, pw;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		L = Integer.parseInt(st.nextToken()); 
		C = Integer.parseInt(st.nextToken()); 

		pw = new char[L]; // 암호
		input = new char[C]; // 문자의 개수

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < C; i++) 
			input[i] = st.nextToken().charAt(0);
		
		Arrays.sort(input);
		makePw(0, 0);
	}

	public static void makePw(int start, int cnt) {

		if (cnt == L) {
			if (checkCondition(pw)) 
				System.out.println(pw);
			return;
		}
		
		for (int i = start; i < C; i++) {
			pw[cnt] = input[i];
			makePw(i + 1, cnt + 1);
		}
	}

	public static boolean checkCondition(char[] pw) {
		int vow = 0; // 모음
		int con = 0; 

		for (char c : pw) {
			if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') 
				vow++;
			else con++;
		}

		if (vow >= 1 && con >= 2) return true;
		return false;
	}
}
