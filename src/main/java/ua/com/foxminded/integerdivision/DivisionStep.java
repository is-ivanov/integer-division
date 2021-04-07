package ua.com.foxminded.integerdivision;

public class DivisionStep {
    private int remainderNumber;
    private int multiplyResult;
    private int mod;

    public DivisionStep(int remainderNumber, int multiplyResult, int mod) {
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + this.mod;
        result = prime * result + this.multiplyResult;
        result = prime * result + this.remainderNumber;
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
        DivisionStep other = (DivisionStep) obj;
        if (this.mod != other.mod)
            return false;
        if (this.multiplyResult != other.multiplyResult)
            return false;
        if (this.remainderNumber != other.remainderNumber)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "DivisionStep [remainderNumber=" + this.remainderNumber
                + ", multiplyResult=" + this.multiplyResult + ", mod="
                + this.mod + "]";
    }

}
