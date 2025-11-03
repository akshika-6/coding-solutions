class Solution {
    public int calPoints(String[] operations) {
        List<Integer> arr = new ArrayList<>();
        int sum = 0;

        for (String st : operations) {
            int size = arr.size();

            if (st.equals("+")) {
                int c = arr.get(size - 1) + arr.get(size - 2);
                arr.add(c);
                sum += c;
            } 
            else if (st.equals("C")) {
                sum -= arr.remove(size - 1);
            } 
            else if (st.equals("D")) {
                int val = arr.get(size - 1) * 2;
                arr.add(val);
                sum += val;
            } 
            else {
                int n = Integer.parseInt(st);
                arr.add(n);
                sum += n;
            }
        }

        return sum;
    }
}