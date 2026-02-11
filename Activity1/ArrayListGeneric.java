package Activity1;

interface Comparator<T> {
    int compare(T a, T b);
}

class StringComparator implements Comparator<String> {
    public int compare(String a, String b) {
        int len = Math.min(a.length(), b.length());
        for (int i = 0; i < len; i++) {
            if (a.charAt(i) != b.charAt(i)) {
                return a.charAt(i) - b.charAt(i);
            }
        }
        return 0;
    }
}

class Student {
    String name;
    int rno;
    int age;

    Student() {
    }

    public Student(String name, int rno, int age) {
        this.name = name;
        this.rno = rno;
        this.age = age;
    }
}

class GenericList<T> {
    private T[] data;
    private int size;

    GenericList() {
        this.data = (T[]) new Object[4];
        this.size = 0;
    }

    public void add(T val) {
        if (size == data.length) {
            resize();
        }
        data[size++] = val;
    }

    public T get(int idx) {
        if (idx < 0 || idx >= size) {
            throw new IndexOutOfBoundsException();
        }
        return data[idx];
    }

    public void resize() {
        T[] temp = (T[]) new Object[2 * data.length + 1];
        for (int i = 0; i < size; i++) {
            temp[i] = data[i];
        }
        data = temp;
    }

    public T remove(int idx) {
        T val = data[idx];
        for (int i = idx; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
        return val;
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }

    public boolean search(T val) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(val)) {
                return true;
            }
        }
        return false;
    }

    public void sort() {
        // Insertion sort

        for (int i = 1; i < size; i++) {
            T curr = data[i];
            int prev = i - 1;

            while (prev >= 0 && compare(data[prev], curr) > 0) {
                data[prev + 1] = data[prev];
                prev = prev - 1;
            }

            data[prev + 1] = curr;
        }
    }

    public int compare(T a, T b) {
        if (a == null && b == null) {
            return 0;
        }
        if (a == null) {
            return -1;
        }
        if (b == null) {
            return 1;
        }

        if (a instanceof Integer && b instanceof Integer) {
            return (Integer) a - (Integer) b;
        }

        if (a instanceof String && b instanceof String) {
            // if < 0 => a comes before b
            // if > 0 => a comes after b
            // if = 0 => a is equal to b

            StringComparator stringComparator = new StringComparator();
            int ans = stringComparator.compare((String) a, (String) b);
            return ans;
        }

        throw new RuntimeException("Unsupported type in Java");
    }

}

class ArrayListGeneric {
    public static void main(String[] args) {
        GenericList<Integer> lst = new GenericList();
        lst.add(2);
        lst.add(7);
        lst.add(3);
        lst.add(9);
        lst.add(5);
        lst.print();
        System.out.println("Get el: " + lst.get(0));
        System.out.println("Removed el: " + lst.remove(0));
        lst.print();
        lst.sort();
        System.out.println("Sorted arrayList: ");
        lst.print();

        GenericList<String> str = new GenericList();
        str.add("Hey");
        str.add("Lady");
        str.add("Gaga");
        str.add("Bye");
        str.print();
        System.out.println("Get el: " + str.get(1));
        System.out.println("Removed el: " + str.remove(1));
        str.print();
        System.out.println("Sorted arrayList: ");
        str.sort();
        str.print();

    }
}