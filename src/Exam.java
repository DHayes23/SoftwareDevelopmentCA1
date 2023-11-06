public abstract class Exam {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    protected int examId;
    protected String subject;
    protected int duration;

    public Exam(int examId, String subject, int duration) throws ExamException {
        setDuration(duration); // Using the setter to enforce the rule within the constructor
        this.examId = examId;
        this.subject = subject;
    }

    // Getters
    public int getExamId() {
        return examId;
    }

    public String getSubject() {
        return subject;
    }

    public int getDuration() {
        return duration;
    }

    // Setters
    public void setExamId(int examId) {
        this.examId = examId;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setDuration(int duration) throws ExamException {
        if (duration < 30 || duration > 180) {
            throw new ExamException("Duration must be between 30 and 180 minutes.");
        }
        this.duration = duration;
    }

    public void displayExamDetails() {
    }

    public abstract int calculateScore();

}