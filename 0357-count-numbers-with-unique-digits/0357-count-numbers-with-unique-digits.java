class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        // int limit = (int) Math.pow(10,n);
        // int count = 0;
        // for(int i=0;i<limit;i++){
        //     int cnt=0;
        //     int temp = i;
        //     HashSet<Integer> hs = new HashSet<>();
        //     boolean isUnique = true;

        //     // Special case for 0
        //     if (i == 0) {
        //         count++;
        //         continue;
        //     }
        //     while (temp > 0) {
        //         int d = temp % 10;
        //         if (hs.contains(d)) {
        //             isUnique = false;
        //             break;
        //         }
        //         hs.add(d);
        //         temp = temp / 10;
        //     }

        //     if (isUnique) {
        //         count++;
        //     }
        // }

        // return count;

        if (n == 0) return 1;

        int result = 10; // for n = 1
        int uniqueDigits = 9;
        int availableNumbers = 9;

        for (int i = 2; i <= n && availableNumbers > 0; i++) {
            uniqueDigits *= availableNumbers;
            result += uniqueDigits;
            availableNumbers--;
        }

        return result;
    }
}