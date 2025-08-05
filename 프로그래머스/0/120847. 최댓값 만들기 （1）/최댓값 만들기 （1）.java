class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        for(int i=0; i<numbers.length-1; i++){
            for(int j=i+1; j<numbers.length; j++){
                int temp = numbers[i] * numbers[j];
                if(answer < temp)
                    answer = temp;
            }
        }
        return answer;
    }
}