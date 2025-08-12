public class Palindrome {
    public static boolean isPalindrome(String s) {
        if (s == null) return false;
        int i = 0;
        int j = s.length()-1;
        while(i<j) {
            if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}