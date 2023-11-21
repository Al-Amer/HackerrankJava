package Advanced.JavaReflection.Attributes;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;

// musst write this solution in Java 7 and Press SubmitCode , becuse in Rund Code you will have a attiction

class Student{
    private String name;
    private String id;
    private String email;
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public String getId() {return id;}
    public void setId(String id) {this.id = id;}
    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}
}


public class Solution {
    public static void main(String[] args) throws ClassNotFoundException {

 //       Class student = ~~Complete this line~~;
       // Class student = Student.class;
        Class student = new Student().getClass();
 //       Method[] methods = ~~Complete this line~~;
      //  Method[] methods = student.getDeclaredMethods();
        Method[] methods = student.getDeclaredMethods();
        ArrayList<String> methodList = new ArrayList<>();
  //      for(~~Complete this line~~){
  //          methodList.add(~~Complete this line~~);
         for(Method me:methods){
             methodList.add(me.getName());
        }
        Collections.sort(methodList);
        for(String name: methodList){
            System.out.println(name);
        }

    }
}
