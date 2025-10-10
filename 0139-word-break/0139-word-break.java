class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> hs=new HashSet<>(wordDict);
        Map<String,Boolean> memo=new HashMap<>();
        return helper(s,memo,hs);
    }
    public static boolean helper(String s,Map<String,Boolean> memo,Set<String> hs){
        if(s.isEmpty()) return true;
        if(memo.containsKey(s)) return memo.get(s);
        for(int i=1;i<=s.length();i++){
            String prefix=s.substring(0,i);
            if(hs.contains(prefix)){
                String suffix=s.substring(i);
                if(helper(suffix,memo,hs)){
                    memo.put(s,true);
                    return true;
                }
            }
        }
        memo.put(s,false);
        return false;
    }
}