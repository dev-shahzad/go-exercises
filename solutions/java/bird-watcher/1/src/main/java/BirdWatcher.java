class BirdWatcher {

    private static final int TODAY_INDEX = 6;
    private int[] birdsPerDay;

    // ✅ Add this constructor
    public BirdWatcher(int[] birdsPerDay) {
        // Use a copy to avoid modifying the original array
        this.birdsPerDay = java.util.Arrays.copyOf(birdsPerDay, birdsPerDay.length);
    }

    // ✅ Default constructor still allowed (for backward compatibility)
    public BirdWatcher() {
        this.birdsPerDay = new int[] { 0, 2, 5, 3, 7, 8, 4 };
    }

    public int[] getLastWeek() {
        return java.util.Arrays.copyOf(birdsPerDay, birdsPerDay.length);
    }

    public int getToday() {
        return birdsPerDay[TODAY_INDEX];
    }

    public void incrementTodaysCount() {
        birdsPerDay[TODAY_INDEX]++;
    }

    public boolean hasDayWithoutBirds() {
        for (int count : birdsPerDay) {
            if (count == 0) {
                return true;
            }
        }
        return false;
    }

    public int getCountForFirstDays(int numberOfDays) {
        int total = 0;
        for (int i = 0; i < numberOfDays && i < birdsPerDay.length; i++) {
            total += birdsPerDay[i];
        }
        return total;
    }

    public int getBusyDays() {
        int busyDays = 0;
        for (int count : birdsPerDay) {
            if (count >= 5) {
                busyDays++;
            }
        }
        return busyDays;
    }
}
