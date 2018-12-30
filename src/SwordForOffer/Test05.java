package SwordForOffer;

/**
 * Created by apple on 12/29/18.
 */
public class Test05 {
    public static int replaceBlank(char[] data, int oldLen) {
        int newLen = oldLen;
        for (int i = 0; i < oldLen; i++) {
            if (data[i] == ' ') {
                newLen += 2;
            }
        }
        if (data == null || oldLen == 0 || data.length < newLen) {
            return -1;
        }

        int iOld = oldLen - 1;
        int iNew = newLen - 1;
        while (iOld >= 0 && iOld != iNew) {
            if (data[iOld] == ' ') {
                data[iNew--] = '0';
                data[iNew--] = '2';
                data[iNew--] = '%';
            }
            else {
                data[iNew--] = data[iOld];
            }
            iOld--;

        }
        return newLen;
    }

    public static void main(String[] args){
        char[] predata = "We are happy.".toCharArray();
        char[] data = new char[20];
        for(int i=0;i<predata.length;i++)
            data[i] = predata[i];
        System.out.println(data);
        replaceBlank(data,13);
        System.out.println(data);
    }


}
