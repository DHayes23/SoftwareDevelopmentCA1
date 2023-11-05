
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
//    Initialises Main Menu Scanner
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
            System.out.println("2. Add New Exam");
            System.out.println("3. Record Exam Result");
            System.out.println("4. Display Exam Results");
            System.out.println("5. Print Results to File");
            System.out.println("6. Exit System");
            System.out.print(ANSI_GREEN + "Please make your selection:" + ANSI_RESET);


            int mainMenuChoice = scanner.nextInt();
            switch (mainMenuChoice) {
                case 1:
                    // Add student
                    System.out.println(ANSI_CYAN + "-- Add New Student --" + ANSI_RESET);
                    mainMenuRunning = false;
                    break;
                case 2:
                    // Add exam
                    System.out.println(ANSI_CYAN + "-- Add New Exam --" + ANSI_RESET);
                    mainMenuRunning = false;
                    break;
                case 3:
                    // Record exam result
                    System.out.println(ANSI_CYAN + "-- Record Exam Result --" + ANSI_RESET);
                    mainMenuRunning = false;
                    break;
                case 4:
                    // Display exam results
                    System.out.println(ANSI_CYAN + "-- Display Exam Result --" + ANSI_RESET);
                    mainMenuRunning = false;
                    break;
                case 5:
                    // Print results to file
                    System.out.println(ANSI_CYAN + "-- Print Exam Results to File --" + ANSI_RESET);
                    mainMenuRunning = false;
                    break;
                case 6:
                    System.out.println(ANSI_CYAN + "-- Exit System --" + ANSI_RESET);
                    mainMenuRunning = false;
                    break;
                default:
                    System.out.println(ANSI_RED + "Invalid option. Returning to Main Menu." + ANSI_RESET);
                    break;
            }
        }
    }
}