package hello.recurisive;

/**
 * Created by scnyig on 10/31/2017.
 */
public class ReverseWordsInSentence {
    public String reverse(String str){
        char[] array = str.toCharArray();
        for(int i = 0;i<(array.length)/2;i++){
            char temp = array[i];
            array[i] = array[array.length-1-i];
            array[array.length-i-1]=temp;
        }
        return String.valueOf(array);
    }
    public void reverseSentence(String sentence){
        if(sentence == null)
            return;
        String sentenceReverse = reverse(sentence);
        String[] splitStrings = sentenceReverse.split(" ");
        String resultBuffer = "";
        for(String s:splitStrings)
            resultBuffer = resultBuffer+reverse(s)+" ";
        System.out.println(resultBuffer);
    }

    /*****反转单个字符串函数****/
    public char[] reverseStr(char[] StrArr, int start, int end) {
        if (StrArr == null)
            return null;

        while(start < end)
        {
            char temp = StrArr[start];
            StrArr[start ++] = StrArr[end];
            StrArr[end --]   = temp;
        }

        return StrArr;
    }

    /** 根据单词进行反转
     *  策略是先反转整个字符串，在根据空格划分单词，然后依次反转每个单词*/
    public String reverseAll(String dataStr) {
        if(dataStr == null || dataStr.length() == 0)
            return dataStr;

        char[] dataArr = dataStr.toCharArray();

        //反转整个字符串
        int start = 0;
        int end = dataStr.length() - 1;

        reverseStr(dataArr, start, end);

        //类似于双指针法，根据空格划分单词
        start = end = 0;

        while(start < dataStr.length()) {
            //如果start为空格，则跳过它不把它识别为单词的一部分
            if(dataArr[start] == ' ')
            {
                start ++;
                end ++;
            }
            //当end指针移到字符串数组末尾，或者当前为空格，则start指针到end指针之间构成一个单词
            else if(end == dataStr.length() || dataArr[end] == ' ')
            {
                //注意end已经对应单词末尾后面一位，要注意先自减
                reverseStr(dataArr, start, --end);
                //开始识别下一个单词
                start = ++ end;
            }
            else
            {
                //此为一般情况，end指针一直后移
                end++;
            }
        }

        return new String(dataArr);
    }
}
