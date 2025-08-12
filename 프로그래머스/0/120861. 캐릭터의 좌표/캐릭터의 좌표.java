class Solution {
    public int[] solution(String[] keyinput, int[] board) {
        int[] answer = new int[2];
        
        int x = 0, y = 0;
        for(int i=0; i<keyinput.length; i++){
            String order = keyinput[i];
            if(order.equals("left")){
                if(x-1 >= -1 * (board[0] / 2))
                    x -= 1;
            } else if(order.equals("right")){
                if(x+1 <= (board[0] / 2))
                    x += 1;
            } else if(order.equals("up")){
                if(y+1 <= (board[1] / 2))
                    y += 1;
            } else{
                if(y-1 >= -1 * (board[1] / 2))
                    y -= 1;
            }
        }
        
        answer[0] = x;
        answer[1] = y;
        return answer;
    }
}