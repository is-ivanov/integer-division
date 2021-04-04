package ua.com.foxminded.integerdivision;

public class DivisionFormatter {
    private static final String LF = System.lineSeparator();

    public String formatLine(ResultOfCalculations result) {
        StringBuilder outputString = new StringBuilder();
        int divisor = result.getDivisor();
        int dividend = result.getDividend();
        int quotient = result.getQuotient();
        int remainder = result.getRemainder();
        int indentFinalRemainder = 0;
        int indent = 0;
        int i = 0;
        for (DivisionStep step : result.getDivisionSteps()) {

            int multiplyResult = step.getMultiplyResult();
            int remainderNumber = step.getRemainderNumber();

            if (multiplyResult >= divisor) {
                String format = String.format("%s%ds", "%", indent + 2);

                String remainderString = String.format(format,
                        "_" + remainderNumber);
                String multiplyString = String.format(format, multiplyResult);
                String underline = String.format(format,
                        repeateChar(countDigit(remainderNumber), '-'));
                indentFinalRemainder = underline.length();
                if (i == 0) {
                    outputString.append(createFirstThreeLines(dividend, divisor,
                            quotient, multiplyString, underline));
                } else {
                    outputString.append(remainderString).append(LF);
                    outputString.append(multiplyString).append(LF);
                    outputString.append(underline).append(LF);
                }

                i++;
            }
            indent++;
        }
        String finalRemainder = String
                .format(String.format("%s%dd", "%", indentFinalRemainder), remainder);
        outputString.append(finalRemainder);
        return outputString.toString();
    }

    private String createFirstThreeLines(int dividend, int divisor,
            int quotient, String multiplyString, String underline) {
        StringBuilder firstThreeLines = new StringBuilder();
        String firstString = String.format("_%d|%d", dividend, divisor);
        firstThreeLines.append(firstString).append(LF);
        String secondStringAfterMultiply = String.format("%s|%s",
                repeateChar(countDigit(dividend) + 1 - multiplyString.length(),
                        ' '),
                repeateChar(countDigit(quotient), '-'));
        firstThreeLines.append(multiplyString).append(secondStringAfterMultiply)
                .append(LF);
        String thirdStringAfterUnderline = String.format("%s|%d",
                repeateChar(countDigit(dividend) + 1 - underline.length(), ' '),
                quotient);
        firstThreeLines.append(underline).append(thirdStringAfterUnderline)
                .append(LF);
        return firstThreeLines.toString();
    }

    private int countDigit(int number) {
        return (int) Math.log10(number) + 1;
    }

    private String repeateChar(int numberOfChars, char symbol) {
        StringBuilder string = new StringBuilder();
        for (int i = 0; i < numberOfChars; i++) {
            string.append(symbol);
        }
        return string.toString();
    }
}
