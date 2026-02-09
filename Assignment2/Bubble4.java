import java.util.*;

public class Bubble4 {
    static class Student {
        String name;
        int rno;
        int age;
        int[] marks;

        public Student(String name, int rno, int age, int[] marks) {
            this.name = name;
            this.rno = rno;
            this.age = age;
            this.marks = marks;
        }

    }

    public static void swap(Student[] std, int id1, int id2) {
        Student temp = std[id1];
        std[id1] = std[id2];
        std[id2] = temp;
    }

    public static void main(String[] args) {
        Student s0 = new Student("Unknown", 102, 42, new int[] { 76, 72, 84 });
        Student s1 = new Student("Aman Gupta", 105, 41, new int[] { 76, 72, 84 });
        Student s2 = new Student("Anupam Mittal", 108, 41, new int[] { 76, 74, 84, 92 });
        Student s3 = new Student("Namita Thapar", 103, 38, new int[] { 93, 90, 88, 82, 59 });
        Student s4 = new Student("Ashneer Grover", 101, 37, new int[] { 91, 74 });
        Student s5 = new Student("Vineeta", 106, 38, new int[] { 76, 89, 84, 91 });

        Student[] students = new Student[] { s0, s1, s2, s3, s4, s5 };

        for (int i = 0; i < students.length; i++) {
            for (int j = 0; j < students.length - i - 1; j++) {
                Student currStudent = students[j];
                Student nextStudent = students[j + 1];

                int[] currMarks = currStudent.marks;
                int[] nextMarks = nextStudent.marks;

                int currAge = currStudent.age;
                int nextAge = currStudent.age;

                int len = Math.min(currMarks.length, nextMarks.length);

                for (int k = 0; k < len; k++) {
                    if (currMarks[k] > nextMarks[k]) { // marks in ascending order
                        swap(students, j, j + 1);
                        break;
                    } else if (currMarks[k] < nextMarks[k]) {
                        break;
                    } else if (currMarks[k] == nextMarks[k] && currAge > nextAge) { // age in descending order
                        swap(students, j + 1, j);
                    }
                }
            }
        }

        for (Student student : students) {
            System.out.println(
                    "Name: " + student.name +
                            " Roll No: " + student.rno +
                            " Age: " + student.age +
                            " Marks: " + Arrays.toString(student.marks));
        }

    }
}
