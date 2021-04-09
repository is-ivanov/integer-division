package ua.com.foxminded.integerdivision;

public class DivisionFormatter implements Formatable {
    private static final char SYMBOL_DASH = '-';
    private static final char SYMBOL_SPACE = ' ';
    private static final char SYMBOL_UNDERSCORE = '_';
    private static final char SYMBOL_PERCENT = '%';
    private static final String PART_OF_STRING_WHEN_DIVIDEND_ZERO = " 0";
    private static final String UNDERLINE_WHEN_DIVIDEND_ZERO_STRING = " -";
    private static final String TEMPLATE_FORMAT_LINES = "%s%ds";
    private static final String TEMPLATE_FORMAT_FIRST_LINE = "_%d|%d";
    private static final String TEMPLATE_FORMAT_SECOND_LINE = "%s|%s";
    private static final String TEMPLATE_FORMAT_THIRD_LINE = "%s|%d";
    private static final String TEMPLATE_FORMAT_LINE_FINAL_REMAINDER = "%s%dd";
    private static final String LF = System.lineSeparator();

    @Override
    public String formatDivision(ResultOfCalculations result) {
        StringBuilder outputString = new StringBuilder();
        int divisor = result.getDivisor();
        int dividend = result.getDividend();
        int quotient = result.getQuotient();
        int remainder = result.getRemainder();
        int indentFinalRemainder = 0;
        int indent = 0;
        int i = 0;

        if (dividend == 0) {
            return getFormatDividendZero(divisor, dividend, quotient);
        }
        for (DivisionStep step : result.getDivisionSteps()) {

            int multiplyResult = step.getMultiplyResult();
            int remainderNumber = step.getRemainderNumber();

            if (multiplyResult >= divisor) {
                indentFinalRemainder = formatStepDivision(outputString, divisor,
                        dividend, quotient, indent, i, multiplyResult,
                        remainderNumber);
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

    private int formatStepDivision(StringBuilder outputString, int divisor, int dividend,
            int quotient, int indent, int i, int multiplyResult,
            int remainderNumber) {
        int indentFinalRemainder;
        String format = String.format(TEMPLATE_FORMAT_LINES,
                SYMBOL_PERCENT, indent + 2);

        String remainderString = String.format(format,
                Character.toString(SYMBOL_UNDERSCORE)
                        + remainderNumber);
        String multiplyString = String.format(format, multiplyResult);
        String underline = String.format(format,
                repeateChar(countDigit(remainderNumber), SYMBOL_DASH));
        if (i == 0) {
            outputString.append(getHeader(dividend, divisor, quotient,
                    multiplyString, underline));
        } else {
            outputString.append(remainderString).append(LF)
                    .append(multiplyString).append(LF).append(underline)
                    .append(LF);
        }
        indentFinalRemainder = underline.length();
        return indentFinalRemainder;
    }

    private String getFormatDividendZero(int divisor, int dividend,
            int quotient) {
        StringBuilder outputString = new StringBuilder();
        outputString
                .append(getHeader(dividend, divisor, quotient,
                        PART_OF_STRING_WHEN_DIVIDEND_ZERO,
                        UNDERLINE_WHEN_DIVIDEND_ZERO_STRING))
                .append(PART_OF_STRING_WHEN_DIVIDEND_ZERO);

        return outputString.toString();
    }

    private String getHeader(int dividend, int divisor, int quotient,
            String multiplyString, String underline) {
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
