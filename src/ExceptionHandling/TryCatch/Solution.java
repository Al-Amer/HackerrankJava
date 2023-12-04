package Java.ExceptionHandling.TryCatch;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);
        int y,x ;


            try{
                 x = new Integer(scanner.nextInt());
                 y = new Integer(scanner.nextInt());
                System.out.println(x/y);
            }catch (InputMismatchException ex){
                System.out.println(ex.getClass().toString().replaceFirst("class ",""));

            } catch(Exception e){
            System.out.println(e);
        }
        scanner.close();
    }

}
