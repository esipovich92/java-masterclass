package com.esipovich.masterclass.junits;

import static org.junit.Assert.*;

public class UtilitiesTest {

    @org.junit.Test
    public void everyNthChar() {
        Utilities utilities = new Utilities();
        char[] output = utilities.everyNthChar(new char[]{'h','e','l','l','o'}, 2);
        assertArrayEquals(new char[]{'e', 'l'}, output);
        char[] output2 = utilities.everyNthChar(new char[]{'h','e','l','l','o'}, 7);
        assertArrayEquals(new char[]{'h', 'e', 'l', 'l', 'o'}, output2);
    }

    @org.junit.Test
    public void removePairs() {
        Utilities utilities = new Utilities();
        assertEquals("ABCDEF", utilities.removePairs("ABBCDEEF"));
        assertEquals("ABD", utilities.removePairs("AAABBD"));
        assertNull("Not null!", utilities.removePairs(null));
        assertEquals("A", utilities.removePairs("A"));
        assertEquals("", utilities.removePairs(""));
    }

    @org.junit.Test
    public void converter() {
        Utilities utilities = new Utilities();
        assertEquals(300, utilities.converter(10, 5));
    }

    @org.junit.Test
    public void nullIfOddLength() {
        Utilities utilities = new Utilities();
        assertNull(utilities.nullIfOddLength("odd"));
        assertNotNull(utilities.nullIfOddLength("even"));
    }
}