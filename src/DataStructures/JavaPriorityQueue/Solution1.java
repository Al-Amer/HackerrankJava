package java.DataStructures.JavaPriorityQueue;

import java.io.IOException;
import java.util.*;

class Student_1{
    int id;
    String name;
    double cgpa;
    public Student_1(int id, String name, double cgpa){
        this.id=id;
        this.name = name;
        this.cgpa = cgpa;}
    public int getId() {return id;}
    public void setId(int id) {this.id = id;}
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public double getCgpa() {return cgpa;}
    public void setCgpa(double cgpa) {this.cgpa = cgpa;}
}
public class Solution1 {

    public static void main(String[] args) throws IOException {

      //      BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
         PriorityQueue<Student_1> studentQuery = new PriorityQueue<>(
                Comparator.comparing(Student_1::getCgpa).reversed().thenComparing(Student_1::getName).thenComparing(Student_1::getId));
        Scanner scanner = new Scanner(System.in);
     //   int studentInputCount = Integer.parseInt(bufferedReader.readLine());
        int studentInputCount = Integer.parseInt(scanner.nextLine());

        List<Student_1> studentLits =  new ArrayList<>();
        // Input student preopertes and add this to list .
        while (studentInputCount > 0){
       //     String[] inputssatz = bufferedReader.readLine().split(" ");
            String[] inputssatz = scanner.nextLine().split(" ");
            if (inputssatz[0].equals("ENTER")){
                    Student_1 student_1= new Student_1(Integer.parseInt(inputssatz[3]),inputssatz[1], Double.parseDouble(inputssatz[2]) );
                studentQuery.add(student_1);
            }else if(inputssatz[0].equals("SERVED")){
                studentQuery.poll();
            }
            studentInputCount--;
        }
        scanner.close();


        List<Student_1> students = new ArrayList<>();
        while (!studentQuery.isEmpty()) {
            students.add(studentQuery.poll());
        }
        for (Student_1 each : students) {
            System.out.println(each.getName());
        }




    }

}

