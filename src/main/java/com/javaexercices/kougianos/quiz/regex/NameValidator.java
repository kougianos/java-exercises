package com.javaexercices.kougianos.quiz.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * For this exercise, keep in mind the following definitions:
 * <p>
 * A term is either an initials or word.
 * initials = 1 character
 * words = 2+ characters (no dots allowed)
 * <p>
 * A valid name is a name written in one of the following ways:
 * <p>
 * H. Wells
 * H. G. Wells
 * Herbert G. Wells
 * Herbert George Wells
 * <p>
 * The following names are invalid:
 * <p>
 * Herbert or Wells (single names not allowed)
 * H Wells or H. G Wells (initials must end with dot)
 * h. Wells or H. wells or h. g. Wells (incorrect capitalization)
 * H. George Wells (middle name expanded, while first still left as initial)
 * H. G. W. (last name is not a word)
 * Herb. G. Wells (dot only allowed after initial, not word)
 * <p>
 * Rules
 * <p>
 * Both initials and words must be capitalized.
 * Initials must end with a dot.
 * A name must be either 2 or 3 terms long.
 * If the name is 3 words long, you can expand the first and middle name or expand the first name only.
 * You cannot keep the first name as an initial and expand the middle name only.
 * The last name must be a word (not an initial).
 * <p>
 * Your task is to write a function that determines whether a name is valid or not. Return true if the
 * name is valid, false otherwise.
 */
public class NameValidator {

    private NameValidator() {
        throw new IllegalStateException("Utility class");
    }

    public static boolean validName(String str) {

        String[] array = str.split("\\s");
        String regex;
        if (array.length < 2 || array.length > 3) {
            return false;
        } else if (array.length == 2) {
            regex = "^[A-Z](?:\\.|\\w+)\\s[A-Z]\\w+$";
        } else {
            if (array[0].endsWith(".") && !array[1].endsWith(".")) {
                return false;
            }
            regex = "(^[A-Z](?:\\.|\\w+)\\s[A-Z](?:\\.|\\w+)\\s[A-Z]\\w*$)";
        }

        Pattern p = Pattern.compile(regex, Pattern.MULTILINE);
        Matcher m = p.matcher(str);
        return m.matches();

    }

    /**
     * This function removes hyphens from the end and start of a string, and if more that one hyphens exist
     * in the middle of the string they are removed as well leaving only one in each occurrence.
     * Eg.
     * --hello----my-man---how-are--you--  => hello-my-man-how-are-you
     *
     * @param str String
     * @return String
     */
    public static String hyphenSanitizer(String str) {
        final String regex = "-+";
        str = str.replaceAll(regex, "-");
        if (str.startsWith("-")) {
            str = str.replaceFirst("-", "");
        }
        if (str.endsWith("-")) {
            str = str.replaceAll("-$", "");
        }
        return str;
    }

}
