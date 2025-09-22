class Solution {
    public int solution(int n) {
        StringBuilder sb = new StringBuilder();
        while(n >= 3){
            sb.append(n % 3);
            n /= 3;
        }
        sb.append(n);
        
        String str = sb.toString();
        System.out.print(str);
        int sum = 0;
        int mul = 1;
        for(int i=str.length()-1; i>=0; i--){
            int num = str.charAt(i) - '0';
            sum += num * mul;
            mul *= 3;
        }
        
        return sum;
    }
}