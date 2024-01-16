import java.util.Scanner;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] dwarf = new int[9];
		int sum = 0;
		
		for (int i = 0; i<9; i++) {
			dwarf[i] = sc.nextInt();
			sum += dwarf[i];
		}
			
		for (int i=0; i<8; i++) {
			for (int j = i+1; j<9; j++) {
				int temp = dwarf[i] + dwarf[j];
				if (sum - temp == 100) {
					dwarf[i] = -1;
					dwarf[j] = -1;
					break;
				}
				
			}
			if (dwarf[i] == -1)
				break;
		}
		Arrays.sort(dwarf);
		
		for (int i = 2; i<dwarf.length; i++)
			System.out.println(dwarf[i]);
	}
}
// 합에서. 난쟁이 한명을 기준으로, 나머지를 순회하며 추가로 1명 더 뺐을때 100이 되면 정답
// 정답이 없으면 다음 난쟁이 기준으로 