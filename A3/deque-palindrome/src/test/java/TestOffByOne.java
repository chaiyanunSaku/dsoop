

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestOffByOne {
    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();

    // Your tests go here.
    @Test
    public void testIsPalindromeWithOffByOne() {
        Palindrome p = new Palindrome();
        CharacterComparator cc = new OffByOne();

        assertTrue(p.isPalindrome("flake", cc));
        assertTrue(p.isPalindrome("abcb", cc));

        assertFalse(p.isPalindrome("racecar", cc));
        assertTrue(p.isPalindrome("a", cc));     // single letter, not off-by-one with itself
        assertTrue(p.isPalindrome("", cc));       // empty string is always valid

        assertTrue(p.isPalindrome("ab", cc));
        assertFalse(p.isPalindrome("ac", cc));
    }
} 

