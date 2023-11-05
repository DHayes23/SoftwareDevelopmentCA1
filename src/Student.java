import java.util.ArrayList;
import java.util.List;

public class Student implements Printable {
    private int studentId;
    private String studentName;
    private List<Exam> examsTaken;

    public Student(int studentId, String studentName) throws StudentException {
        if (studentName == null || studentName.trim().isEmpty() || studentName.length() < 2 || studentName.length() > 30) {
            throw new StudentException("Student name must be between 2 and 30 characters long.");
        }
        this.studentId = studentId;
        this.studentName = studentName;
        this.examsTaken = new ArrayList<>();
    }

    // Implementation of Printable methods
    @Override
    public void printSummaryResult() {
        // Implementation for printing summary
    }

    @Override
    public void printDetailedResults() {
        // Implementation for printing detailed results
    }

    // Getters
    public int getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public List<Exam> getExamsTaken() {
        return examsTaken;
    }

    // Setters
    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public void setStudentName(String studentName) throws StudentException {
        if (studentName == null || studentName.trim().isEmpty() || studentName.length() < 2 || studentName.length() > 30) {
            throw new StudentException("Student name must be between 2 and 30 characters long.");
        }
        this.studentName = studentName;
    }

    public void setExamsTaken(List<Exam> examsTaken) {
        this.examsTaken = examsTaken;
    }

    // Method to add an exam to the examsTaken list
    public void addExam(Exam exam) {
        if (exam != null) {
            this.examsTaken.add(exam);
        }
    }
}
