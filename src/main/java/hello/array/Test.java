package hello.array;

/**
 * Created by scnyig on 7/24/2017.
 * http://wiki.jikexueyuan.com/project/for-offer/question-thirty-six.html
 */
public class Test {
    /**
     * Single Number
     * http://wiki.jikexueyuan.com/project/for-offer/question-forty.html
     * 异或这个操作符，位操作符
     */
    public boolean isBitIndex(int num, int index) {
        num >>>= index;
        return (num&1) == 1;
    }

    public int findDifferentBit(int num) {
        int index = 0;
        while ((num&1) == 0&&index<32) {
            index++;
            num>>>=1;
        }
        return index;
    }

    public int[] singleNumber(int[] data) {
        if (data == null || data.length == 0) {
            return new int[]{};
        }

        int result = 0;
        for (int i =0;i< data.length;i++) {
            result ^= data[i];
        }

        int[] resultInt = new int[2];
        int bitIndex = findDifferentBit(result);
        for (int j = 0; j < data.length;j++) {
            if (isBitIndex(data[j],bitIndex)) {
                resultInt[0] ^= data[j];
            }else {
                resultInt[1] ^= data[j];
            }
        }

        return resultInt;
    }
}
