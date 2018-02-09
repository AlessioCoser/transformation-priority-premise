package com.alessiocoser;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class WordWrapKataTest {

    private WordWrap wordWrap;

    @Before
    public void setUp() throws Exception {
        wordWrap = new WordWrap();
    }

    @Test
    public void WrapNullReturnsEmptyString() throws Exception {
        assertThat(wordWrap.wrap(null, 10), is(""));
    }

    @Test
    public void WrapEmptyStringReturnsEmptyString() throws Exception {
        assertThat(wordWrap.wrap("", 10), is(""));
    }

    @Test(expected = WordWrap.InvalidArgument.class)
    public void LengthLessThanOneShouldThrowInvalidArgument() throws Exception {
        wordWrap.wrap("xxx", 0);
    }

    @Test
    public void OneShortWordShouldNotWrap() throws Exception {
        assertThat(wordWrap.wrap("word", 5), is("word"));
    }

    @Test
    public void TwoWordsLongerThanLimitShouldWrap() throws Exception {
        assertThat(wordWrap.wrap("word word", 6), is("word\nword"));
        assertThat(wordWrap.wrap("wrap here", 6), is("wrap\nhere"));
    }

    @Test
    public void WordLongerThanLengthBreaksAtLength() throws Exception {
        assertThat(wordWrap.wrap("longword", 4), is("long\nword"));
        assertThat(wordWrap.wrap("longerword", 6), is("longer\nword"));
    }

    @Test
    public void WordLongerThanTwiceLengthShouldBreakTwice() throws Exception {
        assertThat(wordWrap.wrap("verylongword", 4), is("very\nlong\nword"));
    }
}