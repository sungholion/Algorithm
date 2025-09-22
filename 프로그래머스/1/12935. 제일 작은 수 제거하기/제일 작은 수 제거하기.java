class Solution {
    public int[] solution(int[] arr) {
        if(arr.length == 1) return new int[]{-1};
        int[] answer = new int[arr.length-1];
        int min = Integer.MAX_VALUE;
        int minIdx = -1;
        for(int i=0; i<arr.length; i++){
            if(min > arr[i]){
                min = arr[i];
                minIdx = i;
            }
        }
        for(int i=0; i<minIdx; i++){
            answer[i] = arr[i];
        }
        for(int i=minIdx+1; i<arr.length; i++)
            answer[i-1] = arr[i];
        
        return answer;
    }
}