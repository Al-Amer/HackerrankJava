package Java.JavaTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Result {

    /*
     * Complete the 'typeCounter' function below.
     *
     * The function accepts STRING sentence as parameter.
     */

    public static void typeCounter(String sentence) {

        String[] firstMultipleInput = sentence.replaceAll("\\s+$", "").split(" ");
        int intnummer =0 ;
        int doublenum = 0;
        int stringnumer =0;
        for (int i =0; i<firstMultipleInput.length;i++){
            if (firstMultipleInput[i].matches("\\d+")) {
                intnummer++;
            } else if (firstMultipleInput[i].matches("\\d*[.]\\d+")) {
                doublenum++;
            }else{
                stringnumer++;
            }

        }
        System.out.println("string"+ stringnumer+"\ninteger"+intnummer+"\ndouble"+doublenum);

    }

}
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String sentence = bufferedReader.readLine();

        Result.typeCounter(sentence);

        bufferedReader.close();
    }
}
