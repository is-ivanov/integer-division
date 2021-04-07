package ua.com.foxminded.integerdivision;

import java.util.List;

public class ResultOfCalculations {
    private final int dividend;
    private final int divisor;
    private final int quotient;
    private final int remainder;
    private final List<DivisionStep> divisionSteps;

    private ResultOfCalculations(ResultBuilder builder) {
        this.dividend = builder.dividend;
        this.divisor = builder.divisor;
        this.quotient = builder.quotient;
        this.remainder = builder.remainder;
        this.divisionSteps = builder.divisionSteps;

    }

    public int getDividend() {
        return this.dividend;
    }

    public int getDivisor() {
        return this.divisor;
    }

    public int getQuotient() {
        return this.quotient;
    }

    public int getRemainder() {
        return this.remainder;
    }

    public List<DivisionStep> getDivisionSteps() {
        return this.divisionSteps;
    }

    public static class ResultBuilder {
        private int dividend;
        private int divisor;
        private int quotient;
        private int remainder;
        private List<DivisionStep> divisionSteps;

        public ResultBuilder(int dividend, int divisor) {
            this.dividend = dividend;
            this.divisor = divisor;
        }

        public ResultBuilder quotient(int quotient) {
            this.quotient = quotient;
            return this;
        }
        
        public ResultBuilder remainder(int remainder) {
            this.remainder = remainder;
            return this;
        }

        public ResultBuilder divisionSteps(List<DivisionStep> divisionSteps) {
            this.divisionSteps = divisionSteps;
            return this;
        }

        public ResultOfCalculations build() {
            return new ResultOfCalculations(this);
        }
    }

}
