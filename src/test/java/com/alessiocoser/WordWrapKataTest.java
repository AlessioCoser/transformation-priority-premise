package com.alessiocoser;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class WordWrapKataTest {
    @Test
    public void WrapNullReturnsEmptyString() throws Exception {
        WordWrap wordWrap = new WordWrap();

        assertThat(wordWrap.wrap(null, 10), is(""));
    }
}