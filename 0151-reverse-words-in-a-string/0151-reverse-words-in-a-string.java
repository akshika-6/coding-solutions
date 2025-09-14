class Solution {
    public String reverseWords(String s) {
        char[] ch=s.toCharArray();
        int n=cleanspaces(ch);
        reverse(ch,0,n-1);
        int start=0;
        for(int end=0;end<n;end++){
            if(ch[end] == ' '){
                reverse(ch,start,end-1);
                start=end+1;
            }
        }
        reverse(ch,start,n-1);
        return new String(ch,0,n);
    }
    public static void reverse(char[] ch,int i,int j){
        while(i < j){
            char temp=ch[i];
            ch[i]=ch[j];
            ch[j]=temp;
            i++;
            j--;
        }
    }
    public static int cleanspaces(char[] ch){
        int i=0;
        int j=0;
        int n=ch.length;
        while(j < n){
            while(j<n && ch[j]==' ') j++;
            while(j<n && ch[j]!=' ') ch[i++]=ch[j++];
            while(j<n && ch[j]==' ') j++;
            if(j<n) ch[i++]=' ';
        }
        return i;
    }
}