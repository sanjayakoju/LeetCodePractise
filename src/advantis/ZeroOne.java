package advantis;

import java.util.Stack;

public class ZeroOne {

    public static int remainingSize(String st) {

        Stack<Character> stack = new Stack<>();
        char ch[] = st.toCharArray();
        for (int i=0;i<ch.length;i++) {
            if(!stack.isEmpty()) {
                if(stack.peek() == '1' && ch[i] == '0') {
                    stack.pop();
                } else if (stack.peek() == '0' && ch[i] == '1') {
                    stack.pop();
                } else {
                    stack.push(ch[i]);
                }
            } else {
                stack.push(ch[i]);
            }
         }
        return stack.size();
    }
    public static void main(String[] args) {
//        String st = "01010";
        String st = "111*000";
        System.out.println(remainingSize(st));
    }
}
