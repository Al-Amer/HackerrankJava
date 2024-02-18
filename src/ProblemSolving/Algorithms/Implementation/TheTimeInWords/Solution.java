/*
Given the time in numerals we may convert it into words, as shown below:
5:00 -> five o’ clock
5:01 -> one minute past five
5:10 -> ten minute past five
5:15 -> quarter past five
5:30 -> half past five
5:40 -> twenty minutes to six
5:45 -> quarter to six
5:47 -> thirteen minutes to six
5:28 -> twenty eight minutes past five

At minutes = 0, use o’ clock. For 1 <= minutes <= 30, use past,
 and for 30 < minutes use to. Note the space between the apostrophe and clock in o’ clock.
 Write a program which prints the time in words for the input given in the format described.



 */

package ProblemSolving.Algorithms.Implementation.TheTimeInWords;


import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'timeInWords' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. INTEGER h
     *  2. INTEGER m
     */

    public static String timeInWords(int h, int m) {
        // Write your code here
        String[] oclock = {"zero","one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven",
                "twelve","thirteen", "fourteen", "quarter", "sixteen", "seventeen", "eighteen", "nineteen", "twenty", };
        String result = "";
        if (m == 00){
            result =oclock[(h)]+ " o' clock";
        }else if (m == 15 ){
        result = "quarter past "+oclock[h];
        }else if (m == 30 ){
        result = "half past "+oclock[h];
        }else if (m == 45 ){
            result = "quarter to "+oclock[h+1];
        }else if(m <20){
            if (m==1){
                result = oclock[m]+" minute past "+oclock[h];
            }else {
                result = oclock[m]+" minutes past "+oclock[h];}
        }else if (m >20 && m<30){
                String str = String.valueOf(m);
                int str1= Integer.parseInt(String.valueOf(str.charAt(0)));
                int str2 = Integer.parseInt(String.valueOf(str.charAt(1)));
                 result = oclock[20]+" "+oclock[str2]+" minutes past "+oclock[h];
        }else if (m > 30){
               int nm = 60 - m ;
               if (nm <20){
                   if (nm ==1){
                       result = oclock[nm]+" minute to "+oclock[h+1];
                   }else{
                       result = oclock[nm]+" minutes to "+oclock[h+1];}
               } else if (nm >20) {
                    String str = String.valueOf(nm);
                    int str1= Integer.parseInt(String.valueOf(str.charAt(0)));
                    int str2 = Integer.parseInt(String.valueOf(str.charAt(1)));
                    result = oclock[20]+" "+oclock[str2]+" minutes to "+oclock[h+1];}}
        return result;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
 //       BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int h = Integer.parseInt(bufferedReader.readLine().trim());

        int m = Integer.parseInt(bufferedReader.readLine().trim());

        String result = Result.timeInWords(h, m);

//        bufferedWriter.write(result);
//        bufferedWriter.newLine();

        bufferedReader.close();
//        bufferedWriter.close();
        System.out.println(result);

    }
}


