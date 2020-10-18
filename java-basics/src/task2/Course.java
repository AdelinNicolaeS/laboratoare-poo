package task2;

public class Course {
    String title;
    String description;
    Student[] students;

    public String getTitle() {
        return title;
    } // varianta finala cu setters si getters rezolva erorile de compilare date de private

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Student[] getStudents() {
        return students;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }

    Student[] filterYear(Integer y) {
        Student []liststudents = new Student[20];
        int j = -1;
        for(int i = 0; i < students.length; i++) {
            if(students[i].getYear() == y) {
                j++;
                liststudents[j] = students[i];
            }
        }
        return liststudents;
    }
}
