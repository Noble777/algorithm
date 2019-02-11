package SwordForOffer;

/**
 * 1. 字符串表达的数字上模拟加法
 * 2. 如何在每一次增加1之后快速判断是不是到了最大的n位数
 * 3. 如何打印用字符串表示的数字
 */
public class Test17 {
    public static void printNum(int n) {
        if (n <= 0) {
            return;
        }
        StringBuilder number = new StringBuilder(n);
        for (int i = 0; i < n; i++) {
            number.append('0');
        }

        while(increment(number)) {
            printNumber(number);
        }
    }

    public static boolean increment(StringBuilder str) {
        for(int i=str.length()-1;i>=0;i--){
            if(str.charAt(i)<'9' && str.charAt(i)>='0'){
                str.setCharAt(i,(char)(str.charAt(i)+1));
                return true;
            }
            else if(str.charAt(i)=='9'){
                str.setCharAt(i,'0');
            }
            else{
                return false;
            }
        }
        return false;
    }

    public static void printNumber(StringBuilder number) {
        boolean flag = false;
        for(int i = 0; i < number.length(); i++){
            if(flag)
                System.out.print(number.charAt(i));
            else{
                if(number.charAt(i) != '0'){
                    flag = true;
                    System.out.print(number.charAt(i));
                }
            }
        }
        System.out.println();
    }

    // 第二个思路就是n位所有的十进制数就是n个从0到9的全排列
    public static void printNum2(int n) {
        if (n <= 0) {
            return;
        }
        StringBuilder number = new StringBuilder(n);
        for (int i = 0; i < n; i++) {
            number.append('0');
        }

        for (int i = 0; i < 10; i++) {
            number.setCharAt(0, (char) (i + '0'));
            printToMaxRecursively(number, n, 0);
        }
    }

    public static void printToMaxRecursively(StringBuilder number, int n, int index) {
        if (index == n - 1) {

            printNumber(number);
            return;
        }
        for (int i = 0; i < 10; i++) {

            number.setCharAt(index + 1, (char)(i + '0'));
            printToMaxRecursively(number, n, index + 1);
        }
    }
    

    public static void main(String[] args) {
        printNum2(3);
    }
}
