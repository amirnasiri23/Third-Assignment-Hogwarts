import java.util.ArrayList;

public class Hogwarts {

    ArrayList<Student> students;
    ArrayList<Teacher> teachers;
    ArrayList<Assistant> assistants;
    ArrayList<Course> courses;
    Assistant headAssistant;

    public Hogwarts(Assistant headAssistant) {
        this.assistants = new ArrayList<>();
        this.teachers = new ArrayList<>();
        this.students = new ArrayList<>();
        this.courses = new ArrayList<>();
        this.headAssistant = headAssistant;
        this.assistants.add(headAssistant);
    }

    public void viewAllTeachers() {
        for (Teacher teacher : teachers) {
            System.out.println("Name: " + teacher.getUsername());
        }
    }

    public void viewAllStudents() {
        for (Student student : students) {
            System.out.println("Name: " + student.getUsername());
        }
    }

    public void viewIndividualStudentProfile(Student student) {
        // view all atributs of student
    }

    public void viewAllCourses() {
        for (Course course : courses) {
            System.out.print("Title: " + course.getTitle() + " ");
            System.out.print("UUID: " + course.getUuid() + " Students: ");
            System.out.println();
            course.showStudents();
        }
    }

    public void addStudent(Student student) {
        this.students.add(student);
    }

    public void addTeacher(Teacher teacher) {
        this.teachers.add(teacher);
    }

    public void addAssistant(Assistant assistant) {
        this.assistants.add(assistant);
    }

    public void addCourse(Course course) {
        this.courses.add(course);
    }
}
