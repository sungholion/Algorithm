class Solution {
    public int solution(String name) {
        int answer=0;
        int len = name.length();
        int move = len-1; // 좌우이동횟수
        
        for(int i=0; i<len;i++){
            // 상하이동
            if(name.charAt(i)<'N'){
                answer += name.charAt(i)-'A';
            }else{
                answer += 'Z' - name.charAt(i)+1;
            }
            
            // A의 마지막 위치구함
            int conA = i+1;
            while(conA <len && name.charAt(conA) =='A'){
                conA++;
            }
			// 좌우이동
            move = Math.min(move, i+(len-conA)+Math.min(i,len-conA));
        }
        
        return answer+move;
    }
}

