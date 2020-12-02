import java.util.*;
import java.lang.Integer;

public class Student implements Comparable<Student> {
    private String name;
    private String surname;
    private long id;
    private double averageGrade;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getAverageGrade() {
        return averageGrade;
    }

    public void setAverageGrade(double averageGrade) {
        this.averageGrade = averageGrade;
    }

    public Student(String name, String surname, long id, double averageGrade) {
        this.name = name;
        this.surname = surname;
        this.id = id;
        this.averageGrade = averageGrade;
    }

    @Override
    public int compareTo(Student student) {
        if(this.averageGrade == student.getAverageGrade()) {
            if(this.surname.equals(student.getSurname())) {
                return this.name.compareTo(student.getName());
            } else {
                return this.surname.compareTo(student.getSurname());
            }
        } else {
            if(this.averageGrade > student.getAverageGrade()) {
                return 1;
            }
            return -1;
        }
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", id=" + id +
                ", averageGrade=" + averageGrade +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return id == student.id &&
                Double.compare(student.averageGrade, averageGrade) == 0 &&
                Objects.equals(name, student.name) &&
                Objects.equals(surname, student.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, id, averageGrade);
    }
}
class MyLinkedHashSet extends LinkedHashSet<Integer> {
    @Override
    public boolean add(Integer integer) {
        int val = integer;
        if(val%2 == 0) {
            return super.add(integer);
        }
        return false;
    }
}
class MyHashSet extends HashSet<Integer> {
    @Override
    public boolean add(Integer integer) {
        int val = integer;
        if(val%2 == 0) {
            return super.add(integer);
        }
        return false;
    }
}
class MyTreeSet extends TreeSet<Integer> {
    @Override
    public boolean add(Integer integer) {
        int val = integer;
        if(val%2 == 0) {
            return super.add(integer);
        }
        return false;
    }
}
class Test {
    public static void main(String []args) {
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("Popescu", "Dana", 13, 9.4));
        students.add(new Student("Ababei", "Raluca", 12, 9.7));
        students.add(new Student("Constantin", "Petrisor", 20, 9));
        students.add(new Student("Constantin", "Aurel", 11, 9));
        students.add(new Student("Stoica", "Danut", 10, 9.4));
        System.out.println(students);
        System.out.println("--------Task 2---------");
        Collections.sort(students);
        System.out.println(students);
        System.out.println("--------Task 3---------");
        students.sort((o1, o2) -> (int) (10 * (o2.getAverageGrade() - o1.getAverageGrade())));
        // am pus 10 * ca sa nu aproximeze prost cand face cast
        System.out.println(students);
        System.out.println("--------Task 4---------");
        PriorityQueue<Student> studentPriorityQueue = new PriorityQueue<>(new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return Long.compare(s1.getId(), s2.getId());
            }
        });
        studentPriorityQueue.addAll(students);
        System.out.println(studentPriorityQueue);
        System.out.println("--------Task 5---------");
        for(Student student : studentPriorityQueue) {
            System.out.println(student.hashCode());
        }
        System.out.println("--------Task 6---------");
        HashMap<Student, LinkedList<String>> map = new HashMap<>();
        map.put(students.get(0), new LinkedList<>(Arrays.asList("POO", "IOCLA", "SPORT")));
        map.put(students.get(1), new LinkedList<>(Arrays.asList("FIZICA", "IOCLA")));
        map.put(students.get(2), new LinkedList<>(Arrays.asList("PC", "PA")));
        map.put(students.get(3), new LinkedList<>(Arrays.asList("MATEMATICA2", "MATEMATICA3")));
        map.put(students.get(4), new LinkedList<>(Arrays.asList("MN", "PI")));
        for(Map.Entry<Student, LinkedList<String>> entry : map.entrySet()) {
            System.out.println(entry.getKey().toString() + ", " + entry.getValue());
        }
        System.out.println("--------Task 7---------");
        MyLinkedHashSet set1 = new MyLinkedHashSet();
        set1.add(1);
        set1.add(8);
        set1.add(4);
        set1.add(3);
        set1.add(6);
        set1.add(20);
        System.out.println("Pentru LinkedHashSet");
        for(Integer integer : set1) {
            System.out.println(integer);
        }
        System.out.println("Pentru HashSet");
        MyHashSet set2 = new MyHashSet();
        set2.add(1);
        set2.add(8);
        set2.add(4);
        set2.add(3);
        set2.add(6);
        set2.add(20);
        for(Integer integer : set2) {
            System.out.println(integer);
        }
        System.out.println("Pentru TreeSet");
        MyTreeSet set3 = new MyTreeSet();
        set3.add(1);
        set3.add(8);
        set3.add(4);
        set3.add(3);
        set3.add(6);
        set3.add(20);
        for(Integer integer : set3) {
            System.out.println(integer);
        }
        /*
          Atunci cand extindem LinkedHashSet, elementele sunt inserate in set in ordinea in care
          le-am introdus initial, in timp ce daca folosesc HashSet, ordinea este aleatoare, ele-
          mentele nefiind nici sortate, nici ordonate, iar cand folosesc TreeSet, acestea sunt
          by default ordonate crescator.
         */
    }
}
