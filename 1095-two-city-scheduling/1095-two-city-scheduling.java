//풀이수준 : B-, 정렬할 생각을 못했음
class Solution {
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, Comparator.comparingInt(a -> (a[0] - a[1])));

        int sum = 0;
        for (int i = 0; i < costs.length / 2; i++) {
            sum += costs[i][0];
        }
        for (int i = costs.length / 2; i < costs.length; i++) {
            sum += costs[i][1];
        }

        return sum;
    }
}