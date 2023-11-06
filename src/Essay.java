public class Essay extends Exam implements Scorable {
    private String essayAnswer;
    private int grammar;
    private int content;
    private int wordLimit;

    public Essay(int examId, String subject, int duration, String essayAnswer, int grammar, int content, int wordLimit) throws ExamException {
        super(examId, subject, duration);
        setWordLimit(wordLimit); // Using the setter to enforce the rule
        this.essayAnswer = essayAnswer;
        this.grammar = grammar;
        this.content = content;
    }

    public int gradeEssay() {
        // Assumes that grammar and content are already scores out of 100 - Will need to validate later!!
        int grammarScore = grammar; // 20% of total score
        int contentScore = content; // 70% of total score
        int lengthScore = (countWords(essayAnswer) <= wordLimit) ? 100 : 0; // 10% of total score. Doesn't account for essays being far short of the limit.

        // Calculate final score based on weighting.
        double finalScore = (grammarScore * 0.2) + (contentScore * 0.7) + (lengthScore * 0.1);

        // Round to nearest whole number for final score
        return (int) Math.round(finalScore);
    }

    private int countWords(String text) {
        // Counts words in essay.
        if (text == null || text.isEmpty()) {
            return 0;
        }
        String[] words = text.split("\\s+");
        return words.length;
    }

    @Override
    public int calculateScore() {
        return gradeEssay();
    }

    public void displayExamDetails() {
        System.out.println(ANSI_GREEN + "Exam ID: " + ANSI_RESET + getExamId());
        System.out.println(ANSI_GREEN + "Subject: " + ANSI_RESET + getSubject());
        System.out.println(ANSI_GREEN + "Duration: " + ANSI_RESET + getDuration());
        System.out.println(ANSI_GREEN + "Essay Answer: " + ANSI_RESET + getEssayAnswer());
        System.out.println(ANSI_GREEN + "Grammar Score: " + ANSI_RESET + getGrammar());
        System.out.println(ANSI_GREEN + "Content Score: " + ANSI_RESET + getContent());
        System.out.println(ANSI_GREEN + "Word Limit: " + ANSI_RESET + getWordLimit());
        System.out.println(ANSI_GREEN + "Calculated Score: " + ANSI_RESET + calculateScore()+ "%");
        System.out.println("----------------------------------------------\n");
    }

    // Getters
    public String getEssayAnswer() {
        return essayAnswer;
    }

    public int getGrammar() {
        return grammar;
    }

    public int getContent() {
        return content;
    }

    public int getWordLimit() {
        return wordLimit;
    }

    // Setters
    public void setEssayAnswer(String essayAnswer) {
        this.essayAnswer = essayAnswer;
    }

    public void setGrammar(int grammar) {
        this.grammar = grammar;
    }

    public void setContent(int content) {
        this.content = content;
    }

    public void setWordLimit(int wordLimit) throws ExamException {
        if (wordLimit < 500 || wordLimit > 10000) {
            throw new ExamException("Word limit must be between 500 and 10000.");
        }
        this.wordLimit = wordLimit;
    }
}