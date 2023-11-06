import java.util.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
public class ExamManagement {

    //    Color Palette Options for Terminal Use
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";

    // Initialises Main Menu Scanner
    private static List<Student> studentList = new ArrayList<>();
    private static List<Exam> examList = new ArrayList<>();

    private static List<ExamResult> examResultsList = new ArrayList<>();
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

        System.out.println("Welcome to the Exam Management System.\n");

        // Main Menu
        //      Enables main menu loop
        boolean mainMenuRunning = true;
        while (mainMenuRunning) {
            System.out.println(ANSI_GREEN + "--- MAIN MENU ---\n" + ANSI_RESET);
            System.out.println("Please choose one of the following options:\n");
            System.out.println(ANSI_BLUE + "- Students -" + ANSI_RESET);
            System.out.println(ANSI_BLUE + "1." + ANSI_RESET + " Add New Student");
            System.out.println(ANSI_BLUE + "2." + ANSI_RESET + " List All Students");
            System.out.println(ANSI_YELLOW + "- Exams -" + ANSI_RESET);
            System.out.println(ANSI_YELLOW + "3." + ANSI_RESET + " Add New Exam");
            System.out.println(ANSI_YELLOW + "4." + ANSI_RESET + " List All Exams");
            System.out.println(ANSI_YELLOW + "5." + ANSI_RESET + " Record Exam Result");
            System.out.println(ANSI_YELLOW + "6." + ANSI_RESET + " Display a Student's Exam Results");
            System.out.println(ANSI_YELLOW + "7." + ANSI_RESET + " Display/Print All Exam Results");
            System.out.println(ANSI_RED + "- System -" + ANSI_RESET);
            System.out.println(ANSI_RED + "8." + ANSI_RESET + " Create Test Data (Should be used only once, and before adding other users)");
            System.out.println(ANSI_RED + "0." + ANSI_RESET + " Exit System");
            System.out.println(ANSI_GREEN + "\nPlease make your selection:" + ANSI_RESET);


            int mainMenuChoice = scanner.nextInt();
            switch (mainMenuChoice) {
                case 1:
                    // Add student
                    System.out.println(ANSI_BLUE + "-- Add New Student --\n" + ANSI_RESET);
                    addStudentSubMenu();
                    break;
                case 2:
                    // List All Students
                    System.out.println(ANSI_BLUE + "-- List All Students --\n" + ANSI_RESET);
                    System.out.println("----------------------------------------------\n");
                    listAllStudents();
                    break;
                case 3:
                    // Add exam
                    System.out.println(ANSI_YELLOW + "-- Add New Exam --\n" + ANSI_RESET);
                    addExamSubMenu();
                    break;
                case 4:
                    // List All Exams
                    System.out.println(ANSI_YELLOW + "-- List All Exams --\n" + ANSI_RESET);
                    System.out.println("----------------------------------------------\n");

                    listAllExams();
                    break;
                case 5:
                    // Record exam result
                    System.out.println(ANSI_YELLOW + "-- Record Exam Result --\n" + ANSI_RESET);
                    recordExamResultFromInput();
                    break;
                case 6:
                    // Display exam results for student
                    System.out.println(ANSI_YELLOW + "-- Display a Student's Exam Results --\n" + ANSI_RESET);
                    printExamsForStudent();
                    break;
                case 7:
                    // Display all exam results
                    System.out.println(ANSI_YELLOW + "-- Display All Exam Results --\n" + ANSI_RESET);
                    printAllStudentsExamsDetails();
                    break;
                case 8:
                    System.out.println(ANSI_RED + "-- Create Test Data --\n" + ANSI_RESET);
                    System.out.println(ANSI_RED + "Test Data (Students and Exams) created.\n**Note that Exam Results must still be recorded, linking a student to an exam.**\n" + ANSI_RESET);
                    createSampleData();
                    break;
                case 0:
                    System.out.println(ANSI_RED + "-- Exit System --\n" + ANSI_RESET);
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
                    System.out.println(ANSI_YELLOW + "Adding Essay Exam...\n" + ANSI_RESET);
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
            System.out.println(ANSI_BLUE + "Student ID: " + ANSI_RESET + student.getStudentId());
            System.out.println(ANSI_BLUE + "Student Name: " + ANSI_RESET + student.getStudentName());
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
            System.out.println(ANSI_YELLOW + "Multiple Choice Exam created successfully!\n" + ANSI_RESET);
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

    public static void recordExamResultFromInput() {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println(ANSI_GREEN + "Please enter the student ID:" + ANSI_RESET);
            int studentId = scanner.nextInt();
            scanner.nextLine();
            Student student = getStudentById(studentId);

            System.out.println(ANSI_GREEN + "Please enter the exam ID:" + ANSI_RESET);
            int examId = scanner.nextInt();
            scanner.nextLine();
            Exam exam = getExamById(examId);

            int score = exam.calculateScore();

            // Create the ExamResult object
            ExamResult newExamResult = new ExamResult(student, exam, score);

            // Add the newExamResult to examResultsList
             examResultsList.add(newExamResult);

            // Add the exam to the student's examsTaken list
            student.addExam(exam);

            System.out.println(ANSI_YELLOW + "Exam Result created successfully!\n" + ANSI_RESET);
            System.out.println(ANSI_GREEN + "Student ID: " + ANSI_RESET + newExamResult.getStudent().getStudentId());
            System.out.println(ANSI_GREEN + "Exam ID: " + ANSI_RESET  + newExamResult.getExam().getExamId());
            System.out.println(ANSI_GREEN + "Score: " + ANSI_RESET  + newExamResult.getScore() + "%\n");

        } catch (InputMismatchException ime) {
            System.err.println("Invalid input. Please ensure you enter the correct data types.");
            scanner.nextLine();
        } catch (StudentException | ExamException e) {
            System.err.println(e.getMessage());
        }
    }


    // Finds a Student by their ID.
    public static Student getStudentById(int studentId) throws StudentException {
        for (Student student : studentList) {
            if (student.getStudentId() == studentId) {
                return student;
            }
        }
        // Throws an exception if matching student not found.
        throw new StudentException("Student with ID " + studentId + " not found.");
    }

    // Finds an Exam by its ID.
    public static Exam getExamById(int examId) throws ExamException {
        for (Exam exam : examList) {
            if (exam.getExamId() == examId) {
                return exam;
            }
        }
        // Throws an exception if matching exam not found.
        throw new ExamException("Exam with ID " + examId + " not found.");
    }

    // Asks user for student ID; if found prints the exams they've taken.
    public static void printExamsForStudent() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the student ID:");
        int studentId = scanner.nextInt();
        scanner.nextLine(); // Consume the rest of the line

        try {
            Student student = getStudentById(studentId);
            printExamsTakenByStudent(student);
        } catch (StudentException e) {
            System.err.println(e.getMessage());
        }
    }

