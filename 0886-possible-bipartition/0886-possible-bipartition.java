import java.util.*;

class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        //n명의 그룹을 2그룹으로 나누고싶음.
        //각 사람은 다른 사람을 싫어할 수 있고 이 둘은 같은 그룹에 있을 수 없음
        // n 정수가 주어지고, 서로 싫어하는 a가 싫어하는 b가 dislikes (단방향 그래프)
        // 사이클이 있으면 팀이 안갈린거임.

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] dislike : dislikes) {
            int a = dislike[0];
            int b = dislike[1];
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        //0:미방문,1:red, 2:blue
        int[] color = new int[n + 1];

        for (int i = 1; i < n; i++) {
            if (color[i] == 0) {
                if (!possibleBiPartition(i, graph, color, 1)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean possibleBiPartition(int person, List<List<Integer>> graph, int[] color, int currentColor) {
        if (color[person] != 0) return color[person] == currentColor;
        color[person] = currentColor;

        List<Integer> list = graph.get(person);
        for (Integer next : list) {
            if (!possibleBiPartition(next, graph, color, -currentColor)) {
                return false;
            }
        }

        return true;
    }
}