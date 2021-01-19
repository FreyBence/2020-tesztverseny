package hu.testathon.model.domain;

public class FinalResult {
    private final int order;
    private final String id;
    private final int score;

    public FinalResult(String id, int score) {
        this.order = 0;
    this.id = id;
        this.score = score;
    }
    public FinalResult(int order, String id, int score) {
        this.order = order;
        this.id = id;
        this.score = score;
    }

    public String getId() {
        return id;
    }

    public Integer getScore() {
        return score;
    }

    public int getOrder() {
        return order;
    }

    @Override
    public String toString() {
        return getOrder() + ". díj (" + getScore() + " pont): " + getId();
    }
}
