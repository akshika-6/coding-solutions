class Solution {
    public int countCollisions(String directions) {
        int n = directions.length();
        char[] arr = directions.toCharArray();
        
        int i = 0;
        // skip all leading 'L' (they go left forever, no collision)
        while (i < n && arr[i] == 'L') {
            i++;
        }

        int j = n - 1;
        // skip all trailing 'R' (they go right forever, no collision)
        while (j >= 0 && arr[j] == 'R') {
            j--;
        }

        int collisions = 0;
        // in the middle, count all moving cars (L or R)
        for (int k = i; k <= j; k++) {
            if (arr[k] != 'S') { // it's 'L' or 'R'
                collisions++;
            }
        }

        return collisions;
    }
}