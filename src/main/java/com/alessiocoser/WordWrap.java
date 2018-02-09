package com.alessiocoser;

public class WordWrap {

    public String wrap(String text, Integer length) throws InvalidArgument {
        if (length < 1)
            throw new InvalidArgument();

        if (text == null)
            return "";

        if (text.length() <= length)
            return text;

        int space = text.indexOf(" ");
        if (space >= 0) {
            return breakBetween(text, space, space + 1, length);
        }

        return breakBetween(text, length, length, length);
    }

    private String breakBetween(String text, Integer start, Integer end, Integer length) throws InvalidArgument {
        return text.substring(0, start) + "\n" + wrap(text.substring(end), length);
    }

    public class InvalidArgument extends Exception {
    }
}
