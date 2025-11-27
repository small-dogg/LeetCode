class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] prerequisite : prerequisites) {
            int a = prerequisite[0];
            int b = prerequisite[1];
            graph.get(b).add(a);
        }

        //0: 미방문 1:방문중 2:방문 완료
        int[] visited = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (dfs(i, visited, graph)) {
                return false;
            }
        }

        return true;
    }

    private boolean dfs(int cur, int[] visited, List<List<Integer>> graph) {
        if (visited[cur] == 1) {
            return true;
        }
        if (visited[cur] == 2) {
            return false;
        }

        visited[cur] = 1;

        for (int next : graph.get(cur)) {
            if (dfs(next, visited, graph)) {
                return true;
            }
        }
        visited[cur] = 2;

        return false;
    }
}