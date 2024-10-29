class Solution {
    public int[] solution(long n) {
        int[] answer = {};
        String temp = "" + n;
        int l = temp.length();
        
        answer = new int[l];
        for(int i=0; i<l; i++){
            char c = temp.charAt(l-i-1);
            answer[i] = Character.getNumericValue(c);
        }
        
        return answer;
    }
}