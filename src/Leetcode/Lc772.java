import java.util.Stack;

/**
 * Created by apple on 18/10/3.
 */
public class Lc772 {
    public int calculate(String s) {
        Stack<Integer> numb = new Stack<>();
        Stack<Character> operator = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // ' ' blank
            if (c == ' ') {
                continue;
            }

            // number
            if (Character.isDigit(c)) {
                int num = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + s.charAt(i++) - '0';
                }
                numb.push(num);
                i--;
                continue;
            }

            if (c == ')') {
                while (operator.peek() != '(') {
                    calculate(numb, operator.pop());
                }
                operator.pop();
                continue;
            }

            if (c == '+' || c == '-') {
                while (!operator.isEmpty() && operator.peek() != '(') {
                    calculate(numb, operator.pop());
                }
            } else if (c == '*' || c == '/') {
                while (!operator.isEmpty() && operator.peek() != '(' && operator.peek() != '+' && operator.peek() != '-') {
                    calculate(numb, operator.pop());
                }
            }
            operator.push(c);

        }

        while (!operator.isEmpty()) {
            calculate(numb, operator.pop());
        }
        return numb.pop();
    }

    public void calculate(Stack<Integer> numb, char ope) {
        int num1 = numb.pop();
        int num2 = numb.pop();

        if (ope == '+') {
            numb.push(num2 + num1);
        }
        else if (ope == '-') {
            numb.push(num2 - num1);
        }
        else if (ope == '*') {
            numb.push(num2 * num1);
        }
        else if (ope == '/') {
            numb.push(num2 / num1);
        }
    }

}
