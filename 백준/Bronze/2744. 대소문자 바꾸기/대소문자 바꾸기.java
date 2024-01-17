import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String input = sc.nextLine();
		char[] input_array = input.toCharArray();
		String result = "";
		
		for (int i=0; i<input_array.length; i++) {
			if (Character.isLowerCase(input_array[i]))
				result += Character.toUpperCase(input_array[i]);
			else
				result += Character.toLowerCase(input_array[i]);
		}
		
		System.out.println(result);
	}
}