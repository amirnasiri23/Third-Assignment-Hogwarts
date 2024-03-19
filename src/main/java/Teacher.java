import java.util.ArrayList;

public class Teacher extends Account{

    private boolean canSignUp;
    private boolean isRequested;
    private int score = -1;
    private ArrayList<Course> coursesTeach;
    private ArrayList<String> comments;

    public Teacher(String username, String password) {
        super(username, password);
        canSignUp = false;
        isRequested = true;
        coursesTeach = new ArrayList<>();
        comments = new ArrayList<>();
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

    public void takeCourse(Course course) {
        course.changeTeacher(this);
        this.coursesTeach.add(course);
    }

    public ArrayList<Course> getCoursesTeahch() {
        return this.coursesTeach;
    }

    public int getScore() {
        return this.score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void addComment(String comment) {
        this.comments.add(comment);
    }

    public void showProfile() {
        System.out.println("Name: " + this.getUsername());
        if (this.score != -1) System.out.println("Score: " + this.getScore());
        System.out.println("Courses: ");
        for (Course course : this.getCoursesTeahch()) {
            System.out.println(course.getTitle());
        }
    }

    @Override
    public void dosplayChoiceMenu() {
        System.out.println("Options --> ");
        System.out.println("1) Take Course");
        System.out.println("2) Score Students");
        System.out.println("3) View Cources List That You Teach");
        System.out.println("4) View Course's List of Students");
        System.out.println("5) Show Teacher’s Score");
        System.out.println("6) Exit From Your Portal");
        System.out.println("7) Exit The Program");
    }
}

