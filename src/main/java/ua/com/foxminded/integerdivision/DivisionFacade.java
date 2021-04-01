package ua.com.foxminded.integerdivision;

import java.util.Objects;

public class DivisionFacade {

    private static final String MESSAGE_NULL_EXCEPTION = "Divident or divider is null";
    private static final String MESSAGE_DIVIDE_NULL = "Divider can't be 0";

    public String start(int divident, int divisor) {

        checkInputData(divident, divisor);

        DivisionCalculator calculator = new DivisionCalculator();
        calculator.calculateDivision(divident, divisor);
        return "Test";
    }

    private void checkInputData(int divident, int divisor) {

        // Why check for null, if this configure isn't compile
        if (Objects.isNull(divident) || Objects.isNull(divisor)) {
            throw new IllegalArgumentException(MESSAGE_NULL_EXCEPTION);
        }
        if (divisor == 0) {
            throw new IllegalArgumentException(MESSAGE_DIVIDE_NULL);
        }
    }
}
