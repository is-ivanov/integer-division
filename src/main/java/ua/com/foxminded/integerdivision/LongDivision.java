package ua.com.foxminded.integerdivision;

public class LongDivision {

    @SuppressWarnings({ "squid:S106" })
    public static void main(String[] args) {
        DivisionFacade longDivision = new DivisionFacade();

        System.out.println(longDivision.start(-1578, 4));
    }

}
