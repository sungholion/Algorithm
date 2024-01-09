import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
	
		for(int t = 1; t <= T; t++)
		{
           	double sum = 0;
			for (int cnt = 0; cnt < 10; cnt++)
            {
                int n = sc.nextInt();
                sum += n;
            }
            System.out.printf("#%d %d\n", t, Math.round(sum/10));
		}
	}
}