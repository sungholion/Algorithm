class Solution {
    public int solution(int[] array) {
        int answer = 0;
        
        int[] cnt = new int[1000];
        
        for(int i=0; i<array.length; i++){
            int num = array[i];
            cnt[num]++;
        }
        
        int max = -1;
        for(int i=0; i<1000; i++){
            if(cnt[i] > max){
                max = cnt[i];
                answer = i;
            } 
        }
        

        
        int freq = 0;
        for(int i=0; i<1000; i++){
            if(cnt[i] == max){
                freq++;
            }
            
            if(freq >= 2){
                answer = -1;
                break;
            }
        }
        
        
        return answer;
    }
}