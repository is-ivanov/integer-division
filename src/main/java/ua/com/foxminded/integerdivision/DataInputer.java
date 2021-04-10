package ua.com.foxminded.integerdivision;

import java.util.Scanner;

@SuppressWarnings({ "squid:S106" })
public class DataInputer {

    private static final String ERROR_MESSAGE = "This isn't number! ";
    private static final String MESSAGE_INPUT_DIVISOR = "Input divisor: ";
    private static final String MESSAGE_INPUT_DIVIDEND = "Input dividend: ";

    public int[] getInitialData() {
        int[] initialData = new int[2];
        String[] messages = { MESSAGE_INPUT_DIVIDEND, MESSAGE_INPUT_DIVISOR };
        Scanner in = new Scanner(System.in);

        for (int i = 0; i < initialData.length; i++) {
            System.out.print(messages[i]);
            while (!in.hasNextInt()) {
                System.out.print(ERROR_MESSAGE + messages[i]);
                in.next();
            }
            initialData[i] = in.nextInt();
        }

        in.close();
        return initialData;
    }
}
