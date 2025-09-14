class Solution {
    public int compress(char[] chars) {
        int n = chars.length;
        int write=0;
        int read=0;
        while(read < n){
            char curr=chars[read];
            int c=0;
            while(read < n && chars[read] == curr){
                read++;
                c++;
            }
            chars[write++]=curr;
            if(c > 1){
                for(char ch:String.valueOf(c).toCharArray()){
                    chars[write++]=ch;
                }
            }
        }
        return write;
    }
}