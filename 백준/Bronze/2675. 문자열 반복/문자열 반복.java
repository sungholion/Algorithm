import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();	//test case 개수 입력
		sc.nextLine();	// /n 문자 삭제
		
		for (int i=0; i<t; i++) {
			String n_word = sc.nextLine();	//숫자와 문자 동시에 입력받고
			int n = Character.getNumericValue(n_word.charAt(0));	//숫자 분리
			
			
			for (int k=2; k<n_word.length(); k++) {	//숫자만큼 문자 반복
				for (int j=0; j<n; j++) {
					System.out.print(n_word.charAt(k));
				}
			}
			System.out.println();
		}
	}
}
