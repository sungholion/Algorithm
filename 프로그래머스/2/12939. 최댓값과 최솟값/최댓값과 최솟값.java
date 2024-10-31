class Solution {
    public String solution(String s) {
        String answer = "";
        
        String[] arr = s.split(" ");
        int min = Integer.parseInt(arr[0]);
        int max = min;
        
        for(int i=1; i<arr.length; i++){
            int num = Integer.parseInt(arr[i]);
            min = Math.min(num, min);
            max = Math.max(num, max);
        }
        
        answer = min + " " + max;
        
        
        return answer;
    }
}