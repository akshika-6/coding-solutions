class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a, b) -> a.length() - b.length());

        int n=words.length;
        HashMap<String,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(words[i],1);
        }
        for(String word:words){
            for(int i=0;i<word.length();i++){
                String str=word.substring(0,i) + word.substring(i+1);
                if(map.containsKey(str)){
                    map.put(word,Math.max(map.get(word),map.get(str)+1));
                }
            }
        }
        int max = 1;
        for (int val : map.values()) {
            max = Math.max(max, val);
            }
        return max;
    }
}