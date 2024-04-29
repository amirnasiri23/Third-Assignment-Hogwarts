import java.util.ArrayList;

public class Student extends Account{

    private boolean canSignUp;
    private boolean isRequested;
    private int score = -1;
    private ArrayList<Course> coursesLearn;

    public Student(String username, String password) {
        super(username, password);
        canSignUp = false;
        isRequested = true;
        coursesLearn = new ArrayList<>();
    }

    public boolean getIsRequested() {
        return this.isRequested;
    }

    public boolean getCanSignUp() {
        return this.canSignUp;
    }

    public void setSignUpAlocation() {
        this.canSignUp = true;
    }

    public void changeIsRequested() {
        this.isRequested = false;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getScore() {
        return this.score;
    }

    public ArrayList<Course> getCoursesLearn() {
        return this.coursesLearn;
    }

    public void viewAllCoursesGet() {
        for (Course course : this.coursesLearn) {
            System.out.println("Title: " + course.getTitle());
            System.out.println("ID: " + course.getUuid());
        }
    }

    public void viewAllTeachers() {
        for (Course course : this.coursesLearn) {
            System.out.println(course.getTeacher().getUsername());
        }
    }

    public void addCourse(Course course) {
        this.coursesLearn.add(course);
    }

    public void showProfile() {
        System.out.println("Name: " + this.getUsername());
        if (this.score != -1) System.out.println("Score: " + this.getScore());
        System.out.println("Courses: ");
        for (Course course : this.getCoursesLearn()) {
            System.out.println(course.getTitle());
        }
    }

    @Override
    public void dosplayChoiceMenu() {
        System.out.println("Options --> ");
        System.out.println("1) Taking Courses");
        System.out.println("2) Viewing All Courses Taken");
        System.out.println("3) Viewing All Teachers");
        System.out.println("4) Taking a Sorting Quiz");
        System.out.println("5) Leave a Comment For a Teacher");
        System.out.println("6) Exit From Your Prtal");
        System.out.println("7) Exit The Program");
    }
}