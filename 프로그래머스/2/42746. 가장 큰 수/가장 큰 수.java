import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        StringBuilder sb = new StringBuilder();
        String[] arr = new String[numbers.length];
        for(int i=0; i<arr.length; i++)
            arr[i] = String.valueOf(numbers[i]);

        Arrays.sort(arr,(a, b) -> (b+a).compareTo(a+b)
        );
        
        for(String s : arr)
            sb.append(s);
        
        if(arr[0].equals("0")) return "0";
        
        return sb.toString();
    }
}