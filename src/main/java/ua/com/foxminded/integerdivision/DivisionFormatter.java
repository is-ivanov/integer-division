package ua.com.foxminded.integerdivision;

public class DivisionFormatter {
    public static final String LF = System.lineSeparator();

    public String outputResult(DivisionDto result) {
        StringBuilder outputResult = new StringBuilder();
        outputResult.append(formatLine(result));

        return outputResult.toString();
    }

    // format line
    private String formatLine(DivisionDto result) {
        StringBuilder outputString = new StringBuilder();
        int divisor = result.getDivisor();
        int divident = result.getDivident();
        int quotient = result.getQuotient();
        int remainder = result.getRemainder();
        int indent = 0;
        int i = 0;
        for (DivisionStep step : result.getDivisionSteps()) {

            int multiplyResult = step.getMultiplyResult();
            int remainderNumber = step.getReminderNumber();

            if (multiplyResult >= divisor) {
                String format = "%" + (indent + 2) + "s";

                String remainderString = String.format(format,
                        "_" + remainderNumber);
                String multiplyString = String.format(format, multiplyResult);
                String underline = String.format(format,
                        repeaterChar(countDigit(remainderNumber), '-'));
                if (i == 0) {
                    String firstString = String.format("_%d|%d", divident,
                            divisor);
                    outputString.append(firstString).append(LF);
                    String secondStringAfterMultiply = String.format("%s|%s",
                            repeaterChar(countDigit(divident) + 1
                                    - multiplyString.length(), ' '),
                            repeaterChar(countDigit(quotient), '-'));
                    outputString.append(multiplyString)
                            .append(secondStringAfterMultiply).append(LF);
                    String thirdStringAfterUnderline = String
                            .format("%s|%d",
                                    repeaterChar(countDigit(divident) + 1
                                            - underline.length(), ' '),
                                    quotient);
                    outputString.append(underline)
                            .append(thirdStringAfterUnderline).append(LF);
                } else {
                    outputString.append(remainderString).append(LF);
                    outputString.append(multiplyString).append(LF);
                    outputString.append(underline).append(LF);
                }

                i++;
            }
            indent++;
        }
        String finalRemainder = String.format("%" + (indent + 1) + "d",
                remainder);
        outputString.append(finalRemainder);
        return outputString.toString();
    }

    // method count digits in number
    private int countDigit(int number) {
        return (int) Math.log10(number) + 1;

    }

    // method repeat any chars
    private String repeaterChar(int numberOfChars, char symbol) {
        StringBuilder string = new StringBuilder();
        for (int i = 0; i < numberOfChars; i++) {
            string.append(symbol);
        }
        return string.toString();
    }
}
