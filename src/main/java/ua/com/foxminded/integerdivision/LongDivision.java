package ua.com.foxminded.integerdivision;

public class LongDivision {

    @SuppressWarnings({ "squid:S106" })
    public static void main(String[] args) {
        DivisionFacade longDivision = new DivisionFacade();
        Division division = new Division();
        
//        System.out.println(String.format("%3s", "1"));
//        System.out.println(longDivision.start(405022500, 45));
        System.out.println(division.makeDivision(405022500, 45));
    }

}
