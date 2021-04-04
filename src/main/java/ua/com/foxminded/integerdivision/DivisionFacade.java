package ua.com.foxminded.integerdivision;

import java.util.Objects;

public class DivisionFacade {

    private static final String MESSAGE_NULL_EXCEPTION = "Divident or divisor is null";
    private static final String MESSAGE_DIVIDE_NULL = "Divisor can't be 0";

    public String start(int dividend, int divisor) {

        checkInputData(dividend, divisor);
        DivisionCalculator calculator = new DivisionCalculator();
        ResultOfCalculations result = calculator.calculateResult(dividend,
                divisor);
        DivisionFormatter divisionFormatter = new DivisionFormatter();

        return divisionFormatter.formatLine(result);
    }

    private void checkInputData(int dividend, int divisor) {

        // Why check for null, if this configure isn't compile
        if (Objects.isNull(dividend) || Objects.isNull(divisor)) {
            throw new IllegalArgumentException(MESSAGE_NULL_EXCEPTION);
        }
        if (divisor == 0) {
            throw new IllegalArgumentException(MESSAGE_DIVIDE_NULL);
        }
    }
}
