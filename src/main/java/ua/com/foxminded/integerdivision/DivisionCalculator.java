package ua.com.foxminded.integerdivision;

public class DivisionCalculator {
    private static final String DELIMITER_FOR_NUMBER = "";

    public DivisionDto calculateDivision(int divident, int divisor) {
        StringBuilder remainderStep = new StringBuilder();

        int quotient = divident / divisor;
        int remainder = divident % divisor;

        DivisionDto divisionData = new DivisionDto();
        divisionData.setDivident(divident);
        divisionData.setDivisor(divisor);
        divisionData.setQuotient(quotient);
        divisionData.setRemainder(remainder);

        divident = Math.abs(divident);
        divisor = Math.abs(divisor);

        int remainderNumber;
        int multiplyResult;
        // Integer divisorDigit = calculateDigit(divisor);
        int mod;
        int indent;

        String[] digitsDivident = String.valueOf(divident)
                .split(DELIMITER_FOR_NUMBER);

        for (int i = 0; i < digitsDivident.length; i++) {
            remainderStep.append(digitsDivident[i]); // как сделать на след шагах, чтобы было mod + след строка число
            remainderNumber = Integer.parseInt(remainderStep.toString());
            mod = remainderNumber % divisor;
            multiplyResult = remainderNumber / divisor * divisor;
            indent = i;
            DivisionStep divisionStep = new DivisionStep(remainderNumber,
                    multiplyResult, mod, indent);
            divisionData.setDivisionSteps(divisionStep);

        }

        return divisionData;
    }
}
