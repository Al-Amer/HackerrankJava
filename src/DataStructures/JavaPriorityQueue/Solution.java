package java.DataStructures.JavaPriorityQueue;

import java.util.*;

class Student {
    int id;
    String name;
    double cgpa;
    public Student( int id, String name, double cgpa) {
        this.id=id;
        this.name=name;
        this.cgpa=cgpa;
    }
    public int getId() {return id;}
    public void setId(int id) {this.id = id;}
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public double getCgpa() {return cgpa;}
    public void setCgpa(double cgpa) {this.cgpa = cgpa;}

}


class Priorities {
    private final PriorityQueue<Student> studentQuery = new PriorityQueue<>(
            Comparator.comparing(Student::getCgpa).reversed().thenComparing(Student::getName).thenComparing(Student::getId));

    public List<Student> getStudents(List<String> e) {
        for (int i = 0; i < e.size(); i++) {
            if (e.get(i).equals("SERVED")) {
                studentQuery.poll();
            } else {
                String[] str = e.get(i).split(" ");
                studentQuery.add(new Student(Integer.parseInt(str[3]), str[1], Double.parseDouble(str[2])));
            }
        }
        List<Student> students = new ArrayList<>();
        while (!studentQuery.isEmpty()) {
            students.add(studentQuery.poll());
        }
        return students;
    }
}
public class Solution {
        private final static Scanner scan = new Scanner(System.in);
        private final static Priorities priorities = new Priorities();

        public static void main(String[] args) {
            int totalEvents = Integer.parseInt(scan.nextLine());
            List<String> events = new ArrayList<>();

            while (totalEvents-- != 0) {
                String event = scan.nextLine();
                events.add(event);
            }

            List<Student> students = priorities.getStudents(events);

            if (students.isEmpty()) {
                System.out.println("EMPTY");
            } else {
                for (Student st: students) {
                    System.out.println(st.getName());
                }
            }
        }
    }

