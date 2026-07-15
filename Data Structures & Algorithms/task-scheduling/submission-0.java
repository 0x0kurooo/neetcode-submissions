class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> freq = new HashMap<>();
        for (char task: tasks) {
            int currentFreq = freq.computeIfAbsent(task, k -> 0);
            freq.put(task, currentFreq + 1);
        }

        PriorityQueue<Character> queue = new PriorityQueue<>((a, b) -> freq.get(b) - freq.get(a));
        for (char task: tasks) {
            queue.offer(task);
        }

        int cycle = 0;
        Map<Character, Integer> cooldown = new HashMap<>();
        while (!queue.isEmpty()) {
            Character task = queue.poll();
            List<Character> pendingTasks = new ArrayList<>();
            
            // Can run task if the cooldown period has end
            // If task still in cooldown, pick next one
            while (cooldown.computeIfAbsent(task, k -> 0) > cycle && !queue.isEmpty()) {
                pendingTasks.add(task);
                task = queue.poll();
            }
            for (char t : pendingTasks) {
                queue.offer(t);
            }

            boolean canRun = cooldown.computeIfAbsent(task, k -> 0) <= cycle;
            if (canRun) {
                freq.put(task, freq.get(task) - 1);
                cooldown.put(task, cycle + n + 1); // After run the task, must wait n cycle
            } else {
                queue.offer(task);
            }
            cycle ++;
        }

        return cycle;
    }
}
