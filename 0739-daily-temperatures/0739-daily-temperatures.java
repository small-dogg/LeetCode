import java.util.*;

class Solution {

    class Temp{
        int idx;
        int temp;

        public Temp(int idx, int temp) {
            this.idx = idx;
            this.temp = temp;
        }
    }
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n];
        Stack<Temp> stack = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty()) {
                if (stack.peek().temp > temperatures[i]){
                    answer[i] = stack.peek().idx-i;
                    break;
                }else{
                    stack.pop();
                }
            }

            if (stack.isEmpty()) answer[i] = 0;
            stack.push(new Temp(i,temperatures[i]));
        }

        return answer;
    }
}
