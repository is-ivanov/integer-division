package ua.com.foxminded.integerdivision;

@SuppressWarnings({ "squid:S106" })
public class StartLongDivision {

    public static void main(String[] args) {
        DataInputer dataInputer = new DataInputer();
        int[] initialData = dataInputer.getInitialData();
        
        DivisionCalculator calculator = new DivisionCalculator();
        Formatable formatter = new DivisionFormatter();

        DivisionFacade longDivision = new DivisionFacade(calculator, formatter);
        System.out.println(longDivision.makeDivision(initialData[0], initialData[1]));

    }

}
