package com.ustmportal.resources.utilities;

import com.ustmportal.resources.logs.Log;

public class Conversions {

    /*
     * USELESS FOR A WHILE
     *
     */
    public int toInt(String stringToConvert) {
        int number = 0;
        try {
            number = Integer.parseInt(stringToConvert);
        } catch (NumberFormatException e) {
            Log.error(e, "Erro While converting from string to int!");
        }
        return number;
    }

    public byte toByte(String stringToConvert) {
        byte number = 0;
        try {
            number = Byte.parseByte(stringToConvert);
        } catch (NumberFormatException e) {
            Log.error(e, "Erro While converting from string to byte!");

        }
        return number;
    }

    public double toDouble(String stringToConvert) {
        double number = 0;
        try {
            number = Double.parseDouble(stringToConvert);
        } catch (NumberFormatException e) {
            Log.error(e, "Erro While converting from string to double!");
        }
        return number;
    }

    public String intToString(int integerToConvert) {
        String string = Integer.toString(integerToConvert);
        return string;
    }

    public String byToString(byte byteToConvert) {
        String string = Byte.toString(byteToConvert);
        return string;
    }

    public String charToString(char characterToConvert) {
        String string = Character.toString(characterToConvert);
        return string;
    }

    public String doubToString(double doubleToConvert) {
        String string = Double.toString(doubleToConvert);
        return string;
    }

}
