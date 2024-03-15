/*
You are given a 2D matrix of dimension  and a positive integer . You have to rotate the matrix  times and print the
resultant matrix. Rotation should be in anti-clockwise direction.
Rotation of a  matrix is represented by the following figure. Note that in one rotation, you have to shift elements
by one step only.
 */

package ProblemSolving.Algorithms.Implementation.MatrixLayerRotation;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'matrixRotation' function below.
     *
     * The function accepts following parameters:
     *  1. 2D_INTEGER_ARRAY matrix
     *  2. INTEGER r
     */

    public static void matrixRotation(List<List<Integer>> matrix, int r) {
        // Write your code here
        int n = matrix.size();
        int m = matrix.get(0).size();
        int min = Math.min(n, m);
        for (int i=0;i< min/2; i++) {
            int round = r % ((n - 2 * i) * 2 + (m - 2 * i) * 2 - 4);
            int k=0;
            while(k<round){
                int first = i;
                int lastN = n - i - 1;
                int lastM = m - i - 1;
                int temp = matrix.get(first).get(first);
                for (int j = first; j < lastM; j++) {
                    matrix.get(first).set(j, matrix.get(first).get(j + 1));
                }
                for (int j = first; j < lastN; j++) {
                    matrix.get(j).set(lastM, matrix.get(j + 1).get(lastM));
                }
                for (int j = lastM; j > first; j--) {
                    matrix.get(lastN).set(j, matrix.get(lastN).get(j - 1));
                }
                for (int j = lastN; j > first; j--) {
                    matrix.get(j).set(first, matrix.get(j - 1).get(first));
                }
                matrix.get(first + 1).set(first, temp);
                k++;
            }
        }
        for (List list:matrix) {
            for (Object i:list) {
                System.out.print(i+" ");
            }
            System.out.println();
        }

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int m = Integer.parseInt(firstMultipleInput[0]);

        int n = Integer.parseInt(firstMultipleInput[1]);

        int r = Integer.parseInt(firstMultipleInput[2]);

        List<List<Integer>> matrix = new ArrayList<>();

        IntStream.range(0, m).forEach(i -> {
            try {
                matrix.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        Result.matrixRotation(matrix, r);

        bufferedReader.close();
    }
}

