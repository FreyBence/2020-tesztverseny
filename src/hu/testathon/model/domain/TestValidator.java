package hu.testathon.model.domain;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TestValidator {
    /**
     * A verseny feladatai nem egyenlő nehézségűek:
     * az 1-5. feladat 3 pontot, a 6-10. feladat
     * 4 pontot, a 11-13. feladat 5 pontot, míg a 14. feladat 6 pontot ér.
     */
    private static final int[] POINTS = {3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 5, 5, 5, 6};

    private  final  String answers;

    public TestValidator(String answers) {
        this.answers = answers;
    }

    public String getAnswers() {
        return answers;
    }

    public String checkResult(String competitorAnswers) {
        return IntStream.range(0, answers.length())
                .mapToObj(i -> checkAnswer(competitorAnswers, i))
                .collect(Collectors.joining());
    }

    public int calculateScore(String competitorAnswers) {
        return IntStream.range(0, answers.length())
                .map(i -> getScore(competitorAnswers, i))
                .sum();
    }

    public boolean isCorrect(String competitorAnswers, int i) {
        return answers.charAt(i) == competitorAnswers.charAt(i);
    }
    private String checkAnswer(String competitorAnswers, int i) {
    return isCorrect(competitorAnswers, i) ? "+" : " ";
    }

    private int getScore(String competitorAnswers, int i) {
        return isCorrect(competitorAnswers, i) ? POINTS[i] : 0;
    }

}
