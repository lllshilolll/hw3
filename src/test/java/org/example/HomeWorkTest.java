package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class HomeWorkTest {

    @Test
    void findMaxSubstringTest() {
        HomeWork homeWork = new HomeWork();

        Assertions.assertEquals(homeWork.findMaxSubstring("abcddcba"), "abcd");

        Assertions.assertEquals(homeWork.findMaxSubstring("abcddcbaX"), "dcbaX");

        Assertions.assertEquals(homeWork.findMaxSubstring("abcddcbaXXpfdjlwie"), "Xpfdjlwie");

        Assertions.assertEquals(homeWork.findMaxSubstring("aaaaaaa"), "a");

        Assertions.assertEquals(homeWork.findMaxSubstring("abababab"), "ab");

        Assertions.assertEquals(homeWork.findMaxSubstring("tyuiohfjd"), "tyuiohfjd");

    }

    @Test
    void checkTest() {
        HomeWork homeWork = new HomeWork();
        Assertions.assertTrue(homeWork.check("The quick brown fox jumps over the lazy dog"));
        Assertions.assertTrue(homeWork.check("The quick3737838 brown fox jumps over the lazy dog"));

        Assertions.assertFalse(homeWork.check("The quick brown "));

    }
}