package ua.com.foxminded.integerdivision;

import java.util.ArrayList;
import java.util.List;

public class ResultOfCalculations {
    private int dividend;
    private int divisor;
    private int quotient;
    private int remainder;
    private List<DivisionStep> divisionSteps = new ArrayList<>();

    public int getDividend() {
        return this.dividend;
    }

    public void setDividend(int divident) {
        this.dividend = divident;
    }

    public int getDivisor() {
        return this.divisor;
    }

    public void setDivisor(int divisor) {
        this.divisor = divisor;
    }

    public int getQuotient() {
        return this.quotient;
    }

    public void setQuotient(int quotient) {
        this.quotient = quotient;
    }

    public int getRemainder() {
        return this.remainder;
    }

    public void setRemainder(int remainder) {
        this.remainder = remainder;
    }

    public List<DivisionStep> getDivisionSteps() {
        return this.divisionSteps;
    }

    public void setDivisionSteps(List<DivisionStep> divisionSteps) {
        this.divisionSteps = divisionSteps;
    }

}
