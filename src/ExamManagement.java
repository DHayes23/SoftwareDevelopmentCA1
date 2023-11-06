import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
public class ExamManagement {

    //    Color Palette Options for Terminal Use
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    // Initialises Main Menu Scanner
    private static List<Student> studentList = new ArrayList<>();
    private static List<Exam> examList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {


        System.out.println(ANSI_GREEN + "\n" +
                "====================================================================================================\n" +
                "  ___                  __  __                                       _     ___         _             \n" +
                " | __|_ ____ _ _ __   |  \\/  |__ _ _ _  __ _ __ _ ___ _ __  ___ _ _| |_  / __|_  _ __| |_ ___ _ __  \n" +
                " | _|\\ \\ / _` | '  \\  | |\\/| / _` | ' \\/ _` / _` / -_) '  \\/ -_) ' \\  _| \\__ \\ || (_-<  _/ -_) '  \\ \n" +
                " |___/_\\_\\__,_|_|_|_| |_|  |_\\__,_|_||_\\__,_\\__, \\___|_|_|_\\___|_||_\\__| |___/\\_, /__/\\__\\___|_|_|_|\n" +
                "                                            |___/                             |__/                  \n" +
                "====================================================================================================\n" +
                ANSI_RESET);


        // Main Menu

        //      Enables main menu loop
        boolean mainMenuRunning = true;
        while (mainMenuRunning) {
            System.out.println(ANSI_CYAN + "--- MAIN MENU ---\n" + ANSI_RESET);
            System.out.println("Welcome to the Exam Management System.\n");
            System.out.println("Please choose one of the following options:\n");
            System.out.println("1. Add New Student");
            System.out.println("2. List All Students");
            System.out.println("3. Add New Exam");
            System.out.println("4. List All Exams");
            System.out.println("5. Record Exam Result");
            System.out.println("6. Display Exam Results");
            System.out.println("7. Print Results to File");
            System.out.println("8. Exit System");
            System.out.println(ANSI_GREEN + "Please make your selection:" + ANSI_RESET);


            int mainMenuChoice = scanner.nextInt();
            switch (mainMenuChoice) {
                case 1:
                    // Add student
                    System.out.println(ANSI_CYAN + "-- Add New Student --\n" + ANSI_RESET);
                    addStudentSubMenu();
                    break;
                case 2:
                    // List All Students
                    System.out.println(ANSI_CYAN + "-- List All Students --\n" + ANSI_RESET);
                    System.out.println("----------------------------------------------\n");
                    listAllStudents();
                    break;
                case 3:
                    // Add exam
                    System.out.println(ANSI_CYAN + "-- Add New Exam --\n" + ANSI_RESET);
                    addExamSubMenu();
                    break;
                case 4:
                    // List All Exams
                    System.out.println(ANSI_CYAN + "-- List All Exams --\n" + ANSI_RESET);
                    System.out.println("----------------------------------------------\n");

                    listAllExams();
                    break;
                case 5:
                    // Record exam result
                    System.out.println(ANSI_CYAN + "-- Record Exam Result --\n" + ANSI_RESET);
                    mainMenuRunning = false;
                    break;
                case 6:
                    // Display exam results
                    System.out.println(ANSI_CYAN + "-- Display Exam Result --\n" + ANSI_RESET);
                    mainMenuRunning = false;
                    break;
                case 7:
                    // Print results to file
                    System.out.println(ANSI_CYAN + "-- Print Exam Results to File --\n" + ANSI_RESET);
                    mainMenuRunning = false;
                    break;
                case 8:
                    System.out.println(ANSI_CYAN + "-- Exit System --\n" + ANSI_RESET);
                    mainMenuRunning = false;
                    break;
                default:
                    System.out.println(ANSI_RED + "Invalid option. Returning to Main Menu.\n" + ANSI_RESET);
                    break;
            }
        }
    }
//  Add Student Sub-Menu
private static void addStudentSubMenu() {
    boolean studentSubMenuRunning = true;
    while (studentSubMenuRunning) {
        System.out.println("1. Enter student details");
        System.out.println("2. Return to Main Menu");

        System.out.println(ANSI_GREEN + "Please make your selection:" + ANSI_RESET);
        int studentSubMenuChoice = scanner.nextInt();

        switch (studentSubMenuChoice) {
            case 1:
                // Add Student
                System.out.println(ANSI_CYAN + "Enter student details here.\n" + ANSI_RESET);
                createStudentFromInput();
                break;
            case 2:
                // Return to Main Menu
                System.out.println(ANSI_YELLOW + "Returning to Main Menu...\n" + ANSI_RESET);
                studentSubMenuRunning = false; // Return to Main Menu
                break;
            default:
                System.out.println(ANSI_RED + "Invalid option. Please try again." + ANSI_RESET);
                break;
        }
    }
}
    private static void addExamSubMenu() {
        boolean examSubMenuRunning = true;
        while (examSubMenuRunning) {
            System.out.println("Please select the type of Exam you wish to add:");
            System.out.println("1. Essay");
            System.out.println("2. Multiple Choice");
            System.out.println("3. Return to Main Menu");


            System.out.println(ANSI_GREEN + "\nPlease make your selection:" + ANSI_RESET);
            int examSubMenuChoice = scanner.nextInt();

            switch (examSubMenuChoice) {
                case 1:
                    // Add Essay Exam
                    System.out.println(ANSI_CYAN + "Adding Essay Exam...\n" + ANSI_RESET);
                    createEssayFromInput();
                    break;
                case 2:
                    // Add Multiple Choice Exam
                    System.out.println(ANSI_YELLOW + "Adding Multiple Choice Exam...\n" + ANSI_RESET);
                    createMultipleChoiceFromInput();
                    break;
                case 3:
                    // Return to Main Menu
                    System.out.println(ANSI_YELLOW + "Returning to Main Menu...\n" + ANSI_RESET);
                    examSubMenuRunning = false; // Return to Main Menu
                    break;
                default:
                    System.out.println(ANSI_RED + "Invalid option. Please try again." + ANSI_RESET);
                    break;
            }
        }
    }
    public static void createStudentFromInput() {
        Scanner scanner = new Scanner(System.in);
        int studentId = 0;
        String studentName;

        try {
            System.out.println("Please enter the student ID:");
            // Throws exception if user enters a non-integer.
            if (!scanner.hasNextInt()) {
                throw new StudentException("Student ID must be a valid integer.");
            }
            studentId = scanner.nextInt();
            scanner.nextLine();
            // Throws exception if user enters duplicate examId.
            if (doesStudentExist(studentId)) {
                throw new StudentException("A student with this ID already exists.");
            }

            System.out.println("Please enter the student name (2-30 characters):");
            studentName = scanner.nextLine();

            // Throws exception if user enters an exam duration outside accepted limits.
            if (studentName == null || studentName.trim().isEmpty() || studentName.length() < 2 || studentName.length() > 30) {
                throw new StudentException("Student name must be between 2 and 30 characters long.");
            }

            // Create the Student object
            Student newStudent = new Student(studentId, studentName);
            // Add the new student to the list of students.
            studentList.add(newStudent);
            // Prints success message.
            System.out.println(ANSI_BLUE + "Student created successfully!\n" + ANSI_RESET);
            System.out.println("----------------------------------------------" + "\n");
            System.out.println(ANSI_GREEN + "Student Name: " + ANSI_RESET + newStudent.getStudentName() + "\n" + ANSI_GREEN + "Student ID: " + ANSI_RESET + newStudent.getStudentId());
            System.out.println("----------------------------------------------" + "\n");

        } catch (StudentException e) {
            System.out.println(ANSI_RED + e.getMessage() + ANSI_RESET);
        }
    }

