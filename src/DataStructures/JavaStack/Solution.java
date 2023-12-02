package java.DataStructures.JavaStack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

        public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                while (sc.hasNext()) {
                        String input=sc.next();
                        if (input.isEmpty())
                                break;
                        //Complete the code
                        String[] str = input.split("");
                        ArrayList<String> inputInArray = new ArrayList<>(Arrays.asList(str));
                        int arrayLength = inputInArray.size()-1;
                      //  int i = 0 ;
                        while (arrayLength>=0){
                               // int o =
                                for(int i = 0; i<arrayLength; i++ ){
                                        if (i != arrayLength) {
                                                if (inputInArray.get(arrayLength).equals(inputInArray.get(i))){
                                                        inputInArray.remove(i);
                                                        inputInArray.remove(arrayLength);
                                                        arrayLength --;
                                                    //    i++;
                                                }
                                        }

                                }arrayLength--;
                        }
                        if(inputInArray.isEmpty()){
                                System.out.println("true");
                        } else if (inputInArray.size()>0) {
                                System.out.println("false");

                        }

                }sc.close();



        }

}
/*
{}()
({()})
{}(
[]
 */