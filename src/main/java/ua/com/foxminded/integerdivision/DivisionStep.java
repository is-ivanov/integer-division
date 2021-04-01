package ua.com.foxminded.integerdivision;

public class DivisionStep {
    private int remainderNumber;
    private int multiplyResult;
    private int mod;
    private int indent;

    public DivisionStep(int reminderNumber, int multiplyResult, int mod,
            int indent) {
        super();
        this.remainderNumber = reminderNumber;
        this.multiplyResult = multiplyResult;
        this.mod = mod;
        this.indent = indent;
    }

    public int getReminderNumber() {
        return this.remainderNumber;
    }

    public void setReminderNumber(int reminderNumber) {
        this.remainderNumber = reminderNumber;
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

    public int getIndent() {
        return this.indent;
    }

    public void setIndent(int indent) {
        this.indent = indent;
    }

}
