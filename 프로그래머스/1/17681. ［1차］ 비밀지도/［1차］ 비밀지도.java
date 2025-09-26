class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for(int i=0; i<n; i++){
            int num = arr1[i] | arr2[i];
            String binary = Integer.toBinaryString(num);
            
            while(binary.length() < n) binary = 0 + binary;
            binary = binary.replace('0', ' ');
            binary = binary.replace('1', '#');
            answer[i] = binary;
        }
        return answer;
      
    }
}