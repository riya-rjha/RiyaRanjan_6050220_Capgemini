public class Bubble3 {

    static class Employee {
        String name;
        int age;
        float rating;

        public Employee(String name, int age, float rating) {
            this.name = name;
            this.age = age;
            this.rating = rating;
        }
    }

    public static void swap(Employee[] emp, int id1, int id2) {
        Employee temp = emp[id1];
        emp[id1] = emp[id2];
        emp[id2] = temp;
    }

    public static void main(String[] args) {
        Employee[] empData = {
                new Employee("Robert", 27, 5.55f),
                new Employee("Frost", 29, 9.43f),
                new Employee("David", 35, 9.31f),
                new Employee("Ghazal", 44, 6.44f),
                new Employee("Anupam", 39, 8.28f),
                new Employee("Aman", 39, 9.28f),
                new Employee("Namita", 44, 9.31f),
                new Employee("Ashneer", 24, 6.44f)
        };

        for (int i = 0; i < empData.length; i++) {
            for (int j = 0; j < empData.length - i - 1; j++) {
                float currRating = empData[j].rating;
                float nextRating = empData[j + 1].rating;

                int currAge = empData[j].age;
                int nextAge = empData[j + 1].age;

                if (currRating < nextRating) {
                    // sort rating in descending order
                    // if curr rating is less then the next index rating
                    swap(empData, j, j + 1);
                } else if (currRating == nextRating && currAge > nextAge) {
                    // sort age in ascending order
                    // if rating equal
                    swap(empData, j, j + 1);
                }

            }
        }

        for (

        Employee employee : empData) {
            System.out.println("Name: " + employee.name + " Age: " + employee.age + " Rating: " + employee.rating);
        }
    }
}
