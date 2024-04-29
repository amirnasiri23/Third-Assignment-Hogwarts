import java.net.Socket;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        runMenu();
    }

    public static void runMenu() {
        Assistant MrNasiri = new Assistant("AmirAliNasiri", "1383");
        Hogwarts hopeHogwarts = new Hogwarts(MrNasiri);

        Quiz[] quiz = new Quiz[4];
        quiz[0] = new Quiz("25 % 3", "1");
        quiz[1] = new Quiz("4 x 10", "40");
        quiz[2] = new Quiz("5 + 11", "16");
        quiz[3] = new Quiz("36 / 4", "9");

        Scanner input = new Scanner(System.in);
        String userType;

        while (true) {
            displayFirstMenu();
            userType = input.nextLine();

            switch (userType) {
                case "1": // Assistant
                    System.out.println("--------We Have An Assistant--------");
                    String AssistantLog = displayLogMenu(input);
                    if (AssistantLog.equals("Up")) {
                        String AssistantInitialUserName;
                        String AssistantInitialPassword;
                        String AssistantInitialPasswordCopy;

                        System.out.print("Enter Your UserName: ");
                        AssistantInitialUserName = input.nextLine();

                        System.out.print("Enter Your Password: ");
                        AssistantInitialPassword = input.nextLine();

                        System.out.print("Enter Your Password Again: ");
                        AssistantInitialPasswordCopy = input.nextLine();

                        if (AssistantInitialPassword.equals(AssistantInitialPasswordCopy)) {
                            Assistant assistant = new Assistant(AssistantInitialUserName, AssistantInitialPassword);
                            hopeHogwarts.addAssistant(assistant);
                            System.out.println("You Siggned Up Succesfully No Login");
                        }
                        else {
                            System.out.println("Passwords Should Be The Same!");
                        }
                    }
                    else if (AssistantLog.equals("In")) {
                        boolean isLoggedIn = false;
                        boolean isFound = false;
                        String AssistantName;
                        System.out.print("Enter Your Username: ");
                        AssistantName = input.nextLine();
                        for (Assistant assistant : hopeHogwarts.assistants) {
                            if (assistant.getUsername().equals(AssistantName)) {
                                isFound = true;
                                String AssistantPass;
                                System.out.print("Enter Your PassWord: ");
                                AssistantPass = input.nextLine();
                                if (assistant.validatePassword(AssistantPass)) {
                                    System.out.println("You Logged In");

                                    for (Student student : hopeHogwarts.students) {
                                        if (student.getIsRequested()) {
                                            String AssistantChoiceForStudent;
                                            System.out.println(student.getUsername() + " Wants To Sign Up");
                                            System.out.print("Accept: 1) No, 2) Yes: ");
                                            AssistantChoiceForStudent = input.nextLine();
                                            switch (AssistantChoiceForStudent) {
                                                case "1":
                                                    System.out.println("You Do Not Accept " + student.getUsername());
                                                    break;
                                                case "2":
                                                    System.out.println("You Accept " + student.getUsername());
                                                    student.setSignUpAlocation();
                                                    student.changeIsRequested();
                                                default:
                                                    System.out.println("Invalid Order!");
                                                    break;
                                            }
                                        }
                                    }
                                    for (Teacher teacher : hopeHogwarts.teachers) {
                                        if (teacher.getIsRequested()) {
                                            String AssistantChoiceForTeacher;
                                            System.out.println(teacher.getUsername() + " Wants To Sign Up");
                                            System.out.print("Accept: 1) No, 2) Yes: ");
                                            AssistantChoiceForTeacher = input.nextLine();
                                            switch (AssistantChoiceForTeacher) {
                                                case "1":
                                                    System.out.println("You Do Not Accept " + teacher.getUsername());
                                                    break;
                                                case "2":
                                                    System.out.println("You Accept " + teacher.getUsername());
                                                    teacher.setSignUpAlocation();
                                                    teacher.changeIsRequested();
                                                    break;
                                                default:
                                                    System.out.println("Invalid Order!");
                                                    break;
                                            }
                                        }
                                    }
                                    String assistantChoice;
                                    isLoggedIn = true;
                                    assistant.dosplayChoiceMenu();
                                    System.out.print("Your Choice: ");
                                    assistantChoice = input.nextLine();

                                    switch (assistantChoice) {
                                        case "1":
                                            String whoString;
                                            System.out.print("Remove a --> 1) Teacher or 2) Student: ");
                                            whoString = input.nextLine();
                                            if (whoString.equals("1")) {
                                                boolean isFoundTeacher = false;
                                                String removeTeacher;
                                                hopeHogwarts.viewAllTeachers();
                                                System.out.print("Enter the Name Of Teacher: ");
                                                removeTeacher = input.nextLine();
                                                for (Teacher teacher : hopeHogwarts.teachers) {
                                                    if (teacher.getUsername().equals(removeTeacher)){
                                                        isFoundTeacher = true;
                                                        hopeHogwarts.teachers.remove(teacher);
                                                        System.out.println(removeTeacher + " Succesfully Removed");
                                                    }
                                                }
                                                if (!isFoundTeacher) {System.out.println("Teacher Not Found!");}
                                            }
                                            else if (whoString.equals("2")) {
                                                boolean isFoundStudent = false;
                                                String removeStudent;
                                                hopeHogwarts.viewAllStudents();
                                                System.out.print("Enter the Name Of Student: ");
                                                removeStudent = input.nextLine();
                                                for (Student student : hopeHogwarts.students) {
                                                    if (student.getUsername().equals(removeStudent)) {
                                                        isFoundStudent =true;
                                                        hopeHogwarts.students.remove(student);
                                                        System.out.println(removeStudent + " Succesfully Removed");
                                                    }
                                                }
                                                if (!isFoundStudent) {System.out.println("Student Not Found!");}
                                            }
                                            break;
                                        case "2":
                                            hopeHogwarts.viewAllCourses();
                                            break;
                                        case "3":
                                            String profileChoice;
                                            System.out.print("1) Teacher or 2) Student: ");
                                            profileChoice = input.nextLine();
                                            if (profileChoice.equals("1")) {
                                                for (Teacher teacher : hopeHogwarts.teachers) {
                                                    teacher.showProfile();
                                                }
                                            }
                                            else if (profileChoice.equals("2")) {
                                                for (Student student : hopeHogwarts.students) {
                                                    student.showProfile();
                                                }
                                            }
                                            else {System.out.println("Invalid Order!");}
                                            break;
                                        case "4":
                                            String TitleOfCourse;
                                            System.out.print("Enter The Title Of The Course: ");
                                            TitleOfCourse = input.nextLine();
                                            Course course = new Course(TitleOfCourse);
                                            hopeHogwarts.addCourse(course);
                                            System.out.println("Course Added");
                                            break;
                                        case "5":
                                            System.out.println("Exiting From Portal......");
                                            break;
                                        case "6":
                                            exit();
                                            break;
                                        default:
                                            break;
                                    }
                                }
                                if (!isLoggedIn) {System.out.println("Username And Password Not Match!");}
                            }
                        }
                        if (!isFound) {System.out.println("You Dont Have Accont Please Sign Up First!");}
                    }
                    break;
                case "2": // Student
                    System.out.println("--------We Have A Student--------");
                    String studentLog = displayLogMenu(input);
                    if (studentLog.equals("Up")) {
                        System.out.println("----SignUp Menu----");

                        String StudentInitialUserName;
                        String StudentInitialPassword;
                        String StudentInitialPasswordCopy;

                        System.out.print("Enter Your UserName: ");
                        StudentInitialUserName = input.nextLine();

                        System.out.print("Enter Your Password: ");
                        StudentInitialPassword = input.nextLine();

                        System.out.print("Enter Your Password Again: ");
                        StudentInitialPasswordCopy = input.nextLine();

                        if (StudentInitialPassword.equals(StudentInitialPasswordCopy)) {
                            Student student = new Student(StudentInitialUserName, StudentInitialPassword);
                            hopeHogwarts.addStudent(student);
                            System.out.println("Your Request Had Sended Please Login Now");
                        }
                        else {
                            System.out.println("Passwords Should Be The Same!");
                        } }
                    else if (studentLog.equals("In")) {
                        boolean isLoggedIn = false;
                        boolean isFound = false;
                        String StudentName;
                        System.out.print("Enter Your Username: ");
                        StudentName = input.nextLine();
                        for (Student student : hopeHogwarts.students) {
                            if (student.getUsername().equals(StudentName)) {
                                isFound = true;
                                String StudentPass;
                                System.out.print("Enter Your PassWord: ");
                                StudentPass = input.nextLine();
                                if (student.validatePassword(StudentPass)) {
                                    if (student.getCanSignUp()) {
                                        System.out.println("You Logged In");
                                        isLoggedIn = true;
                                        String studentChoice;
                                        System.out.println("------Hello Student " + student.getUsername() + "------");
                                        student.dosplayChoiceMenu();
                                        System.out.print("Your Choice: ");
                                        studentChoice = input.nextLine();

                                        switch (studentChoice) {
                                            case "1":
                                                String studentCourse;
                                                boolean isClassFound = false;
                                                hopeHogwarts.viewAllCourses();
                                                System.out.print("Enter The Title Of Course You Want To Get: ");
                                                studentCourse = input.nextLine();
                                                for (Course course : hopeHogwarts.courses) {
                                                    if (course.getTitle().equals(studentCourse)) {
                                                        course.addStudent(student);
                                                        student.addCourse(course);
                                                        System.out.println("You Add To " + course.getTitle() + " Class");
                                                        isClassFound = true;
                                                    }
                                                }
                                                if (!isClassFound) {System.out.println("This Course Not Exist!");}
                                                break;
                                            case "2":
                                                student.viewAllCoursesGet();
                                                break;
                                            case "3":
                                                student.viewAllTeachers();
                                                break;
                                            case "4":
                                                int rand = generateRandomNumber();
                                                String ans;
                                                quiz[rand].showQuestion();
                                                System.out.print("Answer: ");
                                                ans = input.nextLine();
                                                if (quiz[rand].isCorrect(ans)) {System.out.println("Correct Ans :)");}
                                                else {System.out.println("Incorrect Ans :|");}
                                                break;
                                            case "5":
                                                String comment;
                                                String who;
                                                student.viewAllTeachers();
                                                System.out.print("Enter Teachers Name: ");
                                                who = input.nextLine();
                                                System.out.print("Enter The Comment: ");
                                                comment = input.nextLine();
                                                for (Course course : student.getCoursesLearn()) {
                                                    if (who.equals(course.getTeacher().getUsername())) {
                                                        course.getTeacher().addComment(comment);
                                                        System.out.println("Comment Added");
                                                    }
                                                }
                                                break;
                                            case "6":
                                                System.out.println("Exiting From Portal......");
                                                break;
                                            case "7":
                                                exit();
                                                break;

                                            default:
                                                break;
                                        }
                                    }
                                    else {System.out.println("Sorry You Dont Accept To SignUp"); isLoggedIn = true;}
                                }
                                if (!isLoggedIn) {System.out.println("Username And Password Not Match!");}
                            }
                        }
                        if (!isFound) {System.out.println("You Dont Have Accont Please Sign Up First!");}
                    }
                    break;
                case "3": // Teacher
                    System.out.println("--------We Have A Teacher--------");
                    String teacherLog = displayLogMenu(input);
                    if (teacherLog.equals("Up")) {
                        System.out.println("----SignUp Menu----");

                        String TeacherInitialUserName;
                        String TeacherInitialPassword;
                        String TeacherInitialPasswordCopy;

                        System.out.print("Enter Your UserName: ");
                        TeacherInitialUserName = input.nextLine();

                        System.out.print("Enter Your Password: ");
                        TeacherInitialPassword = input.nextLine();

                        System.out.print("Enter Your Password Again: ");
                        TeacherInitialPasswordCopy = input.nextLine();

                        if (TeacherInitialPassword.equals(TeacherInitialPasswordCopy)) {
                            Teacher teacher = new Teacher(TeacherInitialUserName, TeacherInitialPassword);
                            hopeHogwarts.addTeacher(teacher); // acception
                            System.out.println("Your Request Had Sended Please Login Now");
                        }
                        else {
                            System.out.println("Passwords Should Be The Same!");
                        } }
                    else if (teacherLog.equals("In")) {
                        boolean isLoggedIn = false;
                        boolean isFound = false;
                        String TeacherName;
                        System.out.print("Enter Your Username: ");
                        TeacherName = input.nextLine();
                        for (Teacher teacher : hopeHogwarts.teachers) {
                            if (teacher.getUsername().equals(TeacherName)) {
                                isFound = true;
                                String TeacherPass;
                                System.out.print("Enter Your PassWord: ");
                                TeacherPass = input.nextLine();
                                if (teacher.validatePassword(TeacherPass)) {
                                    if (teacher.getCanSignUp()) {
                                        System.out.println("You Logged In");
                                        isLoggedIn = true;
                                        String teacherChoice;
                                        System.out.println("------Hello Teacher " + teacher.getUsername() + "------");
                                        teacher.dosplayChoiceMenu();
                                        System.out.print("Your Choice: ");
                                        teacherChoice = input.nextLine();

                                        switch (teacherChoice) {
                                            case "1":
                                                if (hopeHogwarts.courses.size() == 0) {System.out.println("We Dont Have Any Courses Now"); break;}
                                                hopeHogwarts.viewAllCourses();
                                                String courseName;
                                                System.out.print("Write The Title Of Course You Want To Get: ");
                                                courseName = input.nextLine();
                                                for (Course course : hopeHogwarts.courses) {
                                                    if (course.getTitle().equals(courseName)) {
                                                        teacher.takeCourse(course);
                                                        System.out.println("Now You Are " + courseName + " Teacher");
                                                    }
                                                }
                                                break;
                                            case "2":
                                                for (Course course : teacher.getCoursesTeahch()) {
                                                    String ChoicedStudent;
                                                    course.showStudents();
                                                    System.out.print("Enter Name Of Student You Want To Score: ");
                                                    ChoicedStudent = input.nextLine();
                                                    for (Student student : course.getStudents()) {
                                                        if (student.getUsername().equals(ChoicedStudent)) {
                                                            int Score;
                                                            System.out.print("Enter The Score: ");
                                                            Score = input.nextInt();
                                                            student.setScore(Score);
                                                        }
                                                    }
                                                }
                                                break;
                                            case "3":
                                                int courseCount = 0;
                                                for (Course course : hopeHogwarts.courses) {
                                                    if (course.getTeacher().getUsername().equals(TeacherName)) {
                                                        courseCount++;
                                                        System.out.println(course.getTitle());
                                                    }
                                                    if (courseCount == 0) {System.out.println("You Dont Have Any Courses");}
                                                }
                                                break;
                                            case "4":
                                                for (Course course : hopeHogwarts.courses) {
                                                    if (course.getTeacher().getUsername().equals(TeacherName)) {
                                                        System.out.println(course.getTitle());
                                                        System.out.println("----Students Of " + course.getTitle() + ":");
                                                        for (Student student : course.getStudents()) {
                                                            System.out.println("Name: " + student.getUsername() + " Score: " + student.getScore());
                                                        }
                                                    }
                                                }
                                                break;
                                            case "5":
                                                if (teacher.getScore() != -1){
                                                    System.out.println("Your Score is " + teacher.getScore());
                                                }
                                                else {System.out.println("You Dont Have Score Now!");}
                                                break;
                                            case "6":
                                                System.out.println("Exiting From Portal......");
                                                break;
                                            case "7":
                                                exit();
                                                break;

                                            default:
                                                System.out.println("Invalid Order!");
                                                break;
                                        }
                                    }
                                    else {System.out.println("Sorry You Dont Accept To SignUp"); isLoggedIn = true;} }
                                if (!isLoggedIn) {System.out.println("Username And Password Not Match!");}
                            }
                        }
                        if (!isFound) {System.out.println("You Dont Have Accont Please Sign Up First!");}
                    }
                    break;
                case "4":
                    exit();
                    break;
                default:
                    System.out.println("Enter Was Not Valid!");
                    break;
            }
        }
    }

    public static void exit() {
        System.out.println("Program Ending........");
        System.exit(0);
    }

    public static void displayFirstMenu() {
        System.out.println("------------------Welcome------------------");
        System.out.println("=============== Who Are You ===============");
        System.out.print("1) Assistant - 2) Student - 3) Teacher - 4) Exit : ");
    }

    public static String displayLogMenu(Scanner input) {
        String userLog;
        System.out.print("Are You Have An Account (1) Yes: SignIn ~~~ 2) No: SignUp) : ");
        userLog = input.nextLine();

        if (userLog.equals("1")) {
            System.out.println("-------------Lets Sign In-------------");
            return "In";
        }
        else if (userLog.equals("2")) {
            System.out.println("-------------Lets Sign Up-------------");
            return "Up";
        }
        else {
            System.out.println("Log Type Was Not Valid!");
            return "Invalid";
        }
    }

    public static int generateRandomNumber() { // for Students quiz
        int ans = (int) (Math.random() * 4);
        return ans;
    }
}
