import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		int[] tArray = new int[45];
		for(int i=1; i<45; i++) 
			tArray[i] = (i*(i+1))/2; 
		
		while (true) {
			if(t == 0)
				break;
			
			int n = sc.nextInt();
			boolean tri = false;
			
			for(int i=1; i<45; i++) {
				for(int j=1; j<45; j++) {
					for(int k=1; k<45; k++) {
						int tot  = tArray[i] + tArray[j] + tArray[k];
						if (tot == n)
							tri = true;
					}
				}
							
			}
			
			if(tri)
				System.out.println(1);
			else
				System.out.println(0);
			
			tri = false;
			t--;
		}
		
	}
}
