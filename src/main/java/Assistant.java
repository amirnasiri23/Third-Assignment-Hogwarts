public class Assistant extends Account{
    public Assistant(String username, String password) {
        super(username, password);
    }

    @Override
    public void dosplayChoiceMenu() {
        System.out.println("Options --> ");
        System.out.println("1) Remove a Teacher/Student");
        System.out.println("2) View Courses and Their List of Students");
        System.out.println("3) Check Student/Teacher Profile");
        System.out.println("4) Create a Course");
        System.out.println("5) Exit From Your Portal");
        System.out.println("6) Exit The Program");
    }
}
