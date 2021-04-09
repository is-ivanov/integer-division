package ua.com.foxminded.integerdivision;

public class DivisionFacade {

    private static final String MESSAGE_DIVIDE_NULL = "Divisor can't be 0";

    private DivisionCalculator calculator;
    private Formatable divisionFormatter;

    public DivisionFacade(DivisionCalculator calculator, Formatable divisionFormatter) {
        this.calculator = calculator;
        this.divisionFormatter = divisionFormatter;
    }

    public String makeDivision(int dividend, int divisor) {

        checkInputData(divisor);

        ResultOfCalculations result = calculator.calculateResult(dividend,
                divisor);

        return divisionFormatter.formatDivision(result);
    }

    private void checkInputData(int divisor) {
        if (divisor == 0) {
            throw new IllegalArgumentException(MESSAGE_DIVIDE_NULL);
        }
    }
}
