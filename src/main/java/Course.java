import java.util.ArrayList;
import java.util.UUID;

public class Course {
    private String title;
    private UUID courseID;
    private Teacher teacher;
    private ArrayList<Student> students;

    public Course(String title) {
        this.title = title;
        this.courseID = UUID.randomUUID();
        this.students = new ArrayList<>();
    }

    public void changeTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public void addStudent(Student student) {
        this.students.add(student);
    }

    public String getTitle() {
        return this.title;
    }

    public UUID getUuid() {
        return this.courseID;
    }

    public void showStudents() {
        for (Student student : this.students) {
            System.out.println(student.getUsername());
        }
    }

    public ArrayList<Student> getStudents() {
        return this.students;
    }

    public Teacher getTeacher() {
        return this.teacher;
    }
}
