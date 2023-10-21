package resources.utilities;

public abstract class StringConversions {

    /*
     * USELESS FOR A WHILE
     *
     */
    public int toInt(String stringToConvert) {
        int number = 0;
        try {
            number = Integer.parseInt(stringToConvert);
        } catch (NumberFormatException e) {
            System.out.println("Error While converting!");
        }
        return number;
    }

    public double toDouble(String stringToConvert) {
        double number = 0;
        try {
            number = Double.parseDouble(stringToConvert);
        } catch (NumberFormatException e) {
            System.out.println("Error While converting!");
        }
        return number;
    }

}
