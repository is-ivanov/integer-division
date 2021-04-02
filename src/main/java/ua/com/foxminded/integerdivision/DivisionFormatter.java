package ua.com.foxminded.integerdivision;

public class DivisionFormatter {
    public static final String LF = System.lineSeparator();

    public String outputResult(DivisionDto result) {
        StringBuilder outputResult = new StringBuilder();
        outputResult.append(formatFirstLine(result));

        return outputResult.toString();
    }

    private String formatFirstLine(DivisionDto result) {
        return String.format("_%d|%d", result.getDivident(),
                result.getDivisor()) + LF;
    }

    // format second line
    private String formatSecondStringLine(DivisionDto result) {
        for (DivisionStep divisionStep : result.getDivisionSteps()) {

            int multiplyResult = divisionStep.getMultiplyResult();
            if (multiplyResult != 0) {
                int digitsOfDivident = countDigit(result.getDivident());
                String secondLine = String.format(
                        " %-" + (digitsOfDivident - countDigit(multiplyResult))
                                + "d|%d",
                        multiplyResult, result.getQuotient());
                startLines.append(secondLine);
                break;
            }
        }
    }

    // method count digits in number
    private int countDigit(int number) {
        return (int) Math.log10(number) + 1;

    }

    // method
    private String repeaterChar(int numberOfChars, char symbol) {
        StringBuilder string = new StringBuilder();
        for (int i = 0; i < numberOfChars; i++) {
            string.append(symbol);
        }
        return string.toString();
    }
}
