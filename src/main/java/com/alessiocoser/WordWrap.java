package com.alessiocoser;

public class WordWrap {

    public String wrap(String text, Integer length) throws InvalidArgument{
        if (length < 1) {
            throw new InvalidArgument();
        }

        if (text == null) {
            return "";
        }

        return text;
    }

    public class InvalidArgument extends Exception {
    }
}
