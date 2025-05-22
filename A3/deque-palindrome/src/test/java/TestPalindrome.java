
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testIsPalindrome() {
        Palindrome p = new Palindrome();

        assertTrue(p.isPalindrome("a"));
        assertTrue(p.isPalindrome("racecar"));
        assertTrue(p.isPalindrome("noon"));

        assertFalse(p.isPalindrome("horse"));
        assertFalse(p.isPalindrome("aaab"));
        assertTrue(p.isPalindrome("")); // edge case: empty string
    }

}

