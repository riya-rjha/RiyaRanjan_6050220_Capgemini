public class Selection2 {

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

        // Selection sort on the basis of donations

        int n = objStudents.length;
        for (int i = 0; i < n; i++) {
            int minPos = i;
            for (int j = i + 1; j < n; j++) {
                int minDonation = objStudents[minPos].donation;
                int higherDonation = objStudents[j].donation;
                if (minDonation > higherDonation) {
                    minPos = j;
                }
            }

            Student temp = objStudents[minPos];
            objStudents[minPos] = objStudents[i];
            objStudents[i] = temp;

        }

        for (Student student : objStudents) {
            System.out.println(student.name + " " + student.rno + " " + student.donation);
        }

    }
}
