package model;

import java.util.ArrayList;
import java.util.HashMap;

public class Question {
    private static final ArrayList<String> questions = new ArrayList<>();
    private final HashMap<Integer, String> answers = new HashMap<>();

    public static void addToQuestions(String question) {
        questions.add(question);
    }

    public void addToAnswers(int questionNo, String answer) {
        if (questionNo < 0 || questionNo >= questions.size()) {
            throw new IllegalArgumentException("Invalid question number");
        }
        this.answers.put(questionNo, answer);
    }

    public boolean hasAnswered(int number) {
        return answers.containsKey(number);
    }

    public boolean isAnswerTrue(String answer, int number) {
        return answers.get(number).equals(answer);
    }

    public static ArrayList<String> getQuestions() {
        return questions;
    }
}
