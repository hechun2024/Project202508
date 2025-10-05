// 8.2_task1

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the PalindromeChecker class.
 */
public class PalindromeCheckerTest {
    @Test
    public void testIsPalindrome() {
        PalindromeChecker checker = new PalindromeChecker();
        assertTrue(checker.isPalindrome("radar"), "'radar' is a palindrome");
    }

    @Test
    public void testPhrasePalindromes() {
        PalindromeChecker checker = new PalindromeChecker();
        assertTrue(checker.isPalindrome("A man, a plan, a canal, Panama"));
    }
    @Test
    public void testNonPalindromes() {
        PalindromeChecker checker = new PalindromeChecker();
        assertFalse(checker.isPalindrome("hello"));
    }
    @Test
    public void testNumericPalindromes() {
        PalindromeChecker checker = new PalindromeChecker();
        assertTrue(checker.isPalindrome("12321"));
    }
    @Test
    public void testEmptyString() {
        PalindromeChecker checker = new PalindromeChecker();
        assertTrue(checker.isPalindrome(""), "Empty string is a palindrome");
    }

}