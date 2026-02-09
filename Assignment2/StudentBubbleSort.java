public class StudentBubbleSort {

    static class Student {
        String name;
        int rno;
        int donation;

        public Student(String name, int rno, int donation) {
            this.name = name;
            this.rno = rno;
            this.donation = donation;
        }
    }

    public static void main(String[] args) {
        Student[] objStudents = {
                new Student("Riya", 101, 500),
                new Student("Sarthak", 103, 5000),
                new Student("Ashu", 102, 2500),
                new Student("Swati", 100, 1000)
        };

        for (int i = 0; i < objStudents.length; i++) {
            for (int j = 0; j < objStudents.length - i - 1; j++) {
                if (objStudents[j].donation > objStudents[j + 1].donation) {
                    Student temp = objStudents[j];
                    objStudents[j] = objStudents[j + 1];
                    objStudents[j + 1] = temp;
                }
            }
        }

        for (Student s : objStudents) {
            System.out.println(s.name + " " + s.rno + " " + s.donation);
        }
    }
}
