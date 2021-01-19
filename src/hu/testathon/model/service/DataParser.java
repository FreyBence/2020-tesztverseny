package hu.testathon.model.service;

import hu.testathon.model.domain.TestResult;

import java.util.List;
import java.util.stream.Collectors;

public class
DataParser {
    public String getAnswers(List<String> lines) {
        return lines.get(0);
    }

    public List<TestResult> getResults(List<String> lines) {
        return lines.stream()
                .skip(1)
                .map(this::createTestResult)
                .collect(Collectors.toList());

    }
    private TestResult createTestResult(String line) {
        String[] items = line.split(" ");
        return new TestResult(items[0], items[1]);
    }
}
