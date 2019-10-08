import org.junit.Test;
import static org.junit.Assert.*;

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
    public void testisPalindrome() {
        assertFalse(palindrome.isPalindrome(null));
        assertTrue(palindrome.isPalindrome("noon"));
        assertFalse(palindrome.isPalindrome("cat"));
        assertTrue(palindrome.isPalindrome("toohottohoot"));
        assertTrue(palindrome.isPalindrome("1221"));
    }
    @Test
    public void testisPalindromeobo() {
        CharacterComparator offByOne = new OffByOne();
        assertFalse(palindrome.isPalindrome(null, offByOne));
        assertTrue(palindrome.isPalindrome("flake", offByOne));
        assertTrue(palindrome.isPalindrome("a", offByOne));
        assertTrue(palindrome.isPalindrome("AXDYB", offByOne));
        assertFalse(palindrome.isPalindrome("noon", offByOne));
        assertTrue(palindrome.isPalindrome("14652", offByOne));
    }
}
