class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> hm = new HashMap<>();

        for (int[] pair : prerequisites) {
            List<Integer> temp;

            if (!hm.containsKey(pair[0])) {
                temp = new ArrayList<>();
                
            } else {
                temp = hm.get(pair[0]);
            }
            temp.add(pair[1]);

            hm.put(pair[0], temp);
        }

        Set<Integer> visited = new HashSet<>();

        for (int i=0; i<numCourses; i++) {
            if (!dfs(hm, visited, i)) {
                return false;
            }
        }
        
        return true;
    }
    
    private boolean dfs(Map<Integer, List<Integer>> hm, Set<Integer> visited, int num) {
        if (visited.contains(num)) {
            return false;
        }

        if (hm.getOrDefault(num, List.of()).isEmpty()) {
            return true;
        }

        visited.add(num);

        for (int neighbour : hm.getOrDefault(num, List.of())) {
            if (!dfs(hm, visited, neighbour)) {
                return false;
            }
        }

        visited.remove(num);
        hm.put(num, new ArrayList<>());

        return true;
    }
}