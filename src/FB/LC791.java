package FB;

public class LC791 {
    public static String customSortString(String S, String T) {
        int[] count = new int[26];
        // count the char in the T
        for (char c : T.toCharArray()) {
            count[c - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        // sort the char in the T based on the order of S
        for (char c : S.toCharArray()) {
            while (count[c - 'a'] -- > 0) {
                sb.append(c);
            }
        }

        // the char in the T but not in the S
        for (char c = 'a'; c <= 'z'; c++) {
            while (count[c - 'a']-- > 0) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(customSortString("cba","abcd"));
    }
}
