class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int totalDrunk = 0;
        int fullBottles = numBottles;
        int emptyBottles = 0;
        int currentExchangeRate = numExchange;

        // The process continues as long as we can perform an exchange to get a new bottle.
        while (true) {
            
            // 1. Drink all current full bottles 
            // This is the greedy step to maximize empty bottles.
            totalDrunk += fullBottles;
            emptyBottles += fullBottles;
            fullBottles = 0; // All full bottles are now empty
            
            // 2. Check and perform exchange
            if (emptyBottles >= currentExchangeRate) {
                // Exchange is possible:
                
                // Get 1 new full bottle
                fullBottles = 1; 
                
                // Use up empty bottles
                emptyBottles -= currentExchangeRate;
                
                // Increase the exchange rate for the next trade
                currentExchangeRate += 1;
            } else {
                // Cannot exchange to get a new bottle, so the process stops
                break;
            }
        }
        
        return totalDrunk;
    }
}