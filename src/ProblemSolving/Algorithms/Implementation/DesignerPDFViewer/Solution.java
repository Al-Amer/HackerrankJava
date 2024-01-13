/*
When a contiguous block of text is selected in a PDF viewer,
the selection is highlighted with a blue rectangle. In this PDF viewer,
each word is highlighted independently. For example:
 */


package ProblemSolving.Algorithms.Implementation.DesignerPDFViewer;

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
     * Complete the 'designerPdfViewer' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY h
     *  2. STRING word
     */

    public static int designerPdfViewer(List<Integer> h, String word) {
        // Write your code here
        HashMap<String , Integer>alphbitList = new HashMap<>();
        String[] apList = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
        for (int i=0; i<h.size();i++){
            alphbitList.put(apList[i],h.get(i));
        }

        int size = alphbitList.get(String.valueOf(word.charAt(0)));
        for (int j=0;j<word.length();j++){
            if (size< alphbitList.get(String.valueOf(word.charAt(j)))){
                size = alphbitList.get(String.valueOf(word.charAt(j)));
            }
        }
        return  size * word.length();
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
 //       BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        List<Integer> h = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        String word = bufferedReader.readLine();

        int result = Result.designerPdfViewer(h, word);

 //       bufferedWriter.write(String.valueOf(result));
 //       bufferedWriter.newLine();

        bufferedReader.close();
 //       bufferedWriter.close();

        System.out.println(result);

    }
}



