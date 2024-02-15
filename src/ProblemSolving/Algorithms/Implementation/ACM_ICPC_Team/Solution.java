/*
There are a number of people who will be attending ACM-ICPC World Finals. Each of them may be well versed in a number
of topics. Given a list of topics known by each attendee, presented as binary strings, determine the maximum number
of topics a 2-person team can know. Each subject has a column in the binary string, and a '1' means the subject is
known while '0' means it is not. Also determine the number of teams that know the maximum number of topics. Return
an integer array with two elements. The first is the maximum number of topics known, and the second is the number of
teams that know that number of topics.
Example
n=3
topic=['10101','11110','00010']
The attendee data is aligned for clarity below:
 */
package ProblemSolving.Algorithms.Implementation.ACM_ICPC_Team;


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
     * Complete the 'acmTeam' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts STRING_ARRAY topic as parameter.
     */

    public static List<Integer> acmTeam(List<String> topic) {
        // Write your code here
        Map<List<Integer>,Integer> map= new LinkedHashMap<>();
        for(int i=0;i<topic.size()-1;i++){
            for(int j=i+1;j<topic.size();j++){
                int index=0;
                int count=0;
                while(index<topic.get(j).length()){
                    if(topic.get(i).charAt(index)=='0' && topic.get(j).charAt(index)=='0'){
                        index++;
                    }else{
                        count++;
                        index++;
                    }
                }
                map.put(Arrays.asList(i+1,j+1),count);
            }
        }

        int max=map.entrySet().stream().max((a,b)->a.getValue().compareTo(b.getValue())).get().getValue();
        int maxGroup= (int)map.entrySet().stream().filter(e->e.getValue()==max).count();
        return Arrays.asList(max,maxGroup);

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//         BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<String> topic = IntStream.range(0, n).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .collect(toList());

        List<Integer> result = Result.acmTeam(topic);
/*
        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );
*/
        bufferedReader.close();
 //       bufferedWriter.close();
        System.out.println(result);
    }
}


