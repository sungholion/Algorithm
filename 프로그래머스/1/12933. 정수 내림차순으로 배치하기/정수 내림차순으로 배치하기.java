import java.util.*;

class Solution {
    public long solution(long n) {
        // 각 자리수를 배열에 하나씩 넣기
        // 배열 정렬
        // 배열에서 하나씩 꺼내서 문자열에 더하기
        // 문자열 long으로 바꾸기
        String str = String.valueOf(n);
        int[] arr = new int[str.length()];
        for(int i=0; i<arr.length; i++)
            arr[i] = str.charAt(i) - '0';
        Arrays.sort(arr);
        
        String temp = "";
        for(int i=arr.length-1; i>= 0; i--)
            temp += arr[i] + "";
        
        long answer = Long.parseLong(temp);
        return answer;
    }
}