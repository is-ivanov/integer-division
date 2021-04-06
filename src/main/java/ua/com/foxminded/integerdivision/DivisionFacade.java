package ua.com.foxminded.integerdivision;

public class DivisionFacade {

    private static final String MESSAGE_DIVIDE_NULL = "Divisor can't be 0";

    public String start(int dividend, int divisor) {

        checkInputData(divisor);
        DivisionCalculator calculator = new DivisionCalculator();
        ResultOfCalculations result = calculator.calculateResult(dividend,
                divisor);
        DivisionFormatter divisionFormatter = new DivisionFormatter();

        return divisionFormatter.formatLine(result);
    }

    private void checkInputData(int divisor) {
        if (divisor == 0) {
            throw new IllegalArgumentException(MESSAGE_DIVIDE_NULL);
        }
    }
}
