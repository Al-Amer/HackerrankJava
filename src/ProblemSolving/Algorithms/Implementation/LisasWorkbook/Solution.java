/*
Lisa just got a new math workbook. A workbook contains exercise problems, grouped into chapters. Lisa believes a
problem to be special if its index (within a chapter) is the same as the page number where it’s located. The format
of Lisa’s book is as follows:
There are n chapters in Lisa’s workbook, numbered from 1 to n.
The ith chapter has arr[i] problems, numbered from 1 to arr[i].
Each page can hold up to k problems. Only a chapter’s last page of exercises may contain fewer than k problems.
Each new chapter starts on a new page, so a page will never contain problems from more than one chapter.
The page number indexing starts at 1.
Given the details for Lisa’s workbook, can you count its number of special problems?
Example
arr = [4, 2]
k = 3
Lisa’s workbook contains arr[1] = 4 problems for chapter 1, and arr[2] = 2 problems for chapter 2. Each page can
hold k = 3 problems.
The first page will hold 3 problems for chapter 1. Problem 1 is on page 1, so it is special. Page 2 contains only
Chapter 1, Problem 4, so no special problem is on page 2. Chapter 2 problems start on page 3 and there are 2 problems.
Since there is no problem 3 on page 3, there is no special problem on that page either. There is 1 special problem
in her workbook.
Note: See the diagram in the Explanation section for more details.
 */

package ProblemSolving.Algorithms.Implementation.LisasWorkbook;


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
     * Complete the 'workbook' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER k
     *  3. INTEGER_ARRAY arr
     */

    public static int workbook(int n, int k, List<Integer> arr) {
        // Write your code here
        int result =0;
        int pagenumber = 0;
        for(int i =0; i<arr.size();i++){
            pagenumber++;
            int element = arr.get(i);
            for (int j =1; j<= element;j++){
                if (j == pagenumber){
                    result++;
                }
                if (j % k == 0 && j < element){
                    pagenumber++;
                }
            }
        }
        return result;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
 //       BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result.workbook(n, k, arr);

//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();

        bufferedReader.close();
//        bufferedWriter.close();
        System.out.println(result);

    }
}


