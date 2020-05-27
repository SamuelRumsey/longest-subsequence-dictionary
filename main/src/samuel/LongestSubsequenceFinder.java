package samuel;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LongestSubsequenceFinder {

    /**
     * Returns the longest word in d that is a subsequence of s.
     *
     * <p>A subsequence is defined as a word that can be formed by removing characters from a string without reordoring it.
     * <p>With the input of "abppplee" and a set of "able," "ale," "apple," "bale," and "kangaroo," the first 3 are subsequences.
     *
     * @param s  base string to compare subsequences to
     * @param d  set of words to check
     * @return  the longest word in d that is a subsequence of s
     */
    public String find(String s, Set<String> d) {
        if(d.isEmpty()) {
            return "";
        }

        Set<String> validPhrases = new HashSet<>();

        // add all valid substrings to validPhrases list
        for(String testPhrase : d) {
            if(isSubsequence(s, testPhrase)) {
                validPhrases.add(testPhrase);
            }
        }

        return getLongest(validPhrases);
    }

    /**
     * Returns whether the second string is a subsequence of the first string.
     *
     * <p>A subsequence is defined as a word that can be formed by removing characters from a string without reordoring it.
     * <p>With the input of "abppplee" and a set of "able," "ale," "apple," "bale," and "kangaroo," the first 3 are subsequences.
     *
     * @param original  string to test check string against; base value
     * @param check  string that would be a subsequence of the original string
     * @return  whether check is a subsequence of original
     */
    public boolean isSubsequence(String original, String check) {
        // get an ordered list of characters for each input
        List<Character> originalCharacters = new ArrayList<>();
        for(char c : original.toCharArray()) {
            originalCharacters.add(c);
        }

        List<Character> checkCharacters = new ArrayList<>();
        for(char c : check.toCharArray()) {
            checkCharacters.add(c);
        }

        // see if the first list contains all elements of the second one in order
        for(Character testCharacter : checkCharacters) {
            // if the original string does not contain a character in the check string, return false
            if(!originalCharacters.contains(testCharacter)) {
                return false;
            } else {
                int newIndex = originalCharacters.indexOf(testCharacter);

                // remove all elements before the new index
                originalCharacters = originalCharacters.subList(newIndex, originalCharacters.size());
            }
        }

        return true;
    }

    /**
     * Returns the longest string in the given {@link Set}.
     *
     * @param strings  strings to check
     * @return  longest string in strings
     */
    public String getLongest(Set<String> strings) {
        String longest = "";

        for(String testString : strings) {
            if(testString.length() > longest.length()) {
                longest = testString;
            }
        }

        return longest;
    }
}
