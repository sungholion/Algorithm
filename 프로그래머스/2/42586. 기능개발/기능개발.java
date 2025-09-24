import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> list = new ArrayList<>();
        Queue<Integer> q = new ArrayDeque<>();
        for(int i = 0; i < progresses.length; i++){
            int time = (100 - progresses[i]) / speeds[i];
            if((100 - progresses[i]) % speeds[i] != 0) time++;
            q.offer(time);
        }
        
        int totalDay = q.poll(); // 첫 작업까지 필요한 시간
        int cnt = 1;
        while(!q.isEmpty()){
            int day = q.poll();
            if(totalDay < day){
                list.add(cnt);
                cnt = 1; // 그룹 초기화
                totalDay = day;
            } else {
                cnt++;
            }
        }
        list.add(cnt);
        
        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++)
            answer[i] = list.get(i);
        return answer;
    }
}