    // Checks new student ids against existing to prevent duplicates.
    private static boolean doesStudentExist(int studentId) {
        for (Student student : studentList) {
            if (student.getStudentId() == studentId) {
                return true;
            }
        }
        return false;
    }

    // Prints all existing students to the console.
    public static void listAllStudents() {
        if (studentList.isEmpty()) {
            System.out.println(ANSI_RED + "No students found! Returning to Main Menu.\n" + ANSI_RESET);
            return;
        }

        for (Student student : studentList) {
            System.out.println(ANSI_GREEN + "Student ID: " + ANSI_RESET + student.getStudentId());
            System.out.println(ANSI_GREEN + "Student Name: " + ANSI_RESET + student.getStudentName());
            System.out.println("----------------------------------------------" + "\n");
        }
    }

    public static void createEssayFromInput() {
        Scanner scanner = new Scanner(System.in);
        int examId;
        String subject;
        int duration;
        String essayAnswer;
        int grammar;
        int content;
        int wordLimit;

        try {
            System.out.println("Please enter the exam ID:");
            // Throws exception if user enters a non-integer.
            if (!scanner.hasNextInt()) {
                throw new ExamException("Exam ID must be a valid integer.");
            }
            examId = scanner.nextInt();
            scanner.nextLine();
            // Throws exception if user enters duplicate examId.
            if (doesExamExist(examId)) {
                throw new ExamException("An exam with this ID already exists.");
            }

            System.out.println("Please enter the subject:");
            subject = scanner.nextLine();
            // Throws exception if user enters a blank subject.
            if (subject == null || subject.trim().isEmpty()) {
                throw new ExamException("Subject cannot be empty.");
            }

            System.out.println("Please enter the duration of the exam in minutes:");
            // Throws exception if user enters a non-integer.
            if (!scanner.hasNextInt()) {
                scanner.nextLine();
                throw new ExamException("Duration must be an integer value for minutes.");
            }
            duration = scanner.nextInt();
            // Throws exception if user enters an exam duration outside accepted limits.
            if (duration < 30 || duration > 180) {
                throw new ExamException("Exam duration must be between 30 and 180 minutes.");
            }
            scanner.nextLine();

            System.out.println("Please enter the essay answer:");
            essayAnswer = scanner.nextLine();
            // Throws exception if user enters a blank essay answer.
            if (essayAnswer == null || essayAnswer.trim().isEmpty()) {
                throw new ExamException("Essay answer cannot be empty.");
            }

            System.out.println("Please enter the grammar score out of 100:");
            // Throws exception if user enters a non-integer.
            if (!scanner.hasNextInt()) {
                scanner.nextLine();
                throw new ExamException("Grammar score must be an integer.");
            }
            grammar = scanner.nextInt();
            // Throws exception if user enters a grammar score outside accepted limits.
            if (grammar < 0 || grammar > 100) {
                throw new ExamException("Grammar score must be between 0 and 100.");
            }

            System.out.println("Please enter the content score out of 100:");
            // Throws exception if user enters a non-integer.
            if (!scanner.hasNextInt()) {
                scanner.nextLine();
                throw new ExamException("Content score must be an integer.");
            }
            content = scanner.nextInt();
            // Throws exception if user enters a content score outside accepted limits.
            if (content < 0 || content > 100) {
                throw new ExamException("Content score must be between 0 and 100.");
            }

            System.out.println("Please enter the word limit (between 500 and 10000):");
            // Throws exception if user enters a non-integer.
            if (!scanner.hasNextInt()) {
                scanner.nextLine();
                throw new ExamException("Word limit must be an integer.");
            }
            wordLimit = scanner.nextInt();
            // Throws exception if user enters a word limit outside accepted limits.
            if (wordLimit < 500 || wordLimit > 10000) {
                throw new ExamException("Word limit must be between 500 and 10000.");
            }

            // Create the Essay object
            Essay newEssay = new Essay(examId, subject, duration, essayAnswer, grammar, content, wordLimit);
            // Add the new essay object to the list of exams.
            examList.add(newEssay);
            // Prints success message.
            System.out.println(ANSI_BLUE + "\nEssay Exam created successfully!\n" + ANSI_RESET);
            newEssay.displayExamDetails();

        } catch (ExamException e) {
            System.err.println(e.getMessage());
        } catch (InputMismatchException e) {
            System.err.println("Invalid input. Please ensure you enter the correct data types.");
            scanner.nextLine();
        }
    }

