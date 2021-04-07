package ua.com.foxminded.integerdivision;

public class DivisionFacade {

    private static final String MESSAGE_DIVIDE_NULL = "Divisor can't be 0";

    DivisionCalculator calculator;
    Formatable divisionFormatter;

    public DivisionFacade(DivisionCalculator calculator, Formatable formatter) {
        this.calculator = calculator;
        this.divisionFormatter = formatter;
    }

    public String start(int dividend, int divisor) {

        checkInputData(divisor);

        ResultOfCalculations result = calculator.calculateResult(dividend,
                divisor);

        return divisionFormatter.formatLine(result);
    }

    private void checkInputData(int divisor) {
        if (divisor == 0) {
            throw new IllegalArgumentException(MESSAGE_DIVIDE_NULL);
        }
    }
}
