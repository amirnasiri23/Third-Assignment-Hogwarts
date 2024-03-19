public class Quiz {
    private String question;
    private String answer;

    public Quiz(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    public boolean isCorrect(String answer) {
        return this.answer.equals(answer);
    }

    public void showQuestion() {
        System.out.println(this.question);
    }
}