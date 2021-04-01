package ua.com.foxminded.integerdivision;

public class Division {
    private StringBuilder result = new StringBuilder();
    private StringBuilder quotient = new StringBuilder();
    private StringBuilder remainder = new StringBuilder();

    public String makeDivision(Integer dividend, Integer divisor) {

        if (divisor == 0) {
            throw new IllegalArgumentException("Can not divide by zero");
        }

        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);

        String oneByOne = "";
        String[] digits = String.valueOf(dividend).split(oneByOne);
        Integer remainderNumber;
        Integer multiplyResult;
        Integer divisorDigit = calculateDigit(divisor);
        Integer mod;

        for (int i = 0; i < digits.length; i++) {
            remainder.append(digits[i]);
            remainderNumber = Integer.parseInt(remainder.toString());

            if (remainderNumber >= divisor) {
                mod = remainderNumber % divisor;
                multiplyResult = remainderNumber / divisor * divisor;

                String lastRemainder = String.format("%" + (i + 2) + "s",
                        "_" + remainderNumber.toString());
                result.append(lastRemainder).append("\n");

                String multiply = String.format("%" + (i + 2) + "d",
                        multiplyResult);
                result.append(multiply).append("\n");

                Integer tab = lastRemainder.length()
                        - calculateDigit(multiplyResult);
                result.append(makeDivisor(remainderNumber, tab)).append("\n");

                quotient.append(remainderNumber / divisor);

                remainder.replace(0, remainder.length(), mod.toString());
                remainderNumber = Integer.parseInt(remainder.toString());
            } else {
                if (i >= divisorDigit) {
                    quotient.append(0);
                }
            }

            if (i == digits.length - 1) {
                result.append(String.format("%" + (i + 2) + "s",
                        remainderNumber.toString())).append("\n");
            }
        }
        modifyResultToView(dividend, divisor);
        return result.toString();
    }

    private String makeDivisor(Integer remainderNumber, Integer tab) {
        return assemblyString(tab, ' ')
                + assemblyString(calculateDigit(remainderNumber), '-');
    }

    private void modifyResultToView(Integer dividend, Integer divisor) {
        int[] index = new int[3];
        for (int i = 0, j = 0; i < result.length(); i++) {
            if (result.charAt(i) == '\n') {
                index[j] = i;
                j++;
            }
            if (j == 3) {
                break;
            }
        }
        int tab = calculateDigit(dividend) + 1 - index[0];
        result.insert(index[2],
                assemblyString(tab, ' ') + "|" + quotient.toString());
        result.insert(index[1], assemblyString(tab, ' ') + "|"
                + assemblyString(quotient.length(), '-'));
        result.insert(index[0], "|" + divisor);
        result.replace(1, index[0], dividend.toString());
    }

    private int calculateDigit(Integer algebra) {
        return (int) Math.log10(algebra) + 1;
    }

    private String assemblyString(Integer numberOfSymbols, char symbol) {
        StringBuilder string = new StringBuilder();
        for (int i = 0; i < numberOfSymbols; i++) {
            string.append(symbol);
        }
        return string.toString();
    }
}
