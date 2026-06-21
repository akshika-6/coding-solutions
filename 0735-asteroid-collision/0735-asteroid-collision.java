class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        int n = asteroids.length;
        for(int i:asteroids){
            boolean alive = true;
            while(alive && i < 0 && !st.isEmpty() && st.peek() > 0){
                if(st.peek() < -i){
                    st.pop();
                } else if(st.peek() == -i){
                    st.pop();
                    alive = false;
                } else{
                    alive = false;
                }
            }
            if(alive){
                st.push(i);
            }
        }
        n = st.size();
        int[] ans = new int[n];
        for(int i = n-1;i>=0;i--){
            ans[i] = st.pop();
        }
        return ans;
    }
}