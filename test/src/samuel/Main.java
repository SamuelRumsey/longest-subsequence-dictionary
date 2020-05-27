package samuel;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {

    private final LongestSubsequenceFinder finder = new LongestSubsequenceFinder();
    private final Set<String> phrases = new HashSet<>(Arrays.asList("able", "ale", "apple", "bale", "kangaroo"));

    @Test
    public void testFinder() {
        Assertions.assertEquals("apple", finder.find("abppplee", phrases));
    }

    @Test
    public void testSubsequence() {
        // check whether proper subsequence return true
        Assertions.assertTrue(finder.isSubsequence("abppplee", "apple"));
        Assertions.assertTrue(finder.isSubsequence("abppplee", "ab"));
        Assertions.assertTrue(finder.isSubsequence("abppplee", "ae"));

        // check whether blatantly invalid subsequence return false
        Assertions.assertFalse(finder.isSubsequence("abppplee", "banana"));

        // check whether the same value returns true
        Assertions.assertTrue(finder.isSubsequence("abppplee", "abppplee"));
    }

    @Test
    public void testSorter() {
        Assertions.assertEquals("kangaroo", finder.getLongest(phrases));
    }
}
