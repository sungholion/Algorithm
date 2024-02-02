import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine()); // test case 입력
		
		for(int test_case = 1; test_case<=t; test_case++) {
			char[] num = br.readLine().toCharArray();	// 메모리 원래 값 입력
			char[] setZero = new char[num.length];	// 초기화 값
			for(int i=0; i<num.length; i++)
				setZero[i] = '0';
			
			int cnt = 0;
			for(int i=0; i<setZero.length; i++) {
				if(setZero.equals(num))
					break;
				if(setZero[i] != num[i]) {
					cnt++;
					for(int j=i; j<setZero.length; j++) {
						setZero[j] = num[i];
					}
				}
			}
			
			System.out.println("#" + test_case + " " + cnt);
		}
	}
}

