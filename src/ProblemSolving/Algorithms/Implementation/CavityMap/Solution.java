/*
You are given a square map as a matrix of integer strings. Each cell of the map has a value denoting its depth.
We will call a cell of the map a cavity if and only if this cell is not on the border of the map and each cell
adjacent to it has strictly smaller depth. Two cells are adjacent if they have a common side, or edge.
Find all the cavities on the map and replace their depths with the uppercase character X.

 */

package ProblemSolving.Algorithms.Implementation.CavityMap;


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
     * Complete the 'cavityMap' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts STRING_ARRAY grid as parameter.
     */

    public static List<String> cavityMap(List<String> grid) {
        // Write your code here
        List<String> ans = new ArrayList<>();

        for(int i = 0; i < grid.size(); i++) {
            StringBuilder row = new StringBuilder();
            for(int j = 0; j < grid.get(i).length(); j++) {
                char currentChar = grid.get(i).charAt(j);

                //Check if it's not at a border
                if(i != 0 && i != grid.size()-1 && j != 0 && j != grid.get(i).length() - 1) {
                    //Check if it's a cavity
                    if(currentChar > grid.get(i).charAt(j-1) && currentChar > grid.get(i).charAt(j+1) && currentChar > grid.get(i-1).charAt(j) && currentChar > grid.get(i+1).charAt(j)) {
                        row.append('X');
                        continue;
                    }
                }
                // If it's not a cavity
                row.append(currentChar);
            }
            ans.add(row.toString()); //adding to the arrayList ans of String
        }
        return ans;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> grid = IntStream.range(0, n).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .collect(toList());

        List<String> result = Result.cavityMap(grid);
/*
        bufferedWriter.write(
                result.stream()
                        .collect(joining("\n"))
                        + "\n"
        );
*/
        bufferedReader.close();
 //       bufferedWriter.close();
        for(String str:result){
            System.out.println(str);
        }
    }
}


