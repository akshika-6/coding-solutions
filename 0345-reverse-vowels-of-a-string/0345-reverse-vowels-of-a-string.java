class Solution {
    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        
        int left = 0, right = chars.length - 1;
        String vowels = "aeiouAEIOU"; // vowel set

        while (left < right) {
            // Move left until vowel found
            while (left < right && vowels.indexOf(chars[left]) == -1) {
                left++;
            }
            // Move right until vowel found
            while (left < right && vowels.indexOf(chars[right]) == -1) {
                right--;
            }
            // Swap vowels
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;

            left++;
            right--;
        }

        return new String(chars);
    }
}