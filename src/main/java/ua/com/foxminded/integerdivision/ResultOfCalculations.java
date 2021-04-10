package ua.com.foxminded.integerdivision;

import java.util.List;

public class ResultOfCalculations {
    private final int dividend;
    private final int divisor;
    private final int quotient;
    private final int remainder;
    private final List<DivisionStep> divisionSteps;

    private ResultOfCalculations(ResultOfCalculationsBuilder builder) {
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

    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + this.dividend;
        result = prime * result + ((this.divisionSteps == null) ? 0
                : this.divisionSteps.hashCode());
        result = prime * result + this.divisor;
        result = prime * result + this.quotient;
        result = prime * result + this.remainder;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ResultOfCalculations other = (ResultOfCalculations) obj;
        if (this.dividend != other.dividend)
            return false;
        if (this.divisionSteps == null) {
            if (other.divisionSteps != null)
                return false;
        } else if (!this.divisionSteps.equals(other.divisionSteps))
            return false;
        if (this.divisor != other.divisor)
            return false;
        if (this.quotient != other.quotient)
            return false;
        if (this.remainder != other.remainder)
            return false;
        return true;
    }

    
    
    @Override
    public String toString() {
        return "ResultOfCalculations [dividend=" + this.dividend + ", divisor="
                + this.divisor + ", quotient=" + this.quotient + ", remainder="
                + this.remainder + ", divisionSteps=" + this.divisionSteps
                + "]";
    }



    public static class ResultOfCalculationsBuilder {
        private int dividend;
        private int divisor;
        private int quotient;
        private int remainder;
        private List<DivisionStep> divisionSteps;

        public ResultOfCalculationsBuilder(int dividend, int divisor) {
            this.dividend = dividend;
            this.divisor = divisor;
        }

        public ResultOfCalculationsBuilder quotient(int quotient) {
            this.quotient = quotient;
            return this;
        }
        
        public ResultOfCalculationsBuilder remainder(int remainder) {
            this.remainder = remainder;
            return this;
        }

        public ResultOfCalculationsBuilder divisionSteps(List<DivisionStep> divisionSteps) {
            this.divisionSteps = divisionSteps;
            return this;
        }

        public ResultOfCalculations build() {
            return new ResultOfCalculations(this);
        }
    }

}
