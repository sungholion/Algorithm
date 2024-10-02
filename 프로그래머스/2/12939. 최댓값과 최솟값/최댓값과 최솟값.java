class Solution {
    public String solution(String s) {
        String answer = "";
        String[] numbers = s.split(" ");
        
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        
        for(int i=0; i < numbers.length; i++){
            int n = Integer.parseInt(numbers[i]);
            
            if(n > max){
                max = n;
            }
            
            if( n < min){
                min = n;
            }
        }
        
        answer = min + " " + max;
        
        return answer;
    }
}