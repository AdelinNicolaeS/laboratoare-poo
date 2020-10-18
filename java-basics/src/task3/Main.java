package task3;

import task2.Student;

public class Main {
    public static void main(String[] args) {
        Student s1 = new Student();
        Student s2 = new Student();
        Student s3;
        Student s4 = new Student();
        s1.setName("Bobita");
        s1.setYear(10);
        s2.setName("Bobita");
        s2.setYear(10);
        s3 = s1;
        s4.setName("Giani");
        s4.setYear(10);
        boolean b1 = s1.equals(s2);
        boolean b2 = s1.equals(s3);
        boolean b3 = s3.equals(s4);
        System.out.println(b1); //fals desi au aceleasi valori
        System.out.println(b2);
        System.out.println(b3);

    }
}
