class Solution {
    public int solution(int n) {
        int answer = 0;
        String str = "";
        while(n != 0){
            int x = n % 3;
            n /= 3;
            str += x;
        }
        System.out.print(str);
        int base = 0;
        for(int i = str.length() - 1; i >= 0; i--){
            int x = str.charAt(i) - '0';
            answer += x * Math.pow(3, base++);
        }
        return answer;
    }
}