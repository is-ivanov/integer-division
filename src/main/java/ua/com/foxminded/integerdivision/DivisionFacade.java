package ua.com.foxminded.integerdivision;

import java.util.Objects;

public class DivisionFacade {

    private static final String MESSAGE_NULL_EXCEPTION = "Divident or divider is null";
    private static final String MESSAGE_DIVIDE_NULL = "Divider can't be 0";

    public String start(int divident, int divisor) {

        checkInputData(divident, divisor);
        DivisionDto result = new DivisionDto();
        DivisionCalculator calculator = new DivisionCalculator();
        result = calculator.calculateDivision(divident, divisor);
        DivisionFormatter divisionFormatter = new DivisionFormatter();
        String resultString = divisionFormatter.outputResult(result);
        
        return resultString;
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
