public class MultipleChoice extends Exam implements Scorable{

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    private int correctAnswers;
    private int noQuestions;

    public MultipleChoice(int examId, String subject, int duration, int noQuestions, int correctAnswers) throws ExamException {
        super(examId, subject, duration);
        setNoQuestions(noQuestions); // Using the setter to enforce the rule
        //    This part of the system brief doesn't make sense. This shouldn't be in the Multiple Choice class.
        setCorrectAnswers(correctAnswers); // Using the setter to enforce the rule
    }

    @Override
    public int calculateScore() {
        return (int) ((double) correctAnswers / noQuestions * 100);
    }

    public void displayExamDetails() {
        System.out.println("----------------------------------------------\n");
        System.out.println("Exam ID: " + getExamId());
        System.out.println("Subject: " + getSubject());
        System.out.println("Duration: " + getDuration());
        System.out.println("Number of Questions: " + getNoQuestions());
//        This part of the system brief doesn't make sense. This shouldn't be in the Multiple Choice class.
        System.out.println("Correct Answers: " + getCorrectAnswers());
        System.out.println("Score: " + calculateScore() + "%");
        System.out.println("----------------------------------------------\n");
    }

    // Getters

//    This part of the system brief doesn't make sense. This shouldn't be in the Multiple Choice class.
    public int getCorrectAnswers() {
        return correctAnswers;
    }

    public int getNoQuestions() {
        return noQuestions;
    }

    // Setters
//    This part of the system brief doesn't make sense. This shouldn't be in the Multiple Choice class.
    public void setCorrectAnswers(int correctAnswers) throws ExamException {
        if (correctAnswers < 0) {
            throw new ExamException("Correct answers must be greater than or equal to zero.");
        }
        this.correctAnswers = correctAnswers;
    }

    public void setNoQuestions(int noQuestions) throws ExamException {
        if (noQuestions < 10 || noQuestions > 50) {
            throw new ExamException("Number of questions must be between 10 and 50.");
        }
        this.noQuestions = noQuestions;
    }
}