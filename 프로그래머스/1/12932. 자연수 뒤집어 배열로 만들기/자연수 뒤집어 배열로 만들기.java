class Solution {
    public int[] solution(long n) {
        String str = String.valueOf(n);
        int len = str.length();
        int[] answer = new int[len];
        
        System.out.println(str);
        for(int i = 0; i < len; i++){
            answer[i] = str.charAt(len - 1 - i) - '0';
        }
        return answer;
    }
}