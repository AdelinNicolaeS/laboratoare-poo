package task2;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        Integer an = Integer.parseInt(args[0]);
        Course curs = new Course();
        curs.setTitle("Programare orientata pe obiecte");
        curs.setDescription("Acesta este cursul de Programare orientata pe obiecte. Surprinzator, nu?");
        Student []students = new Student[4];

        Student student1 = new Student();
        student1.setName("ana");
        student1.setYear(1);

        Student student2 = new Student();
        student2.setName("maria");
        student2.setYear(2);

        Student student3 = new Student();
        student3.setName("barbu");
        student3.setYear(1);

        Student student4 = new Student();
        student4.setName("ion");
        student4.setYear(3);

        students[0] = student1;
        students[1] = student2;
        students[2] = student3;
        students[3] = student4;
        curs.setStudents(students);

        System.out.println(Arrays.toString(curs.getStudents()));
        Student []list;
        list = curs.filterYear(an);
        System.out.println(Arrays.toString(list));
    }
}
