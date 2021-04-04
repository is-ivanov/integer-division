package ua.com.foxminded.integerdivision;

public class DivisionStep {
    private int remainderNumber;
    private int multiplyResult;
    private int mod;

    public DivisionStep(int remainderNumber, int multiplyResult, int mod) {
        super();
        this.remainderNumber = remainderNumber;
        this.multiplyResult = multiplyResult;
        this.mod = mod;
    }

    public int getRemainderNumber() {
        return this.remainderNumber;
    }

    public void setRemainderNumber(int remainderNumber) {
        this.remainderNumber = remainderNumber;
    }

    public int getMultiplyResult() {
        return this.multiplyResult;
    }

    public void setMultiplyResult(int multiplyResult) {
        this.multiplyResult = multiplyResult;
    }

    public int getMod() {
        return this.mod;
    }

    public void setMod(int mod) {
        this.mod = mod;
    }

}
