public final class RankingOutOfBoundsException extends Exception {
    public RankingOutOfBoundsException(int ranking) {
        super("Ranking must be in [0,1000]: " + ranking);
    }
}
