package com.javaexercices.kougianos.util;

import org.apache.commons.lang3.StringUtils;

public class TelcoUtils {

    private TelcoUtils() {

    }

    /**
     * validate that a msisdn:
     * - is 10/12 digits long
     * - starts with 3069 or 69
     * - all characters are numeric
     *
     * @param msisdn String
     */
    public static boolean isMsisdnValid(String msisdn) {

        return StringUtils.isNumeric(msisdn)
                && ((msisdn.startsWith("3069") && msisdn.length() == 12)
                || (msisdn.startsWith("69") && msisdn.length() == 10));

    }

    /**
     * validate that a cli:
     * - is 10 digits long
     * - starts with 2
     * - all characters are numeric
     *
     * @param cli String
     */
    public static boolean isCliValid(String cli) {
        return StringUtils.isNumeric(cli)
                && (cli.startsWith("2") && cli.length() == 10);
    }

}
