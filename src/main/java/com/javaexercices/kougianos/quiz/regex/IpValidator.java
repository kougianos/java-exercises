package com.javaexercices.kougianos.quiz.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IpValidator {

    private IpValidator(){

    }

    public static boolean isValidIPAddress(String ip) {

        if (ip == null) {
            return false;
        }

        // Regex for digit from 0 to 255.
        String zeroTo255 = "(\\d{1,2}|([01])\\d{2}|2[0-4]\\d|25[0-5])";

        // Regex for a digit from 0 to 255 and
        // followed by a dot, repeat 4 times.
        String regex = zeroTo255 + "\\." + zeroTo255 + "\\." + zeroTo255 + "\\." + zeroTo255;

        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(ip);

        // Return if the IP address
        // matched the ReGex
        return m.matches();
    }

}
