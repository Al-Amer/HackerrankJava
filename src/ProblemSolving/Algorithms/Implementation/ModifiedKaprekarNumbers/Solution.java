/*
A modified Kaprekar number is a positive whole number with a special property. If you square it, then split the number
into two integers and sum those integers, you have the same value you started with.
Consider a positive whole number n and d with digits. We square n to arrive at a number that is either 2*d digits
long or (2*d)-1 digits long. Split the string representation of the square into two parts,l and r. The right hand
part, r must be d digits long. The left is the remaining substring. Convert those two substrings back to integers,
add them and see if you get n.
Example
n=5
d=1
First calculate that n^2=25. Split that into two strings and convert them back to integers 2 and 5.
Test 2+5=7!=5, so this is not a modified Kaprekar number. If n=9, still d=1, and n^2=81. This gives us , the original n.
Note: r may have leading zeros.
Here’s an explanation from Wikipedia about the ORIGINAL Kaprekar Number (spot the difference!):
In mathematics, a Kaprekar number for a given base is a non-negative integer, the representation of whose square in
that base can be split into two parts that add up to the original number again. For instance, 45 is a Kaprekar number,
because 45² = 2025 and 20+25 = 45.
 */

package ProblemSolving.Algorithms.Implementation.ModifiedKaprekarNumbers;


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
     * Complete the 'kaprekarNumbers' function below.
     *
     * The function accepts following parameters:
     *  1. INTEGER p
     *  2. INTEGER q
     */

    public static void kaprekarNumbers(int p, int q) {
        // Write your code here
        List<Integer>resultList = new ArrayList<>();
        if (p>q){
            System.out.println("INVALID RANGE");
        }else{
            for (int i=p;i<=q;i++){
                Long nElement = (long) i*i;
                if (nElement < 10) {
                    if (nElement == i) {
                        resultList.add(i);
                    }
                }else{
                        String str = String.valueOf(nElement);
                        if (str.length() ==2){
                            int re1 = Integer.parseInt(String.valueOf(str.charAt(0)));
                            int re2 = Integer.valueOf(String.valueOf(str.charAt(1)));
                            if((re1+re2) == i){
                                resultList.add(i);
                            }
                        }else{
                            int strlen = str.length()/2;
                      //      strlen+= str.length()%2;
                            int num1 = Integer.parseInt(str.substring(0,strlen));
                            int num2 = Integer.parseInt(str.substring(strlen,str.length()));
                            if ((num1+num2) == i){
                                resultList.add(i);
                        }
                        }   }   }   }
        if (resultList.size()==0){
            System.out.println("INVALID RANGE");
        }else{
            for (Integer output :resultList ){
                System.out.print(output+" ");
            }   }
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int p = Integer.parseInt(bufferedReader.readLine().trim());

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        Result.kaprekarNumbers(p, q);

        bufferedReader.close();
    }
}



