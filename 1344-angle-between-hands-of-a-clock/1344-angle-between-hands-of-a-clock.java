class Solution {
    public double angleClock(int hour, int minutes) {
        double minuteangle = minutes * 6;
        double hourangle = (hour % 12) * 30 + minutes * 0.5;
        double diff = Math.abs(hourangle - minuteangle);

        return Math.min(diff, 360 - diff);
    }
}