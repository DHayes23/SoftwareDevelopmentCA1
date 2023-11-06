public class ExamResult implements Comparable<ExamResult> {
    private Student student;
    private Exam exam;
    private int score; // Should get from calculateScore()

    // Constructor
    public ExamResult(Student student, Exam exam, int score) {
        this.student = student;
        this.exam = exam;
        this.score = score;
    }

    // Getters
    public Student getStudent() {
        return student;
    }

    public Exam getExam() {
        return exam;
    }

    public int getScore() {
        return score;
    }

    // Setters
    public void setStudent(Student student) {
        this.student = student;
    }

    public void setExam(Exam exam) {
        this.exam = exam;
    }

    public void setScore(int score) {
        this.score = score;
    }

    // Implement the compareTo method to allow for comparison based on scores
    @Override
    public int compareTo(ExamResult other) {
        return Integer.compare(this.score, other.score);
    }

    @Override
    public String toString() {
        return "ExamResult{" +
                "student=" + student +
                ", exam=" + exam +
                ", score=" + score +
                '}';
    }
}
