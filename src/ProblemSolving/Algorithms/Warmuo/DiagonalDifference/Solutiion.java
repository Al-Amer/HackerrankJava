package ProblemSolving.Algorithms.Warmuo.DiagonalDifference;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class Result{

    public static int diagonalDifference(List<List<Integer>> arr) {
        int matrex_1 =0;
        int matrex_2 =0;
        for(int i =0; i< arr.size();i++){
            matrex_1+= arr.get(i).get(i);
        }
        int arrSiye = arr.size()-1;
        for (int j =0 ; j< arr.size(); j++){
            matrex_2+= arr.get(j).get(arrSiye);
            arrSiye--;
        }
       return Math.abs(matrex_1 - matrex_2);
    }
}

public class Solutiion {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
      //  BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> arr = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
            try {
                arr.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Result.diagonalDifference(arr);
        //Test
        System.out.println(result);
      //  bufferedWriter.write(String.valueOf(result));
     //   bufferedWriter.newLine();

        bufferedReader.close();
      //  bufferedWriter.close();
    }

}
