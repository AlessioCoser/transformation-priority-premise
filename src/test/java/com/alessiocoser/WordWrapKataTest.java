package com.alessiocoser;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class WordWrapKataTest {

    @Test
    public void WrapNullReturnsEmptyString() throws Exception {
        assertThat(WordWrap.wrap(null, 10), is(""));
    }

    @Test
    public void WrapEmptyStringReturnsEmptyString() throws Exception {
        assertThat(WordWrap.wrap("", 10), is(""));
    }

    @Test(expected = WordWrap.InvalidArgument.class)
    public void LengthLessThanOneShouldThrowInvalidArgument() throws Exception {
        WordWrap.wrap("xxx", 0);
    }

    @Test
    public void OneShortWordShouldNotWrap() throws Exception {
        assertThat(WordWrap.wrap("word", 5), is("word"));
    }

    @Test
    public void WordLongerThanLengthBreaksAtLength() throws Exception {
        assertThat(WordWrap.wrap("longword", 4), is("long\nword"));
        assertThat(WordWrap.wrap("longerword", 6), is("longer\nword"));
    }

    @Test
    public void WordLongerThanTwiceLengthShouldBreakTwice() throws Exception {
        assertThat(WordWrap.wrap("verylongword", 4), is("very\nlong\nword"));
    }

    @Test
    public void TwoWordsLongerThanLimitShouldWrap() throws Exception {
        assertThat(WordWrap.wrap("word word", 6), is("word\nword"));
        assertThat(WordWrap.wrap("wrap here", 6), is("wrap\nhere"));
    }

    @Test
    public void ThreeWordsEachLongerThanLimitShouldWrap() throws Exception {
        assertThat(WordWrap.wrap("word word word", 6), is("word\nword\nword"));
    }

    @Test
    public void ThreeWordsJustOverTheLimitShouldBreakAtSecond() throws Exception {
        assertThat(WordWrap.wrap("word word word", 11), is("word word\nword"));
    }

    @Test
    public void TwoWordsTheFirstEndingAtTheLimit() throws Exception {
        assertThat(WordWrap.wrap("word word", 4), is("word\nword"));
    }
}