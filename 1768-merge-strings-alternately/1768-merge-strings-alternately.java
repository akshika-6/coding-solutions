class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder st = new StringBuilder();
        int i = 0;
        int j = 0;
        while(i<word1.length() && j<word2.length()){
            st.append(word1.charAt(i));
            i++;
            st.append(word2.charAt(j));
            j++;
        }
        while(i<word1.length()){
            st.append(word1.charAt(i));
            i++;
        }
        while(j<word2.length()){
            st.append(word2.charAt(j));
            j++;
        }
        return st.toString();
    }
}