    // Prints details about each exam an individual student has taken.
    public static void printExamsTakenByStudent(Student student) {
        System.out.println("\nExams taken by student " + student.getStudentName() + " (ID: " + student.getStudentId() + "):\n");
        if (student.getExamsTaken().isEmpty()) {
            System.out.println(ANSI_RED + "This student has not taken any exams yet." + ANSI_RESET);
        } else {
            for (Exam exam : student.getExamsTaken()) {
                exam.displayExamDetails();
            }
        }
    }

    public static void printAllStudentsExamsDetails() {
        // Check if there is any exam data to display
        boolean dataExists = false;
        for (Student student : studentList) {
            if (!student.getExamsTaken().isEmpty()) {
                dataExists = true;
                break; // Break the loop as we have found data
            }
        }

        // If no exams are found, print a message and return
        if (!dataExists) {
            System.out.println(ANSI_RED + "Unable to find any exams for any students! Returning to Main Menu.\n" + ANSI_RESET);
            return; // Exit the method early
        }

        // Iterate over all students and print their exam details
        for (Student student : studentList) {
            // Only proceed if the student has taken exams
            if (!student.getExamsTaken().isEmpty()) {
                // Print the student's details
                System.out.printf("Student ID: %-10d   Name: %-30s\n", student.getStudentId(), student.getStudentName());
                System.out.println("-------------------------------------------------------------------------------------------------------------------------------");

                // Header for exams
                System.out.println("Exam ID            Subject                   Duration                  Exam Type                 Score\n");

                // Iterate over each exam the student has taken
                for (Exam exam : student.getExamsTaken()) {
                    String examType = exam instanceof MultipleChoice ? "Multiple Choice" : "Essay";
                    int score = exam.calculateScore();

                    System.out.printf("%-13d      %-20s      %-20s      %-20s      %-15d     \n",
                            exam.getExamId(),
                            exam.getSubject(),
                            exam.getDuration() + " minutes",
                            examType,
                            exam.calculateScore());
                }
                System.out.println("===============================================================================================================================\n");
            }
        }

        // Ask the user if they want to print the data to a file
        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you want to print this data to a file? (y/n)");
        String response = scanner.nextLine();

        if ("y".equalsIgnoreCase(response)) {
            // Prompt for the file name
            System.out.println("Enter the filename to save to (e.g., exams.txt):");
            String filename = scanner.nextLine();

            // Call the method to write data to a file
            writeDataToFile(filename);
        }
    }
    private static void writeDataToFile(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            // Write the same data to the file as was printed to the screen
            for (Student student : studentList) {
                if (!student.getExamsTaken().isEmpty()) {
                    writer.write(String.format("Student ID: %-10d   Name: %-30s%n", student.getStudentId(), student.getStudentName()));
                    writer.write("-------------------------------------------------------------------------------------------------------------------------------\n");

                    writer.write("Exam ID            Subject                   Duration                  Exam Type                 Score\n");

                    for (Exam exam : student.getExamsTaken()) {
                        String examType = exam instanceof MultipleChoice ? "Multiple Choice" : "Essay";
                        int score = exam.calculateScore();

                        writer.write(String.format("%-13d      %-20s      %-20s      %-20s      %-15d     %n",
                                exam.getExamId(),
                                exam.getSubject(),
                                exam.getDuration() + " minutes",
                                examType,
                                exam.calculateScore()));
                    }
                    writer.write("===============================================================================================================================\n");
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
        }
    }

    private static void createSampleData(){
        // Create an array with all test student objects
        Student[] sampleStudents = new Student[0];
        try {
            sampleStudents = new Student[] {
                    new Student(1, "Roald Amundsen"),
                    new Student(2, "Robert Falcon Scott"),
                    new Student(3, "Ernest Shackleton"),
                    new Student(4, "Richard E. Byrd"),
                    new Student(5, "Fridtjof Nansen"),
                    new Student(6, "Sir John Franklin"),
                    new Student(7, "Douglas Mawson"),
                    new Student(8, "Matthew Henson"),
                    new Student(9, "Valerian Albanov"),
                    new Student(10, "Henry Hudson")
            };
        } catch (StudentException e) {
            throw new RuntimeException(e);
        }

        // Add all students to the studentList
        studentList.addAll(Arrays.asList(sampleStudents));

        List<Exam> sampleExams = new ArrayList<>();

        try {
            // Create MultipleChoice exams
            MultipleChoice mc1 = new MultipleChoice(101, "Geography", 30, 20, 15);
            MultipleChoice mc2 = new MultipleChoice(102, "Mathematics", 45, 35, 33);
            MultipleChoice mc3 = new MultipleChoice(103, "English", 50, 40, 23);
            MultipleChoice mc4 = new MultipleChoice(104, "Japanese", 60, 20, 18);
            MultipleChoice mc5 = new MultipleChoice(105, "French", 30, 25, 13);
            MultipleChoice mc6 = new MultipleChoice(106, "Physics", 90, 20, 16);
            MultipleChoice mc7 = new MultipleChoice(107, "German", 120, 35, 28);
            MultipleChoice mc8 = new MultipleChoice(108, "Biology", 45, 25, 20);
            MultipleChoice mc9 = new MultipleChoice(109, "Irish", 60, 30, 19);
            MultipleChoice mc10 = new MultipleChoice(110, "History", 45, 30, 8);

            // Create Essay exams
            Essay essay1 = new Essay(201, "History", 60, "The impact of World War II...", 80, 90, 1000);
            Essay essay2 = new Essay(202, "Literature", 90, "Analysis of Shakespeare's works...", 40, 55, 3000);
            Essay essay3 = new Essay(202, "Art", 90, "The life of Da'Vinci...", 85, 95, 1500);
            Essay essay4 = new Essay(202, "Architecture", 90, "Gaudi: Genius or Madman...", 55, 60, 2500);
            Essay essay5 = new Essay(202, "Medicine", 90, "Bedside Manner 101...", 55, 35, 1500);

            // Add MultipleChoice exams to sampleExams list
            sampleExams.add(mc1);
            sampleExams.add(mc2);
            sampleExams.add(mc3);
            sampleExams.add(mc4);
            sampleExams.add(mc5);
            sampleExams.add(mc6);
            sampleExams.add(mc7);
            sampleExams.add(mc8);
            sampleExams.add(mc9);
            sampleExams.add(mc10);

            // Add MultipleChoice exams to sampleExams list

            sampleExams.add(essay1);
            sampleExams.add(essay2);
            sampleExams.add(essay3);
            sampleExams.add(essay4);
            sampleExams.add(essay5);

        } catch (ExamException e) {
            throw new RuntimeException(e);
        }

        examList.addAll(sampleExams);
    }
}