    public static void createMultipleChoiceFromInput() {
        Scanner scanner = new Scanner(System.in);
        int examId;
        String subject;
        int duration;
        int noQuestions;
        int correctAnswers;

        try {
            System.out.println("Please enter the exam ID:");
            if (!scanner.hasNextInt()) {
                throw new ExamException("Exam ID must be a valid integer.");
            }

            examId = scanner.nextInt();
            scanner.nextLine();
            // Throws exception if user enters duplicate examId
            if (doesExamExist(examId)) {
                throw new ExamException("An exam with this ID already exists.");
            }

            System.out.println("Please enter the subject:");
            subject = scanner.nextLine();
            // Throws exception if user enters a blank subject.
            if (subject == null || subject.trim().isEmpty()) {
                throw new ExamException("Subject cannot be empty.");
            }

            System.out.println("Please enter the duration of the exam in minutes:");
            // Throws exception if user enters a non-integer.
            if (!scanner.hasNextInt()) {
                scanner.nextLine();
                throw new ExamException("Duration must be an integer value for minutes.");
            }
            duration = scanner.nextInt();
            // Throws exception if user enters a duration outside accepted limits.
            if (duration < 30 || duration > 180) {
                throw new ExamException("Exam duration must be between 30 and 180 minutes.");
            }

            System.out.println("Please enter the number of questions:");
            // Throws exception if user enters a non-integer.
            if (!scanner.hasNextInt()) {
                scanner.nextLine();
                throw new ExamException("Number of questions must be an integer.");
            }
            noQuestions = scanner.nextInt();
            // Throws exception if user enters a number of questions outside accepted limits.
            if (noQuestions < 10 || noQuestions > 50) {
                throw new ExamException("Number of questions must be between 10 and 50.");
            }

            System.out.println("Please enter the number of correct answers:");
            // Throws exception if user enters a non-integer.
            if (!scanner.hasNextInt()) {
                scanner.nextLine();
                throw new ExamException("Number of correct answers must be an integer.");
            }
            // Throws exception if user enters less than 0 correct answers or more correct answers than there are
            // questions.
            correctAnswers = scanner.nextInt();
            if (correctAnswers < 0 || correctAnswers > noQuestions) {
                throw new ExamException("Correct answers must be between 0 and the number of questions.");
            }

            // Create the MultipleChoice object
            MultipleChoice newMultipleChoice = new MultipleChoice(examId, subject, duration, noQuestions, correctAnswers);

            // Add the new multiple choice object to the list of exams.
            examList.add(newMultipleChoice);
            System.out.println(ANSI_BLUE + "Multiple Choice Exam created successfully!\n" + ANSI_RESET);
            newMultipleChoice.displayExamDetails();

        } catch (ExamException e) {
            System.err.println(e.getMessage());
        } catch (InputMismatchException e) {
            System.err.println("Invalid input. Please ensure you enter the correct data types.");
            scanner.nextLine();
        }
    }

    // Checks new exam ids against existing to prevent duplicates.
    private static boolean doesExamExist(int examId) {
        for (Exam exam : examList) {
            if (exam.getExamId() == examId) {
                return true;
            }
        }
        return false;
    }

    // Prints all existing exams to the console.
    public static void listAllExams() {
        if (examList.isEmpty()) {
            System.out.println(ANSI_RED + "No exams found! Returning to Main Menu.\n" + ANSI_RESET);
            return;
        }

        for (Exam exam : examList) {
            exam.displayExamDetails();
        }
    }
}