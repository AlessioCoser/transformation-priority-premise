package com.alessiocoser;

public class WordWrap {

    public String wrap(String text, Integer length) throws InvalidArgument {
        if (length < 1) {
            throw new InvalidArgument();
        }

        if (text == null) {
            return "";
        }

        if (text.length() <= length) {
            return text;
        }

        int space = text.indexOf(" ");
        if (space >= 0) {
            return text.substring(0, space) + "\n" + text.substring(space + 1);
        }

        return text.substring(0, length) + "\n" + wrap(text.substring(length), length);
    }

    public class InvalidArgument extends Exception {
    }
}
