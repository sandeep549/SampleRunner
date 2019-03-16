package com.example.misc.cardexpiry;

import java.util.Calendar;
import java.util.regex.Pattern;

public class CardValidator {

    private static final int LEN = 4;
    private static final int YEAR_RANGE = 15;
    private static String DDMM_REGEX = "^(0[1-9]|1[0-2])[0-9]{2}$";
    private Pattern pattern = Pattern.compile(DDMM_REGEX);
    private Calendar calendar;

    public CardValidator(Calendar calendar) {
        this.calendar = calendar;
    }

    /**
     * Function is online and predictive, so expected to be called for each character input.
     * @param mmyy Input string.
     * @return true if current input can be within range of 15 years from now, false otherwise.
     */
    public boolean check(String mmyy) {
        if (mmyy == null || mmyy.length() == 0) return true;
        // If user not yet entered all digits, check with prediction using lower & upper bound
        String mmyyMin = String.format("%1$-" + LEN + "s", mmyy).replace(' ', '0');
        String mmyyMax = String.format("%1$-" + LEN + "s", mmyy).replace(' ', '9');
        return mmyy.length() <= 2 ? pattern.matcher(mmyyMin).matches() || pattern.matcher(mmyyMax).matches()
                : (pattern.matcher(mmyyMin).matches() || pattern.matcher(mmyyMax).matches())
                && (isWithinRange(mmyyMin) || isWithinRange(mmyyMax));
    }

    /**
     * Checks mmyy value in within 15 years range from current month.
     * @param mmyy Input value to be checked.
     * @return true if within range, false otherwise.
     */
    private boolean isWithinRange(String mmyy) {
        String lowerBoundString = ""
                + calendar.get(Calendar.YEAR) % 100
                + String.format("%02d", calendar.get(Calendar.MONTH));
        String upperBoundString = ""
                + (calendar.get(Calendar.YEAR) + YEAR_RANGE) % 100
                + String.format("%02d", calendar.get(Calendar.MONTH));
        int lowerBound = Integer.parseInt(lowerBoundString);
        int upperBound = Integer.parseInt(upperBoundString);
        int value = Integer.parseInt(mmyy.substring(2) + mmyy.substring(0, 2)); // yymm
        return value > lowerBound && value <= upperBound;
    }
}
