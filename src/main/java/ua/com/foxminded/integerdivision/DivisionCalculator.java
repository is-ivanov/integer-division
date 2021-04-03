package ua.com.foxminded.integerdivision;

import java.util.ArrayList;
import java.util.List;

public class DivisionCalculator {
    private static final String DELIMITER_FOR_NUMBER = "";

    public DivisionDto calculateDivision(int dividend, int divisor) {
        StringBuilder remainderStep = new StringBuilder();

        int quotient = dividend / divisor;
        int remainder = dividend % divisor;
        // without minus
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);

        DivisionDto divisionData = new DivisionDto();
        divisionData.setDivident(dividend);
        divisionData.setDivisor(divisor);
        divisionData.setQuotient(quotient);
        divisionData.setRemainder(remainder);
//      with minus
//        dividend = Math.abs(dividend);
//        divisor = Math.abs(divisor);

        int remainderNumber;
        int multiplyResult;
        // Integer divisorDigit = calculateDigit(divisor);
        int mod;
        int indent = 0;

        String[] digitsDivident = String.valueOf(dividend)
                .split(DELIMITER_FOR_NUMBER);
        List<DivisionStep> divisionSteps = new ArrayList<>();

        for (int i = 0; i < digitsDivident.length; i++) {
            remainderStep.append(digitsDivident[i]);
            remainderNumber = Integer.parseInt(remainderStep.toString());
            mod = remainderNumber % divisor;
            multiplyResult = remainderNumber / divisor * divisor;
            if (mod == 0 || remainderNumber == 0
                    || remainderNumber < divisor) {
                indent = i + 1;
            }

            DivisionStep divisionStep = new DivisionStep(remainderNumber,
                    multiplyResult, mod, indent);
            divisionSteps.add(divisionStep);
            remainderStep.replace(0, remainderStep.length(), mod + "");

        }
        divisionData.setDivisionSteps(divisionSteps);
        return divisionData;
    }

//    private int[] extractDigit(int number) {
//        int lengthNumber = (int) Math.log10(number) + 1;
//        int[] digits = new int[lengthNumber];
//        while (number !=0) {
//            digits[];
//            
//        }
//        return;
//    }
}
