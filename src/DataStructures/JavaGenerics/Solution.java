package Java.DataStructures.JavaGenerics;


import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Arrays;

class Printer
{
    //Write your code here
    public static <T extends Comparable<T> > void printArray(T[] a){
        for (T t:a) {
            System.out.println(t);
        }
    }
    /*
    T – Type
    E – Element
    K – Key
    N – Number
    V – Value
     */
}

public class Solution {


    public static void main( String args[] ) {
        Printer myPrinter = new Printer();
        Integer[] intArray = { 1, 2, 3 };
        String[] stringArray = {"Hello", "World"};
        myPrinter.printArray(intArray);
        myPrinter.printArray(stringArray);
        int count = 0;

        for (Method method : Printer.class.getDeclaredMethods()) {
            String name = method.getName();

            if(name.equals("printArray"))
                count++;
        }

        if(count > 1)System.out.println("Method overloading is not allowed!");

    }
}
