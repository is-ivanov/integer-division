package ua.com.foxminded.integerdivision;

import java.util.ArrayList;
import java.util.List;

public class DivisionCalculator {

    public ResultOfCalculations calculateResult(int dividend, int divisor) {
        int quotient = dividend / divisor;
        int remainder = dividend % divisor;
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);

        List<DivisionStep> listDivisionSteps = new ArrayList<>();

        if (dividend == 0) {
            DivisionStep divisionStep = new DivisionStep(0,
                    0, 0);
            listDivisionSteps.add(divisionStep);
            return new ResultOfCalculations.ResultBuilder(dividend, divisor)
                    .quotient(quotient).remainder(remainder).divisionSteps(listDivisionSteps)
                    .build();
        } 
        
        int[] digitsDividend = reverseArray(extractDigitToArray(dividend));

        int mod = 0;
        int remainderNumber;
        int multiplyResult;
        for (int i = 0; i < digitsDividend.length; i++) {
            remainderNumber = mod + digitsDividend[i];
            mod = remainderNumber % divisor;
            multiplyResult = remainderNumber / divisor * divisor;

            DivisionStep divisionStep = new DivisionStep(remainderNumber,
                    multiplyResult, mod);
            listDivisionSteps.add(divisionStep);
            mod *= 10;
        }
        return new ResultOfCalculations.ResultBuilder(dividend, divisor)
                .quotient(quotient).remainder(remainder)
                .divisionSteps(listDivisionSteps).build();
    }

    private int[] extractDigitToArray(int number) {
        int lengthNumber = (int) Math.log10(number) + 1;
        int[] digits = new int[lengthNumber];
        for (int i = 0; i < lengthNumber; i++) {
            digits[i] = number % 10;
            number /= 10;
        }
        return digits;
    }

    private int[] reverseArray(int[] inputArray) {
        int length = inputArray.length;
        int[] outputArray = new int[length];
        for (int i = 0; i < length; i++) {
            outputArray[length - 1 - i] = inputArray[i];
        }
        return outputArray;
    }
}
