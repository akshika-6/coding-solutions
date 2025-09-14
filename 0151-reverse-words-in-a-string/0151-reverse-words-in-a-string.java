class Solution {
    public String reverseWords(String s) {
        s=s.trim();
        String[] st=s.split("\\s+");
        int n=st.length;
        StringBuilder sb=new StringBuilder();
        for(int i=n-1;i>=0;i--){
            if(i == 0){
                sb.append(st[i]);
            } else{
                sb.append(st[i]).append(" ");
            }
        }
        return sb.toString();
    }
}