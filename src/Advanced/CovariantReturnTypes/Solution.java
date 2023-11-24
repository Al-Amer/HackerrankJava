/*
Java allows for Covariant Return Types, which means you can vary your return type as long you are returning a subclass of your specified return type.
Method Overriding allows a subclass to override the behavior of an existing superclass method and specify a return type that is some subclass of the original return type. It is best practice to use the @Override annotation when overriding a superclass method.
Implement the classes and methods detailed in the diagram below:
 */

package Advanced.CovariantReturnTypes;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.annotation.Target;

//Complete the classes below

class Flower {
    public String whatsYourName(){
        return "I have many Name and type";
    }
}

class Jasmine extends Flower {
    @Override
    public String whatsYourName() {
        return "Jasmine";
    }
}

class Lily extends Flower {
    @Override
    public String whatsYourName() {
        return "Lily";
    }
}
/*
// Solution 2
class Region {
    Flower flower;
    public Flower yourNationalFlower(){
        return flower;
    }
}

class WestBengal extends Region{
    Flower flower;
    @Override
    public Flower yourNationalFlower(){
        flower = new Jasmine();
        return flower;
    }
}

class AndhraPradesh extends Region{
    Flower flower;

    @Override
    public Flower yourNationalFlower() {
         flower = new Lily();
        return  flower;
    }
}

 */
// Solution 1
class Region {
    public Flower yourNationalFlower(){
        return new Flower();
    }
}

class WestBengal extends Region{
    @Override
    public Flower yourNationalFlower(){
        return new Jasmine();
    }
}

class AndhraPradesh extends Region{
    @Override
    public Flower yourNationalFlower() {
       return new Lily();
    }
}
public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine().trim();
        Region region = null;
        switch (s) {
            case "WestBengal":
                region = new WestBengal();
                break;
            case "AndhraPradesh":
                region = new AndhraPradesh();
                break;
        }
        Flower flower = region.yourNationalFlower();
        System.out.println(flower.whatsYourName());
    }

}
