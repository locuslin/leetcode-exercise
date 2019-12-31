package me.locus0;

/**
 * Created on 2019/12/30.
 *
 * @author LingChuan
 */
public class Solution4 {

    public String longestPalindrome(String s) {
        int currentMaxLength = 0;
        String currentLongestPalindrome = "";

        for (int i = 0; i < s.length(); i++) {

            int leftIndex = i;
            int rightIndex = i;

            char c = s.charAt(leftIndex);
            while (leftIndex > 0 && s.charAt(leftIndex - 1) == c) {
                leftIndex--;
            }
            while (rightIndex < s.length() - 1 && s.charAt(rightIndex + 1) == c) {
                rightIndex++;
            }

            String palindrome = extendPalindrome(s, leftIndex, rightIndex);
            if (palindrome.length() > currentMaxLength) {
                currentLongestPalindrome = palindrome;
                currentMaxLength = palindrome.length();
            }
        }

        return currentLongestPalindrome;
    }

    String extendPalindrome(String s, int leftIndex, int rightIndex) {
        if (leftIndex > 0 && rightIndex < s.length() - 1) {
            char left = s.charAt(leftIndex - 1);
            char right = s.charAt(rightIndex + 1);
            if (left == right) {
                return extendPalindrome(s, leftIndex - 1, rightIndex + 1);
            }
        }
        return s.substring(leftIndex, rightIndex + 1);
    }

}
