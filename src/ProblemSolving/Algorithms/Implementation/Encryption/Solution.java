/*
An English text needs to be encrypted using the following encryption scheme.
First, the spaces are removed from the text. Let L be the length of this text.
Then, characters are written into a grid, whose rows and columns have the following constraints:
[√L] <= row <= column <= [√L] , where [x] is the floor function and [x] is ceil function
Example
s = if man was meant to stay on the ground god would have given us roots
After removing spaces, the string is 54 characters long. √54 is between 7 and 8, so it is written in the form of
a grid with 7 rows and 8 columns.
 */

package ProblemSolving.Algorithms.Implementation.Encryption;


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
     * Complete the 'encryption' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String encryption(String s) {
        // Write your code here
        double strLength = s.length();
     String resultString = "";
        int rowMax = (int) Math.ceil(Math.sqrt(strLength));
        int columMin = (int) Math.floor(Math.sqrt(strLength));
        List<String>worlds = new ArrayList<>();
        int slength = 0;
        int floop =0;
        String neWo = "";
        for (int i=0; i<strLength;i++){
            if ((i+1)== strLength){
                neWo+= s.charAt(i);
                worlds.add(neWo);
            }else if (floop != columMin){
               neWo+= s.charAt(i);
               floop++;
           } else if (floop == columMin) {
               neWo+= s.charAt(i);
               worlds.add(neWo);
               neWo="";
               floop=0;
           }
        }
        for(int a =0; a<rowMax;a++){
            for (int ls=0; ls< worlds.size();ls++){
                if (a < worlds.get(ls).length()){
                    resultString+= worlds.get(ls).charAt(a);
            }
           }
            resultString+=" ";
        }

        return resultString;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.encryption(s);

//        bufferedWriter.write(result);
//        bufferedWriter.newLine();

        bufferedReader.close();
//        bufferedWriter.close();

        System.out.println(result);

    }
}


