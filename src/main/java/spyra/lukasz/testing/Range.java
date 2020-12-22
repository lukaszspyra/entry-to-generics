package spyra.lukasz.testing;

public class Range {

    private final long lowerBound;
    private final long upperBound;

    Range(final long lowerBound, final long upperBound) {
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
    }

    boolean isInRange(Long number){

        return number >= lowerBound && number <= upperBound;
    }

}
