package ua.com.foxminded.integerdivision;

public class DivisionFormatter implements Formatable {
    private static final char SYMBOL_DASH = '-';
    private static final char SYMBOL_SPACE = ' ';
    private static final char SYMBOL_UNDERSCORE = '_';
    private static final char SYMBOL_PERCENT = '%';
    private static final String TEMPLATE_FORMAT_LINES = "%s%ds";
    private static final String TEMPLATE_FORMAT_FIRST_LINE = "_%d|%d";
    private static final String TEMPLATE_FORMAT_SECOND_LINE = "%s|%s";
    private static final String TEMPLATE_FORMAT_THIRD_LINE = "%s|%d";
    private static final String TEMPLATE_FORMAT_LINE_FINAL_REMAINDER = "%s%dd";
    private static final String LF = System.lineSeparator();

    @Override
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
                String format = String.format(TEMPLATE_FORMAT_LINES,
                        SYMBOL_PERCENT, indent + 2);

                String remainderString = String.format(format,
                        SYMBOL_UNDERSCORE + remainderNumber);
                String multiplyString = String.format(format, multiplyResult);
                String underline = String.format(format,
                        repeateChar(countDigit(remainderNumber), SYMBOL_DASH));
                indentFinalRemainder = underline.length();
                if (i == 0) {
                    outputString.append(createFirstThreeLines(dividend, divisor,
                            quotient, multiplyString, underline));
                } else {
                    outputString.append(remainderString).append(LF)
                                .append(multiplyString).append(LF)
                                .append(underline).append(LF);
                }
                i++;
            }
            indent++;
        }
        String finalRemainder = String
                .format(String.format(TEMPLATE_FORMAT_LINE_FINAL_REMAINDER,
                        SYMBOL_PERCENT, indentFinalRemainder), remainder);
        outputString.append(finalRemainder);
        return outputString.toString();
    }

    private String createFirstThreeLines(int dividend, int divisor,
            int quotient, String multiplyString, String underline) {
        StringBuilder firstThreeLines = new StringBuilder();
        String firstString = String.format(TEMPLATE_FORMAT_FIRST_LINE, dividend,
                divisor);
        firstThreeLines.append(firstString).append(LF);
        String secondStringAfterMultiply = String.format(
                TEMPLATE_FORMAT_SECOND_LINE,
                repeateChar(countDigit(dividend) + 1 - multiplyString.length(),
                        SYMBOL_SPACE),
                repeateChar(countDigit(Math.max(divisor, quotient)),
                        SYMBOL_DASH));
        firstThreeLines.append(multiplyString).append(secondStringAfterMultiply)
                .append(LF);
        String thirdStringAfterUnderline = String.format(
                TEMPLATE_FORMAT_THIRD_LINE,
                repeateChar(countDigit(dividend) + 1 - underline.length(),
                        SYMBOL_SPACE),
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
