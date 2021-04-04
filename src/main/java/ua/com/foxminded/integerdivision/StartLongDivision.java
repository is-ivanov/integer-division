package ua.com.foxminded.integerdivision;

@SuppressWarnings({ "squid:S106" })
public class StartLongDivision {

    public static void main(String[] args) {
        DataInputer dataInputer = new DataInputer();
        int[] initialData = dataInputer.getInitialData();

        DivisionFacade longDivision = new DivisionFacade();
        System.out.println(longDivision.start(initialData[0], initialData[1]));

    }

}
