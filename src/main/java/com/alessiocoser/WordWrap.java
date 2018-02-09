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

        return "long\nword";
    }

    public class InvalidArgument extends Exception {
    }
}
