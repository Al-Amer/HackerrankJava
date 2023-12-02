package java.ObjectOrientProgramming.JavaInheritance2;

/* Java Inheritance
Take a look at the following java code:

class Solution{

    public static void main(String []argh){
        Adder X=new Adder();
        System.out.println("My superclass is: "+X.getClass().getSuperclass().getName());
        System.out.print(X.add(10,32)+" "+X.add(10,3)+" "+X.add(10,10)+"\n");

    }
}
The main function in Solution class creates an object of Adder class. Then it prints the name of the class that Adder inherited and calls the add method several times.

Now complete this code so that it outputs the following lines:

My superclass is: Arithmetic
42 13 20
You don't need to write the Solution class. We will append your code with the code given above before running it.

If you need to write more than one class, write them in a single file. Your classes shouldn't be public.

Sample Input

No input.

Sample Output

My superclass is: Arithmetic
42 13 20
*/
class Arithmetic{
    public int add(int num1,int num2){
        int sum = num1+num2;
        return sum;
    }
}
class Adder extends Arithmetic{
    public Adder(){
        System.out.println("My superclass is: "+this.getClass().getSuperclass().getName());
    }
}


public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        Adder adder = new Adder();
        int a = adder.add(10,32);
        int b = adder.add(10,3);
        int c = adder.add(10,10);
        System.out.print(a+" "+b+" "+c);

    }
}

