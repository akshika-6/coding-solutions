class Solution {
    public int bestClosingTime(String customers) {
        int n = customers.length();
        
        // Initial penalty: shop closed all day
        int penalty = 0;
        for (char c : customers.toCharArray()) {
            if (c == 'Y') penalty++;
        }
        
        int minPenalty = penalty;
        int bestHour = 0;
        
        // Move closing hour from 1 to n
        for (int i = 0; i < n; i++) {
            if (customers.charAt(i) == 'Y') {
                penalty--;   // customer now served
            } else {
                penalty++;   // shop open but no customer
            }
            
            if (penalty < minPenalty) {
                minPenalty = penalty;
                bestHour = i + 1;
            }
        }
        
        return bestHour;
    }
}