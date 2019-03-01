package com.example.misc;

import java.util.Calendar;
import java.util.Locale;
import java.util.regex.Pattern;

public class CardValidator {

    private static String DD_REGEX = "^(0[1-9]|1[0-2]|1)$";
    private Pattern pattern = Pattern.compile(DD_REGEX);

    /**
     * Function is online and predictive, so expected to be called for each character input.
     *
     * @param mmyy Input string.
     * @return true if current input can be within range of 15 years from now, false otherwise.
     */
    public boolean check(String mmyy) {
        if (mmyy == null || mmyy.length() == 0) return true;
        if (mmyy.length() > 4) return false;
        if (mmyy.length() <= 2) {
            return pattern.matcher(mmyy).matches();
        }
        // If user not yet entered last digit of year, check with prediction using lower bound
        return isWithinRange(mmyy.length() == 3 ? mmyy + "0" : mmyy);
    }

    /**
     * Checks mmyy value in within 15 years range from current month.
     *
     * @param mmyy Input value to be checked.
     * @return true if within range, false otherwise.
     */
    private boolean isWithinRange(String mmyy) {
        String lowerBoundString = ""
                + Calendar.getInstance(Locale.getDefault()).get(Calendar.YEAR) % 100
                + String.format("%02d", Calendar.getInstance(Locale.getDefault()).get(Calendar.MONTH));

        String upperBoundString = ""
                + (Calendar.getInstance(Locale.getDefault()).get(Calendar.YEAR) + 15) % 100
                + String.format("%02d", Calendar.getInstance(Locale.getDefault()).get(Calendar.MONTH));

        int lowerBound = Integer.parseInt(lowerBoundString);
        int upperBound = Integer.parseInt(upperBoundString);

        // Reverse mmyy
        mmyy = mmyy.substring(2) + mmyy.substring(0, 2);
        int value = Integer.parseInt(mmyy);

        return value > lowerBound && value < upperBound;
    }
}
