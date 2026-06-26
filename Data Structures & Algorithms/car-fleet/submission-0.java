class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;

        Integer[] idx = new Integer[n];
        for (int i = 0; i < n; i++) idx[i] = i;

        // Sort position descending for easier to get the limit
        Arrays.sort(idx, (a, b) -> position[b] - position[a]);

        Deque<Double> stack = new ArrayDeque<>();

        for (int i : idx) {
            double timeToArrival = (double) (target - position[i]) / speed[i];

            // Check if current time to decide if this car can make a new fleet
            if (stack.isEmpty() || timeToArrival > stack.peek()) {
                // This car is slower than current fleet
                // So it will make up new fleet
                stack.push(timeToArrival);
            }

            // If the car drive faster current fleet, we will merge it to the same (one way)
        }

        return stack.size();
    }
}
