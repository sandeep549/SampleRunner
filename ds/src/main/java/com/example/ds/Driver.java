package com.example.ds;

import java.util.Calendar;
import java.util.Locale;
import java.util.regex.Pattern;

public class Driver {
    private static String DD_REGEX = "^(0[1-9]|1[0-2]|1)$";
    private static Pattern pattern = Pattern.compile(DD_REGEX);

    public static void main(String[] args) {
        getMiddleExpr();
    }

    // ^(0[1-9]|1[0-2])(2[0-9]|3[0-2])$
    private static String getMiddleExpr() {
        Calendar c = Calendar.getInstance(Locale.getDefault());
        int year = c.get(Calendar.YEAR) % 100;


        return null;
    }

    private static boolean validate(String mmyy) {
        if (mmyy == null || mmyy.length() == 0) return true;
        if (mmyy.length() <= 2) {
            return pattern.matcher(mmyy).matches();
        }
        if (mmyy.length() == 3) {

        }
        if (mmyy.length() == 4) {
            return isWithinRange(mmyy);
        }
        return false;
    }

    /**
     * Checks MMYY value in within range assuming lower bound current month
     * and upper bound after 15 years.
     *
     * @param mmyy Date string in mmyy format to be checked.
     * @return true if within range, false otherwise.
     */
    private static boolean isWithinRange(String mmyy) {
        String lowerBoundString = ""
                + Calendar.getInstance(Locale.getDefault()).get(Calendar.YEAR) % 100
                + String.format("%02d", Calendar.getInstance(Locale.getDefault()).get(Calendar.MONTH));

        String upperBoundString = ""
                + Calendar.getInstance(Locale.getDefault()).get(Calendar.YEAR) + 15 % 100
                + String.format("%02d", Calendar.getInstance(Locale.getDefault()).get(Calendar.MONTH));

        int lowerBound = Integer.parseInt(lowerBoundString);
        int upperBound = Integer.parseInt(upperBoundString);

        // Reverse mmyy
        mmyy = mmyy.substring(2) + mmyy.substring(0, 2);
        int value = Integer.parseInt(mmyy);

        return value > lowerBound && value < upperBound;
    }

}